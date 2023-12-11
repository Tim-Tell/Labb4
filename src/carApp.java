

public class carApp {

    public static void main(String[] args) {

        World world = new World();

        CarView carView = new CarView("CarSim 1.0", world);

        CarController cc = new CarController(world, carView);

        world.addCar("volvo");
        world.addCar("scania");
        world.addCar("saab");

        carView.makeComponents(world.cars);

        cc.createButtons();
        cc.createGas();
        cc.addActionListeners();

        world.addObserver(carView);

        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0");

        // Start the timer
        world.timer.start();
    }
}