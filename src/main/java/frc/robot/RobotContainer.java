package frc.robot;
 
import frc.robot.commands.LowPickup;
import frc.robot.commands.TopNode;
import frc.robot.commands.TuckedFromBottom;
import frc.robot.commands.TuckedFromTop;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotArmSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Tucked;

public class RobotContainer {
  private final PivotArmSubsystem p_subsystem = new PivotArmSubsystem(); 
  private final ElevatorSubsystem elevator = new ElevatorSubsystem();

  //private final Joystick joystick1 = new Joystick(0);
  private final XboxController xController = new XboxController(0);

  public RobotContainer() {
   // p_subsystem.setDefaultCommand(new PivotArmJoystickCmd(p_subsystem, () -> xController.getLeftY()));
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(xController, 1).onTrue(new LowPickup(p_subsystem, elevator)); // Button for picking up and scoring
    new JoystickButton(xController, 2).onTrue(new TuckedFromBottom(p_subsystem, elevator)); // Button for tucking from the 
    new JoystickButton(xController, 3).onTrue(new TopNode(p_subsystem, elevator)); // Button for the middle position
    new JoystickButton(xController, 4).onTrue(new TuckedFromTop(p_subsystem, elevator)); // Button for the high position
    new JoystickButton(xController, 5).onTrue(Tucked.getCommand(p_subsystem, elevator)); // Button for tucking in from the bottom or top
  }

  

  public Command getAutonomosCommand() {
    return null;
  }
}