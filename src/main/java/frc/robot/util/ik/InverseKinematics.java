package frc.robot.util.ik;

import java.util.Collections;
import java.util.Vector;

public interface InverseKinematics {
//    Returns a series of possible solutions. If there are no solutions none could be found
//    Takes a Vector of Floats representing the target point for the end effector
//    The target point must be based on 0,0,0 being the origin of the system
//    Z axis is up, X axis is towards the front of the robot
SystemPose solve(Vector<Float> targetPos);


    SystemPose INVALID = new SystemPose();

    class SystemPose {
        public SystemPose(){}
        public SystemPose(Vector<Float> jointAngles){
            this.jointAngles = new Vector<>(Collections.singletonList(jointAngles));
        }
        private Vector<Vector<Float>> jointAngles;

        public Vector<Vector<Float>> getJointAngles() {
            return jointAngles;
        }
    }
}


