package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoystick extends Command {
  private Joystick joystick;
  private Drivetrain drivetrain;

  public DriveWithJoystick() {
    // requires(Robot.drivetrain);
    // joystick = Robot.operatorInput.getJoystick();
    // drivetrain = Robot.drivetrain;
  }

  @Override
  public void execute() {
    //drivetrain.arcadeDrive(joystick.getY() * -1, joystick.getZ(), 1 - ((joystick.getThrottle() + 1) / 2));
  }

  @Override
  public boolean isFinished() {
    // TODO Auto-generated method stub
    return false;
  }
}
