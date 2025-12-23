package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Roller extends SubsystemBase {
  private static final double SUCK_SPEED = 1;
  private static final double SPIT_SPEED = -1;
  private WPI_TalonSRX rollerMotor;
  /** 1 for intake, -1 for expell, 0 for stop */
  private int direction = 0;

  private DigitalInput beam1;
  private DigitalInput beam2;

  public Roller() {
    rollerMotor = new WPI_TalonSRX(RobotMap.ROLLER);
    beam1 = new DigitalInput(RobotMap.THROUGH_BEAM_1);
    beam2 = new DigitalInput(RobotMap.THROUGH_BEAM_2);
  }

  // @Override
  // protected void initDefaultCommand() {}

  public void checkBeam() {
    if ((beam1.get() || beam2.get()) && direction == 1) {
      stop();
    }
  }

  public void stop() {
    rollerMotor.set(0);
    direction = 0;
  }

  public void suck() {
    direction = 1;
    rollerMotor.set(SUCK_SPEED);
  }

  public void spit() {
    direction = -1;
    rollerMotor.set(SPIT_SPEED);
  }
}