package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class ArmStop extends Command {
  // The subsystem the command runs on

  private final Arm m_Arm;

  public ArmStop(Arm subsystem) {
    m_Arm = subsystem;
    addRequirements(m_Arm);
  }

  public boolean isFinished() {
    return true;
  }

  public void initialize() {
    m_Arm.stop();
  }
}
