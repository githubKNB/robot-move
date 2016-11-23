/**
 * 
 */
package com.robotmove.robot;

import com.robotmove.environment.SurfaceDetail;
import com.robotmove.robot.RobotCommand.CommandStatus;

/**
 * Robot details class
 * @author niranjan
 */
public class Robot {

	public enum FacingDirection {NORTH, EAST, SOUTH, WEST}
	
	//Default values
	SurfaceDetail surfaceDetail = null;
	private  boolean isOnFurface = false;
	private FacingDirection directionFacing = FacingDirection.NORTH;
	private int xPosition = 0;
	private int yPosition = 0;
	
	public Robot(SurfaceDetail surfaceDetail){
		if(surfaceDetail == null){
			throw new IllegalArgumentException("Surface detail is null.");
		}
		this.surfaceDetail = surfaceDetail;
	}
	
	public void placeRobot(int xPosition, int yPosition, FacingDirection directionFacing){
		
		if(xPosition < 0 || yPosition < 0 || !surfaceDetail.isValidPosition(xPosition, yPosition)){
			throw new IllegalArgumentException("Invalid postion");
		}
		
		this.isOnFurface = true;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.directionFacing = directionFacing;
	}
		
	private CommandStatus moveRobot(){
		CommandStatus commandStatus = null;
		if(isOnFurface){
			switch (directionFacing) {
			case NORTH:
				int northYPosition = yPosition + 1;
				if(surfaceDetail.isValidPosition(xPosition, northYPosition))
				{
					yPosition = northYPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;
			case SOUTH:
				int southYPosition = yPosition - 1;
				if(surfaceDetail.isValidPosition(xPosition, southYPosition))
				{
					yPosition = southYPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}				
				break;
			case EAST:
				int eastXPosition = xPosition + 1;
				if(surfaceDetail.isValidPosition(eastXPosition, yPosition))
				{
					xPosition = eastXPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;				
			case WEST:
				int westXPosition = xPosition - 1;
				if(surfaceDetail.isValidPosition(westXPosition, yPosition))
				{
					xPosition = westXPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}												
				break;				
			default:
				commandStatus = CommandStatus.IGNORED;
			}
		} else {
			commandStatus = CommandStatus.IGNORED;
		}
		return commandStatus;
	}
	
	private CommandStatus turnRobot(RobotCommand command){
		
		CommandStatus commandStatus = null;
		
		if(isOnFurface){
			switch(command.getTurnDirection()){
			case LEFT:
				switch (directionFacing) {
				case NORTH:
					directionFacing = FacingDirection.WEST;
					break;
				case WEST:
					directionFacing = FacingDirection.SOUTH;
					break;
				case SOUTH:
					directionFacing = FacingDirection.EAST;
					break;
				case EAST:
					directionFacing = FacingDirection.NORTH;
					break;										
				default:
					break;
				}
				commandStatus = CommandStatus.DONE;
				break;
			case RIGHT:
				switch (directionFacing) {
				case NORTH:
					directionFacing = FacingDirection.EAST;
					break;
				case WEST:
					directionFacing = FacingDirection.NORTH;
					break;
				case SOUTH:
					directionFacing = FacingDirection.WEST;
					break;
				case EAST:
					directionFacing = FacingDirection.SOUTH;
					break;										
				default:
					break;
				}				
				commandStatus = CommandStatus.DONE;
				break;
			default:
				commandStatus = CommandStatus.IGNORED; 
			}
		} else {
			commandStatus = CommandStatus.IGNORED;
		}	
		
		return commandStatus;
	}
	
	private CommandStatus reportStatus(){
		if(isOnFurface){
			System.out.println(xPosition + "," + yPosition + "," + directionFacing.name());
			return CommandStatus.DONE;
		} else {
			return CommandStatus.IGNORED;
		}
	}
	
	public CommandStatus action(RobotCommand command){
		
		if(!isOnFurface){
			return CommandStatus.IGNORED;	
		} else {
			CommandStatus commandStatus = null;
			
			switch(command.getCommand()){
			case MOVE:
				commandStatus = moveRobot();
				break;
			case TURN:
				commandStatus = turnRobot(command);
				break;			
			case REPORT:
				commandStatus = reportStatus();
				break;
			default:
				commandStatus = CommandStatus.IGNORED;
			}
			return commandStatus;			
		}
	}	
}
