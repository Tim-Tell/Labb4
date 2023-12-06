import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */



public class CarController {

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    //CarView carView;
    // A list of cars, modify if needed

    public CarController(){
        //makeDrawPanel(frame);
        System.out.println("i am a car controller");
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



