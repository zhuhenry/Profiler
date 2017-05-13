package org.koushik.javabrains.messenger.service;
import  java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.messenger.model.PERFORMANCE_LOG;
import org.koushik.javabrains.messenger.model.PERF_AVERAGES;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import  org.apache.poi.hssf.usermodel.HSSFCell;
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
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class CreateExlFileService{
//	private static Map<String, PERF_AVERAGES> mperf_averages = new HashMap<String, PERF_AVERAGES>();
//	private static List<PERF_AVERAGES> mperf_averages_list = new ArrayList<PERF_AVERAGES>();
	
	private static Map<String, PERFORMANCE_LOG> mperformance_log = new HashMap<String, PERFORMANCE_LOG>();

	private static List<PERFORMANCE_LOG> mperformance_log_list = new ArrayList<PERFORMANCE_LOG>();
	private XSSFWorkbook workbook = new XSSFWorkbook();
	private FileOutputStream fileOut;
	private Set<PERF_AVERAGES> avgs_set;
	private Map<String, PERFORMANCE_LOG> log_Set = new TreeMap<String, PERFORMANCE_LOG>();
	private File file;
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

//	private Map<String, PERFORMANCE_LOG> log_TreeMap;


	public CreateExlFileService(){
        Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERF_AVERAGES.class);
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERFORMANCE_LOG.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.getSessionFactory().openSession();				
		session.beginTransaction();
		
		mperformance_log_list = (ArrayList<PERFORMANCE_LOG>)session.createSQLQuery("SELECT * FROM PERFORMANCE_LOG").addEntity(PERFORMANCE_LOG.class).list();

	}
	
	public File generateExlFile() {
		try {
	          CellStyle cellStyle = workbook.createCellStyle();
	          cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
	          Font font = workbook.createFont();
	          font.setColor(HSSFColor.RED.index);
	          cellStyle.setFont(font);

	          String filename = "C:/Users/henry.zhu/Desktop/Orion Performance Testing Excel Files/PerformanceTests.xlsx";
	          XSSFSheet sheet = workbook.createSheet("16.2");  
	          XSSFSheet s161 = workbook.createSheet("16.1");  

	          XSSFRow rowhead = sheet.createRow((short)0);
	          rowhead.createCell(0).setCellValue("Build");

	          XSSFRow row = sheet.createRow((short)1);
	          row.createCell(1).setCellValue("Date ->");
	          row.createCell(3).setCellValue("% Improvement over");
	          
	          XSSFRow row2 = sheet.createRow((short)2);
	          row2.createCell(1).setCellValue("Source code change (i.e Merge from Develop) and/or fixes ->");
	          row2.createCell(2).setCellValue("(Baseline)");
	          XSSFRow row3 = sheet.createRow((short)3);
	          row3.createCell(1).setCellValue("Source code/Config Improvements ->");
	          row3.createCell(2).setCellValue("(Baseline)");
	          
	          XSSFRow row4 = sheet.createRow((short)4);
	          row4.createCell(1).setCellValue("AVM Change ->");
	          row4.createCell(2).setCellValue("(Baseline)");

	          XSSFRow row6 = sheet.createRow((short)6);
	          row6.createCell(0).setCellValue("Test ID");
	          row6.createCell(1).setCellValue("Test Description");
	          row6.createCell(2).setCellValue("KPI Time");
	          
//		      for(int i = 0; i < mperf_averages_list.size(); i++){
//			 	mperf_averages.put(mperf_averages_list.get(i).getmKPI_ID(), mperf_averages_list.get(i));
//			  }  
	          
//	          log_Set = new HashSet<PERFORMANCE_LOG>(mperformance_log_list);
//	          
//	          int counter = 0;
//		      for(PERFORMANCE_LOG log : log_Set){
//		    	  XSSFRow xrow;
//			      xrow = s162.createRow((short)(7+counter));
//			      counter++;
//			      xrow.createCell(0).setCellValue(log.getmKPI_ID());  
//		      }
		      
		      for(int i = 0; i < mperformance_log_list.size(); i++){
		    	  if( mperformance_log_list.get(i).getmKPI_ID() != null ){
		    		  mperformance_log.put(mperformance_log_list.get(i).getmKPI_ID(), mperformance_log_list.get(i));
		    	  }
	          }
		      Map<String, PERFORMANCE_LOG> log_TreeMap = new TreeMap<String, PERFORMANCE_LOG>(mperformance_log);
		      //log_TreeMap = new TreeMap<String, PERFORMANCE_LOG>(mperformance_log);
	          //XSSFRow xrow;
	          int counter = 0;
	          for(Map.Entry<String, PERFORMANCE_LOG> log : log_TreeMap.entrySet()){
	        	  if(log.getKey() != null){
		        	  XSSFRow xrow;
		        	  xrow = sheet.createRow((short) (counter+7));
		        	  counter++;
		        	  xrow.createCell(0).setCellValue(log.getKey());
		        	  xrow.createCell(1).setCellValue(log.getValue().getmKPI_DESC());
	        	  
		        	  System.out.println(log.getKey());
	        	  }
	          }
	          row = sheet.createRow((short) (counter+8));
	          row.createCell(1).setCellValue("NOTES");
	          row = sheet.createRow((short) (counter+9));
	          row.createCell(0).setCellValue("1");
	          row.createCell(1).setCellValue("Unless otherwise stated % Improvement is improvement in time relative to the baseline");
	          row = sheet.createRow((short) (counter+10));
	          row.createCell(0).setCellValue("2");
	          row.createCell(1).setCellValue("All times in seconds");
	          row = sheet.createRow((short) (counter+11));
	          row.createCell(0).setCellValue("3");
	          row.createCell(1).setCellValue("Test IDs in Green are MEF KPIs");
	          
	          

	          sheet.autoSizeColumn(0);
	          sheet.autoSizeColumn(1);
	          
	          fileOut = new FileOutputStream(filename);
	          workbook.write(fileOut);
	          fileOut.close();
	          System.out.println("Your excel file has been generated!");
	          file = new File(filename);
	      } catch ( Exception ex ) {
	          System.out.println(ex);
	          file = null;
	      }

		return file;
	}
