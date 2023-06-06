package frc.robot.subsystems.armIO;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
        IO.setVoltageOutputs(1.5, 0);
    }
}
