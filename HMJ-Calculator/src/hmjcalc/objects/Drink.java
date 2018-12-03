/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjcalc.objects;

import hmjcalc.iDrinks;

/**
 *
 * @author dtdkn
 */
public abstract class Drink implements iDrinks { //how to implement Java interfaces: https://www.tutorialspoint.com/java/java_interfaces.htm
    private static int drinkID;
    private static String name;
    private static double alcoholContent;
    private static double volume;
    
    public static int getID() { return drinkID; }
    public static void setID(int drinkID) { Drink.drinkID = drinkID; }
    public static String getName() { return name; }
    public static void setName(String name) { Drink.name = name; }
    public static Double getAC() { return alcoholContent; }
    public static void setAC(Double ac) { Drink.alcoholContent = ac; }
    public static Double getVolume() { return volume; }
    public static void setVolume(Double volume) { Drink.volume = volume; }
}
