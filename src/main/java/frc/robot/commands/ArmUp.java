package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class ArmUp extends Command {
  // The subsystem the command runs on

  private final Arm m_Arm;

  public ArmUp(Arm subsystem) {
    m_Arm = subsystem;
    addRequirements(m_Arm);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void initialize() {
    m_Arm.up();
  }
}
