package org.koushik.javabrains.messenger.service;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.persistence.internal.jpa.rs.metadata.model.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Graph_PERF_AVERAGES;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.PERFORMANCE_LOG;
import org.koushik.javabrains.messenger.model.PERF_AVERAGES;

import util.HibernateUtil;

public class MonitorService {
	private Map<String, PERF_AVERAGES> mperf_averages_map = new TreeMap<String, PERF_AVERAGES>();
	private Map<Integer, PERFORMANCE_LOG> mperformance_log_map = new HashMap<Integer, PERFORMANCE_LOG>();
	
	private List<PERFORMANCE_LOG> mperformance_log = new ArrayList<PERFORMANCE_LOG>(0);
	private List<PERF_AVERAGES> mgoogle_chart = new ArrayList<PERF_AVERAGES>(0);
	private List<Graph_PERF_AVERAGES> mgoogle_chart2 = new ArrayList<Graph_PERF_AVERAGES>(0);
	private List<Double> mcalls_list = new ArrayList<Double>(0);

	private int mNumberOfCalls;
	
	public MonitorService() {
			
	}
	
	public void addPERFORMANCE_LOG(PERFORMANCE_LOG performance_log) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERF_AVERAGES.class);
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERFORMANCE_LOG.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.getSessionFactory().openSession();				
		session.beginTransaction();
		mperformance_log = session.createCriteria(PERFORMANCE_LOG.class).list();
		int currentLargest = mperformance_log.get(mperformance_log.size()-1).getmID();
		for(int i = mperformance_log.size() - 2; i >= 0; i--){
			if(mperformance_log.get(i).getmID() > currentLargest){
				currentLargest = mperformance_log.get(i).getmID();
			}
		}
		System.out.println(performance_log);

		System.out.println(performance_log.getmID());
		performance_log.setmID((currentLargest+1));
		if(performance_log.getmPATH() != null){
			performance_log.setmPARENT(currentLargest);
		}
		System.out.println(currentLargest+1);
		System.out.println(performance_log.mID);


	   if(performance_log.getmChild() == null){
		   performance_log.setmNOTES("Monitoring");
	   }
       session.save(performance_log);

	   session.getTransaction().commit();
	   if(performance_log.getmChild() != null){
		   addPERFORMANCE_LOG(performance_log.getmChild());
	   }

	}
	public List<PERFORMANCE_LOG> getAllPERFORMANCE_LOG(){
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERF_AVERAGES.class);
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERFORMANCE_LOG.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.getSessionFactory().openSession();				
		session.beginTransaction();
		mperformance_log = session.createCriteria(PERFORMANCE_LOG.class).list();
		Collections.sort(mperformance_log);
		return mperformance_log;
	}
	public PERF_AVERAGES addPERF_AVERAGES(PERF_AVERAGES avg) {
		
		return avg;
	}
	public void deleteAllMonitoredScripts(){
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERF_AVERAGES.class);
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERFORMANCE_LOG.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.getSessionFactory().openSession();				
        session.beginTransaction();

	        String sql = "DELETE FROM PERFORMANCE_LOG WHERE KPI_DESC = 'Monitored Script'";
	        //Query query = session.createQuery(sql);
	        org.hibernate.query.Query que = session.createQuery(sql);
	         int row = que.executeUpdate();
	         //if (row == 0)
	         //    System.out.println("Doesnt deleted any row!");
	         //else
	             System.out.println("Deleted Row: " + row);
	        session.getTransaction().commit(); 
	        session.close();

	}
}
