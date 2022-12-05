// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
    public final TalonSRX mMotor1FrontRight = new TalonSRX(2);
    public final TalonSRX mMotor2BackRight = new TalonSRX(3);
    public final TalonSRX mMotor3FrontLeft = new TalonSRX(4);
    public final TalonSRX mMotor4BackLeft = new TalonSRX(5);
    public final TalonSRX extramotor = new TalonSRX(6);
    public final TalonSRX IntMotor = new TalonSRX(1);
    public final TalonSRX ShootMotor = new TalonSRX (7);
    
    double rightDemand;
    double rightspeed;
    double leftDemand;
    double leftspeed;
    double turn;
    double quickturn;
    boolean hugup;
    boolean hugset;
    boolean Aim;
    boolean Shooter;

    double M1Speed = 0.5;
    double M2Speed = 0.5;
    double M3Speed = 0.5;
    double M4Speed = 0.5;
    double Intspeed = 1;
    double Aim1 = .5;
    double Aim2 = .8;
    boolean Aimspeed = false;
    double turnadd = 0;
    private final XboxController control = new XboxController(0);
    private final XboxController control2 = new XboxController(1);    

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  /*public class MoveForwardAction{
    Drive mAutoDrive = new Drive();
    
    public void finalMoveForwardAction(){
      mAutoDrive.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
    }
  }*/
  
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    /*mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
    mMotor2BackRight.set(ControlMode.PercentOutput, 0);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);  
    extramotor.set(ControlMode.PercentOutput, 0);    
    IntMotor.set(ControlMode.PercentOutput, 0);
    ShootMotor.set(ControlMode.PercentOutput, 0);*/
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, -M3Speed);
    mMotor4BackLeft.set(ControlMode.PercentOutput, -M4Speed);
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
    try {
      TimeUnit.MICROSECONDS.sleep(150);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, -M3Speed);
    mMotor4BackLeft.set(ControlMode.PercentOutput, -M4Speed);
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
    mMotor2BackRight.set(ControlMode.PercentOutput, 0);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
    try {
      TimeUnit.MICROSECONDS.sleep(50);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    extramotor.set(ControlMode.PercentOutput, -0.8);
      try {
        TimeUnit.MICROSECONDS.sleep(100);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
    extramotor.set(ControlMode.PercentOutput, 0);
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
    try {
      TimeUnit.MICROSECONDS.sleep(300);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, -M3Speed);
    mMotor4BackLeft.set(ControlMode.PercentOutput, -M4Speed);
    try {
      TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    extramotor.set(ControlMode.PercentOutput, 0);
    mMotor1FrontRight.set(ControlMode.PercentOutput, M1Speed);
    mMotor2BackRight.set(ControlMode.PercentOutput, M2Speed);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
    try {
      TimeUnit.MICROSECONDS.sleep(300);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    rightDemand = control.getRawAxis(2);
    rightspeed = Drive.speedramp(rightDemand,rightspeed);
    leftDemand = control.getRawAxis(3);
    leftspeed = Drive.speedramp(leftDemand,leftspeed);
    turn = control.getRawAxis(0);
    quickturn = control.getRawAxis(4);
    hugup = control2.getBButton();
    Aim = control2.getYButtonPressed();
    Shooter = control2.getXButton();

    rightDemand = Math.abs(rightDemand) < 0.15 ? 0 : control.getRawAxis(2);
    leftDemand = Math.abs(leftDemand) < 0.15 ? 0 : control.getRawAxis(3);
    turn = Math.abs(turn) < 0.15 ? 0 : control.getRawAxis(0);
    turnadd = turn/2;
    quickturn = Math.abs(quickturn) < 0.15 ? 0 : control.getRawAxis(4);


    
    if(rightDemand != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, rightspeed + turnadd);
      mMotor2BackRight.set(ControlMode.PercentOutput, rightspeed + turnadd);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, -rightspeed + turnadd);
      mMotor4BackLeft.set(ControlMode.PercentOutput, -rightspeed + turnadd);
    }
    else if(leftDemand != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, -leftspeed + turnadd);
      mMotor2BackRight.set(ControlMode.PercentOutput, -leftspeed + turnadd);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, leftspeed + turnadd);
      mMotor4BackLeft.set(ControlMode.PercentOutput, leftspeed + turnadd); 
    }  
    else{
      mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
      mMotor2BackRight.set(ControlMode.PercentOutput, 0);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
      mMotor4BackLeft.set(ControlMode.PercentOutput, 0); 
    }  
    if(quickturn != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, quickturn);
      mMotor2BackRight.set(ControlMode.PercentOutput, quickturn);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, quickturn);
      mMotor4BackLeft.set(ControlMode.PercentOutput, quickturn); 
    }

    if(hugup == true){
      if(hugset == true){
        extramotor.set(ControlMode.PercentOutput, -0.8);
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        extramotor.set(ControlMode.PercentOutput, 0);
        hugset = !hugset;
      }else{
        extramotor.set(ControlMode.PercentOutput, 0.8); 
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      extramotor.set(ControlMode.PercentOutput, 0);
      hugset = !hugset;
      }
    }

    if(hugset == true){
      extramotor.set(ControlMode.PercentOutput, -0.8);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      extramotor.set(ControlMode.PercentOutput, 0);
    }
    IntMotor.set(ControlMode.PercentOutput, 0);
    if(Shooter == true){
      IntMotor.set(ControlMode.PercentOutput, 1);
      ShootMotor.set(ControlMode.PercentOutput, 1);
    }
    /*if((Shooter == true)&&(Intspeed == 0)){
      Intspeed = 1;
      while(Shooter == true){
        IntMotor.set(ControlMode.PercentOutput,Intspeed);
        if(Aimspeed == true){
          Aimspeed=!Aimspeed;
          ShootMotor.set(ControlMode.PercentOutput,Aim1);
        } else {
        Aimspeed=!Aimspeed;
        ShootMotor.set(ControlMode.PercentOutput,Aim2);
        }
      }
    } else if((Shooter == true)&&(Intspeed == 1)){
      Intspeed = 0;
      while(Shooter == true){
        IntMotor.set(ControlMode.PercentOutput,Intspeed);
        ShootMotor.set(ControlMode.PercentOutput,0);
      }
    }
    ShootMotor.set(ControlMode.PercentOutput, 0);*/
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
