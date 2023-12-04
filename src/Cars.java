
import java.awt.*;

public abstract class Cars implements Movable {


    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double posX;   // Position X of the car
    private double posY;   // Position Y of the car
    private String direction;  // Direction of the car

    public abstract double speedFactor();



    public Cars(int nrDoors, double enginePower, Color color,
                String modelName, String direction, double posY, double posX) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.posY = posY;
        this.posX = posX;
        stopEngine();

    }

    protected int GetnrDoors() {
        return nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    protected double geteningePower() {
        return enginePower;
    }

    protected double GetcurrentSpeed() {
        return currentSpeed;
    }

    protected String getDirection() {
        return direction;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected double getPosX(){
        return posX;
    }

    protected double getPosY(){
        return posY;
    }

    public void setPosY(double place){
        posY = place;
    }

    public void setPosX(double place){
        posX = place;
    }

    public void move() {
        if (posY >= 500) {
            turnRight();
            turnRight();
        }
        else if (posY <= 0 && direction == "South") {
            turnRight();
            turnRight();
        }
        switch (direction) {
            case "North":
                posY = posY + currentSpeed;
                break;
            case "South":
                posY = posY - currentSpeed;
                break;
            case "West":
                posX = posX - currentSpeed;
                break;
            case "East":
                posX = posX + currentSpeed;
                break;
        }
    }

    public void turnLeft() {
        switch(direction){
            case "North":
                direction = "West";
                break;
            case "West":
                direction = "South";
                break;
            case "South":
                direction = "East";
                break;
            case "East":
                direction =  "North";
                break;

        }
    }


    public void turnRight() {
        switch(direction) {
            case "North":
                direction = "East";
                break;
            case "East":
                direction = "South";
                break;
            case "South":
                direction = "West";
                break;
            case "West":
                direction = "North";
                break;
        }
    }


    private void incrementSpeed(double amount){

        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if (currentSpeed > enginePower) {

            currentSpeed = enginePower;

        }
    }

    private void decrementSpeed(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if (currentSpeed < 0) {

            currentSpeed = 0;

        }
    }


    protected void gas(double amount){

        if (amount > 1 || amount < 0) {
            System.out.println("Please choose a value between 0 and 1");
        }
        else {
            incrementSpeed(amount);
        }
    }

    protected void brake(double amount){

        if (amount > 1 || amount < 0) {
            System.out.println("Please choose a value between 0 and 1");
        }
        else {
            decrementSpeed(amount);
        }
    }
}