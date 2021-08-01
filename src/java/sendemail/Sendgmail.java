/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import DTO.UserDTO;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author PRREDETOR
 */
public class Sendgmail {
    public String getCodeRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean senGmail(UserDTO user) {
        boolean check = false;

        String toEmail = user.getEmail();
        String fromEmail = "longdk0486@gmail.com";
        String password = "Longzerovnlong0486";

        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.mail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication(){
                      return new PasswordAuthentication(fromEmail, password);
                  }
            });
            
            //set email message details
            Message msg = new MimeMessage(session);
            
            //set from email address
            msg.setFrom(new InternetAddress(fromEmail));
    		//set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    		
    		//set email subject
            msg.setSubject("User Email Verification");
            
    		//set message text
            msg.setText("Registered successfully.Please verify your account using this code: " + user.getVerifycode());
            //send the message
            Transport.send(msg);
            
            check = true;
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static void main(String[] args) {
        Sendgmail sm = new Sendgmail();
        UserDTO user = new UserDTO("Long Duong Kim", "longdk0486@gmail.com", "999999");
        sm.senGmail(user);               
    }
}
