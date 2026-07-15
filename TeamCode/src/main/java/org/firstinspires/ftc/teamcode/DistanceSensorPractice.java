package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
@TeleOp
public class DistanceSensorPractice extends OpMode {
    double distance;
    TestBench bench = new TestBench();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Distance", bench.getDistance());


        if (distance < 10) {
            telemetry.addLine("Too Close");
        }
    }
}
