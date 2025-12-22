package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class RollerSpit extends Command {

  public RollerSpit() {
    setInterruptible(false);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void initialize() {
    Robot.roller.spit();
  }
}
