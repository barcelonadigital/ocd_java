package org.bdigital.ocd.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilsWs {

	public static final String FORMAT_DATE_WS = "yyyy-MM-dd";
	public static final String FORMAT_DATEHOUR_WS = "yyyy-MM-dd hh:mm";
	
	public static String objectToXml(Object caseObj, Class<?>... classesToBeBound) throws JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
  		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

  		// output pretty printed
  		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

  		//jaxbMarshaller.marshal(customer, file);
  		OutputStream os = new ByteArrayOutputStream();

  		jaxbMarshaller.marshal(caseObj, os);
  	    return os.toString();
	}

	public static Object xmlToObject(String value, Class<?>... classesToBeBound) throws JAXBException, UnsupportedEncodingException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		InputStream is = new ByteArrayInputStream(value.getBytes());
		return jaxbUnmarshaller.unmarshal(new InputStreamReader(is, "ISO-8859-1"));
	}

	public static String getValue(String item, String id){
   		int idlenght = id.length();
   		int itemlenght = item.length();
   		if(itemlenght>idlenght){
   			return (item.substring(idlenght+1));
   		}else{
   			return "";
   		}
   	}
}
