package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;

public class ArmUp extends Command {

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void initialize() {
    Arm.up();
  }
}
