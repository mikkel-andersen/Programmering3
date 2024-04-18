package simplefactory;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @org.junit.jupiter.api.Test
    void createCar() {
        //Arrange
        CarFactory carFactory = new CarFactory();

        //Act
        Car car = carFactory.createCar(CarFactory.carType.Sedan, 4, 4);

        //Assert
        assertNotNull(car);
        assertTrue(car instanceof Sedan);

    }
}