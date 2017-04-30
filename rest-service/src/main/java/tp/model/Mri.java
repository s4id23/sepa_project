package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MndtRltdInf")
public class Mri {
	
	@XmlElement(name="MndtId")
	String MndtId;

	@XmlElement(name="DtOfSgntr")
	String DtOfSgntr;
	
	public Mri(){}
	
	public Mri(String id, String date) {
		this.MndtId = id;
		this.DtOfSgntr = date;
	}
	
	public String getMndtId() {
		return MndtId;
	}

	public String getDtOfSgntr() {
		return DtOfSgntr;
	}

}
