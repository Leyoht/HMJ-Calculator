/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjcalc.objects;

import hmjcalc.objects.Bar; //this class will inherit barID from Bar

/**
 *
 * @author dtdkn
 */
public class barLocation extends Bar { //find out how to directly tie Bar instantiations to barLocations
    private static String street1;
    public static String getS1() { return street1; }
    public static void setS1(String street1) { barLocation.street1 = street1; }
    
    private static String street2;
    public static String getS2() { return street2; }
    public static void setS2(String street2) { barLocation.street2 = street2; }
    
    private static String city;
    public static String getCity() { return city; }
    public static void setCity(String city) { barLocation.city = city; }
    
    private static String state;
    public static String getState() {return state; }
    public static void setState(String state) {barLocation.state = state; }
    
    private static String zip;
    public static String getZip() { return zip; }
    public static void setZip(String zip) { barLocation.zip = zip; }
}
