package out;

import App.DestinationPort;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

public class EmailAdapter implements DestinationPort {
    private String mailSmtpHost="smtp.gmail.com";
    private String mailSmtpSocketFactoryPort="465";
    private String mailSmtpSocketFactoryClass="javax.net.ssl.SSLSocketFactory";
    private String mailSmtpAuth="true";
    private String mailSmtpPort="465";
    private String mailUsername="derekclark1971@gmail.com";
    private String mailPassword="dereksgoogle";

    public boolean send(String recipient, List<String> textList) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.socketFactory.port", mailSmtpSocketFactoryPort);
        props.put("mail.smtp.socketFactory.class",
                mailSmtpSocketFactoryClass);
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.port", mailSmtpPort);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailUsername,mailPassword);
                    }
                });

        try {
            System.out.println("informing friend " + recipient);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fromAddress","socialeggbox"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("emailSubject");
            for (String text: textList){
                message.setText(text);
            }

            Transport.send(message);

            System.out.println("Email Sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

}