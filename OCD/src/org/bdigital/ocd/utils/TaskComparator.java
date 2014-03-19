package org.bdigital.ocd.utils;

import java.util.Comparator;

import org.bdigital.ocd.model.form.TaskAf;

public class TaskComparator implements Comparator<TaskAf> {

	@Override
	public int compare(TaskAf arg0, TaskAf arg1) {
		
		int ref0 = Integer.parseInt(arg0.getId());
		int ref1 = Integer.parseInt(arg1.getId());
		if (ref0 > ref1)
            return 1;
        else if (ref0 < ref1)
            return -1;
        else
            return 0;
	}

}
