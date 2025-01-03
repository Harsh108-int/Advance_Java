import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.*;

public class SendAttachedFiles {
    public static void main(String[] args) {

        // SMTP server configuration details
        String host = "smtp.gmail.com"; // SMTP server address for Gmail
        String port = "587"; // Port for TLS
        final String email = "h87539994@gmail.com";
        final String password = "shso suhu dzxh lbtb";
        String to = "pandeharshavardhan@gmail.com";
        String subject = "Hello I am Harshvardhan";

        // Configures the SMTP server details
        Properties properties = new Properties();
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Create a session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        // debug for see log details
        session.setDebug(true);

        //create MimeMessage Class Object & Constructor Take Session Object as Argument
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            // Set the sender email
            mimeMessage.setFrom(email);

            // Set the recipient email
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set the subject of the email
            mimeMessage.setSubject(subject);


            // Set the plain text body of the email
            mimeMessage.setText("Ignore this.....");

            //MimeMultipart Inside on another try-catch block
            try {
                // Create a MimeMultipart object to hold multiple parts of the email
                MimeMultipart mimeMultipart = new MimeMultipart();

                // Create a MimeBodyPart object for the photo attachment
                MimeBodyPart attachmentPart = new MimeBodyPart();

                // Attach a file to the MimeBodyPart you can attach photo,video etc in this i attach video
                attachmentPart.attachFile(new File("C:\\Users\\Admin\\Downloads\\naruto-funny-shorts-vyuk-naruto-phonk-otaku-anime-720-publer.io.mp4"));

                // Add the attachment to the MimeMultipart object
                mimeMultipart.addBodyPart(attachmentPart);

                // Set MimeMultipart Object as the email content
                mimeMessage.setContent(mimeMultipart);

            } catch (Exception e) {
                // exceptions attachment
                System.err.println("Error : " + e);
            }

            // Send the email using the Transport class
            Transport.send(mimeMessage);
            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            // exception email
            System.err.println("Error : " + e);
        }
    }
}
