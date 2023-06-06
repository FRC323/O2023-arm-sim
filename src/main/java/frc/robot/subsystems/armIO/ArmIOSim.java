package frc.robot.subsystems.armIO;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.Constants;

public class ArmIOSim implements ArmIO {

    private static final SingleJointedArmSim sim =
            new SingleJointedArmSim(
                    DCMotor.getFalcon500(1),
                    Constants.Arm.Proximal.GEARING,
                    SingleJointedArmSim.estimateMOI(Constants.Arm.Proximal.LENGTH_METERS, Constants.Arm.Proximal.MASS_KG),
                    Constants.Arm.Proximal.LENGTH_METERS,
                    Units.degreesToRadians(Constants.Arm.Proximal.U_LIMIT_DEG),
                    Units.degreesToRadians(Constants.Arm.Proximal.L_LIMIT_DEG),
                    true
            );

//    This initializes the sim in a known state
    static {
        sim.setState(VecBuilder.fill(Units.degreesToRadians(Constants.Arm.Proximal.INIT_DEG), 0));
    }
    @Override
    public void updateInputs(ArmInputs inputs) {
        if (DriverStation.isDisabled()) {
            sim.setInputVoltage(0.0);
        }
        sim.update(.02);
        inputs.proximalOutputVoltage = MathUtil.clamp(sim.getOutput(0), -12,12);
        inputs.proximalAngle = Units.radiansToDegrees(sim.getAngleRads());
    }

    @Override
    public void setVoltageOutputs(double proximalVoltage, double distalVoltage) {
        sim.setInputVoltage(proximalVoltage);
    }

    @Override
    public void resetProximalEncoder(double absoluteEncoderVolts) {

    }

    @Override
    public void resetDistalEncoder(double absoluteEncoderVolts) {

    }
}
