// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
  private IntakeSubsystem m_intake;

  /** Creates a new IntakeCommand. */
  public IntakeCommand(IntakeSubsystem m_intake) {
    this.m_intake = m_intake;
    addRequirements(m_intake);
  }

  @Override
  public void initialize() {
    m_intake.reset();
  }

  @Override
  public void execute() {
    double LT = RobotContainer.getController().getLeftTrigger();
      if(LT>0){
      m_intake.startIntake(-1);
  }
    else{
    m_intake.stopIntake();
    }
}

  @Override
  public void end(boolean interrupted) {
    m_intake.stopIntake();
  }

  @Override
  public boolean isFinished() {
    return false; // which button is powering the intake?
  }
}
