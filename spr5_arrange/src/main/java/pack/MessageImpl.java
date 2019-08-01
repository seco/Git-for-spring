package pack;

public class MessageImpl implements Messageinter{
	
	private String name;
	private String spec;
	
	//di : 생성자로 주입, 세터로 주입
	public MessageImpl(String name) {
		this.name = name;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void sayhi() {
		String msg = name + " " + spec;
		System.out.println(msg);
	}
}
