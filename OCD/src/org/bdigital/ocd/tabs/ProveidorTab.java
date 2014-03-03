package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;

public abstract class ProveidorTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		TabBean tab = new TabBean();
    	List<RowBean> rows = new ArrayList<RowBean>();
    	tab.setTitle("Proveïdor");
    	UtilsTabs.addBigField("28",questionsMap,rows);
    	UtilsTabs.addSmallField("49","",questionsMap,rows);
    	
    	if(rows.size()>0){
    		tab.setRows(rows);
    		tabs.add(tab);
    	}
	}

}
