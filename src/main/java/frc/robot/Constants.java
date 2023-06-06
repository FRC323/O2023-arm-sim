// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


  public static class Arm {
    public static class Proximal {

        public static double GEARING = 10.0;
      public static double LENGTH_METERS = Units.inchesToMeters(38.75);
      public static double MASS_KG = Units.lbsToKilograms(15.0);
      public static final double INIT_DEG = 45;
      public static double U_LIMIT_DEG = -45;
      public static double L_LIMIT_DEG = 45;
//      TODO: What are these units?
      public static double MAX_VEL = 400;
      public static double MAX_ACC = 1250;
      public static double ANGLE_CONVERSION_FACTOR = 1.0 / GEARING * 360.0;
      public static double VEL_CONVERSION_FACTOR = ANGLE_CONVERSION_FACTOR/60.0;



    }
  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
