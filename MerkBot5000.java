package Decepticons;
import robocode.*;
import robocode.AdvancedRobot

//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * MerkBot5000 - a robot by (your name here)
 *
 */
// Extending advanced robot allows my robot to do more in one turn if possible
public class MerkBot5000 extends AdvancedRobot
{
	/**
	 * run: MerkBot5000's default behavior
	 */
	// Robot main loop when robot is idle
	public void run() {
		//moveAmount makes the bot ride along the border of the arena
		moveAmount = Math.max(getBattleFieldWidth(),getBattleFieldHeight());
		//Allows bot to keep its back along the wall
		peek = false
		
		turnLeft(getHeadin() % 90);
		//keeps wall riding momentum
		ahead(moveAmount)
		turnRight(90);
		//Scanner does 360 degree loop for enemies
		turnRadarRightRadians(Double.POSTITIVE_INFINITY);
		do {
			scan();
		} while(true) {
			//Makes Bot turn back against wall;
			peek = true
			//Moves along wall		
			ahead(moveAmount);
			//Makes Bot turn back against wall;
			peek = false
			//Goes to next wall
			turnRight(90);		
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		//Depicts the strength of gun
		
		fire(2);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		//Moves back when shot
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		//moves after wall contact
		back(20);
	}	
}
