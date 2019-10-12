package com.om;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class EmailSending2Application implements CommandLineRunner {
@Autowired private JavaMailSender sender;
	public static void main(String[] args) {
		SpringApplication.run(EmailSending2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sendmail();
		
	}

	private void sendmail() {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo("nagendralucky521@gmail.com");
		msg.setSubject("OTP for ur txn");
		msg.setText("your one time password is this omkar:"+otps());
		System.out.println("sendingg..................");
		sender.send(msg);
		System.out.println("Otp sent successfully");
	}

	private String otps(){
		String otp="";
		for(int i=1;i<=6;i++)
		{otp=otp+(int)(Math.random()*10);
		}		return otp;
		
	}
}
