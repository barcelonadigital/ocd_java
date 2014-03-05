package org.bdigital.ocd.ws;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

public class LINKCAREProxyWrapper implements es.linkcare.LINKCARE.LINKCARE_PortType {
  private es.linkcare.LINKCARE.LINKCAREProxy lINKCAREProxy = null;
  
  public LINKCAREProxyWrapper() {
	  lINKCAREProxy = new es.linkcare.LINKCARE.LINKCAREProxy();
  }
  
  public LINKCAREProxyWrapper(String endpoint) {
	  lINKCAREProxy = new es.linkcare.LINKCARE.LINKCAREProxy(endpoint);
  }
  
  public String getEndpoint() {
    return lINKCAREProxy.getEndpoint();
  }
  
  public void setEndpoint(String endpoint) {
	  lINKCAREProxy.setEndpoint(endpoint);
  }
  
  public es.linkcare.LINKCARE.LINKCARE_PortType getLINKCARE_PortType() {
	  return lINKCAREProxy.getLINKCARE_PortType();
  }
  
  public void checkConection(javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
      lINKCAREProxy.checkConection(errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_ref(java.lang.String FORM_ID, java.lang.String library, javax.xml.rpc.holders.StringHolder FORM_REF, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_ref(FORM_ID, library, FORM_REF, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_get(java.lang.String FORM_REF, java.lang.String language, javax.xml.rpc.holders.StringHolder template, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_get(FORM_REF, language, template, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_set(java.lang.String FORM_REF, java.lang.String language, javax.xml.rpc.holders.StringHolder template, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_set(FORM_REF, language, template, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_delete(java.lang.String session, java.lang.String FORM_REF, java.lang.String host, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_delete(session, FORM_REF, host, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_insert(java.lang.String template, java.lang.String library, javax.xml.rpc.holders.StringHolder FORM_REF, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_insert(template, library, FORM_REF, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_export(java.lang.String template, java.lang.String host, javax.xml.rpc.holders.ByteArrayHolder text, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_export(template, host, text, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_import(byte[] text, java.lang.String host, java.lang.String especial, javax.xml.rpc.holders.StringHolder template, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_import(text, host, especial, template, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_update(java.lang.String session, byte[] text, java.lang.String host, javax.xml.rpc.holders.StringHolder template, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_update(session, text, host, template, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void template_get_summary(byte[] session, java.lang.String template_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.template_get_summary(session, template_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void activity_load(java.lang.String ACTIVITY_REF, javax.xml.rpc.holders.StringHolder activity, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.activity_load(ACTIVITY_REF, activity, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void activity_optional(java.lang.String ADMISSION_REF, java.lang.String TYPE, java.lang.String LANG, javax.xml.rpc.holders.StringHolder activity_list, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.activity_optional(ADMISSION_REF, TYPE, LANG, activity_list, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_insert(java.lang.String session, java.lang.String ADMISSION_REF, java.lang.String activity, java.lang.String DATE, java.lang.String event_id, javax.xml.rpc.holders.StringHolder TASK_ID, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_insert(session, ADMISSION_REF, activity, DATE, event_id, TASK_ID, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_insert_with_professional(java.lang.String session, java.lang.String ADMISSION_REF, java.lang.String activity, java.lang.String DATE, javax.xml.rpc.holders.StringHolder TASK_ID, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_insert_with_professional(session, ADMISSION_REF, activity, DATE, TASK_ID, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_delete(java.lang.String token, java.lang.String TASK_ID, java.lang.String type, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_delete(token, TASK_ID, type, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_list_day_default(java.lang.String token, java.lang.String id_type, java.lang.String id, javax.xml.rpc.holders.StringHolder date, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_list_day_default(token, id_type, id, date, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_calendar_month(java.lang.String token, java.lang.String year, java.lang.String month, java.lang.String id_type, java.lang.String id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_calendar_month(token, year, month, id_type, id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_calendar_year(java.lang.String token, java.lang.String year, java.lang.String id_type, java.lang.String id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_calendar_year(token, year, id_type, id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public java.lang.String task_list(java.lang.String date, java.lang.String id_type, java.lang.String id, java.lang.String lang, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  java.lang.String returnValue = lINKCAREProxy.task_list(date, id_type, id, lang, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
      return returnValue;
  }
  
  public void task_list_date(java.lang.String session, java.lang.String date, java.lang.String type, java.lang.String id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_list_date(session, date, type, id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_form_list(java.lang.String session, java.lang.String task_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_form_list(session, task_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_get(java.lang.String session, java.lang.String task, java.lang.String context, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_get(session, task, context, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_set(java.lang.String session, java.lang.String task, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_set(session, task, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_role_list(java.lang.String session, java.lang.String task_id, java.lang.String category_id, java.lang.String assigned_roles, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_role_list(session, task_id, category_id, assigned_roles, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void task_user_list(java.lang.String session, java.lang.String task_id, java.lang.String role_id, java.lang.String assigned_users, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.task_user_list(session, task_id, role_id, assigned_users, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void contact_search(java.lang.String session, java.lang.String type, java.lang.String search_str, java.lang.String max_res, java.lang.String scope, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.contact_search(session, type, search_str, max_res, scope, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void source_get_url(java.lang.String session, java.lang.String source_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.source_get_url(session, source_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_list(java.lang.String session, java.lang.String program, java.lang.String role, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_list(session, program, role, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_set_role_list(java.lang.String session, java.lang.String user_id, java.lang.String role_list, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_set_role_list(session, user_id, role_list, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_get_role_list(java.lang.String session, java.lang.String user_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_get_role_list(session, user_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_get(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_get(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_get_contact(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_get_contact(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_insert(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder type, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_insert(session, user, result, type, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_set_contact(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_set_contact(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_merge_contact(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_merge_contact(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void user_set(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.user_set(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_get(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_get(session, _case, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_get_contact(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_get_contact(session, _case, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_insert(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder type, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_insert(session, _case, result, type, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_set_contact(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_set_contact(session, _case, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_merge_contact(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_merge_contact(session, _case, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_set(java.lang.String session, java.lang.String _case, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_set(session, _case, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void case_delete(java.lang.String session, java.lang.String _case, java.lang.String type, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.case_delete(session, _case, type, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_set(java.lang.String session, java.lang.String admission, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_set(session, admission, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_delete(java.lang.String session, java.lang.String admission, java.lang.String type, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_delete(session, admission, type, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_get(java.lang.String session, java.lang.String admission, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_get(session, admission, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_list(java.lang.String session, java.lang.String _case, java.lang.String get, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_list(session, _case, get, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_list_case(java.lang.String session, java.lang.String _case, java.lang.String get, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_list_case(session, _case, get, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_insert(java.lang.String session, java.lang.String _case, java.lang.String program, java.lang.String date, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_insert(session, _case, program, date, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_join(java.lang.String session, java.lang.String admission, java.lang.String protocol, java.lang.String date, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_join(session, admission, protocol, date, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_report(java.lang.String session, java.lang.String start_date, java.lang.String end_date, java.lang.String program, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_report(session, start_date, end_date, program, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void action_list(java.lang.String session, java.lang.String _case, java.lang.String type, java.lang.String admission, java.lang.String id, java.lang.String library, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.action_list(session, _case, type, admission, id, library, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void action_exec(java.lang.String session, java.lang.String action_token, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.action_exec(session, action_token, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_role_list(java.lang.String session, java.lang.String event_id, java.lang.String type, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_role_list(session, event_id, type, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_issuer_list(java.lang.String session, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_issuer_list(session, event_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_task_list(java.lang.String session, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_task_list(session, event_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_form_list(java.lang.String session, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_form_list(session, event_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_template_list(java.lang.String session, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_template_list(session, event_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_set(java.lang.String session, java.lang.String event, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_set(session, event, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_call_duration_set(java.lang.String session, java.lang.String event_id, java.lang.String duration, java.lang.String event_code, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_call_duration_set(session, event_id, duration, event_code, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_get(java.lang.String session, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_get(session, event_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_delete(java.lang.String session, java.lang.String event_id, java.lang.String type, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_delete(session, event_id, type, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_type(java.lang.String session, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_type(session, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_insert(java.lang.String session, java.lang.String date, java.lang.String _case, java.lang.String event_type, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_insert(session, date, _case, event_type, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_report(java.lang.String session, java.lang.String start_date, java.lang.String end_date, java.lang.String program, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_report(session, start_date, end_date, program, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void event_report_2(java.lang.String session, java.lang.String start_date, java.lang.String end_date, java.lang.String program, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.event_report_2(session, start_date, end_date, program, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void elapsed_list(java.lang.String session, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.elapsed_list(session, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_insert(java.lang.String session, java.lang.String type, java.lang.String id_type, java.lang.String template_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_insert(session, type, id_type, template_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_set(java.lang.String session, java.lang.String type, java.lang.String id_type, java.lang.String template_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_set(session, type, id_type, template_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_close(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_close(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_open(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_open(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_delete(java.lang.String session, java.lang.String form, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_delete(session, form, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_get(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_get(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_get_header(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_get_header(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_get_summary(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_get_summary(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_get_question(java.lang.String session, java.lang.String form_id, java.lang.String question_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_get_question(session, form_id, question_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_get_answer(java.lang.String session, java.lang.String form_id, java.lang.String question_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_get_answer(session, form_id, question_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_set_answer(java.lang.String session, java.lang.String form_id, java.lang.String question_id, java.lang.String value, java.lang.String option_id, java.lang.String event_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder refresh, javax.xml.rpc.holders.StringHolder next, javax.xml.rpc.holders.StringHolder next_form, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_set_answer(session, form_id, question_id, value, option_id, event_id, result, refresh, next, next_form, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_PDF(java.lang.String session, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_PDF(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_list(java.lang.String session, java.lang.String type, java.lang.String id, java.lang.String form_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_list(session, type, id, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void form_set_file(java.lang.String session, java.lang.String form_id, java.lang.String type, java.lang.String file_content, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.form_set_file(session, form_id, type, file_content, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void description_get_key(java.lang.String KEY, java.lang.String LANG, javax.xml.rpc.holders.StringHolder text, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.description_get_key(KEY, LANG, text, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void description_get_XLS(javax.xml.rpc.holders.ByteArrayHolder XLS, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.description_get_XLS(XLS, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void description_set_XLS(byte[] XLS, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.description_set_XLS(XLS, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void alert_get(java.lang.String session, java.lang.String ticket, javax.xml.rpc.holders.StringHolder message, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.alert_get(session, ticket, message, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void alert_subscribe(java.lang.String session, java.lang.String endpoint, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.alert_subscribe(session, endpoint, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void team_check(java.lang.String session, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.team_check(session, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_discover(javax.xml.rpc.holders.StringHolder user, java.lang.String password, java.lang.String IP, java.lang.String host, javax.xml.rpc.holders.StringHolder language, javax.xml.rpc.holders.StringHolder token, javax.xml.rpc.holders.StringHolder role, javax.xml.rpc.holders.StringHolder center, javax.xml.rpc.holders.StringHolder name, javax.xml.rpc.holders.StringHolder WS, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_discover(user, password, IP, host, language, token, role, center, name, WS, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_init(javax.xml.rpc.holders.StringHolder user, java.lang.String password, java.lang.String IP, java.lang.String host, javax.xml.rpc.holders.StringHolder language, javax.xml.rpc.holders.StringHolder token, java.lang.String norewrite, javax.xml.rpc.holders.StringHolder role, javax.xml.rpc.holders.StringHolder center, javax.xml.rpc.holders.StringHolder name, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_init(user, password, IP, host, language, token, norewrite, role, center, name, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_center(java.lang.String token, java.lang.String center, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_center(token, center, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_role(java.lang.String token, java.lang.String role, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_role(token, role, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_language(java.lang.String token, java.lang.String language, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_language(token, language, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_get_user(java.lang.String token, javax.xml.rpc.holders.StringHolder user_id, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_get_user(token, user_id, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_get_center_list(java.lang.String token, javax.xml.rpc.holders.StringHolder center_list, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_get_center_list(token, center_list, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_get_role_list(java.lang.String token, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_get_role_list(token, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_get_language_list(java.lang.String token, javax.xml.rpc.holders.StringHolder language_list, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_get_language_list(token, language_list, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_get_active_role(java.lang.String token, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_get_active_role(token, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void session_relocate(java.lang.String token, java.lang.String source_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.session_relocate(token, source_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_obtenerDatosPacienteCIP(java.lang.String CIP, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_obtenerDatosPacienteCIP(CIP, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_obtenerDatosNHC(java.lang.String NHC, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_obtenerDatosNHC(NHC, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_obtenerEquiposReferencia(java.lang.String CIP, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_obtenerEquiposReferencia(CIP, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_obtenerDatosDiagnosticos(java.lang.String CIP, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_obtenerDatosDiagnosticos(CIP, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_obtenerDocumentosCIP(java.lang.String CIP, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_obtenerDocumentosCIP(CIP, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_recuperarDocumento(java.lang.String xml, javax.xml.rpc.holders.StringHolder datosXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_recuperarDocumento(xml, datosXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void HIS_enviarCursoClinico(java.lang.String xml, javax.xml.rpc.holders.StringHolder posicionXML, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.HIS_enviarCursoClinico(xml, posicionXML, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void synergy_get_data(java.lang.String session, java.lang.String xml, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.synergy_get_data(session, xml, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void program_list(java.lang.String session, java.lang.String active, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.program_list(session, active, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void program_get(java.lang.String session, java.lang.String program_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.program_get(session, program_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_list_program(java.lang.String session, java.lang.String program, java.lang.String status, java.lang.String scope, java.lang.String search_str, java.lang.String limit, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_list_program(session, program, status, scope, search_str, limit, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void protocol_list(java.lang.String session, java.lang.String program, java.lang.String mdc, java.lang.String active, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.protocol_list(session, program, mdc, active, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void protocol_get(java.lang.String session, java.lang.String protocol_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.protocol_get(session, protocol_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void protocol_get_XML(java.lang.String session, java.lang.String protocol_id, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.protocol_get_XML(session, protocol_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void admission_list_protocol(java.lang.String session, java.lang.String protocol, java.lang.String status, java.lang.String scope, java.lang.String search_str, java.lang.String limit, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.admission_list_protocol(session, protocol, status, scope, search_str, limit, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void code_search(java.lang.String session, java.lang.String code_system, java.lang.String search_text, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.code_search(session, code_system, search_text, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_session_discover(javax.xml.rpc.holders.StringHolder user, java.lang.String password, java.lang.String IP, java.lang.String host, javax.xml.rpc.holders.StringHolder language, javax.xml.rpc.holders.StringHolder token, javax.xml.rpc.holders.StringHolder role, javax.xml.rpc.holders.StringHolder center, javax.xml.rpc.holders.StringHolder name, javax.xml.rpc.holders.StringHolder WS, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_session_discover(user, password, IP, host, language, token, role, center, name, WS, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_session_init(javax.xml.rpc.holders.StringHolder user, java.lang.String password, java.lang.String IP, java.lang.String host, javax.xml.rpc.holders.StringHolder language, javax.xml.rpc.holders.StringHolder token, javax.xml.rpc.holders.StringHolder role, javax.xml.rpc.holders.StringHolder center, javax.xml.rpc.holders.StringHolder name, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_session_init(user, password, IP, host, language, token, role, center, name, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_task_get_pendings(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_task_get_pendings(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_task_get_optionals(java.lang.String session, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_task_get_optionals(session, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_form_set_device_answers(java.lang.String session, java.lang.String task_id, java.lang.String device_type, java.lang.String answers_XML, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_form_set_device_answers(session, task_id, device_type, answers_XML, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_task_insert_from_optional(java.lang.String session, java.lang.String task_id_optional, java.lang.String user, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_task_insert_from_optional(session, task_id_optional, user, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_task_form_list(java.lang.String session, java.lang.String task_id, java.lang.String optional, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_task_form_list(session, task_id, optional, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_form_get_summary(java.lang.String session, java.lang.String task_id, java.lang.String optional, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_form_get_summary(session, task_id, optional, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
  
  public void mobile_task_list_month(java.lang.String session, java.lang.String from, java.lang.String to, java.lang.String _case, java.lang.String lang, javax.xml.rpc.holders.StringHolder result, javax.xml.rpc.holders.StringHolder errorMsg) throws java.rmi.RemoteException{
	  lINKCAREProxy.mobile_task_list_month(session, from, to, _case, lang, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }

  public void form_get_summary_all(String session, String form_id, StringHolder result, StringHolder errorMsg) throws RemoteException {
	  lINKCAREProxy.form_get_summary_all(session, form_id, result, errorMsg);
      if (errorMsg.value!=null && !"".equals(errorMsg.value))
          throw new LINKCAREException(errorMsg.value);
  }
}