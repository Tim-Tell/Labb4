import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */



public class CarController {

    double trailerAmount = 10;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    int gasAmount = 0;


    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    //CarView carView;
    // A list of cars, modify if needed
    protected ArrayList<Cars> cars = new ArrayList<>();
    Timer timer = new Timer(delay, new CarController.TimerListener());

    public CarController(){
        //makeDrawPanel(frame);
        System.out.println("i am a car controller");
    }


    public ArrayList<Cars> GetArrayList(){
        return cars;
    }

    public void makeDrawPanel(CarView carView) {
        this.frame = carView;
        carView.setArrayList(cars);

        carView.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        carView.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                gas(gasAmount);
            }
        });

        carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                brake(gasAmount);
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                startCars();
                System.out.println("In startButton");
            }
        });

        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                stopCars();
            }
        });

        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                turboOn();
            }
        });

        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                turboOff();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                trailerUp(trailerAmount);
            }
        });

        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                trailerDown(trailerAmount);
            }
        });


    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.repaintFrame();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars
                ) {
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



}



