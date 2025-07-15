package setSlides4;

public class Message {
	protected String sender, recipient, body;
	
	public Message(String sender, String recipient, String body) { 
		this.sender = sender;
		this.recipient = recipient;
		this.body = body;
	}
	
	public void send() {
		System.out.println("Message --> " + recipient + " : " + body);
	}
}
