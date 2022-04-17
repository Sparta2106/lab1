package com.testing.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class saxquery {
    public static void main(String[] args) {
        try {
            File inputFile = new File("Astronomy.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ast2 userHandler = new ast2();
            saxParser.parse(inputFile, userHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ast2 extends DefaultHandler {

    boolean bType = false;
    boolean bFamily = false;
    boolean bSpecies = false;
    String rollNo = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("asteroid")) {
            rollNo = attributes.getValue("tag2ID");
        }
        if("001".equals(rollNo) && qName.equalsIgnoreCase("asteroid")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("CompositionalClass")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Diameter")) {
            bFamily = true;
        } else if (qName.equalsIgnoreCase("YearofDiscovery")) {
            bSpecies = true;
        }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("asteroid")) {
            System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bType && ("001").equals(rollNo)) {
            System.out.println("CompositionalClass: " + new String(ch, start, length));
            bType = false;
        } else if (bFamily && ("001").equals(rollNo)) {
            System.out.println("Diameter: " + new String(ch, start, length));
            bFamily = false;
        } else if (bSpecies && ("001").equals(rollNo)) {
            System.out.println("YearofDiscovery: " + new String(ch, start, length));
            bSpecies = false;
        }
    }
}
