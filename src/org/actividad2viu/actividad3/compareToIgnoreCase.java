package org.actividad2viu.actividad3;

public class compareToIgnoreCase {
    public static void main(String[] args) {
        //Compare to a String
        String str_Sample = "RockStar";
        System.out.println("Compare To 'ROCKSTAR': " + str_Sample.compareTo("rockstar"));
        //Compare to - Ignore case
        System.out.println("Compare To 'ROCKSTAR' - Case Ignored: " + str_Sample.compareToIgnoreCase("ROCKSTAR"));
        System.out.println("Compare To 'ROCKSTAR' - Case Ignored: " + str_Sample.compareToIgnoreCase("RockStar"));
    }
}
