package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Transaction")
public class Resume {
	@XmlElement(name="Num")
	String Num;
	
	@XmlElement(name="Identifiant")
	String Identifiant;
	
	@XmlElement(name="Montant")
	double Montant;
	
	@XmlElement(name="Date")
	String Date;
	
	public Resume(){}
	
	public Resume(String num, String identifiant, double montant, String date) {
		this.Num = num;
		Identifiant = identifiant;
		this.Montant = montant;
		this.Date = date;
	}

	public String getNum() {
		return Num;
	}

	public String getIdentifiant() {
		return Identifiant;
	}

	public double getMontant() {
		return Montant;
	}

	public String getDate() {
		return Date;
	}

}
