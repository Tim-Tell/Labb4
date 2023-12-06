import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

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

    private JLabel gasLabel;
    private JButton gasButton;
    private JButton brakeButton;
    private JButton turboOnButton;
    private JButton turboOffButton;
    private JButton liftBedButton;
    private JButton lowerBedButton;
    private JButton startButton;
    private JButton stopButton;
    private JPanel controlPanel;
    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();

    // A list of cars, modify if needed

    public CarController(World world, CarView carView){
        this.frame = carView;
        this.world = world;

        controlPanel = new JPanel();
        gasPanel = new JPanel();
        gasSpinner = new JSpinner();


        startButton = new JButton("Start Cars");
        stopButton = new JButton("Stop Cars");
        gasButton = new JButton("Gas");
        brakeButton = new JButton("Brake");
        turboOnButton = new JButton("Turbo On!");
        turboOffButton = new JButton("Turbo Off,");
        liftBedButton = new JButton("Lift Bed");
        lowerBedButton = new JButton("Lower Bed");

        gasLabel = new JLabel();


        System.out.println("i am a car controller");
    }

    public void createButtons() {
        // Alla Knappar som inte är start och stopp

        frame.add(controlPanel);
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.setPreferredSize(new Dimension((frame.getSizeX()/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        // StartKnapp

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(frame.getSizeX()/5-15,200));
        frame.add(startButton);

        // StopKnapp

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(frame.getSizeX()/5-15,200));
        frame.add(stopButton);

    }
    // GasSnurran skapas här
    public void createGas() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        frame.add(gasPanel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }



    public void addActionListeners() {

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.brake(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.startCars();
                System.out.println("In startButton");
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.stopCars();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.trailerUp(trailerAmount);
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                world.trailerDown(trailerAmount);
            }
        });

    }}




