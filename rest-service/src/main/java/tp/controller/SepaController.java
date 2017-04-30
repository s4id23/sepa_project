package tp.controller;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import tp.dao.DAO;
import tp.model.*;


@Controller
public class SepaController {
	
	@Autowired
	DAO transactionDAO;
	
	private SEPA sepa;
	
	private ResumeSEPA resumeSEPA;
	
	public SepaController(){
		sepa = new SEPA();
		
		resumeSEPA = new ResumeSEPA();
		
	}
	
	@RequestMapping(value="/depot", method = RequestMethod.POST)
	public @ResponseBody ResponseModel addTransaction(@RequestBody String body) throws SAXException, ParserConfigurationException, IOException {
		InputSource inputSource = new InputSource(new StringReader(body));
		Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
		int id = transactionDAO.getLastId()+1;
			
		try{
				Ddti drctDbtTxInf = new Ddti(id , "BB"+String.format("%04d", id),
				doc.getElementsByTagName("PmtId").item(0).getTextContent(),
				Double.parseDouble(doc.getElementsByTagName("InstdAmt").item(0).getTextContent()), 
				new Mri(doc.getElementsByTagName("MndtId").item(0).getTextContent(),
						doc.getElementsByTagName("DtOfSgntr").item(0).getTextContent()),
				new Fii(doc.getElementsByTagName("BIC").item(0).getTextContent()),
				new Name(doc.getElementsByTagName("Nm").item(0).getTextContent()),
				new Identification(doc.getElementsByTagName("IBAN").item(0).getTextContent()),
				doc.getElementsByTagName("RmtInf").item(0).getTextContent());			
				
				if(transactionDAO.get(drctDbtTxInf.getPmtId())!=null){
					return null;
				}
				transactionDAO.add(drctDbtTxInf);
				return new ResponseModel("succes");
				
		}		
		catch(NullPointerException e){
			return null;
		}
	} 
	
	@RequestMapping(value="/resume", method = RequestMethod.GET)
	public @ResponseBody ResumeSEPA getSEPAInXMLResume() {
		this.resumeSEPA.DrctDbtTxInfSet(transactionDAO.listResume());
		return this.resumeSEPA;
	}
	
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public @ResponseBody SEPA getSEPAInXML() {
		this.sepa.DrctDbtTxInfSet(transactionDAO.list());
		return this.sepa;
	}
	
	
	@RequestMapping(value="/trx/{id}", method = RequestMethod.GET)
	public @ResponseBody Ddti getTransactionById(@PathVariable("id") String id) {
		return transactionDAO.get(id);
	}
	
	@RequestMapping(value="/stats", method = RequestMethod.GET)
	public @ResponseBody Stats getSEPAStats() {
		return transactionDAO.getStats();
	}	
	
}