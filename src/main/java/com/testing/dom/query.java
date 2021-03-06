package com.testing.dom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class query {

    public static void main(String argv[]) {

        try {
            File inputFile = new File("astronomy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Asteroids");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :");
                System.out.print(nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("Element : ");
                    System.out.println(eElement.getAttribute("tag2ID"));
                    NodeList carNameList = eElement.getElementsByTagName("001");

                    for (int count = 0; count < carNameList.getLength(); count++) {
                        Node node1 = carNameList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element Asteroids  = (Element) node1;

                            System.out.println("Asteroids type : "+Asteroids.getTextContent());

                            System.out.println("CompositionalClass : " +Asteroids.getAttribute("CompositionalClass"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}