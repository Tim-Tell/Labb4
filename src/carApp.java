public class carApp {

    public static void main(String[] args) {

        World world = new World();

        CarView carView = new CarView("CarSim 1.0");

        CarController cc = new CarController(world);
        // Instance of this class

        world.cars.add(new Volvo240());
        world.cars.add(new Scania());
        world.cars.add(new Saab95());

        carView.setArrayList(world.cars);
        //cc.makeDrawPanel(carView);
        carView.makeComponents();

        world.addObserver(carView);


        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0");


        // Start the timer
        world.timer.start();
    }
}
