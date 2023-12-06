import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class World {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    protected ArrayList<Cars> cars = new ArrayList<>();
    Timer timer = new Timer(delay, new World.TimerListener());
    ArrayList<CarObserver> carObserverArrayList = new ArrayList<>();

    public World (){}

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
            }
        }

        void trailerDown(double amount) {
            for (Cars car : cars) {
                if (car instanceof Scania) {
                    ((Scania) car).trailerDown(amount);
                }
            }
        }

        public void addObserver(CarObserver observer){
            carObserverArrayList.add(observer);
        }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                for (CarObserver carObserver: carObserverArrayList){
                    carObserver.carObjectChanged();
                }
                // for observer update observer
                //flytta detta och knapparna till cars, alltså de under.
            }
        }
    }

}