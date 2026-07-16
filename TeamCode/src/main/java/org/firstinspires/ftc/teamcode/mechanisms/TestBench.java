package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBench {
    private Servo servoPos;

    private CRServo servoRot;

   private DistanceSensor distance;


    private DigitalChannel touchSensor;
    // Dc Motor
    private DcMotor motor;
    private double ticksPerRev;
            // Common between all hardware
    public void init(HardwareMap hwMap) {
                    // Distance Sensor
        distance = hwMap.get(DistanceSensor.class, "sensor_distance");
                // Dc Motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);

                    // Touch Sensor
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

                    // Servo Motor
        servoPos = hwMap.get(Servo.class, "servo_pos");
        servoRot = hwMap.get(CRServo.class, "servo_rot");
        servoPos.scaleRange(0.5,1.0);
        servoPos.setDirection(Servo.Direction.REVERSE);
        servoRot.setDirection(CRServo.Direction.REVERSE);
    }

                // Distance Sensor
    public double getDistance() {
        return  distance.getDistance((DistanceUnit.CM));
    }
                // ---Dc Motor---
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;
    }

    public void setMotorZeroBehaviour(DcMotor.ZeroPowerBehavior zeroBehaviour) {
        motor.setZeroPowerBehavior(zeroBehaviour);

    }
            //---Touch Sensor---
    public boolean getTouchSensorState() {
        return  !touchSensor.getState();
    }

    public boolean isTouchSensorPressed() {
        return touchSensor.getState();
    }
                // Servo Motor
    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }

    public void setServoRot(double power) {
        servoRot.setPower(power);

    }





}


