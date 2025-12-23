package frc.robot.subsystems;

import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import java.util.Date;
import edu.wpi.first.wpilibj.*;
import frc.robot.Constants.RobotMap;

/**
 * An arcade drive drivetrain class. Contains 4 TalonSRX motor controllers.
 * Also contains the onboard accelerometer from the roborio, used for calculating speed.
 */
public class Drivetrain {
	private final WPI_TalonSRX m_leftLeader;
	private final WPI_TalonSRX m_leftFollower;
	private final WPI_TalonSRX m_rightLeader;
	private final WPI_TalonSRX m_rightFollower;

	private static DifferentialDrive differentialDrive;

		private static BuiltInAccelerometer accelerometer;// Roborio accelerometer

		//Speed estimation variables
		private double estXSpeed = 0;
		private double estYSpeed = 0;
		private double speed;
		private double dXSpeed;
		private double dYSpeed;
		private long   speedTime = 0;
		private long   tempTime;
		private Date   myDate;

	public Drivetrain() {
		// The motors on the left side of the drive.
		m_leftLeader = new WPI_TalonSRX(RobotMap.LEFT_FRONT);
		m_leftFollower  = new WPI_TalonSRX(RobotMap.LEFT_BACK);

		// The motors on the right side of the drive.
		m_rightLeader  = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
		m_rightFollower  = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

		// Set factory defaults
		m_leftLeader.configFactoryDefault();
		m_leftFollower.configFactoryDefault();
		m_rightLeader.configFactoryDefault();
		m_rightFollower.configFactoryDefault();

		// Sets motors so that positive is robot forward i.e. green lights on controllers
		m_leftLeader.setInverted(false);
		m_leftFollower.setInverted(false);
		m_rightLeader.setInverted(true);
		m_rightFollower.setInverted(true);

		// Multi-Motor thing
		m_leftLeader.follow(m_leftFollower);
		m_rightLeader.follow(m_rightFollower);
		
		accelerometer = new BuiltInAccelerometer();// Use onboard roborio accelerometer
		myDate = new Date();// This is used in estimateSpeed()

		differentialDrive = new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);
	}

	/**
	 * Sets the speed and rotation of the drive train.
		 * 
		 * @param speed The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
		 * @param rotation The robot's rotation rate around the Z axis [-1.0..1.0]. Counterclockwise is positive.
	 */
	public void arcadeDrive(double speed, double rotation) {
		differentialDrive.arcadeDrive(speed, rotation);
	}

		// /**
		//  * Estimates the speed using data from the accelerometers onboard the roborio.
		// * Utilizes numerical integration. Extremely imprecise and subject to significant drift.
		// * Should estimate zero speed when robot stopped.
		// * @return The estimated speed.
		// */
		// public double estimateSpeed(){
					
		// 	/*
		// 	* If robot not accelerating and joysticks not commanding movement, assume zero speed.
		// 	* This should help correct drift as it should zero each time the robot stops.
		// 	* FIXME if autonomous is added. May assume zero speed in auto when non-zero speed.
		// 	*/
		// 	if(Robot.getController().getLeftY()==0&&Robot.getController().getRightX()==0&&accelerometer.getX()==0&&
		// 		accelerometer.getY()==0){
		// 		speed = 0;
		// 		return speed;
		// 	}
		// 	else{
		// 		tempTime  = myDate.getTime();
		// 		// 6/275 is ratio to convert from gforce milliseconds to miles per hour
		// 		dXSpeed   = (tempTime - speedTime) * accelerometer.getX() * (6 / 275);
		// 		dYSpeed   = (tempTime - speedTime) * accelerometer.getY() * (6 / 275);
		// 		estXSpeed = estXSpeed + dXSpeed;// Add the change in speed to the last speed
		// 		estYSpeed = estYSpeed + dYSpeed;
		// 		speed     = Math.sqrt((estXSpeed * estXSpeed) + (estYSpeed * estYSpeed));// a^2+b^2=c^2
		// 		speedTime = tempTime;
		// 	}
		// 	return speed;
		// }

		public static BuiltInAccelerometer getAccelerometer(){
			return accelerometer;
		}
	}
