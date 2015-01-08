package org.pandaria.cafe.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class WeixinRobot
 */
public class WeixinRobot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeixinRobot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String INFO = URLEncoder.encode("你好啊", "utf-8");  
        String requesturl = "http://www.tuling123.com/openapi/api?key=2a5ad79d9ab0e365c2f8a5bc93afc4e4&info="+INFO; 
        System.out.println(requesturl);
        HttpGet httpGet = new HttpGet(requesturl);
        HttpResponse httpRes = HttpClients.createDefault().execute(httpGet); 
        
        //200即正确的返回码  
        if(httpRes.getStatusLine().getStatusCode()==200){  
        	String result = EntityUtils.toString(httpRes.getEntity());  
        	System.out.println("返回结果："+result);  
        }
	}
	
}
