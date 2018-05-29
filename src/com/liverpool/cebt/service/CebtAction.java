package com.liverpool.cebt.service;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

public class CebtAction extends ActionSupport implements SessionAware, ParameterNameAware {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1098816024635065249L;
	protected Map<String, Object> session ;
	private String actionError;

	@Override
    public String execute(){
        return null;
    } 

    protected void sendJSONObjectToResponse(Object objToSend)
    {
        Gson gson = new Gson();
        String jsonResult = gson.toJson(objToSend);	      
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json; charset=utf-8");
        
        try 
        {
            response.getWriter().write(jsonResult );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    protected void sendXMLObjectToResponse(Object xmlFile)
    {
        byte[] objXml = (byte[])xmlFile;	      
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/xml");
        try 
        {
            response.setContentType("text/xml");
            response.setCharacterEncoding("UTF-8");
            response.setContentLength(objXml.length);
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(objXml);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } 
        catch (IOException e) 
        {
            System.out.println("Imposible generar la respuesta. Error: " + e.getMessage());
            e.printStackTrace();			
        }
    }

    /* (non-Javadoc)
     * Se implementa este método para prevenir que pidan un parámetro de nombre session
     */
    @Override
    public boolean acceptableParameterName(String parameterName)
    {	     
        boolean allowedParameterName = true ;	     
        if ( parameterName.contains("session")  || parameterName.contains("request")) 
        {	     
        	System.out.println("La ip intento hacer una sesion maliciosa ");
            allowedParameterName = false ;	         
        } 	     
        return allowedParameterName;
    }
    
    /* (non-Javadoc)
     * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    @Override
    public void setSession(Map<String, Object> session) {					 
        this.session = session ;
    }

	public String getActionError() {
		return actionError;
	}

	public void setActionError(String actionError) {
		this.actionError = actionError;
	}
    
}
