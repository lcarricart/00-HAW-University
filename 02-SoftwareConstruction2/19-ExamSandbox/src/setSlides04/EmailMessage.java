package setSlides04;

public class EmailMessage extends Message {

    public EmailMessage(String sender, String recipient, String body) {
        super(sender, recipient, body);
    }

    @Override
    public void send() {
        super.send();
        System.out.println("(Sent via SMTP)");
    }
}