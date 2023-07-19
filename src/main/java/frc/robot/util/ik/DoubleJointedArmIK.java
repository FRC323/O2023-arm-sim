package frc.robot.util.ik;

import java.util.Arrays;
import java.util.Vector;



public class DoubleJointedArmIK implements InverseKinematics{
    final static float THRESHOLD = 0.0001f;
    private float proximalLength, distalLength;
//    TODO: We need to account for joint constraints somewhere, either here or in controller

    public DoubleJointedArmIK(float proximalLength, float distalLength){
        this.proximalLength = proximalLength;
        this.distalLength = distalLength;
    }
    @Override
    public SystemPose solve(Vector<Float> targetPos) {
        float x,y,z, proximalAngle, distalAngle;
        x = targetPos.get(0);
        y = targetPos.get(1); // This will be ignored, we don't have the ability to move in this axis
        z = targetPos.get(2);
        if (Math.abs(y) >= THRESHOLD) {
            return INVALID;
        }

//        This is all law of cosines
        double a = (double) distalLength;
        double b = Math.sqrt(x*x+y*y);
        double c = (double)  proximalLength;

//        These are the interior angles of the triangle
        double alpha = Math.acos((b*b+c*c-a*a)/2.0*b*c);
        double beta = Math.acos((a*a + b*b - c*c)/2.0*a*c);

//        If either of these returned NaN we can't find a solution
        if(Double.isNaN(alpha) || Double.isNaN(beta)) {
            return INVALID;
        }

        distalAngle = 180f - (float) beta;
        double a_p = Math.atan(z/x);
        proximalAngle = (float) alpha + (float) a_p;

//        TODO: Return alternate option


        Vector<Float>angles = new Vector<Float>(Arrays.asList(proximalAngle, distalAngle));
        return new SystemPose(angles);

    }

    public float getDistalLength() {
        return distalLength;
    }

    public void setDistalLength(float distalLength) {
        this.distalLength = distalLength;
    }

    public float getProximalLength() {
        return proximalLength;
    }

    public void setProximalLength(float proximalLength) {
        this.proximalLength = proximalLength;
    }
}
