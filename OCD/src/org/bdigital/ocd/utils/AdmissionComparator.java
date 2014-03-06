package org.bdigital.ocd.utils;

import java.util.Comparator;

import org.bdigital.ocd.model.form.AdmissionAf;

public class AdmissionComparator implements Comparator<AdmissionAf> {

	@Override
	public int compare(AdmissionAf arg0, AdmissionAf arg1) {
		
		int ref0 = Integer.parseInt(arg0.getRef());
		int ref1 = Integer.parseInt(arg1.getRef());
		if (ref0 > ref1)
            return 1;
        else if (ref0 < ref1)
            return -1;
        else
            return 0;
	}

}
