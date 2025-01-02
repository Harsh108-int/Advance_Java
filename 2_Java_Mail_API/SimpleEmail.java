import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SimpleEmail {
    public static void main(String[] args) {
        //my email
        final String sender_email = "h87539994@gmail.com";

        //recipient email
        String recipient_email = "pandeharshavardhan@gmail.com";

        //my app password
        final String password = "shso suhu dzxh lbtb";

        //port number
        String port = "587";

        //host is smtp.gmail.com
        String host = "smtp.gmail.com";

        //store key-value pair of smtp server detail
        Properties properties = new Properties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",port);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");

        //create session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender_email,password);
            }
        });

        //debug mode for see log detail
        session.setDebug(true);

        String subject = "Hi My Name is Harshvardhan Pande";
        String body = "Ignore this Message.....";

        try {
            //create MimeMessage Class Object & Constructor Take Session Object as Argument
            MimeMessage mimeMessage = new MimeMessage(session);

            //set Sender Email Address
            mimeMessage.setFrom(sender_email);

            //set Recipient
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient_email));

            //set subject
            mimeMessage.setSubject(subject);

            //set body
            mimeMessage.setText(body);

            //send email using Transport class with static method send
            Transport.send(mimeMessage);
            System.out.println("Successfully Send Email......");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
