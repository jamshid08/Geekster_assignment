package org.geekster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailHandlerBase {
@Autowired
    Authenticator mailAuthenticator;  // gets the bean of CustomizedMailAuthenticator created by SB

    public void sendMail(String objContent)
    {



        Properties sysPropertiesMap = System.getProperties();



        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth







        //session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);


        //build the mail
        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {

            String rec = "jamsheed01234@outlook.com ,jamsheed.jk01234@gmail.com ,jamsheed01234@gmail.com ";
            String[] recipientList = rec.split(",");
            // InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            //OR
            Address[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }



            mailMessage.setFrom("jamsheed01234.jk@gmail.com");
            mailMessage.setSubject("Geekster Mailing class");
            // mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("jamsheed01234@outlook.com"));
            mailMessage.setRecipients(Message.RecipientType.TO, recipientAddress);
            mailMessage.setText(objContent + "     "+"object send using API");

            Transport.send(mailMessage);

            System.out.println("Mail sent !!!");
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }






    }
}
