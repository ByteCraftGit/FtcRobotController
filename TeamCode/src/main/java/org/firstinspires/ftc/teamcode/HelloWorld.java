package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous
@Disabled
public class HelloWorld extends OpMode {

     @Override
    public void init() {
        telemetry.addData("Hello", "Suhan");
    }

    @Override
    public void loop() {

    }

    //Single Line Comment
    /*


     */
}
