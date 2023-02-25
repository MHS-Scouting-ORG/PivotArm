package frc.robot;

import frc.robot.commands.ArmSafetyPosition;  
import frc.robot.commands.HighPosition;
import frc.robot.commands.LowPosition;
import frc.robot.commands.ManualElevatorDrive;
import frc.robot.commands.MidNode;
import frc.robot.commands.PivotArmButtonCmd;
import frc.robot.commands.PivotMiddleCmd;
import frc.robot.commands.PivotHighCmd;
import frc.robot.commands.PivotLowCmd;
import frc.robot.commands.MidNode;
import frc.robot.commands.TopNode;
import frc.robot.commands.TuckedIn;
import frc.robot.commands.ZeroPosition;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotArmSubsystem;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final PivotArmSubsystem p_subsystem = new PivotArmSubsystem(); 
  private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  private final ArmSafetyPosition arm = new ArmSafetyPosition(elevator);
  private final TuckedIn tucked = new TuckedIn(p_subsystem);
  private AddressableLED led = new AddressableLED(0);
  private AddressableLEDBuffer ledbuffer = new AddressableLEDBuffer(60);

  //private final Joystick joystick1 = new Joystick(0);
  private final XboxController xController = new XboxController(0);

  public RobotContainer() {
   // p_subsystem.setDefaultCommand(new PivotArmJoystickCmd(p_subsystem, () -> xController.getLeftY()));
    led.setLength(ledbuffer.getLength());
    for(var i = 0; i < ledbuffer.getLength(); i++){
      ledbuffer.setRGB(i, 255, 0, 0);
    }
    led.setData(ledbuffer);
    led.start();
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(xController, 1).onTrue(new PivotHighCmd(p_subsystem));
    new JoystickButton(xController, 2).onTrue(tucked); // Button for the starting position
    new JoystickButton(xController, 3).onTrue(new LowPosition(elevator)); // Button for the middle position
    new JoystickButton(xController, 4).onTrue(new PivotLowCmd(p_subsystem)); // Button for the high position
    new JoystickButton(xController, 5).onTrue(new MidNode(elevator)); 
    new JoystickButton(xController, 6).onTrue(new ZeroPosition(elevator)); // Button for driving the motor using the joystick
    new JoystickButton(xController, 7).whileTrue(new PivotArmButtonCmd(p_subsystem, .3));
    new JoystickButton(xController, 8).whileTrue(new PivotArmButtonCmd(p_subsystem, -.3));
  }

  

  public Command getAutonomousCommand() {
    return null;
  }
}
