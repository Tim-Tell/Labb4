
import java.awt.*;

public class CarTransport extends Cars {

    Boolean trailerUp = false;

    Cars[] carsOnTruck = new Cars[3];

    public CarTransport() {
        super(2, 100, Color.green, "Car Transport", "North", 0, 0);
    }

    public void trailerUp() {
        if (this.getCurrentSpeed() != 0) {
            System.out.println("Can't move trailer when Truck is in moving");
        } else {
            trailerUp = true;
        }
    }

    public void trailerDown() {
        if (this.getCurrentSpeed() != 0) {
            System.out.println("Can't move trailer when Truck is in moving");

        } else {
            trailerUp = false;
        }
    }

    public int getNrOfCarsInTruck() {
        int x = 0;
        for (int i = 0; i < carsOnTruck.length; i++) {
            if (carsOnTruck[i] != null) {

                x = x + 1;
            }
        }
        return x;


    }

    public void loadCar(Cars car) {
        if (car instanceof CarTransport) {
            System.out.println("The truck can't carry another car transport");
        } else if (getNrOfCarsInTruck() == 3) {
            System.out.println("The truck is full");
        } else if (trailerUp == true) {
            System.out.println("The truck is up");
        } else if (Math.abs(this.getPosY() - car.getPosY()) < 1 && Math.abs(this.getPosX() - car.getPosX()) < 1) {
            carsOnTruck[getNrOfCarsInTruck()] = car;
            car.setPosY(this.getPosY());
            car.setPosX(this.getPosX());
        }
    }

    private int checkIfCarIsInList(Cars car) {
        int x = 10;
        for (int i = 0; i < carsOnTruck.length; i++) {
            if (car == carsOnTruck[i]) {
                x = i;
            }
        }
        return x;
    }

    public void unloadCar(Cars car) {
        int carInList = checkIfCarIsInList(car);
        if (carInList == 10) {
            System.out.println("Car not on truck");
        } else if (carInList == getNrOfCarsInTruck() - 1) {
            carsOnTruck[carInList] = null;
            car.setPosY(this.getPosY() + 0.1);
            car.setPosX(this.getPosX() + 0.1);
        }
    }


    public double speedFactor() {
        if (carsOnTruck[0] == null) {
            return 55;
        } else if (carsOnTruck[0] != null && carsOnTruck[1] == null) {
            return 40;
        } else {
            return 25;
        }
    }
   @Override
    public void move() {
        if (trailerUp == false) {
            System.out.println("Truck cant move when the trailer is down");
        } else {
            super.move();
            System.out.println("truck moved");
            for (int i = 0; i < getNrOfCarsInTruck(); i++) {

                carsOnTruck[i].setPosY(this.getPosY());
                carsOnTruck[i].setPosX(this.getPosX());
            }
        }
    }
}




