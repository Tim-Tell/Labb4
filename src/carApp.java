

public class carApp {

    public static void main(String[] args) {

        World world = new World();

        CarView carView = new CarView("CarSim 1.0", world);

        CarController cc = new CarController(world, carView);

        world.addCar("volvo");
        world.addCar("scania");
        world.addCar("saab");
        //world.addCar("car transport");

        //måste lägga till så att när knappen trycks så kommer det upp en bil på skärmen.

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
// behöver fixa så att när en car läggs till så läggs den också till i hashmapen (har börjat på detta) och samma fast remove
// behöver lägga till bilder till alla bilsorter och se till att när en ny bil läggs till så kommer det att synas,
//annars komer bilen som läggs till bara ligga bakom den existerande bilen av den sorten
