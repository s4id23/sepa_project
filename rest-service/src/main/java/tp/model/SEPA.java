package tp.model;

import java.util.Collection;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SEPA")
public class SEPA {

	@XmlElement
	Collection<Ddti> DrctDbtTxInf;
	
	public SEPA() {
		this.DrctDbtTxInf = new LinkedList<>();
	}

	public SEPA(Collection<Ddti> drctDbtTxInf) {
		DrctDbtTxInf = drctDbtTxInf;
	}

	public Collection<Ddti> getDrctDbtTxInf() {
		return DrctDbtTxInf;
	}

	public void DrctDbtTxInfSet(Collection<Ddti> drctDbtTxInf) {
		DrctDbtTxInf = drctDbtTxInf;
	}

	public void AddDrctDbtTxInf(Ddti drctDbtTxInf){
		this.DrctDbtTxInf.add(drctDbtTxInf);
	}

}