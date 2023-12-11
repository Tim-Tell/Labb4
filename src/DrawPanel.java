import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;
import java.util.Objects;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize


    BufferedImage volvoImage;
    BufferedImage ScaniaImage;
    BufferedImage SaabImage;
    BufferedImage carTransportImage;

    Map<Cars, BufferedImage> carsMap = new HashMap<>();

    // To keep track of a singel cars position


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Cars> carList) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        {
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.

                volvoImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
                ScaniaImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
                SaabImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
                carTransportImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
                for (Cars car : carList){
                    addNewCar(car);}
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    public BufferedImage getImage(Cars car){
        //returnera rätt image, nu får alla volvoImage
        try{
            this.setDoubleBuffered(true);
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return volvoImage;
    }

    protected void addCars(ArrayList<Cars> carList){
        for (Cars car : carList) {
            if (car instanceof Saab95) {
                carsMap.put(car, SaabImage);
            } else if (car instanceof Volvo240) {
                carsMap.put(car, volvoImage);
            } else if (car instanceof Scania) {
                carsMap.put(car, ScaniaImage);
            }
        }

    }

    protected void addNewCar(Cars car){{
            if (car instanceof Saab95) {
                carsMap.put(car, SaabImage);
            } else if (car instanceof Volvo240) {
                carsMap.put(car, volvoImage);
            } else if (car instanceof Scania) {
                carsMap.put(car, ScaniaImage);
            }
            else if (car instanceof CarTransport) {
                carsMap.put(car, carTransportImage);
            }
        }

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (carsMap == null) {
                this.setDoubleBuffered(true);
                this.setPreferredSize(new Dimension(800, 800));
                this.setBackground(Color.green);}
        else{
            for (Cars car : carsMap.keySet()){
            g.drawImage(carsMap.get(car), (int) car.getPosX(), (int) car.getPosY(), null);}
        }
    }
}

