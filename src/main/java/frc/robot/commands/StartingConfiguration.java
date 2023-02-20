package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class StartingConfiguration extends CommandBase{
    private isTucked limit;
    private ArmSafetyPosition safety;

    public StartingConfiguration(isTucked lswitch, ArmSafetyPosition sposition){
        limit = lswitch;
        safety = sposition;
        addRequirements();
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        safety.andThen(limit);
    }

    @Override
    public void end(boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
