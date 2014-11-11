package br.ufrn.consiste.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CloudObject implements Serializable{
	
	private String id;
	
	public CloudObject(){
		
	}
		
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id == null ? "" : id;
	}
	
	public CloudObject(String id){
		this.id = id;
	}
	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
	
	
}
