/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjcalc.objects;

/**
 *
 * @author dtdkn
 */
public class Bar {
    private static String name;
    public static String getName() { return name; }
    public static void setName(String name) { Bar.name = name; }
    
    private static int barID;
    public static int getID() { return barID; }
    public static void setID(int barID) { Bar.barID = barID; }
}
