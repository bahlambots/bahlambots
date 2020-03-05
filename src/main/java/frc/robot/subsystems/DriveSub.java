/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSub extends SubsystemBase {

  WPI_VictorSPX m_FrontRight;
  
  WPI_VictorSPX m_FrontLeft;
  DifferentialDrive m_drive;

  /**
   * Creates a new DriveSub.
   */
  public DriveSub(WPI_VictorSPX FrontLeft, WPI_VictorSPX FrontRight, DifferentialDrive drive) {
    m_FrontRight = FrontRight;
    m_FrontLeft = FrontLeft;
    m_drive = drive;
  }

  public DriveSub(){

  }
  
  public void drive(double left, double right){
    //RobotContainer.diffDrive.arcadeDrive(speed, rotation);
    m_drive.arcadeDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
