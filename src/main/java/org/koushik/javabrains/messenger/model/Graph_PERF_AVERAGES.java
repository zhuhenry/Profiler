package org.koushik.javabrains.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Graph_PERF_AVERAGES {
	private Date mTEST_END;
	private List<Double> mAVERAGES_TOTALTIME_LIST = new ArrayList<Double>(0);
	
	public Graph_PERF_AVERAGES( Date mTEST_END, List<Double> mAVERAGES_TOTALTIME_LIST) {
		this.mTEST_END = mTEST_END;
		this.mAVERAGES_TOTALTIME_LIST = mAVERAGES_TOTALTIME_LIST;
	}
	
	public Date getmTEST_END() {
		return mTEST_END;
	}


	public void setmTEST_END(Date mTEST_END) {
		this.mTEST_END = mTEST_END;
	}


	public List<Double> getmAVERAGES_TOTALTIME_LIST() {
		return mAVERAGES_TOTALTIME_LIST;
	}


	public void setmAVERAGES_TOTALTIME_LIST(List<Double> mAVERAGES_TOTALTIME_LIST) {
		this.mAVERAGES_TOTALTIME_LIST = mAVERAGES_TOTALTIME_LIST;
	}
	
}
