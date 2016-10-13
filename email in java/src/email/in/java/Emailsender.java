/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email.in.java;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Pritish
 */
public class Emailsender {
    public static boolean sendMail(String from,String to[],String pass,String message ){
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable",true);
        prop.put("mail.smpt.host",host);
        prop.put("mail.smtp.user",from);
        prop.put("mail.smtp.password",pass);
        prop.put("mail.smtp.port",587);
        prop.put("mail.smtp.auth","true");
        
        Session session = Session.getDefaultInstance(prop,null);
        MimeMessage msg = new MimeMessage(session);
        
        try{
            msg.setFrom(new InternetAddress(from)); 
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for(int i=0;i<to.length;i++){
                toAddress[i] = new InternetAddress(to[i]);
            }
            for(int i=0;i<toAddress.length;i++){
                msg.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            msg.setSubject("Mail sent using javaMail api");
            msg.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host,from,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return true;
        }
        catch(Exception e) {
            
        }
        return false;
    }
}
