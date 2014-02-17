package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Tasks;

public class TasksAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    List<TaskAf> tasks = new ArrayList<TaskAf>();
	
	public TasksAf(Tasks obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public List<TaskAf> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskAf> tasks) {
		this.tasks = tasks;
	}

}
