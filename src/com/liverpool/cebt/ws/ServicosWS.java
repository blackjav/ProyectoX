package com.liverpool.cebt.ws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.liverpool.cebt.utils.Utils;

public class ServicosWS 
{
	
	public String consultar(String numeroProveedor, String centro) 
	{		
		Utils utils = new Utils();
		Conexion conexion = new Conexion();
		String respuesta = "";
		System.out.println("Realizando consulta con el servicio web para extrar los pedidos para el proveedor:" + numeroProveedor);

		try {
			String brokerjndi = utils.leerPropiedad("url.ws");
			System.out.println(brokerjndi);
			URL url = new URL(brokerjndi);

			StringBuffer request = new StringBuffer();
			String server = url.toString();
			String soapAction = "http://www.liverpool.com.mx/wbi/cebt/ConsultaPedidos";
			String requestMethod = "POST";
	
			request.append("<?xml version='1.0'?>");
			request.append("<soapenv:Envelope ");
			request.append("xmlns:soapenv=");
			request.append("'http://schemas.xmlsoap.org/soap/envelope/' ");
			request.append("xmlns:cebt=");
			request.append("'http://www.liverpool.com.mx/wbi/cebt'>");
			request.append("<soapenv:Header/>");
			request.append("	<soapenv:Body>");
			request.append("		<cebt:ConsultaPedidosRequest>");
			request.append("			<numeroProveedor>"+numeroProveedor+"</numeroProveedor>");
			request.append("			<centro>"+centro+"</centro>");
			request.append("		</cebt:ConsultaPedidosRequest>");
			request.append("	</soapenv:Body>");
			request.append("</soapenv:Envelope>");
			System.out.println("Enviando consulta Numero de proveedor: "+ numeroProveedor + "  Centro: "+ centro);
			respuesta = conexion.callWS(server, soapAction, requestMethod, request.toString());
			
		} 
		catch (Exception e) 
		{
			System.out.println("Ocurrio una exception a enviar datos para consulta de pedidos .. "+e.getMessage() );
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	public String consultarDetallePedidos(String numeroPedido) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {

		System.out.println("\nRealizando consulta con el servicio web para extrar los detalles del pedido:" + numeroPedido);
		Utils utils = new Utils();
		Conexion conexion = new Conexion();
		String respuesta = "";

		try {
			String brokerjndi = utils.leerPropiedad("url.ws");
			URL url = new URL(brokerjndi);

			System.out.println(brokerjndi);
			StringBuffer request = new StringBuffer();
			String server = url.toString();
			String soapAction = "http://www.liverpool.com.mx/wbi/cebt/ConsultaDetallePedido";
			String requestMethod = "POST";
	
			request.append("<?xml version='1.0'?>");
			request.append("<soapenv:Envelope ");
			request.append("xmlns:soapenv=");
			request.append("'http://schemas.xmlsoap.org/soap/envelope/' ");
			request.append("xmlns:cebt=");
			request.append("'http://www.liverpool.com.mx/wbi/cebt'>");
			request.append("<soapenv:Header/>");
			request.append("	<soapenv:Body>");
			request.append("		<cebt:ConsultaDetallePedidoRequest>");
			request.append("			<numeroPedido>"+numeroPedido+"</numeroPedido>");
			request.append("		</cebt:ConsultaDetallePedidoRequest>");
			request.append("	</soapenv:Body>");
			request.append("</soapenv:Envelope>");
			System.out.println("Numero de pedido: "+ numeroPedido);
	
			respuesta = conexion.callWS(server, soapAction, requestMethod, request.toString());
			System.out.println(respuesta);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ha ocurridoun error al consultar el detalle del pedido. "+e.getMessage());
		}
		return respuesta;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("sdfdf");
		ServicosWS s = new ServicosWS();
		System.out.println(s.consultar("4934", "95"));
		
	}

}
