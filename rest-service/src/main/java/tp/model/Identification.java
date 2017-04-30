package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Id")
public class Identification {

	@XmlElement
	String IBAN;
	
	public Identification(){}
	
	public Identification(String iban) {
		IBAN = iban;
	}

	public String getIBAN() {
		return this.IBAN;
	}

}