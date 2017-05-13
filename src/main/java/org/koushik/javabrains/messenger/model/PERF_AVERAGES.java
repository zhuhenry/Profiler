package org.koushik.javabrains.messenger.model;

import static javax.persistence.GenerationType.IDENTITY;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name = "PERF_AVERAGES", catalog = "orcl") //uniqueConstraints = {
		///@UniqueConstraint(columnNames = "STOCK_NAME"),
		///@UniqueConstraint(columnNames = "STOCK_CODE") })
//@XmlRootElement	(name="PERF_AVERAGES")
public class PERF_AVERAGES implements Serializable, Comparable<PERF_AVERAGES>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int mPERF_AVERAGES_ID;
	public String mKPI_ID;
	public Date mTEST_START;
	public Date mTEST_END;
	public Double mAVERAGE_TOTALTIME;
	public Integer mCOUNT;
	public boolean mIS_BOTNCK;
	public Integer mPARENT;
	public String mPATH;
	public String mFUNCTION_NAME;
	public int mIS_BASELINE;
	
	@Column(name = "IS_BASELINE")
	public int getmIS_BASELINE() {
		return mIS_BASELINE;
	}
	public void setmIS_BASELINE(int mIS_BASELINE) {
		this.mIS_BASELINE = mIS_BASELINE;
	}

	private List<Double> mAVERAGES_TOTALTIME_LIST = new ArrayList<Double>(0);
	private Set<PERFORMANCE_LOG> logs = new HashSet<PERFORMANCE_LOG>(0);
	@Transient
	public String mKPI_DESC;

	@Transient
	//@Column(name = "KPI_DESC")
	public String getmKPI_DESC() {
		return mKPI_DESC;
	}
	public void setmKPI_DESC(String mKPI_DESC) {
		this.mKPI_DESC = mKPI_DESC;
	}
	public PERF_AVERAGES(){
		
	}
	public PERF_AVERAGES( Date mTEST_END, List<Double> mAVERAGES_TOTALTIME_LIST) {
		this.mTEST_END = mTEST_END;
		this.mAVERAGES_TOTALTIME_LIST = mAVERAGES_TOTALTIME_LIST;
	}
	public PERF_AVERAGES(int mPERF_AVERAGES_ID, String mKPI_ID, Date mTEST_START, Date mTEST_END, Double mAVERAGE_TOTALTIME, Integer mCOUNT,
			boolean mIS_BOTNCK,	 Integer mPARENT, String mPATH, String mFUNCTION_NAME, String mKPI_DESC, int mIS_BASELINE) {
		super();
		this.mPERF_AVERAGES_ID = mPERF_AVERAGES_ID;
		this.mKPI_ID = mKPI_ID;
		this.mTEST_START = mTEST_START;
		this.mTEST_END = mTEST_END;
		this.mAVERAGE_TOTALTIME = mAVERAGE_TOTALTIME;
		this.mCOUNT = mCOUNT;
		this.mIS_BOTNCK = mIS_BOTNCK;
		this.mPARENT = mPARENT;
		this.mPATH = mPATH;
		this.mFUNCTION_NAME = mFUNCTION_NAME;
		this.mKPI_DESC = mKPI_DESC;
		this.mIS_BASELINE = mIS_BASELINE;
	}
	
//	public PERF_AVERAGES(int mPERF_AVERAGES_ID, String mKPI_ID, Date mTEST_START, Date mTEST_END, Double mAVERAGE_TOTALTIME, Integer mCOUNT,
//			boolean mIS_BOTNCK, Integer mPARENT, String mPATH, String mFUNCTION_NAME, Set<PERFORMANCE_LOG> logs) {
//		super();
//		this.mPERF_AVERAGES_ID = mPERF_AVERAGES_ID;
//		this.mKPI_ID = mKPI_ID;
//		this.mTEST_START = mTEST_START;
//		this.mTEST_END = mTEST_END;
//		this.mAVERAGE_TOTALTIME = mAVERAGE_TOTALTIME;
//		this.mCOUNT = mCOUNT;
//		this.mIS_BOTNCK = mIS_BOTNCK;
//		this.mPARENT = mPARENT;
//		this.mPATH = mPATH;
//		this.mFUNCTION_NAME = mFUNCTION_NAME;
//		this.logs = logs;
//	}

	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @GenericGenerator(name="id_Sequence",strategy="uuid")
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "mKPI_ID")
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
//	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
//	@Id
//	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fooIdSeq")
//	  @SequenceGenerator(name = "fooIdSeq", sequenceName = "SQ_FOO_ID", allocationSize = 9999999, initialValue = 1)
	@Id
	@Column(name = "ID")
	public int getmPERF_AVERAGES_ID(){
		return mPERF_AVERAGES_ID;
	}
	public void setmPERF_AVERAGES_ID(int mPERF_AVERAGES){
		this.mPERF_AVERAGES_ID = mPERF_AVERAGES;
	}
	@Column(name = "KPI_ID", unique = false, nullable = false)
	public String getmKPI_ID() {
		return mKPI_ID;
	}
	public void setmKPI_ID(String mKPI_ID) {
		this.mKPI_ID = mKPI_ID;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "TEST_START", nullable = false)
	public Date getmTEST_START() {
		return mTEST_START;
	}
	public void setmTEST_START(Date mTEST_START) {
		this.mTEST_START = mTEST_START;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "TEST_END", nullable = false)
	public Date getmTEST_END() {
		return mTEST_END;
	}
	public void setmTEST_END(Date mTEST_END) {
		this.mTEST_END = mTEST_END;
	}
	@Column(name = "AVERAGE_TOTALTIME", unique = false, nullable = false)
	public Double getmAVERAGE_TOTALTIME() {
		return mAVERAGE_TOTALTIME;
	}
	public void setmAVERAGE_TOTALTIME(Double mAVERAGE_TOTALTIME) {
		this.mAVERAGE_TOTALTIME = mAVERAGE_TOTALTIME;
	}
	@Column(name = "COUNT", nullable = true)
	public Integer getmCOUNT() {
		return mCOUNT;
	}
	public void setmCOUNT(Integer mCOUNT) {
		this.mCOUNT = mCOUNT;
	}
	@Column(name = "IS_BOTNCK")
	public boolean ismIS_BOTNCK() {
		return mIS_BOTNCK;
	}
	public void setmIS_BOTNCK(boolean mIS_BOTNCK) {
		this.mIS_BOTNCK = mIS_BOTNCK;
	}
	@Column(name = "PARENT", nullable = true)
	public Integer getmPARENT() {
		return mPARENT;
	}
	public void setmPARENT(Integer mPARENT) {
		this.mPARENT = mPARENT;
	}
	@Column(name = "PATH", nullable = true)
	public String getmPATH() {
		return mPATH;
	}
	public void setmPATH(String mPATH) {
		this.mPATH = mPATH;
	}
	@Column(name = "FUNCTION_NAME")
	public String getmFUNCTION_NAME() {
		return mFUNCTION_NAME;
	}
	public void setmFUNCTION_NAME(String mFUNCTION_NAME) {
		this.mFUNCTION_NAME = mFUNCTION_NAME;
	}
//	public Set<PERFORMANCE_LOG> getPERFORMANCE_LOGs() {
//		return this.logs;
//	}
//
//	public void setPERFORMANCE_LOGs(Set<PERFORMANCE_LOG> logs) {
//		this.logs = logs;
//	}

	@Override
	public int compareTo(PERF_AVERAGES arg0) {
		return getmTEST_END().compareTo(arg0.getmTEST_END());
	}

}
