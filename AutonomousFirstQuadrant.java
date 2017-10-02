import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by hsstudent on 10/2/17.
 */

public class FirstQuadrantAutonomous {
}
package org.swerverobotics.library.examples;

        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.*;
        import org.swerverobotics.library.*;
        import org.swerverobotics.library.interfaces.*;

/**
 * This autonomous OpMode drives the robot forward for a while, turns left, then drives forward
 * again and turns left, etc, until a polygon has been completed. The straights and turns are controlled
 * with simple time values and thus are necessarily only approximate and crude: the point here
 * is not to make a perfect regular polygon but rather to demonstrate the structure of code.
 *
 * This OpMode expects two motors, named 'motorLeft' and 'motorRight' respectively. The
 * OpMode works with both legacy and modern motor controllers.
 */
@Autonomous(name="Auto Polygon (Linear)", group="Swerve Examples")
@Disabled
public class Second Quadrant Autonymous extends LinearOpMode
{
    DcMotor motorRight;
    DcMotor motorLeft;

    /*
    below two of the variables are blank due to us not knowing how fast the robot goes,
    thus we can not determine how long it should travel for
    */

    final long msStraight   = ;
    final long msTurn       = ;
    final double drivePower = 1.0;
    final int  numSides     = 4;

    public @Override void runOpMode() throws InterruptedException
    {
        motorLeft   = hardwareMap.dcMotor.get("motorLeft");
        motorRight  = hardwareMap.dcMotor.get("motorRight");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        this.waitForStart();

        for (int i = 0; i < numSides; i++)
        {
            goStraight();
            Thread.sleep(msStraight);

            turnRight();
            Thread.sleep(msTurn);
        }

        stopRobot();
    }

    void goStraight()
    {
        motorLeft.setPower(drivePower);
        motorRight.setPower(drivePower);
    }
    void turnRight ()
    {
        motorLeft.setPower(-drivePower);
        motorRight.setPower(drivePower);
    }
    void stopRobot()
    {
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }
}
