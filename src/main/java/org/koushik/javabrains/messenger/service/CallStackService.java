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

public class CallStackService {
	private Map<String, PERF_AVERAGES> mperf_averages_map = new TreeMap<String, PERF_AVERAGES>();
	private Map<Integer, PERFORMANCE_LOG> mperformance_log_map = new HashMap<Integer, PERFORMANCE_LOG>();
	
	private List<PERF_AVERAGES> mperf_averages = new ArrayList<PERF_AVERAGES>(0);
	private List<PERFORMANCE_LOG> mperf_performance = new ArrayList<PERFORMANCE_LOG>(0);
	private List<PERF_AVERAGES> mgoogle_chart = new ArrayList<PERF_AVERAGES>(0);
	private List<Graph_PERF_AVERAGES> mgoogle_chart2 = new ArrayList<Graph_PERF_AVERAGES>(0);
	private List<Double> mcalls_list = new ArrayList<Double>(0);



	private int mNumberOfCalls;
	
	public CallStackService() {
		
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERF_AVERAGES.class);
		configuration.addAnnotatedClass(org.koushik.javabrains.messenger.model.PERFORMANCE_LOG.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.getSessionFactory().openSession();				
		session.beginTransaction();


		mperf_averages = session.createCriteria(PERF_AVERAGES.class).list();
		mperf_performance = session.createCriteria(PERFORMANCE_LOG.class).list();

		for(int i = 0; i < mperf_averages.size(); i++){
			for(int j = 0; j < mperf_performance.size(); j++){
				if(mperf_averages.get(i).getmKPI_ID().equals(mperf_performance.get(j).getmKPI_ID()) 
						&& !mperf_performance.get(j).getmKPI_DESC().equals("Monitored Script")
						&& !mperf_performance.get(j).getmKPI_DESC().equals("Internal Script")){
					mperf_averages.get(i).setmKPI_DESC(mperf_performance.get(j).getmKPI_DESC());
					break;
				}
				if(mperf_performance.get(j).getmKPI_ID() == null){
					mperf_averages.get(i).setmKPI_DESC(null);
				}
			}
		}
		Collections.sort(mperf_averages);
		for(PERF_AVERAGES avgs : mperf_averages){
			mperf_averages_map.put(avgs.getmKPI_ID(), avgs);
		}
		for(String avgs : mperf_averages_map.keySet()){
			//System.out.println(avgs);
		}
		DateTimeZone est = DateTimeZone.forID("America/Toronto");

		DateTime currentDate = new DateTime(mperf_averages.get(0).getmTEST_END());
		
		for(int i = 0; i < mperf_averages.size(); i++){
			int DayDiff = Days.daysBetween(currentDate, new DateTime(mperf_averages.get(i).getmTEST_END())).getDays();
			if(DayDiff >= 1){
				currentDate = new DateTime(mperf_averages.get(i).getmTEST_END());
				LocalDateTime d;
				for(int j = DayDiff; j > 0; j--){
					//LocalDateTime.from(mperf_averages.get(i).getmTEST_END().toInstant()).plusDays(Long.valueOf(j));
					Calendar cal = Calendar.getInstance();
					cal.setTime(mperf_averages.get(i).getmTEST_END());
					cal.add(Calendar.DATE, -j);
					
					
//					LocalDate localDate = mperf_averages.get(i).getmTEST_END().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();			
//					localDate.plusDays(-j);
					for(int n = i; n < i + j; n++){
						mcalls_list.add(mperf_averages.get(n).getmAVERAGE_TOTALTIME());
					}
					

										
					mgoogle_chart.add(new PERF_AVERAGES(cal.getTime(), null));
					mgoogle_chart2.add(new Graph_PERF_AVERAGES(cal.getTime(), null));
				}
			}
		}
		mgoogle_chart.add(new PERF_AVERAGES(mperf_averages.get(mperf_averages.size()-1).getmTEST_END(), null));
		mgoogle_chart2.add(new Graph_PERF_AVERAGES(mperf_averages.get(mperf_averages.size()-1).getmTEST_END(), null));
	

	}
	
	public List<PERFORMANCE_LOG> getAllPERFORMANCE_LOG() {
		return mperf_performance;
		//return new ArrayList<PERFORMANCE_LOG>(mperformance_log.values()); 
	}
	
	public List<PERF_AVERAGES> getAllPERF_AVERAGES() {
		//return mgoogle_chart;
		return mperf_averages;
		//return ArrayList<PERF_AVERAGES>(mperf_averages.values());
	}
	
	public PERFORMANCE_LOG addPERFORMANCE_LOG(PERFORMANCE_LOG performance_log) {

		return performance_log;
	}
	public PERF_AVERAGES addPERF_AVERAGES(PERF_AVERAGES avg) {
		
		return avg;
	}

}
