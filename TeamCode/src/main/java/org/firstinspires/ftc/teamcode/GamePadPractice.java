package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class GamePadPractice  extends OpMode {

    @Override
    public void init() {

    }
    @Override
    public void loop() {
        double speedForward = gamepad1.left_stick_y/2.0;
        double sumOfTriggers = gamepad1.right_trigger + gamepad1.left_trigger;


      telemetry.addData("x", gamepad1.left_stick_x);
      telemetry.addData("y", speedForward);
      telemetry.addData("a button", gamepad1.a);
      telemetry.addData("x2", gamepad1.right_stick_x);
      telemetry.addData("y2", gamepad1.right_stick_y);
      telemetry.addData("b button", gamepad1.b);
      telemetry.addData("Difference of x left and right", gamepad1.left_stick_x- gamepad1.right_stick_x );
      telemetry.addData("Sum of triggers", sumOfTriggers);
    }
}
