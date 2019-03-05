package by.gsu.pms;

public class Utilites {
    public static String toBYN(int copic){
        return copic/100 + "." + copic/10%10 + copic % 10+" BYN";
    }
}
