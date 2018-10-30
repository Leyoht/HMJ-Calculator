/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmdatabase;

/**
 *
 * @author dtdkn
 */
public class barLocation extends Bar { //find out how to directly tie Bar instantiations to barLocations
    private static String street1;
    private static String getS1() { return street1; }
    private static void setS1(String street1) { barLocation.street1 = street1; }
    
    private static String street2;
    private static String getS2() { return street2; }
    private static void setS2(String street2) { barLocation.street2 = street2; }
    
    private static String city;
    private static String getCity() { return city; }
    private static void setCity(String city) { barLocation.city = city; }
    
    private static String state;
    private static String getState() {return state; }
    private static void setState(String state) {barLocation.state = state; }
    
    private static String zip;
    private static String getZip() { return zip; }
    private static void setZip(String zip) { barLocation.zip = zip; }
}
