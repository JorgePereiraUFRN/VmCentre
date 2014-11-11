package br.ufrn.consiste.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VirtualMachine extends CloudObject implements Serializable{
	
	public static enum State{
			
		Init  ("init", 0),
		Ready ("ready", 1),
		Stop  ("Stop", 2),
		Start ("Start", 3),
		Reboot("Reboot", 4),
		Undefined("Undefined", 5),
		Terminated("Terminated", 6);
		
		public final String name;
		public final int value;
		
		State(String name, int value){
			this.name = name;
			this.value = value;		
		}
		
	}
	
	private String name;
	private String image;
	private String type;	
	private String keyname;
	private ArrayList<IPAddress> ips;
	private State state;
	
	public VirtualMachine(){
		super(null);
	}
		
	public String getVMType() {		
		return type;
	}
	
	public void setVMType(String vmtype) {
		this.type = vmtype;
	}	
	
	public String getName() {
		return this.name == null ? "" : this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public VirtualMachine(String name, String image, String vmtype){
		super(null);
		this.name = name;
		this.image = image;
		this.type = vmtype;
		this.keyname = "";
		this.ips = new ArrayList<IPAddress>();
	}
	
	public VirtualMachine(String name, String image, String vmtype, String keyname){
		super(null);
		this.name = name;
		this.image = image;
		this.type = vmtype;
		this.keyname = keyname;
		this.ips = new ArrayList<IPAddress>();
	}
		
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<IPAddress> getIps() {
		return ips;
	}
	
	public void addIp(String ipnumber, boolean ispublic) {
		IPAddress ip = new IPAddress(ipnumber, ispublic, getId());
		ips.add(ip);
	}
	
	public void removeIp(IPAddress ip) {
		ips.remove(ip);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "VirtualMachine [name=" + name + ", image=" + image + ", type="
				+ type + ", keyname=" + keyname + ", ips=" + ips + ", state="
				+ state + "]";
	}
	
	
	
	
	
}