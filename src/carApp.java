public class carApp {

    public static void main(String[] args) {

        CarView carView = new CarView("CarSim 1.0");

        CarController cc = new CarController();
        // Instance of this class

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());

        cc.makeDrawPanel(carView);
        carView.makeComponents();


        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0");


        // Start the timer
        cc.timer.start();
    }
}
