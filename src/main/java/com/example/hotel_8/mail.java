package com.example.hotel_8;

import java.util.Enumeration;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class mail {


    public static void check(String host, String storeType, String user, String password) {
        try {

            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
//                message.setFlag(Flag.SEEN, true);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
//                MimeMultipart body = (MimeMultipart) message.getContent();
//                BodyPart textPart = body.getBodyPart(0);
//                String text = (String) textPart.getContent();
//                System.out.println("Text: " + text);
                System.out.println(message.getSentDate());
                System.out.println(message.getMessageNumber());
//                System.out.println(message.getHeader("Received"));
//                Enumeration headers = messages[i].getAllHeaders();
//                while (headers.hasMoreElements()) {
//                    Header h = (Header) headers.nextElement();
//                    System.out.println(h.getName() + ": " + h.getValue());
//                }
//                System.out.println();

            }

            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String username = "hrmanagergg@gmail.com";
        String password = "nikonnikon1";

        check(host, mailStoreType, username, password);

    }
}
