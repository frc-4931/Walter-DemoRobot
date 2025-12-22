package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class RollerStop extends Command {

  @Override
  protected void initialize() {
    Robot.roller.stop();
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
