package org.koushik.javabrains.messenger.model;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
@Entity
//@Table(name = "PERFORMANCE_LOG", catalog = "orcl")//, uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
public class PERFORMANCE_LOG implements Serializable, Comparable<PERFORMANCE_LOG>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int mID;
	public String mKPI_DESC;
	public String mFUNCTION_NAME;
	public double mTOTAL_TIME;
	public Double mMIN_TIME;
	public Double mMAX_TIME;
	public Double mAVG_TIME;
	public Integer mCOUNT;
	public boolean mIS_BOINCK;
	public Integer mPARENT;
	public String mPATH;
	public Date mTEST_DATE;
	public boolean mPASS;
	public String mKPI_ID;
	public String mNOTES;
//	public List<PERFORMANCE_LOG> mParents = new ArrayList<PERFORMANCE_LOG>(0);
	@Transient
	public String mMonitor;
	@Transient
	public PERFORMANCE_LOG mNestedParents;// = new PERFORMANCE_LOG();

	//@ManyToOne(fetch = FetchType.LAZY)
	//public PERF_AVERAGES mPERF_AVERAGES;
//	public PERFORMANCE_LOG(int mID, String mKPI_DESC, String mFUNCTION_NAME, double mTOTAL_TIME, Double mMIN_TIME,
//			Double mMAX_TIME, Double mAVG_TIME, Integer mCOUNT, /*boolean mIS_BOINCK,*/ Integer mPARENT, String mPATH,
//			Date mTEST_DATE, boolean mPASS, String mKPI_ID, String mNOTES) {
//		super();
//		this.mID = mID;
//		this.mKPI_DESC = mKPI_DESC;
//		this.mFUNCTION_NAME = mFUNCTION_NAME;
//		this.mTOTAL_TIME = mTOTAL_TIME;
//		this.mMIN_TIME = mMIN_TIME;
//		this.mMAX_TIME = mMAX_TIME;
//		this.mAVG_TIME = mAVG_TIME;
//		this.mCOUNT = mCOUNT;
//		//this.mIS_BOINCK = mIS_BOINCK;
//		this.mPARENT = mPARENT;
//		this.mPATH = mPATH;
//		this.mTEST_DATE = mTEST_DATE;
//		this.mPASS = mPASS;
//		this.mKPI_ID = mKPI_ID;
//		this.mNOTES = mNOTES;
//
//	}
	public PERFORMANCE_LOG(int mID, String mKPI_DESC, String mFUNCTION_NAME, double mTOTAL_TIME, Double mMIN_TIME,
			Double mMAX_TIME, Double mAVG_TIME, Integer mCOUNT, boolean mIS_BOINCK, Integer mPARENT, String mPATH,
			Date mTEST_DATE, boolean mPASS, String mKPI_ID, String mNOTES, String mMonitor, PERFORMANCE_LOG mParentInstance) {
		super();
		this.mID = mID;
		this.mKPI_DESC = mKPI_DESC;
		this.mFUNCTION_NAME = mFUNCTION_NAME;
		this.mTOTAL_TIME = mTOTAL_TIME;
		this.mMIN_TIME = mMIN_TIME;
		this.mMAX_TIME = mMAX_TIME;
		this.mAVG_TIME = mAVG_TIME;
		this.mCOUNT = mCOUNT;
		this.mIS_BOINCK = mIS_BOINCK;
		this.mPARENT = mPARENT;
		this.mPATH = mPATH;
		this.mTEST_DATE = mTEST_DATE;
		this.mPASS = mPASS;
		this.mKPI_ID = mKPI_ID;
		this.mNOTES = mNOTES;
		this.mMonitor = mMonitor;
		this.mNestedParents = mParentInstance ;
	}
	public PERFORMANCE_LOG(int mID, String mKPI_DESC, String mFUNCTION_NAME, double mTOTAL_TIME, Double mMIN_TIME,
			Double mMAX_TIME, Double mAVG_TIME, Integer mCOUNT, boolean mIS_BOINCK, Integer mPARENT, String mPATH,
			Date mTEST_DATE, boolean mPASS, String mKPI_ID, String mNOTES) {
		super();
		this.mID = mID;
		this.mKPI_DESC = mKPI_DESC;
		this.mFUNCTION_NAME = mFUNCTION_NAME;
		this.mTOTAL_TIME = mTOTAL_TIME;
		this.mMIN_TIME = mMIN_TIME;
		this.mMAX_TIME = mMAX_TIME;
		this.mAVG_TIME = mAVG_TIME;
		this.mCOUNT = mCOUNT;
		this.mIS_BOINCK = mIS_BOINCK;
		this.mPARENT = mPARENT;
		this.mPATH = mPATH;
		this.mTEST_DATE = mTEST_DATE;
		this.mPASS = mPASS;
		this.mKPI_ID = mKPI_ID;
		this.mNOTES = mNOTES;
	}
