package com.liverpool.cebt.ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class Conexion 
{
	
	public String callWS(String server, String soapAction,String requestMethod, String request)
	{
		String response="";
		
		try 
		{
			URL u = new URL(server);
			URLConnection uc = u.openConnection();
			HttpURLConnection connection = (HttpURLConnection) uc;
	      
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(requestMethod);//"POST");
			connection.setRequestProperty("SOAPAction", soapAction);//SOAP_ACTION);
	      
			OutputStream out = connection.getOutputStream();
			Writer wout = new OutputStreamWriter(out);
			wout.write(request);
	      
			wout.flush();
			wout.close();
	      
			InputStream in = connection.getInputStream();
			response = readXMLRPCResponse(in);
	      
			in.close();
			connection.disconnect();
	    } 
		catch (IOException e) 
		{
	    	e.printStackTrace();	
	    } 
		return response;
	}
	  
	  public String readXMLRPCResponse(
			   InputStream in) throws IOException,  
			   StringIndexOutOfBoundsException {
			    
			    StringBuffer sb = new StringBuffer();
			    //Reader reader = new InputStreamReader(in, "UTF-8");
			    
			    int c;
			    while ((c = in.read()) != -1) sb.append((char) c);
			    
			    String document = sb.toString();
				    return document;
			  } 
	  
	  public String getValueTag(String document, String startTag, String endTag){ 
		  	int start = document.indexOf(startTag) + startTag.length();
		    int end = document.indexOf(endTag);
		    String result = document.substring(start, end);
		  return result;
	  }
	
}
