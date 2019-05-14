package structure.adapter;

/**
 * 客户端类
 * @author Administrator
 *
 */
public class Client {
	
	public void test1(Target t){
		t.handleReq();
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		
		Adaptee a = new Adaptee();
		
		Target t1 = new ClassAdapter();

		Target t2 = new ObjectAdapter(a);
		
		c.test1(t1);
		c.test1(t2);

	}
	
}
