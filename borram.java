
public class NotificationSystem {
    public void SendEmail(String[] details){
        Email email =  new Email();
        email.to(details[0]);
        email.from(details[1]);
        email.body(details[2]);
        _smtpService.SendEmail(email)
    }
}

_notificationSystem.SendEmail(new String[] {"recipient@email.com","sender@email.com", "text"})