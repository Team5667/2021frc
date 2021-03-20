package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeStates;
import frc.robot.Constants.ShooterStates;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IndexCommand extends CommandBase {
  private IndexSubsystem m_index;
  private ShooterSubsystem m_shooter;
  private IntakeSubsystem m_intake;

  /** Creates a new IndexCommand. */
  public IndexCommand(IndexSubsystem m_index, ShooterSubsystem m_shooter) {
    this.m_index = m_index;
    this.m_shooter = m_shooter;
    addRequirements(m_index, m_shooter);
  }

  /** Creates a new IndexCommand. */
  public IndexCommand(IndexSubsystem m_index, IntakeSubsystem m_intake) {
    this.m_index = m_index;
    this.m_intake = m_intake;
    addRequirements(m_index, m_intake);
  }

  @Override
  public void initialize() {
    m_index.stopIndex();
  }

  @Override
  public void execute() {
    m_index.startIndex();
  }

  @Override
  public void end(boolean interrupted) {
    m_index.stopIndex();
  }

  @Override
  public boolean isFinished() {
    // end the command if the intake or shooter are idle
    return (m_intake.getIntakeState() == IntakeStates.STORED) || (m_shooter.getShooterState() == ShooterStates.IDLE);
  }
}