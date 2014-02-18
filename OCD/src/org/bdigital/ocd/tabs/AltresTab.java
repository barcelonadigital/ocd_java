package org.bdigital.ocd.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.bdigital.ocd.beans.FieldBean;
import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.utils.Constants;

public abstract class AltresTab {

	public static void generateTab(HashMap<String, Question> questionsMap,
			List<TabBean> tabs) {
		
		if(questionsMap.size()>0){
    		TabBean altresTb = new TabBean();
    		altresTb.setTitle("Altres");
        	List<RowBean> altresRows = new ArrayList<RowBean>();
        	Iterator<Entry<String, Question>> it = questionsMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, Question> pairs = it.next();
                Question questionObj = pairs.getValue();
                RowBean rb1 = new RowBean();
        		rb1.addField(new FieldBean(Constants.HTML_FIELDTYPE_BIG, questionObj));
        		altresRows.add(rb1);
            }
            altresTb.setRows(altresRows);
    		tabs.add(altresTb);
    	}
	}

}
