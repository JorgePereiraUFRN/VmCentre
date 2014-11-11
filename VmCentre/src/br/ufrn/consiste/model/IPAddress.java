package br.ufrn.consiste.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IPAddress extends CloudObject implements Serializable {
	
	
	String number;	
	boolean isPublic;
	String vmID;
	
	public IPAddress(){
		super(null);
	}
			
	public IPAddress(String number, boolean isPublic) {
		super(null);
		this.number = number;
		this.isPublic = isPublic;
	}
	
	public IPAddress(String number, boolean isPublic, String vmID) {
		super(null);
		this.number = number;
		this.isPublic = isPublic;
		this.vmID = vmID;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	public String getVMID() {
		return vmID;
	}
	public void setVMID(String vmID) {
		this.vmID = vmID;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IPAddress other = (IPAddress) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
		

	@Override
	public String toString() {
		return "IPAddress [number=" + number + ", isPublic=" + isPublic
				+ ", vmID=" + vmID + "]";
	}
	
	
	
	
}
