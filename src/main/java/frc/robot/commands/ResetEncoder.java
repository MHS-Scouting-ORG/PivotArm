package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PivotArmSubsystem;

public class ResetEncoder extends CommandBase {
    private PivotArmSubsystem p_subsystem;

    public ResetEncoder(PivotArmSubsystem p_subs){ // Reset Encoder Command
        p_subsystem = p_subs;
        addRequirements(p_subs);
    }

    @Override
    public void initialize(){ // Runs this code first when the command is run 

    }

    @Override
    public void execute(){ // Executes this code when the command is run
   
    }

    @Override
    public void end(boolean interrupted){ // Runs the timer and while it is less than 2 seconds, reset the encoders
        p_subsystem.resetEncoder();
    }

    @Override
    public boolean isFinished(){ // Ends the code when isFinished is true 
        return true;
    }
    
}
