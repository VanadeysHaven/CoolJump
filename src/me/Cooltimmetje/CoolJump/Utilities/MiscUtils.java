package me.Cooltimmetje.CoolJump.Utilities;

/**
 * This class has been created on 13-5-2015 at 21:21 by cooltimmetje.
 */

public class MiscUtils {

    public static String color(String s){
        String colorString = s.replace('&', '\u00A7');
        return colorString;
    }

}