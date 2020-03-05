/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static WPI_VictorSPX FrontLeft = new WPI_VictorSPX(1);
  public static WPI_VictorSPX FrontRight = new WPI_VictorSPX(2);
  public static WPI_VictorSPX BackLeft = new WPI_VictorSPX(3);
  public static WPI_VictorSPX BackRight = new WPI_VictorSPX(4);
  public DifferentialDrive diffDrive;
  // The robot's subsystems and commands are defined here...

public static Joystick Joystick1 = new Joystick(0);

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);



  public DriveSub drivesub;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //peedControllerGroup left = new SpeedControllerGroup(FrontLeft, FrontRight);
    //SpeedControllerGroup right = new SpeedControllerGroup(BackLeft, BackRight);
    
    BackLeft.follow(FrontLeft);
    BackRight.follow(FrontRight);
    diffDrive = new DifferentialDrive(FrontLeft, FrontRight);
    drivesub = new DriveSub(FrontLeft, FrontRight, diffDrive);
    drivesub.setDefaultCommand(new RunCommand(() -> drivesub.drive(-Joystick1.getRawAxis(1)*0.8,-Joystick1.getRawAxis(2)*0.8),drivesub));
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
