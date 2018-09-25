import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.util.Arrays;

public class Validator {

    //static class
    private Validator(){}

    public static boolean validate(String xml, String[] xsds) throws SAXException, IOException{

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(
                Arrays.stream(xsds)
                        .map(StreamSource::new)
                        .toArray(StreamSource[]::new)
        );

        schema.newValidator().validate(new StreamSource(xml));

        //TODO validate
        return true;
    }

}

