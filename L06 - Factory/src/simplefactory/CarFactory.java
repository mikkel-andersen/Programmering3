package simplefactory;

public class CarFactory {

    public enum carType {
        Sedan, Convertible, Pickup;
    }

    public enum fuelType {
        Gasoline, Electric, Hybrid;
    }

    public Car createCar(carType carType, int seats, int doors) {
        Car car = null;

        if (carType.equals(CarFactory.carType.Sedan)) {
            car = new Sedan(seats, doors);
        } else if (carType.equals(CarFactory.carType.Convertible)) {
            car = new Convertible(seats, doors);
        } else if (carType.equals(CarFactory.carType.Pickup)) {
            car = new Pickup(seats, doors);
        }
        return car;
    }


}
