package org.bdigital.ocd.tabs;

import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.beans.FieldBean;
import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.utils.Constants;

public class UtilsTabs {

	public static void addBigField(String idQuestion, HashMap<String, Question> questionsMap, List<RowBean> rows) {
		
		if(questionsMap.get(idQuestion)!=null){
    		Question questionObj = questionsMap.get(idQuestion);
    		questionsMap.remove(idQuestion);
    		RowBean rb1 = new RowBean();
    		rb1.addField(new FieldBean(Constants.HTML_FIELDTYPE_BIG, questionObj));
    		rows.add(rb1);
    	}
	}

	public static void addSmallField(String idQuestion1, String idQuestion2, HashMap<String, Question> questionsMap, List<RowBean> rows) {
		
		if(questionsMap.get(idQuestion1)!=null || questionsMap.get(idQuestion2)!=null){
    		RowBean rb1 = new RowBean();
    		if(questionsMap.get(idQuestion1)!=null){
        		Question questionObj = questionsMap.get(idQuestion1);
        		questionsMap.remove(idQuestion1);
        		rb1.addField(new FieldBean(Constants.HTML_FIELDTYPE_SMALL, questionObj));
        	}
    		if(questionsMap.get(idQuestion2)!=null){
        		Question questionObj = questionsMap.get(idQuestion2);
        		questionsMap.remove(idQuestion2);
        		rb1.addField(new FieldBean(Constants.HTML_FIELDTYPE_SMALL, questionObj));
        	}
    		rows.add(rb1);
    	}
	}

}
