package create.build;

public class SimpleAirShipBuilder implements AirShipBuilder {
	@Override
	public Engine builderEngine() {
		System.out.println("构建简单发动机");
		return new Engine("简单发动机");
	}

	@Override
	public EscapeTower builderEscapeTower() {

		System.out.println("构建简单逃逸塔");
		return new EscapeTower("简单逃逸塔");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建简单轨道舱");
		return new OrbitalModule("简单轨道舱");
	}

}
