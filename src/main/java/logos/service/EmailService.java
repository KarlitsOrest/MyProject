package logos.service;

import logos.mail.Mail;

public interface EmailService {
	
	void sendMessage(Mail mail);
}
