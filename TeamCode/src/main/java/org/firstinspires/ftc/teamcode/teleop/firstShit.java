package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
public class firstShit extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor flDrive, frDrive, blDrive, brDrive = null;
    boolean forward = true;

    @Override
    public void runOpMode() {
        flDrive  = hardwareMap.get(DcMotor.class, "flDrive");
        frDrive = hardwareMap.get(DcMotor.class, "frDrive");
        blDrive  = hardwareMap.get(DcMotor.class, "blDrive");
        brDrive = hardwareMap.get(DcMotor.class, "brDrive");

        flDrive.setDirection(DcMotor.Direction.REVERSE);
        frDrive.setDirection(DcMotor.Direction.FORWARD);
        blDrive.setDirection(DcMotor.Direction.REVERSE);
        brDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            flDrive.setPower(leftPower);
            frDrive.setPower(rightPower);
            blDrive.setPower(leftPower);
            brDrive.setPower(rightPower);

            if(gamepad1.a && forward){
                forward = false;
                flDrive.setDirection(DcMotor.Direction.FORWARD);
                frDrive.setDirection(DcMotor.Direction.REVERSE);
                blDrive.setDirection(DcMotor.Direction.FORWARD);
                brDrive.setDirection(DcMotor.Direction.REVERSE);
                sleep(100);
            }
            else if(gamepad1.a && !forward){
                forward = true;
                flDrive.setDirection(DcMotor.Direction.REVERSE);
                frDrive.setDirection(DcMotor.Direction.FORWARD);
                blDrive.setDirection(DcMotor.Direction.REVERSE);
                brDrive.setDirection(DcMotor.Direction.FORWARD);
                sleep(100);
            }
        }
    }
}
