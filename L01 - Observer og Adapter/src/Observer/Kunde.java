package Observer;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private List<BogTitel> bogTitelListe;
    private String navn;

    public Kunde(String navn) {
        this.navn = navn;
        bogTitelListe = new ArrayList<>();
    }

    public void addBogTitel(BogTitel b) {
        bogTitelListe.add(b);
    }
}
