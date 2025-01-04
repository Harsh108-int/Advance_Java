import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.*;

public class OtpSend {
    //variable to store int otp
    private static String otp_str;
    //function for OTP Generate
    private static String OTP_Gen()
    {
        //StringBuilder Class For Store otp
        StringBuilder stringBuilder = new StringBuilder();

        //Random Class for generate number
        Random random = new Random();
        for (int i = 1; i <= 6; i++) {
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        //store stringBuilder object toString
        otp_str = stringBuilder.toString();

        //return otp
        return otp_str;
    }
    public static void main(String[] args) {

        //call function OTP_Gen
        OTP_Gen();

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

        // //store key-value pair of smtp server detail
        Properties properties = new Properties();
        properties.put("mail.smtp.port",port);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.host",host);
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

        String subject = "Verify Your OTP.";

        String html = "<html><body>" +
                "<center><h1 style = 'background-color: green; color: white; font-size: 30px; padding: 20px; font-weight: bold;'>Your OTP is :" + otp_str + "<br></center><br>";

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(sender_email);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient_email));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(html,"text/html");
            Transport.send(mimeMessage);
            System.out.println("Successfully Send...");

        }catch (Exception e)
        {
            System.err.println(e);
        }
        //create scanner object
        Scanner sc = new Scanner(System.in);

        //give input to check otp correct or not
        System.out.println("Enter Your OTP: ");
        String otp = sc.next();

        //check otp
        if(!otp_str.equals(otp))
        {
            System.out.println("Wrong OTP...");
        }else {
            System.out.println("Successfully Verify...");
        }
    }
}
