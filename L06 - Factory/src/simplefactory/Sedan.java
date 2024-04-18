package simplefactory;

public class Sedan extends Car {
    private int seats;
    private int doors;

    public Sedan(int seats, int doors) {
        this.seats = seats;
        this.doors = doors;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public int getDoors() {
        return doors;
    }

    @Override
    public void setDoors(int doors) {
        this.doors = doors;
    }
}
