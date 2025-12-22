package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Roller extends SubsystemBase {
    private final TalonSRX rollerMotor;
    /**
     * This subsytem that controls the roller.
     */
    public Roller () {

    // Set up the roller motor as a brushed motor
    rollerMotor = new SparkMax(RollerConstants.ROLLER_MOTOR_ID, MotorType.kBrushless);

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    rollerMotor.setCANTimeout(250);

    // Create and apply configuration for roller motor. Voltage compensation helps
    // the roller behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the roller stalls.
    SparkMaxConfig rollerConfig = new SparkMaxConfig();
    rollerConfig.voltageCompensation(RollerConstants.ROLLER_MOTOR_VOLTAGE_COMP);
    rollerConfig.smartCurrentLimit(RollerConstants.ROLLER_MOTOR_CURRENT_LIMIT);
    rollerConfig.idleMode(IdleMode.kBrake);
    rollerMotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }

    /**
     *  This is a method that makes the roller spin to your desired speed.
     *  Positive values make it spin forward and negative values spin it in reverse.
     * 
     * @param speedmotor speed from -1.0 to 1, with 0 stopping it
     */
    public void runRoller(double speed){
        // lEDs.setColor(.77);
        rollerMotor.set(speed);
    }

    public Command CoralSpit() {
        return this.runOnce(() -> { runRoller(-.15);});
    }

    public Command CoralStop() {
        return this.runOnce(() -> { runRoller(0);});
    }

    public Command rollerReverse() {
        return this.runOnce(() -> { runRoller(-.3);});
    }

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


  //   public class Roller extends SubsystemBase {
  //   private static final double SUCK_SPEED = 1;
  //   private static final double SPIT_SPEED = -1;
  //   private WPI_TalonSRX rollerMotor;
  //   /** 1 for intake, -1 for expell, 0 for stop */
  //   private int direction = 0;

  //   private DigitalInput beam1;
  //   private DigitalInput beam2;

  // public Roller() {
  //     rollerMotor = new WPI_TalonSRX(RobotMap.ROLLER);
  //     beam1 = new DigitalInput(RobotMap.THROUGH_BEAM_1);
  //     beam2 = new DigitalInput(RobotMap.THROUGH_BEAM_2);
  //   }

  //   @Override
  //   protected void initDefaultCommand() {}



}
