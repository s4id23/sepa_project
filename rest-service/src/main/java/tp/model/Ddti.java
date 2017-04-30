package tp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "DrctDbtTxInf")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ddti {
	@XmlTransient
	int id;
	
	@XmlTransient
	String Num;
	
	@XmlElement(name = "PmtId")
	String PmtId;
	
	@XmlElement(name = "InstdAmt")
	double InstdAmt;
	
	@XmlElement(name = "DrctDbtTx")
	Mri DrctDbtTx;
	
	@XmlElement(name = "DbtrAgt")
	Fii DbtrAgt;
	
	@XmlElement
	Name Dbtr;
	
	@XmlElement(name = "DbtrAcct")
	Identification DbtrAcct;
	
	@XmlElement(name = "RmtInf")
	String RmtInf;
	
	public Ddti(){}
	public Ddti(int id, String num, String pmtId, double instdAmt, Mri drctDbtTx, Fii dbtrAgt, Name dbtr, Identification dbtrAcct, String rmtInf) {
		this.id = id;
		this.Num = num;
		this.PmtId = pmtId;
		this.InstdAmt = instdAmt;
		this.DrctDbtTx = drctDbtTx;
		this.DbtrAgt = dbtrAgt;
		this.Dbtr = dbtr;
		this.DbtrAcct = dbtrAcct;
		this.RmtInf = rmtInf;
	}
	public int getId() {
		return id;
	}
	public String getNum() {
		return Num;
	}
	public String getPmtId() {
		return PmtId;
	}
	public double getInstdAmt() {
		return InstdAmt;
	}
	public Mri getDrctDbtTx() {
		return DrctDbtTx;
	}
	public Fii getDbtrAgt() {
		return DbtrAgt;
	}
	public Name getDbtr() {
		return Dbtr;
	}
	public Identification getDbtrAcct() {
		return DbtrAcct;
	}
	public String getRmtInf() {
		return RmtInf;
	}
	
}
