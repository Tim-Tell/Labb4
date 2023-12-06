import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/



public class CarView extends JFrame implements CarObserver{

    private static final int X = 800;
    private static final int Y = 800;

    String frameName; // The controller member
    DrawPanel drawPanel;
    World world;


    double trailerAmount = 10;



    // Constructor
    public CarView(String frameName, World world){
        this.world = world;
    }

        public void makeDrawPanel(ArrayList<Cars> cc){
        //carList = cc;
        drawPanel = new DrawPanel(X, Y-240, cc);
    }

    public void makeComponents(){
        initComponents(frameName);
    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));


        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getSizeY() {
        return Y;
    }

    public int getSizeX() {
        return X;
    }

    public void firstPaintCombonent(){
        drawPanel.paintComponent();
    }



    @Override
    public void carObjectChanged() {
        System.out.println("car object changed");
        drawPanel.repaint();
    }

    public void addObserver (){
    int d=1;
    }

    public void removeObserver(){
        int d=2;
    }
}