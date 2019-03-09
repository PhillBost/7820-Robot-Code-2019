package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveTrain
{
    static VictorSPX leftFrontTalon;
    static VictorSPX leftBackTalon; 
    static VictorSPX rightFrontTalon; 
    static VictorSPX rightBackTalon; 
    static DriveTrain instance;

    private DriveTrain()
    {
        leftFrontTalon = new VictorSPX(12);
        leftBackTalon = new VictorSPX(13);
        rightFrontTalon = new VictorSPX(0);
        rightBackTalon = new VictorSPX(1);
        
       
    }
    
    public static DriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new DriveTrain();


        }
        return instance;
    }
  
    public static void drive(double leftSpeed,double rightSpeed)
    {
        //Left side
        leftFrontTalon.set(ControlMode.PercentOutput, leftSpeed);
        leftBackTalon.set(ControlMode.PercentOutput, leftSpeed);

        //Right side
        rightFrontTalon.set(ControlMode.PercentOutput, rightSpeed);
        rightBackTalon.set(ControlMode.PercentOutput, rightSpeed);
        

        
    }

    public static void arcadeDrive(double turn,double forward)
    {
        drive(Utils.ensureRange(forward+turn, -1d, 1d), Utils.ensureRange(forward-turn, -1d, 1d));
    

    }

    public static void tankDrive(double leftYAxis,double rightYAxis)
    {
      
        drive(leftYAxis, rightYAxis);
        

    }




}


