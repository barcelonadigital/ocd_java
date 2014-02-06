package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Tasks {

    List<Task> tasks = new ArrayList<Task>();

	public List<Task> getTasks() {
		return tasks;
	}

	@XmlElement(name = "task")
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
 
	
}
