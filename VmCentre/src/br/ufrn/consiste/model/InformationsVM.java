package br.ufrn.consiste.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformationsVM {
	
	private String vmIp;
	private String tomcatUser;
	private String tomcatPassword;
	private int tomcatPort;
	private Thresholds thresholds;
	

	public InformationsVM() {
		// TODO Auto-generated constructor stub
	}


	public String getVmIp() {
		return vmIp;
	}


	public void setVmIp(String vmIp) {
		this.vmIp = vmIp;
	}


	public String getTomcatUser() {
		return tomcatUser;
	}


	public void setTomcatUser(String tomcatUser) {
		this.tomcatUser = tomcatUser;
	}


	public String getTomcatPassword() {
		return tomcatPassword;
	}


	public void setTomcatPassword(String tomcatPassword) {
		this.tomcatPassword = tomcatPassword;
	}


	public int getTomcatPort() {
		return tomcatPort;
	}


	public void setTomcatPort(int tomcatPort) {
		this.tomcatPort = tomcatPort;
	}


	public Thresholds getThresholds() {
		return thresholds;
	}


	public void setThresholds(Thresholds thresholds) {
		this.thresholds = thresholds;
	}
	
	

}
