/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjcalc;

/**
 *
 * @author dtdkn
 */
public class Person {
    private static int age;
    private static int getAge() { return age; }
    private static void setAge(int age) { Person.age = age; }
    
    private static int weight;
    private static int getWeight() { return weight; }
    private static void setWeight(int weight) { Person.weight = weight; }
    
    private static boolean sex; //false for male, true for female
    private static boolean getSex() { return sex; }
    private static void setSex(boolean sex) {
        if (sex == true) {
            Person.sex = true; //they are female
        } else {
            Person.sex = false; //they are male
        }
    }
    
    //dDrunk means "desired drunkenness"
    private static int dDrunk; //ask (on a scale of 1 - 10) how drunk someone wants to be
    private static int getDDrunk() { return dDrunk; }
    private static void setDDrunk(int dDrunk) { Person.dDrunk = dDrunk; }
    
    private static int howLongDrinking; //how many hours someone is drinking
    private static int gethLD() { return howLongDrinking; }
    private static void sethLD(int hLD) { Person.howLongDrinking = hLD; }
    
    /*There will be an algorithm to detect the preferred drink of the user.
    * The system will simply look at the user's history and determine
    * which drink they have chosen most often; whichever shows up most
    * will be shown as the preferred drink.
    * Not sure if we should use Strings or a drink ID for this.*/
    private static String prefDrink;
    private static String getPDrink() { return prefDrink; }
    private static void setPDrink(String prefDrink) {Person.prefDrink = prefDrink; }
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    public double howManyShouldIDrink() {
        double BAC = 0.0;
        double numOfDrinks, r; //r is gender constant
        double y = Person.weight; //weight in grams
        
        if (Person.sex == true) {
            r = 0.55;
        } else {
            r = 0.68;
        }
        
        switch (dDrunk) { //switches make if/else much easier: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
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
        double BACWithTime = BAC - (Person.howLongDrinking * 0.015);
        numOfDrinks = (((BACWithTime / 100 ) * (y * r)) / 14);
        return roundAvoid(numOfDrinks,2);
    }
    
    public boolean areYouLegal() {
        if (Person.age >= 21) {
            return true;
        } else {
            return false;
        }
    }
}
