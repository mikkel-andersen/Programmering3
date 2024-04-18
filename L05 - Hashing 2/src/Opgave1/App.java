package Opgave1;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Set set = new HashSet();

        Bil b1 = new Bil("MM12345", "Volvo", "XC90", "Rød");
        Bil b2 = new Bil("MM12345", "Volvo", "XC90", "Gul");


        set.add(b1);
        set.add(b2);

        System.out.println(set);
    }
}
