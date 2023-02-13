package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PivotArmSubsystem;

public class PivotArmJoystickCmd extends CommandBase{
    private PivotArmSubsystem p_subsystem;
    private final DoubleSupplier speed;

    public PivotArmJoystickCmd(PivotArmSubsystem p_subs, DoubleSupplier speed){ // Command Constructor
        this.p_subsystem = p_subs;
        this.speed = speed;
        addRequirements(p_subs);
    }

    @Override
    public void initialize(){ // Runs code when command starts

    }

    @Override
    public void execute(){ // Executes and sets the pivot up based on its speed
        SmartDashboard.putNumber("Speed: ", speed.getAsDouble());
        p_subsystem.pivotUp(speed);
   
    }

    @Override
    public void end(boolean interrupted){ // Runs code when ends

    }

    @Override
    public boolean isFinished(){ // Returns False when the code isFinished
        return false;
    }
}
