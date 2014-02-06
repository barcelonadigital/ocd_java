package org.bdigital.ocd.utils;

import java.util.Comparator;

import org.bdigital.ocd.model.Admission;

public class AdmissionComparator implements Comparator<Admission> {

	@Override
	public int compare(Admission arg0, Admission arg1) {
		
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
