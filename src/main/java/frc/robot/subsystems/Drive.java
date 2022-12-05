package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private final XboxController control = new XboxController(0);
    
    public final TalonSRX mMotor1FrontRight = new TalonSRX(1);
    public final TalonSRX mMotor2BackRight = new TalonSRX(2);
    public final TalonSRX mMotor3FrontLeft = new TalonSRX(3);
    public final TalonSRX mMotor4BackLeft = new TalonSRX(4);
    public final TalonSRX extramotor = new TalonSRX(5);

    double rightDemand;
    double leftDemand;
    double turn;
    double quickTurn;
    double throttle;
    double leftPwm = 0;
    double rightPwm = 0;
    boolean rampActive = true;

  public Drive() {}

  public void mainDrive(){
    rightDemand = control.getRawAxis(3);
    leftDemand = control.getRawAxis(2);       
    turn = control.getRawAxis(0);
    quickTurn = control.getRawAxis(4);

    quickTurn = Math.abs(quickTurn) < 0.15 ? 0 : control.getRawAxis(4);
    rightDemand = Math.abs(rightDemand) < 0.15 ? 0 : control.getRawAxis(3);
    leftDemand = Math.abs(leftDemand) < 0.15 ? 0 : control.getRawAxis(2);

    turn = Math.abs(turn) < 0.15 ? 0 : control.getRawAxis(0);

    throttle = rightDemand - leftDemand;
    throttle = Math.abs(throttle) < 0.15 ? 0 : rightDemand - leftDemand;

    if(throttle>=0){
      leftPwm = (throttle) - turn;
      rightPwm = (throttle) + turn;
    }
    else{
      leftPwm = (throttle) + turn;
      rightPwm = (throttle) - turn;
    }

    if(rightDemand != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, rightDemand);
      mMotor2BackRight.set(ControlMode.PercentOutput, rightDemand);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, rightDemand);
      mMotor4BackLeft.set(ControlMode.PercentOutput, rightDemand);
    }
    else if(leftDemand != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, leftDemand);
      mMotor2BackRight.set(ControlMode.PercentOutput, leftDemand);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, leftDemand);
      mMotor4BackLeft.set(ControlMode.PercentOutput, leftDemand); 
    }  
    else{
      mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
      mMotor2BackRight.set(ControlMode.PercentOutput, 0);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
      mMotor4BackLeft.set(ControlMode.PercentOutput, 0); 
    }  
  }
  public static double speedramp (double targetspeed, double currentspeed){
    if(currentspeed < targetspeed){
      return currentspeed + 0.1;
    } else if(currentspeed > targetspeed) {
      return currentspeed - 0.1;
    } else if((currentspeed - targetspeed)< 0.1){
      return targetspeed;
    }
    return 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

public void outMotoresAuto(double d, double e, double f, double g) {
}
}
