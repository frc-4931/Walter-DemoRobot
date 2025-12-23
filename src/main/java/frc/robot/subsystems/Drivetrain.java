package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.RobotMap;
import frc.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX leftFront, rightFront, leftBack, rightBack;
  //private SpeedControllerGroup left, right;
  private DifferentialDrive drive;

  public Drivetrain() {

    leftFront = new WPI_TalonSRX(RobotMap.LEFT_FRONT); // FIXME add real values
    rightFront = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
    leftBack = new WPI_TalonSRX(RobotMap.LEFT_BACK);
    rightBack = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

    //left = new SpeedControllerGroup(leftFront, leftBack);
    //right = new SpeedControllerGroup(rightFront, rightBack);

    //drive = new DifferentialDrive(left, right);
  }

  // @Override
  // protected void initDefaultCommand() {
  //   setDefaultCommand(new DriveWithJoystick());
  // }

  public void arcadeDrive(double speed, double turn, double multiplier) {
    drive.arcadeDrive(
        Math.copySign(speed * speed, speed) * multiplier,
        Math.copySign(turn * turn, turn) * multiplier,
        false);
  }

  public void arcadeDrive(double speed, double turn) {
    arcadeDrive(speed, turn, 1);
  }

  public void log() {
    // SmartDashboard.putNumber("left side motor speed", left.get());
    // SmartDashboard.putNumber("right side motor speed", right.get());
  }
}
