package frc.robot.subsystems.armIO;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Arm extends SubsystemBase {
    public final ArmInputsAutoLogged inputs;

    private final ArmIO IO;

    public Arm(ArmIO IO) {
        this.inputs = new ArmInputsAutoLogged();
        IO.updateInputs(inputs);
        this.IO = IO;
    }

    @Override
    public void periodic() {
        IO.updateInputs(inputs);
        Logger.getInstance().processInputs("Arm", inputs);
    }

    public void setVoltages(double proximal, double distal) {
        inputs.proximalOutputVoltage = proximal;
        IO.setVoltageOutputs(proximal, distal);
    }
}
