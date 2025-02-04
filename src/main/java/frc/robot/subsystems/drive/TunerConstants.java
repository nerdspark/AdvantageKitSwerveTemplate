package frc.robot.subsystems.drive;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.ClosedLoopOutputType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants.SteerFeedbackType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import edu.wpi.first.math.util.Units;

public class TunerConstants {
  // Both sets of gains need to be tuned to your individual robot.

  // The steer motor uses any SwerveModule.SteerRequestType control request with the
  // output type specified by SwerveModuleConstants.SteerMotorClosedLoopOutput
  public static final Slot0Configs steerGains =
      new Slot0Configs().withKP(100).withKI(0).withKD(0.2).withKS(0).withKV(1.5).withKA(0);
  // When using closed-loop control, the drive motor uses the control
  // output type specified by SwerveModuleConstants.DriveMotorClosedLoopOutput
  public static final Slot0Configs driveGains =
      new Slot0Configs().withKP(3).withKI(0).withKD(0).withKS(0).withKV(0).withKA(0);

  // The closed-loop output type to use for the steer motors;
  // This affects the PID/FF gains for the steer motors
  public static final ClosedLoopOutputType steerClosedLoopOutput = ClosedLoopOutputType.Voltage;
  // The closed-loop output type to use for the drive motors;
  // This affects the PID/FF gains for the drive motors
  public static final ClosedLoopOutputType driveClosedLoopOutput = ClosedLoopOutputType.Voltage;

  // The stator current at which the wheels start to slip;
  // This needs to be tuned to your individual robot
  public static final double kSlipCurrentA = 300.0;

  // Theoretical free speed (m/s) at 12v applied output;
  // This needs to be tuned to your individual robot

  public static final double kSpeedAt12VoltsMps = 5.21;

  // Every 1 rotation of the azimuth results in kCoupleRatio drive motor turns;
  // This may need to be tuned to your individual robot
  public static final double kCoupleRatio = 3.5714285714285716;

  public static final double kDriveGearRatio = 6.122448979591837;
  public static final double kSteerGearRatio = 21.428571428571427;

  public static final double kWheelRadiusInches = 2;

  public static final boolean kSteerMotorReversed = true;
  public static final boolean kInvertLeftSide = false;
  public static final boolean kInvertRightSide = true;

  public static final String kCANbusName = "canivore1";
  public static final int kPigeonId = 25;

  // These are only used for simulation
  public static final double kSteerInertia = 0.00001;
  public static final double kDriveInertia = 0.001;
  // Simulated voltage necessary to overcome friction
  public static final double kSteerFrictionVoltage = 0.25;
  public static final double kDriveFrictionVoltage = 0.25;

  public static final SwerveDrivetrainConstants DrivetrainConstants =
      new SwerveDrivetrainConstants().withPigeon2Id(kPigeonId).withCANbusName(kCANbusName);

  public static final SwerveModuleConstantsFactory ConstantCreator =
      new SwerveModuleConstantsFactory()
          .withDriveMotorGearRatio(kDriveGearRatio)
          .withSteerMotorGearRatio(kSteerGearRatio)
          .withWheelRadius(kWheelRadiusInches)
          .withSlipCurrent(kSlipCurrentA)
          .withSteerMotorGains(steerGains)
          .withDriveMotorGains(driveGains)
          .withSteerMotorClosedLoopOutput(steerClosedLoopOutput)
          .withDriveMotorClosedLoopOutput(driveClosedLoopOutput)
          .withSpeedAt12VoltsMps(kSpeedAt12VoltsMps)
          .withSteerInertia(kSteerInertia)
          .withDriveInertia(kDriveInertia)
          .withSteerFrictionVoltage(kSteerFrictionVoltage)
          .withDriveFrictionVoltage(kDriveFrictionVoltage)
          .withFeedbackSource(SteerFeedbackType.FusedCANcoder)
          .withCouplingGearRatio(kCoupleRatio)
          .withSteerMotorInverted(kSteerMotorReversed);

  // Front Left
  public static final int kFrontLeftDriveMotorId = 15;
  public static final int kFrontLeftSteerMotorId = 16;
  public static final int kFrontLeftEncoderId = 23;

  public static final double kFrontLeftEncoderOffset = -0.02587890625;

  public static final double kFrontLeftXPosInches = 9.375;
  public static final double kFrontLeftYPosInches = 9.375;

  // Front Right
  public static final int kFrontRightDriveMotorId = 13;
  public static final int kFrontRightSteerMotorId = 14;
  public static final int kFrontRightEncoderId = 22;

  public static final double kFrontRightEncoderOffset = 0.160400390625;

  public static final double kFrontRightXPosInches = 9.375;
  public static final double kFrontRightYPosInches = -9.375;

  // Back Left
  public static final int kBackLeftDriveMotorId = 17;
  public static final int kBackLeftSteerMotorId = 18;
  public static final int kBackLeftEncoderId = 24;

  public static final double kBackLeftEncoderOffset = 0.315185546875;

  public static final double kBackLeftXPosInches = -9.375;
  public static final double kBackLeftYPosInches = 9.375;

  // Back Right
  public static final int kBackRightDriveMotorId = 11;
  public static final int kBackRightSteerMotorId = 12;
  public static final int kBackRightEncoderId = 21;

  public static final double kBackRightEncoderOffset = 0.096435546875;

  public static final double kBackRightXPosInches = -9.375;
  public static final double kBackRightYPosInches = -9.375;

  public static final SwerveModuleConstants FrontLeft =
      ConstantCreator.createModuleConstants(
          kFrontLeftSteerMotorId,
          kFrontLeftDriveMotorId,
          kFrontLeftEncoderId,
          kFrontLeftEncoderOffset,
          Units.inchesToMeters(kFrontLeftXPosInches),
          Units.inchesToMeters(kFrontLeftYPosInches),
          kInvertLeftSide);
  public static final SwerveModuleConstants FrontRight =
      ConstantCreator.createModuleConstants(
          kFrontRightSteerMotorId,
          kFrontRightDriveMotorId,
          kFrontRightEncoderId,
          kFrontRightEncoderOffset,
          Units.inchesToMeters(kFrontRightXPosInches),
          Units.inchesToMeters(kFrontRightYPosInches),
          kInvertRightSide);
  public static final SwerveModuleConstants BackLeft =
      ConstantCreator.createModuleConstants(
          kBackLeftSteerMotorId,
          kBackLeftDriveMotorId,
          kBackLeftEncoderId,
          kBackLeftEncoderOffset,
          Units.inchesToMeters(kBackLeftXPosInches),
          Units.inchesToMeters(kBackLeftYPosInches),
          kInvertLeftSide);
  public static final SwerveModuleConstants BackRight =
      ConstantCreator.createModuleConstants(
          kBackRightSteerMotorId,
          kBackRightDriveMotorId,
          kBackRightEncoderId,
          kBackRightEncoderOffset,
          Units.inchesToMeters(kBackRightXPosInches),
          Units.inchesToMeters(kBackRightYPosInches),
          kInvertRightSide);

  //   public static final CommandSwerveDrivetrain DriveTrain =
  //       new CommandSwerveDrivetrain(DrivetrainConstants, FrontLeft, FrontRight, BackLeft,
  // BackRight);
}
