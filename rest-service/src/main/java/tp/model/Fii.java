package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FinInstnId")
public class Fii {

	@XmlElement
	String BIC;

	public Fii(){}
	
	public Fii(String bic){
		this.BIC=bic;
	}
	
	public String getBIC() {
		return this.BIC;
	}

}
