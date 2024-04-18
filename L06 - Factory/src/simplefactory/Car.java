package simplefactory;

public abstract class Car {
    private int seats;
    private int doors;

    public abstract int getSeats();

    public abstract void setSeats(int seats);

    public abstract int getDoors();

    public abstract void setDoors(int doors);

}
