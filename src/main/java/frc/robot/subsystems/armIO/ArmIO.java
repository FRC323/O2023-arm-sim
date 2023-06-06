package frc.robot.subsystems.armIO;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmInputs {
        public double proximalAngle;
        public double proximalEncoderValue;
        public double proximalOutputVoltage;
        public double proximalCurrentDraw;

        public double distalAngle;
        public double distalEncoderValue;
        public double distalOutputVoltage;
        public double distalCurrentDraw;
    }

    public void updateInputs (ArmInputs inputs);
    public void setVoltageOutputs(double proximalVoltage, double distalVoltage);
    public void resetProximalEncoder(double absoluteEncoderVolts);
    public void resetDistalEncoder(double absoluteEncoderVolts);


}
