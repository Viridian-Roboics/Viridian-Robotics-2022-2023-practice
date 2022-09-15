package org.firstinspires.ftc.teamcode.Auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Control Hub Practice", group="Robot")
public class Test extends LinearOpMode{
    private DcMotor motor = null;
    private ElapsedTime runtime = new ElapsedTime();
    private Servo servo = null;

    @Override
    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class, "m");
        servo = hardwareMap.get(Servo.class, "s");
        runtime.reset();

        waitForStart();
        while(opModeIsActive() && (runtime.seconds()<= 120)) {
            motor.setPower(1);
            servo.setPosition(1);
            sleep(2000);
            servo.setPosition(0);
            sleep(2000);
        }
    }
}
