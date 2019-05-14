package behavior.chain;

public class ChainTest {
	public static void main(String[] arg){
		AgeHandler h1 = new AgeHandler("age");
		NameHandler h2 = new NameHandler("name");
//		h1.setHandler(h2);
		h2.setHandler(h1);
		h2.operate();
	}
}