//	private void SendEmail(){
//	     Properties props = System.getProperties();
//	     props.setProperty("mail.smtp.host", "smtp.gmail.com");
//	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
//	     props.setProperty("mail.smtp.port", "465");
//	     props.setProperty("mail.smtp.socketFactory.port", "465");
//	     props.put("mail.smtp.auth", "true");
//	     props.put("mail.debug", "true");
//	     props.put("mail.store.protocol", "pop3");
//	     props.put("mail.transport.protocol", "smtp");
//	     final String username = "henry.zhu@zcomsystems.com";//
//	     final String password = "1q2w3e!@#";
//	     try{
//	    	 javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new Authenticator(){
//	    		 protected PasswordAuthentication getPasswordAuthentication() {
//	    			 return new PasswordAuthentication(username, password);
//	             }});
//
//	   // -- Create a new message --
//	     Message msg = new MimeMessage(session);
//
//	  // -- Set the FROM and TO fields --
//	     msg.setFrom(new InternetAddress("henry.zhu@zcomsystems.com"));
//	     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("zhuhr96@gmail.com",false));
//	     //msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("PDLCOECOCO@pdl.internal.ericsson.com, yigal.yissar@ericsson.com, kapka.djebarova@ericsson.com, thang.x.le@ericsson.com",false));
//
//	     Calendar cal = Calendar.getInstance();
//	     cal.add(Calendar.DATE, -1);
//	     
//	     Format formatter = new SimpleDateFormat("dd/MM/yyyy");
//	     String yesterday = formatter.format(cal.getTime());
//
//	     msg.setSubject("Orion Performance Testing - " + yesterday);
//	     msg.setText("How are you");
//	     
//	     msg.setSentDate(new Date());
//	     // Create the message part 
//	     BodyPart messageBodyPart = new MimeBodyPart();
//
//	     // Fill the message
//	     messageBodyPart.setText("");
//	     
//	     // Create a multipar message
//	     Multipart multipart = new MimeMultipart();
//
//	     // Part two is attachment
//	     messageBodyPart = new MimeBodyPart();
//	     String filename = "C:/Users/henry.zhu/Desktop/Orion Performance Testing Excel Files/PerformanceTests.xlsx";
//	     DataSource source = new FileDataSource(filename);
//	     messageBodyPart.setDataHandler(new DataHandler(source));
//	     messageBodyPart.setFileName(filename);
//	     multipart.addBodyPart(messageBodyPart);
//
//	     // Send the complete message parts
//	     msg.setContent(multipart);
//
//	     Transport.send(msg);
//	     
//	     System.out.println("Message sent.");
//	    }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);
//	    }
	//}
}
