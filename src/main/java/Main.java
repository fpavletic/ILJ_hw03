import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String xml;
        String[] xsds;

        if ( args.length < 2 ){
            try ( Scanner scanner = new Scanner(System.in) ){
                xml = scanner.nextLine();
                List<String> xsdsList = new ArrayList<>();
                String xsd;
                while (!(xsd = scanner.nextLine()).equals("done")){
                    xsdsList.add(xsd);
                }
                xsds = xsdsList.toArray(new String[xsdsList.size()]);
            }
        } else {
            xml = args[0];
            xsds = Arrays.copyOfRange(args, 1, args.length);
        }

        try {
            Validator.validate(args[0], Arrays.copyOfRange(args, 1, args.length));
            System.out.println("XML is valid");
        } catch ( SAXException | IOException e ) {
            System.out.println(e.getMessage());
        }

    }
}
