package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dbtr")
public class Name {
	@XmlElement(name="Nm")
	String Nm;
	
	public Name(){}
	
	public Name(String name) {
		this.Nm = name;
	}

	public String getNm() {
		return Nm;
	}
}
