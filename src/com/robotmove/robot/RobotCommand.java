/**
 * 
 */
package com.robotmove.robot;

/**
 * Robot command class
 * @author niranjan
 */
public class RobotCommand {
	
	public enum CommandType {MOVE, TURN, REPORT}
	public enum CommandStatus {DONE, IGNORED}
	public enum TurnDirection {LEFT, RIGHT}
	
	public RobotCommand(CommandType command){
		this.command = command;
	}	

	public RobotCommand(CommandType command, TurnDirection turnDirection){
		this.command = command;
		this.turnDirection = turnDirection;
	}
	
	private CommandType command = null;
	private TurnDirection turnDirection = null;
	private int xPosition = 0;
	private int yPosition = 0;
	
	/**
	 * @return the turnDirection
	 */
	public TurnDirection getTurnDirection() {
		return turnDirection;
	}
	/**
	 * @param turnDirection the turnDirection to set
	 */
	public void setTurnDirection(TurnDirection turnDirection) {
		this.turnDirection = turnDirection;
	}
	/**
	 * @return the xPosition
	 */
	public int getxPosition() {
		return xPosition;
	}
	/**
	 * @param xPosition the xPosition to set
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	/**
	 * @return the yPosition
	 */
	public int getyPosition() {
		return yPosition;
	}
	/**
	 * @param yPosition the yPosition to set
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	/**
	 * @return the command
	 */
	public CommandType getCommand() {
		return command;
	}
}
