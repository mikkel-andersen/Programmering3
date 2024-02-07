package Adapter;

public class Vare {
    private String navn;
    private int pris;

    public Vare(String navn, int pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public double beregnMoms() {
        return pris * 0.25;
    }


}
