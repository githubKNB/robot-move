/**
 * 
 */
package com.robotmove.main;

import com.robotmove.environment.SurfaceDetail;
import com.robotmove.robot.Robot;
import com.robotmove.robot.Robot.FacingDirection;
import com.robotmove.robot.RobotCommand;
import com.robotmove.robot.RobotCommand.CommandType;
import com.robotmove.robot.RobotCommand.TurnDirection;

/**
 * Command line launcher
 * @author niranjan
 */
public class RobotMover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RobotMover robotMover = new RobotMover();
		robotMover.moveRobot();
	}
	
	public void moveRobot(){
		SurfaceDetail surfaceDetail = new SurfaceDetail(5, 5);
		
		//Example A
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.placeRobot(0, 0, FacingDirection.NORTH);
		robot_A.action(new RobotCommand(CommandType.MOVE));
		robot_A.action(new RobotCommand(CommandType.REPORT));
		
		//Example B
		Robot robot_B = new Robot(surfaceDetail);
		robot_B.placeRobot(0, 0, FacingDirection.NORTH);
		robot_B.action(new RobotCommand(CommandType.TURN,TurnDirection.LEFT));
		robot_B.action(new RobotCommand(CommandType.REPORT));
		
		//Example C
		Robot robot_C = new Robot(surfaceDetail);
		robot_C.placeRobot(1, 2, FacingDirection.EAST);
		robot_C.action(new RobotCommand(CommandType.MOVE));
		robot_C.action(new RobotCommand(CommandType.MOVE));
		robot_C.action(new RobotCommand(CommandType.TURN,TurnDirection.LEFT));
		robot_C.action(new RobotCommand(CommandType.MOVE));
		robot_C.action(new RobotCommand(CommandType.REPORT));
	}

}
