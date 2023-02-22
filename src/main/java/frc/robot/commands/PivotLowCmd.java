package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PivotArmSubsystem;

public class PivotLowCmd extends CommandBase{
    private PivotArmSubsystem p_subs;

    public PivotLowCmd(PivotArmSubsystem subs){
        p_subs = subs;
        addRequirements(subs);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){ // Moves the arm to encoder counts: Low Position
        SmartDashboard.putNumber("Pivot Encoder: ", p_subs.getEncoder());
        p_subs.pivotArmPID(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
