package create.build;

public class Client {
	public static void main(String[] args) {

		AirShipDirector director = new SimpleAirshipDirector(new SimpleAirShipBuilder());

		AirShip ship = director.directAirShip();

		System.out.println(ship.getEngine().getName());

		ship.launch();

	}
}
