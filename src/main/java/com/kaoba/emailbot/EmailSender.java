package com.kaoba.emailbot;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;

public class EmailSender {
    public static void sendEmail(List<String> recipients, String subject, String htmlContent) throws MessagingException {
        final String fromEmail = "hamzabenchaoui2004@gmail.com";
        final String password = "xanq iqki mkds bdmz"; // Remplace par un mot de passe d'application Gmail

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        for (String toEmail : recipients) {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setContent(htmlContent, "text/html");
            Transport.send(msg);
            System.out.println("Email envoyé à: " + toEmail);
        }
    }
}
