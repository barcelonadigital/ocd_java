package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;

public abstract class EquipamentTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		TabBean tab = new TabBean();
    	List<RowBean> rows = new ArrayList<RowBean>();
    	tab.setTitle("Equip prescrit");
    	UtilsTabs.addBigField("17",questionsMap,rows);
    	UtilsTabs.addBigField("19",questionsMap,rows);
    	UtilsTabs.addBigField("20",questionsMap,rows);
    	UtilsTabs.addBigField("21",questionsMap,rows);
    	UtilsTabs.addBigField("22",questionsMap,rows);
    	
    	if(rows.size()>0){
    		tab.setRows(rows);
    		tabs.add(tab);
    	}
	}

}
