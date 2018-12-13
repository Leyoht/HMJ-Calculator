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
public class Person {
    private static int age;
    public static int getAge() { return age; }
    public static void setAge(int age) { Person.age = age; }
    
    private static int weight;
    public static int getWeight() { return weight; }
    public static void setWeight(int weight) { Person.weight = weight; }
    
    private static boolean sex; //false for male, true for female
    public static boolean getSex() { return sex; }
    public static void setSex(boolean sex) {
        if (sex == true) {
            Person.sex = true; //they are male
        } else {
            Person.sex = false; //they are female
        }
    }
    
    //dDrunk means "desired drunkenness"
    private static int dDrunk; //ask (on a scale of 1 - 10) how drunk someone wants to be
    public static int getDDrunk() { return dDrunk; }
    public static void setDDrunk(int dDrunk) { Person.dDrunk = dDrunk; }
    
    private static double howLongDrinking; //how many hours someone is drinking
    public static double gethLD() { return howLongDrinking; }
    public static void sethLD(double hLD) { Person.howLongDrinking = hLD; }
    
    /*There will be an algorithm to detect the preferred drink of the user.
    * The system will simply look at the user's history and determine
    * which drink they have chosen most often; whichever shows up most
    * will be shown as the preferred drink.
    * Not sure if we should use Strings or a drink ID for this.*/
    private static String prefDrink;
    public static String getPDrink() { return prefDrink; }
    public static void setPDrink(String prefDrink) {Person.prefDrink = prefDrink; }
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public double howManyShouldIDrink() {
        //currently this does not take the ABV of drinks into account AT ALL
        Double BAC = 0.0;
        double numOfDrinks, r; //r is gender constant
        double y = getWeight(); //weight in grams
        
        if (getSex() == true)
            r = 0.55;
        else
            r = 0.68;
        
        switch (getDDrunk()) { //switches make if/else much easier: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
            case 1: BAC = 0.02;
                break;
            case 2: BAC = 0.04;
                break;
            case 3: BAC = 0.07;
                break;
            case 4: BAC = 0.1;
                break;
            case 5: BAC = 0.13;
                break;
            case 6: BAC = 0.16;
                break;
            case 7: BAC = 0.2;
                break;
            case 8: BAC = 0.25;
                break;
            case 9: BAC = 0.3;
                break;
            case 10: BAC = 0.35;
                break;
            default:
                break;
        }
        double BACWithTime = 0.35 - (gethLD() * 0.015);
        numOfDrinks = (((BACWithTime / 100 ) * (y * r)) / 14);
        return roundAvoid(numOfDrinks,2);
    }
    
    public boolean areYouLegal() {
        if (getAge() >= 21) {
            return true;
        } else {
            return false;
        }
    }
}
