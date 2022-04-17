package com.testing.sax;

        import org.xml.sax.Attributes;
        import org.xml.sax.SAXException;
        import org.xml.sax.helpers.DefaultHandler;

        import javax.xml.parsers.SAXParser;
        import javax.xml.parsers.SAXParserFactory;
        import java.io.File;

public class saxparser {

    public static void main(String[] args) {
        try {
            File inputFile = new File("Astronomy.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ast1 userHandler = new ast1();
            saxParser.parse(inputFile, userHandler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ast1 extends DefaultHandler{
    boolean bType = false;
    boolean bFamily = false;
    boolean bSpecies = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            String rollNo = attributes.getValue("tag2ID");
            System.out.println("Roll No : "+rollNo);
        }else if (qName.equalsIgnoreCase("CompositionalClass")){
            bType = true;
        }else if (qName.equalsIgnoreCase("Diameter")){
            bFamily = true;
        }else if (qName.equalsIgnoreCase("YearofDiscovery")){
            bSpecies = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            System.out.println("End : "+ qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bType){
            System.out.println("CompositionalClass: "+new String(ch, start, length));
            bType = false;
        }else if (bFamily){
            System.out.println("Diameter: "+new String(ch, start, length));
            bFamily = false;
        }else if (bSpecies){
            System.out.println("YearofDiscovery: "+new String(ch, start, length));
            bSpecies = false;
        }
    }
}
