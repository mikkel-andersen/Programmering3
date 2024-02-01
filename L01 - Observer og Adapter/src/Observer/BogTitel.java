package Observer;

import java.util.ArrayList;
import java.util.List;

public class BogTitel implements Subject {
    private List<Kunde> kundeList;
    private List<Observer> observers;
    private String titel;
    private int antal;

    public BogTitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
        kundeList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void indkoebTilLager(int antal) {
        this.antal += antal;
        notifyObservers();
    }

    public void etKoeb(Kunde k) {
        k.addBogTitel(this);
        kundeList.add(k);
        antal--;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
