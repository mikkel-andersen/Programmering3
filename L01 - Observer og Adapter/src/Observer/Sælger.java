package Observer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sælger implements Observer {
    Set<String> BogTitel = new HashSet<>();
    private String navn;

    public Sælger(String navn) {
        this.navn = navn;
    }

    /*
    at metoden update(Subject s): void på Saelger har følgende specifikation:
    Der er udskrevet en liste på skærmen med titlen på de bøger, der er købt af andre kunder, der også har købt den netop solgte bog s.
    Listen må ikke indeholde den samme titel flere gange.
    Endvidere skal listen ikke indeholde titlen på den aktuelle bog.
     */
    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel) {    //Tjekker om s er en instans af BogTitel
            BogTitel b = (BogTitel) s;  //Sætter b = s
            BogTitel.add(b.getTitel());
            System.out.println("Bøger købt af andre kunder: " + BogTitel);}
    }
}

