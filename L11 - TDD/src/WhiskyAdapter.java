public class WhiskyAdapter extends Whiskey {

    private Whisky whisky;

    public WhiskyAdapter(Whisky whisky) {
        super(whisky.getTitle(), whisky.getCountry(), whisky.getColour(), whisky.getProof());
        this.whisky = whisky;
        setAlcohol(whisky.getProof() * 0.571);
    }
}
