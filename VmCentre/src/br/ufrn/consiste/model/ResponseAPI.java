package br.ufrn.consiste.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseAPI implements Serializable {
	private int statusCode;
	private String message;
	private List<CloudObject> objects = new ArrayList<CloudObject>();
	
		
	public ResponseAPI() {
		super();
		statusCode = 0;
		message = "";	
	}
	public ResponseAPI(int statusCode, String message, List<CloudObject> objs) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.objects = objs;
	}
	
	public ResponseAPI(int statusCode, String message, CloudObject obj) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.objects = new ArrayList<CloudObject>();
		objects.add(obj);
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<CloudObject> getObjects() {
		return objects;
	}
	public void setObjects(List<CloudObject> objs) {
		this.objects = objs;
	}
	@Override
	public String toString() {
		return "ResponseAPI [statusCode=" + statusCode + ", message=" + message
				+ ", object=" + objects + "]";
	}
	
	
}
