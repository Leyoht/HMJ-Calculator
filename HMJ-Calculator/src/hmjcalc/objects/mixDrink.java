/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjcalc.objects;

import hmjcalc.objects.Drink;

/**
 *
 * @author dtdkn
 */
public class mixDrink extends Drink {
    //there needs to be some kind of attribute here to set the mixDrink apart from Drink
    //drinkID is 4
    private static int mixID;
    private static int getID() { return mixID; }
    private void setID(int mixID) { mixDrink.mixID = mixID; }
}
