package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
@Disabled
@TeleOp
public class ColorSensorPractice extends OpMode {
        TestBench bench = new TestBench();
        TestBench.DectectedColor dectectedColor;
    @Override
    public void init() {
       bench.init(hardwareMap);
    }

    @Override
    public void loop() {
       dectectedColor = bench.getDetectedColor(telemetry);
       telemetry.addData("Color Detected", dectectedColor);
    }
}
