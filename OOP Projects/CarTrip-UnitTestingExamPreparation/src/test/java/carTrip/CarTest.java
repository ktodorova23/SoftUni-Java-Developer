package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;

    @Before
    public void setCar() {
        this.car = new Car("Suzuki", 50, 30, 10);
    }

    @Test
    public void getModelShouldWorkProperly() {
        Assert.assertEquals("Suzuki", car.getModel());
    }

    @Test
    public void gettankCapacityShouldWorkProperly() {
        Assert.assertEquals(50, car.getTankCapacity(), 0.0);
    }

    @Test
    public void getFuelAmountShouldWorkProperly() {
        Assert.assertEquals(30, car.getFuelAmount(), 0.0);
    }

    @Test
    public void getConsumptionPerKmShouldWorkProperly() {
        Assert.assertEquals(10, car.getFuelConsumptionPerKm(), 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowAnExceptionIfEmptyStringIsEntered() {
        car.setModel("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowAnExceptionIfNullEntered() {
        car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowAnExceptionIfFuelAmountGreaterThanTankCapacityIsEntered() {
        car.setFuelAmount(60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmShouldThrowAnExceptionIfNegativeValueIsEntered() {
        car.setFuelConsumptionPerKm(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmShouldThrowAnExceptionIfZeroIsEntered() {
        car.setFuelConsumptionPerKm(0);
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowAnExceptionIfTheAmountOfFuelIsInsufficient() {
        car.drive(5);
    }

    @Test
    public void driveShouldReduceTheAmountOfFuelCorrectly() {
        car.drive(2);
        Assert.assertEquals(10, car.getFuelAmount(), 0.0);
    }

    @Test
    public void driveShouldReturnCorrectMessage() {
        String message = car.drive(2);
        Assert.assertEquals("Have a nice trip", message);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowAnExceptionIfFuelBecomesMoreThanTankCapacityWithRefueledAmount() {
        car.refuel(30);
    }

    @Test
    public void refuelShouldFuelQuantityCorrectly() {
        car.refuel(10);
        Assert.assertEquals(40, car.getFuelAmount(), 0.0);
    }
}