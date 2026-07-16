package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBench {
    NormalizedColorSensor colorSensor;

    public enum DectectedColor {
        RED,

        BLUE,

        YELLOW,

        UNKNOWN
    }
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

                        // Color Sensor
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(8);
    }
        public DectectedColor getDetectedColor(Telemetry telemetry) {
            NormalizedRGBA colors = colorSensor.getNormalizedColors();

            float normRed, normGreen, normBlue;
            normRed = colors.red / colors.alpha;
            normGreen = colors.green / colors.alpha;
            normBlue = colors.blue / colors.alpha;

            telemetry.addData("red", normRed);
            telemetry.addData("green", normGreen);
            telemetry.addData("blue", normBlue);



            if (normRed > 0.35 && normGreen < 0.3 && normBlue < 0.3) {
                return DectectedColor.RED;

            }
            else if (normRed > 0.5 && normGreen > 0.9 && normBlue < 0.6) {
                return DectectedColor.YELLOW;
            }
            else if (normRed < 0.2 && normGreen < 0.5 && normRed > 0.5) {
                return DectectedColor.BLUE;
            }
            else  {
                return DectectedColor.UNKNOWN;
            }
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