//	public PERFORMANCE_LOG(int mID, String mKPI_DESC, String mFUNCTION_NAME, double mTOTAL_TIME, Double mMIN_TIME,
//			Double mMAX_TIME, Double mAVG_TIME, Integer mCOUNT, boolean mIS_BOINCK, Integer mPARENT, String mPATH,
//			Date mTEST_DATE, boolean mPASS, String mKPI_ID, String mNOTES) {
//		super();
//		this.mID = mID;
//		this.mKPI_DESC = mKPI_DESC;
//		this.mFUNCTION_NAME = mFUNCTION_NAME;
//		this.mTOTAL_TIME = mTOTAL_TIME;
//		this.mMIN_TIME = mMIN_TIME;
//		this.mMAX_TIME = mMAX_TIME;
//		this.mAVG_TIME = mAVG_TIME;
//		this.mCOUNT = mCOUNT;
//		this.mIS_BOINCK = mIS_BOINCK;
//		this.mPARENT = mPARENT;
//		this.mPATH = mPATH;
//		this.mTEST_DATE = mTEST_DATE;
//		this.mPASS = mPASS;
//		this.mKPI_ID = mKPI_ID;
//		this.mNOTES = mNOTES;
//	}

	public PERFORMANCE_LOG(){
		
	}

//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    //@GenericGenerator(name="id_Sequence",strategy="uuid")
	//@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}
	
	@Column(name="KPI_DESC")
	public String getmKPI_DESC() {
		return mKPI_DESC;
	}

	public void setmKPI_DESC(String mKPI_DESC) {
		this.mKPI_DESC = mKPI_DESC;
	}
	
	@Column(name = "FUNCTION_NAME", unique = false, nullable = false)
	public String getmFUNCTION_NAME() {
		return mFUNCTION_NAME;
	}

	public void setmFUNCTION_NAME(String mFUNCTION_NAME) {
		this.mFUNCTION_NAME = mFUNCTION_NAME;
	}
	@Column(name = "TOTAL_TIME", nullable = false)
	public double getmTOTAL_TIME() {
		return mTOTAL_TIME;
	}

	public void setmTOTAL_TIME(double mTOTAL_TIME) {
		this.mTOTAL_TIME = mTOTAL_TIME;
	}
	@Column(name = "MIN_TIME")
	public Double getmMIN_TIME() {
		return mMIN_TIME;
	}

	public void setmMIN_TIME(Double mMIN_TIME) {
		this.mMIN_TIME = mMIN_TIME;
	}
	@Column(name = "MAX_TIME")
	public Double getmMAX_TIME() {
		return mMAX_TIME;
	}

	public void setmMAX_TIME(Double mMAX_TIME) {
		this.mMAX_TIME = mMAX_TIME;
	}
	@Column(name = "AVG_TIME")
	public Double getmAVG_TIME() {
		return mAVG_TIME;
	}

	public void setmAVG_TIME(Double mAVG_TIME) {
		this.mAVG_TIME = mAVG_TIME;
	}
	@Column(name = "COUNT")
	public Integer getmCOUNT() {
		return mCOUNT;
	}

	public void setmCOUNT(Integer mCOUNT) {
		this.mCOUNT = mCOUNT;
	}
	@Column(name = "IS_BOTNCK", nullable = false)
	public boolean ismIS_BOINCK() {
		return mIS_BOINCK;
	}

	public void setmIS_BOINCK(boolean mIS_BOINCK) {
		this.mIS_BOINCK = mIS_BOINCK;
	}
	@Column(name = "PARENT")
	public Integer getmPARENT() {
		return mPARENT;
	}

	public void setmPARENT(Integer mPARENT) {
		this.mPARENT = mPARENT;
	}
	@Column(name = "PATH")
	public String getmPATH() {
		return mPATH;
	}

	public void setmPATH(String mPATH) {
		this.mPATH = mPATH;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "TEST_DATE")
	public Date getmTEST_DATE() {
		return mTEST_DATE;
	}

	public void setmTEST_DATE(Date mTEST_DATE) {
		this.mTEST_DATE = mTEST_DATE;
	}
	///////////////////////////////////////////////////////////"PASS" NUMBER(1,0) DEFAULT 0 NOT NULL ENABLE, 
	@Column(name = "PASS", nullable=false)
	public boolean ismPASS() {
		return mPASS;
	}

	public void setmPASS(boolean mPASS) {
		this.mPASS = mPASS;
	}
	//@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "KPI_ID", nullable = false)
	@Column(name = "KPI_ID")
	public String getmKPI_ID() {
		return mKPI_ID;
	}

	public void setmKPI_ID(String mKPI_ID) {
		this.mKPI_ID = mKPI_ID;
	}
	@Column(name = "NOTES")
	public String getmNOTES() {
		return mNOTES;
	}

	public void setmNOTES(String mNOTES) {
		this.mNOTES = mNOTES;
	}	
	//@Column(name = "PARENTSSS", nullable = true)
	@Transient
	public PERFORMANCE_LOG getmChild(){
		return mNestedParents;
	}
	
	public void setParents(PERFORMANCE_LOG mParentInstance){
		this.mNestedParents = mParentInstance;
	}
	@Transient
	public String getmMonitor() {
		return mMonitor;
	}

	public void setmMonitor(String mMonitor) {
		this.mMonitor = mMonitor;
	}
	@Override
	public int compareTo(PERFORMANCE_LOG arg0) {
		// TODO Auto-generated method stub
		return getmTEST_DATE().compareTo(arg0.getmTEST_DATE());
	}
}
