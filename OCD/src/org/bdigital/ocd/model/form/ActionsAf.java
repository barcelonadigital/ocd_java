package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Actions;

public class ActionsAf extends org.apache.struts.action.ActionForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ActionAf> actions = new ArrayList<ActionAf>();

	public ActionsAf(Actions obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public List<ActionAf> getActions() {
		return actions;
	}

	public void setActions(List<ActionAf> actions) {
		this.actions = actions;
	}
 
	
}
