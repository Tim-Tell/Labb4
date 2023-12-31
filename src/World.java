import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

public class World {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    protected ArrayList<Cars> cars = new ArrayList<>();
    Timer timer = new Timer(delay, new World.TimerListener());
    ArrayList<CarObserver> carObserverArrayList = new ArrayList<>();

        void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (Cars car : cars) {
                car.gas(gas);
            }
        }

        void brake (int amount) {
            double brake= ((double) amount) / 100;
            for (Cars car : cars) {
                car.brake(brake);
            }
        }

        void startCars() {
            for (Cars car : cars) {
                car.startEngine();
            }
        }

        void stopCars() {
            for (Cars car : cars) {
                car.stopEngine();
            }
        }

        void turboOn() {
            for (Cars car : cars) {
                if (car instanceof Saab95) {
                    ((Saab95) car).setTurboOn();
                }
            }
        }


        void turboOff() {
            for (Cars car : cars) {
                if (car instanceof Saab95) {
                    ((Saab95) car).setTurboOff();
                }
            }
        }

        void trailerUp(double amount) {
            for (Cars car : cars) {
                if (car instanceof Scania) {
                    ((Scania) car).trailerUp(amount);
                }
                else if (car instanceof CarTransport){
                    ((CarTransport) car).trailerUp();
                }
            }
        }

        void trailerDown(double amount) {
            for (Cars car : cars) {
                if (car instanceof Scania) {
                    ((Scania) car).trailerDown(amount);
                }
                else if (car instanceof CarTransport){
                    ((CarTransport) car).trailerDown();
            }
            }
        }

        public void addObserver(CarObserver observer){
            carObserverArrayList.add(observer);
        }

        public void removeObserver(CarObserver observer){
            for (int x=0; x < carObserverArrayList.size(); x++){
                if (carObserverArrayList.get(x) == observer){
                    carObserverArrayList.remove(observer);
                }
            }
        }

        public void notifyObservers(){
            for (CarObserver carObserver: carObserverArrayList){
                carObserver.carObjectChanged();
            }
        }

        /* tar emot en string som antingen är en bil ("volvo", "saab", "scania", "car transport")
        eller något helt annat, är de en bil så läggs den sortens bil till, annars läggs en random bil till
         */
        public void addCar(String car){
            String carToAdd;

            if (cars.size() == 10){
                System.out.println("can't add anymore cars");
            }
            else{

            if (car.equals("volvo") || car.equals("saab") || car.equals("scania") || car.equals("car transport")) {
                carToAdd = car;
            }
            else {
                Random rand = new Random();
                int upperbound = 4;
                ArrayList<String> potentialCars = new ArrayList<>();
                potentialCars.add("volvo");
                potentialCars.add("saab");
                potentialCars.add("scania");
                potentialCars.add("car transport");

                int int_random = rand.nextInt(upperbound);

                carToAdd = potentialCars.get(int_random);
            }
            switch (carToAdd){
                case ("volvo"):
                    cars.add(new Volvo240());
                    break;
                case "saab":
                    cars.add(new Saab95());
                    break;
                case "scania":
                    cars.add(new Scania());
                    break;
                case "car transport":
                    cars.add(new CarTransport());
                    break;
        }
            notifyObservers();
            }
        }

    public void removeCar(Cars car){
            System.out.println("car was removed");
        if (cars.isEmpty()){
            System.out.println("Game is empty off cars, can't remove any more.");
        }
        else {
            cars.remove(car);

        }
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
     * observers to update its images.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                notifyObservers();
            }
        }
    }
}