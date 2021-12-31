/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import jdk.nashorn.internal.parser.DateParser;

public class XDate {
    private static SimpleDateFormat fomater = new SimpleDateFormat();
    public static Date parse(String text,String pattern)throws RuntimeException{
        try {
            fomater.applyPattern(pattern);
            return fomater.parse(text);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    public static Date parse(String text) throws RuntimeException{
        return XDate.parse(text,"dd-MM-yyyy");
    }
}
