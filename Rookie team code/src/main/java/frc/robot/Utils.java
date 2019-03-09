package frc.robot;



public class Utils
{

    public static double ensureRange(double v, double min, double max)
    {
        return Math.min(Math.max(v, min), max);
    }












}