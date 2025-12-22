package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class ArmStop extends Command {

  public ArmStop() {
    setInterruptible(false);
  }

  protected boolean isFinished() {
    return true;
  }

  protected void initialize() {
    Robot.arm.stop();
  }
}
