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
    World world;

    int gasAmount = 0;

    double trailerAmount = 10;

    // A list of cars, modify if needed

    public CarController(World world){
        //makeDrawPanel(frame);
        this.world = world;
        System.out.println("i am a car controller");
    }

    public void makeDrawPanel(CarView carView) {
        this.frame = carView;

        carView.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        carView.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.gas(gasAmount);
            }
        });

        carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.brake(gasAmount);
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.startCars();
                System.out.println("In startButton");
            }
        });

        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.stopCars();
            }
        });

        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.turboOn();
            }
        });

        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.turboOff();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.trailerUp(trailerAmount);
            }
        });

        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.trailerDown(trailerAmount);
            }
        });


    }





}



