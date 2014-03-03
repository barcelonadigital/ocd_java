package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;

public abstract class EspirometriaTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		TabBean tab = new TabBean();
    	List<RowBean> rows = new ArrayList<RowBean>();
    	tab.setTitle("Espirometria");
    	tab.setId("ESPIROMETRIA_ID");
    	UtilsTabs.addBigField("5",questionsMap,rows);
    	UtilsTabs.addSmallField("6","38",questionsMap,rows);
    	UtilsTabs.addSmallField("7","39",questionsMap,rows);
    	UtilsTabs.addSmallField("8","",questionsMap,rows);
    	UtilsTabs.addSmallField("9","",questionsMap,rows);
    	
    	if(rows.size()>0){
    		tab.setRows(rows);
    		tabs.add(tab);
    	}
	}

}
