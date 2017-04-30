package tp.model;

import java.util.Collection;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SEPA")
public class ResumeSEPA {

	@XmlElement
	Collection<Resume> DrctDbtTxInf;
	
	public ResumeSEPA() {
		this.DrctDbtTxInf = new LinkedList<>();
	}

	public ResumeSEPA(Collection<Resume> drctDbtTxInf) {
		DrctDbtTxInf = drctDbtTxInf;
	}

	public Collection<Resume> getDrctDbtTxInf() {
		return DrctDbtTxInf;
	}

	public void DrctDbtTxInfSet(Collection<Resume> drctDbtTxInf) {
		DrctDbtTxInf = drctDbtTxInf;
	}

	public void AddDrctDbtTxInf(Resume drctDbtTxInf){
		this.DrctDbtTxInf.add(drctDbtTxInf);
	}

}