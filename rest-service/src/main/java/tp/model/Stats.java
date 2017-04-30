package tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Statistiques")
public class Stats {
	@XmlElement(name="NbrTrans")
	int NbrTrans;
	
	@XmlElement(name="MntTot")
	double MntTot;

	public Stats(){}

	public Stats(int NbrTrans, double MntTot) {
		this.NbrTrans = NbrTrans;
		this.MntTot = MntTot;
	}

	public int getNbrTrans() {
		return NbrTrans;
	}

	public double getMntTot() {
		return MntTot;
	}

}
