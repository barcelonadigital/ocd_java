package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;

public class DomiciliTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		TabBean tab = new TabBean();
    	List<RowBean> rows = new ArrayList<RowBean>();
    	tab.setTitle("Domicili");
    	UtilsTabs.addBigField("52",questionsMap,rows);
    	UtilsTabs.addBigField("53",questionsMap,rows);
    	UtilsTabs.addBigField("54",questionsMap,rows);
    	
    	if(rows.size()>0){
    		tab.setRows(rows);
    		tabs.add(tab);
    	}
	}

}
