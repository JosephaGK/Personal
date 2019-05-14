package behavior.mychain;

public class MyChainTest {
	public static void main(String[] arg){
		NameHandler nameHandler = new NameHandler();
		AgeHandler ageHandler = new AgeHandler();
		nameHandler.setHandler(ageHandler);
		nameHandler.operate();
	}
}
