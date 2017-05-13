import java.text.DateFormat;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendEmail {
  public static void main(String[] args) {
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "henry.zhu@zcomsystems.com";//
     final String password = "1q2w3e!@#";
     try{
    	 Session session = Session.getDefaultInstance(props, new Authenticator(){
    		 protected PasswordAuthentication getPasswordAuthentication() {
    			 return new PasswordAuthentication(username, password);
             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress("henry.zhu@zcomsystems.com"));
     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("zhuhr96@gmail.com",false));
     //msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("PDLCOECOCO@pdl.internal.ericsson.com, yigal.yissar@ericsson.com, kapka.djebarova@ericsson.com, thang.x.le@ericsson.com",false));

     Calendar cal = Calendar.getInstance();
     cal.add(Calendar.DATE, -5);
//     cal.set(Calendar.HOUR_OF_DAY, 0);
//     cal.set(Calendar.MINUTE, 0);
//     cal.set(Calendar.SECOND, 0);
//     cal.set(Calendar.MILLISECOND, 0);
     
     Format formatter = new SimpleDateFormat("dd/MM/yyyy");
     String yesterday = formatter.format(cal.getTime());

     msg.setSubject("Orion Performance Testing - " + yesterday);
     msg.setText("How are you");
     
     msg.setSentDate(new Date());
     // Create the message part 
     BodyPart messageBodyPart = new MimeBodyPart();

     // Fill the message
     messageBodyPart.setText("");
     
     // Create a multipar message
     Multipart multipart = new MimeMultipart();

     // Set text message part
     //multipart.addBodyPart(messageBodyPart);

     // Part two is attachment
     messageBodyPart = new MimeBodyPart();
     String filename = "C:/Users/henry.zhu/Desktop/Orion Performance Testing Excel Files/PerformanceTests.xlsx";
     DataSource source = new FileDataSource(filename);
     messageBodyPart.setDataHandler(new DataHandler(source));
     messageBodyPart.setFileName(filename);
     multipart.addBodyPart(messageBodyPart);

     // Send the complete message parts
     msg.setContent(multipart);

     Transport.send(msg);
     
     System.out.println("Message sent.");
    }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);
    }
  }
  }