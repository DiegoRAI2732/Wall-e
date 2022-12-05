package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.Time;
import frc.robot.Auto.Actions.Move;
import frc.robot.Auto.Actions.Stop;
import frc.robot.subsystems.DriveExample;

public class LineTimer{
  DriveExample mAutoDriveExample = new DriveExample();
  Move mForwardAction = new Move();
  Stop mStopAction = new Stop();
  Time mGetTimeAction = new Time();
  
  public void finalLineTimer(){
    if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<3){
        mForwardAction.finalMoveForwardACtion();
      }
      else mStopAction.finalStopAction();
  }
}
