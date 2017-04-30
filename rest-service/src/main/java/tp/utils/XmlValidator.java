package tp.utils;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XmlValidator {
	public static boolean validateXMLSchema(File xsdFile, String xmlStream){
        try {
            Source xsdSource = new StreamSource(xsdFile);
            StringReader reader = new StringReader(xmlStream);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdSource);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(reader));
        } catch (IOException e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }catch(SAXException e1){
            System.out.println("SAX Exception: "+e1.getMessage());
            return false;
        }
        return true;
    }
}
