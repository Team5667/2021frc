package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
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
  public IndexCommand(IndexSubsystem m_index) {
    this.m_index = m_index;
    addRequirements(m_index);
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
    if(RobotContainer.getController().getLeftTrigger() > 0) {
      m_index.startIndex(false);
    } else if (RobotContainer.getController().getBumper(Hand.kRight)) {
      m_index.startIndex(true);
    }else if (RobotContainer.getController().getRightTrigger()>0){
      m_index.startIndex(false);
    } else{
      m_index.stopIndex();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_index.stopIndex();
  }

  @Override
  public boolean isFinished() {
    // end the command if the intake or shooter are idle
    // XXX: Setting this to true
    return false;
  }
}
