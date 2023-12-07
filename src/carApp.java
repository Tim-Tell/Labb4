

public class carApp {

    public static void main(String[] args) {

        World world = new World();

        CarView carView = new CarView("CarSim 1.0", world);

        CarController cc = new CarController(world, carView);

        world.cars.add(new Volvo240());
        world.cars.add(new Scania());
        world.cars.add(new Saab95());



        cc.createButtons();
        cc.createGas();
        cc.addActionListeners();

        carView.makeComponents();

        carView.makeDrawPanel(world.cars);

        world.addObserver(carView);

        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0");

        // Start the timer
        world.timer.start();
    }
}
