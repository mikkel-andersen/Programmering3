package Opgave1;

import java.util.Objects;

public class Bil {
    private String registreringsNummer;
    private String mærke;
    private String model;
    private String farve;

    public Bil(String registreringsNummer, String mærke, String model, String farve) {
        this.registreringsNummer = registreringsNummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    public String getRegistreringsNummer() {
        return registreringsNummer;
    }

    public void setRegistreringsNummer(String registreringsNummer) {
        this.registreringsNummer = registreringsNummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public String toString() {
        return farve + " " + mærke + " " + model + " med registreringsnummeret " + registreringsNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bil bil = (Bil) o;
        return Objects.equals(registreringsNummer, bil.registreringsNummer) &&
                Objects.equals(mærke, bil.mærke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registreringsNummer, mærke);
    }

}
