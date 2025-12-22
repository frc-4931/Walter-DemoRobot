package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class ArmDown extends Command {

  public ArmDown() {
    setInterruptible(false);
  }

  protected boolean isFinished() {
    return true;
  }

  protected void initialize() {
    Robot.Arm.down();
  }
}
