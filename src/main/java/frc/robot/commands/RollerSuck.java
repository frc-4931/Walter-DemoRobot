package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class RollerSuck extends Command {

  public RollerSuck() {
    setInterruptible(false);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void initialize() {
    Robot.roller.suck();
  }
}
