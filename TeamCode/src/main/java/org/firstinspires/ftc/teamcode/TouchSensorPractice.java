package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
 @TeleOp
 @Disabled
public class TouchSensorPractice extends OpMode {
    TestBench bench = new TestBench();


    @Override
    public void init() {
        bench.init(hardwareMap);
    }
    @Override
    public void loop() {
        String touchSensorState = "Not Pressed";
        String touchSensorState2 = "Pressed";
        if (bench.isTouchSensorPressed()) {
            touchSensorState = "Pressed";
        }

        telemetry.addData("Touch Sensor State", touchSensorState);
        }


    }






