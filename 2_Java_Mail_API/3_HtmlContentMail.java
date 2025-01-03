import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class HtmlContentMail {
    public static void main(String[] args) {
        //my email
        final String sender_email = "h87539994@gmail.com";

        //my app password
        final String password = "my password you enter your";

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

        //subject of email
        String subject = "This is HTML Content Email";

        //html script
        String html = "<html><head>" +
                "<body><h1>This is Html Body.</h1><br>" +
                "<a href = 'https://github.com/Harsh108-int/Advance_Java'><button style = 'background-color: black; color: white; font-size:10px; margin: 10px 0px 10px 20px; padding: 10px; font-weight: bold;'>Git Hub</button></a>" +
                "</body></head></html>";

        try {
            //create MimeMessage Class Object & Constructor Take Session Object as Argument
            MimeMessage mimeMessage = new MimeMessage(session);

            //set sender email
            mimeMessage.setFrom(sender_email);

            //set recipient email address
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("pandeharshavardhan@gmail.com"));

            //set subject
            mimeMessage.setSubject(subject);

            //set Html script
            mimeMessage.setContent(html,"text/html");

            //send email using Transport class with static method send
            Transport.send(mimeMessage);
            System.out.println("Successfully Send Email......");
        }catch (Exception e)
        {
            System.err.println(e);
        }

    }
}
