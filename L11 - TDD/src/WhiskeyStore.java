import java.util.ArrayList;

public class WhiskeyStore {

    private ArrayList<Whiskey> whiskies;

    public WhiskeyStore() {
        this.whiskies = new ArrayList<>();
    }

    public ArrayList<Whiskey> getWhiskies() {
        return new ArrayList<>(whiskies);
    }

    public void addWhisky(Object whisky) { // Metode definition, tager et objekt som parameter
        if (whisky instanceof Whisky) { // Tjekker om det indgående objekt er en instans af Whisky klassen
            whiskies.add(new WhiskyAdapter((Whisky) whisky)); // Hvis ja, oprettes en ny WhiskyAdapter med det indgående objekt som parameter, og denne adapter tilføjes til whiskies listen
        } else if (whisky instanceof Whiskey) { // Hvis det indgående objekt ikke er en instans af Whisky klassen, tjekker det om det er en instans af Whiskey klassen
            whiskies.add((Whiskey) whisky); // Hvis ja, tilføjes det direkte til whiskies listen
        } // Hvis det indgående objekt ikke er en instans af hverken Whisky eller Whiskey klassen, sker der intet, og metoden afsluttes uden at ændre whiskies listen
    }
}
