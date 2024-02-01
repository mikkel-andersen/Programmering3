package Observer;

public class Indkøber implements Observer{
    private String navn;

    public Indkøber(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel) {    //Tjekker om s er en instans af BogTitel
            BogTitel b = (BogTitel) s;  //Sætter b = s
            if (b.getAntal() < 6) {
                System.out.println("Der skal bestilles 10 bøger af " + b.getTitel());
                b.indkoebTilLager(10); //Tilføjer 10 bøger til varens lager
            }
        }
    }
}
