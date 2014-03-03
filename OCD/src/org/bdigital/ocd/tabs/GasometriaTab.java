package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;

public abstract class GasometriaTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		TabBean tab = new TabBean();
    	List<RowBean> rows = new ArrayList<RowBean>();
    	tab.setTitle("Gasometria");
    	tab.setId("GASOMETRIA_ID");
    	UtilsTabs.addBigField("10",questionsMap,rows);
    	UtilsTabs.addSmallField("11","12",questionsMap,rows);
    	UtilsTabs.addBigField("40",questionsMap,rows);
    	UtilsTabs.addSmallField("13","14",questionsMap,rows);
    	UtilsTabs.addBigField("15",questionsMap,rows);
    	UtilsTabs.addSmallField("16","",questionsMap,rows);
    	
    	if(rows.size()>0){
    		tab.setRows(rows);
    		tabs.add(tab);
    	}
	}

}
