package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Roller;

public class RollerSpit extends Command {
  // The subsystem the command runs on

  private final Roller m_Roller;

  public RollerSpit(Roller subsystem) {
    m_Roller = subsystem;
    addRequirements(m_Roller);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void initialize() {
    m_Roller.spit();
  }
}
