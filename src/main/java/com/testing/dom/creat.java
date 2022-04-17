package com.testing.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class creat {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();

            Element rootElement = doc.createElement("Asteroids");
            doc.appendChild(rootElement);

            Element commonObjects = doc.createElement("LargestAsteroids");
            Attr commonAtr1 = doc.createAttribute("name");
            commonAtr1.setValue("Ceres");
            commonObjects.setAttributeNode(commonAtr1);
            rootElement.appendChild(commonObjects);

            Element art1 = doc.createElement("asteroid");
            Attr attr1 = doc.createAttribute("tag2ID");
            attr1.setValue("001");
            art1.setAttributeNode(attr1);
            commonObjects.appendChild(art1);

            Element art11 = doc.createElement("CompositionalClass");
            art11.appendChild(doc.createTextNode("C (carbonaceous)"));
            art1.appendChild(art11);

            Element art21 = doc.createElement("Diameter");
            art21.appendChild(doc.createTextNode("nine hundred and forty"));
            art1.appendChild(art21);

            Element art31 = doc.createElement("YearofDiscovery");
            art31.appendChild(doc.createTextNode("one thousand eight hundred one"));
            art1.appendChild(art31);



            Element art2 = doc.createElement("asteroid");
            Attr attr2 = doc.createAttribute("tag2ID");
            attr2.setValue("002");
            art2.setAttributeNode(attr2);
            commonObjects.appendChild(art2);

            Element art51 = doc.createElement("CompositionalClass");
            art51.appendChild(doc.createTextNode("C (carbonaceous)"));
            art2.appendChild(art51);

            Element art61 = doc.createElement("Diameter");
            art61.appendChild(doc.createTextNode("nine hundred and forty"));
            art2.appendChild(art61);

            Element art71 = doc.createElement("YearofDiscovery");
            art71.appendChild(doc.createTextNode("one thousand eight hundred one"));
            art2.appendChild(art71);



            Element commonObjects1 = doc.createElement("LargestAsteroids");
            Attr commonAtr2 = doc.createAttribute("name");
            commonAtr2.setValue("Pallas");
            commonObjects1.setAttributeNode(commonAtr2);
            rootElement.appendChild(commonObjects1);

            Element art3 = doc.createElement("asteroid");
            Attr attr3 = doc.createAttribute("tag2ID");
            attr3.setValue("001");
            art3.setAttributeNode(attr3);
            commonObjects1.appendChild(art3);

            Element art111 = doc.createElement("CompositionalClass");
            art111.appendChild(doc.createTextNode("S (stony)"));
            art3.appendChild(art111);

            Element art211 = doc.createElement("Diameter");
            art211.appendChild(doc.createTextNode("two hundred sixty-five"));
            art3.appendChild(art211);

            Element art311 = doc.createElement("YearofDiscovery");
            art311.appendChild(doc.createTextNode("one thousand eight hundred forty-nine"));
            art3.appendChild(art311);

            Element art4 = doc.createElement("asteroid");
            Attr attr4 = doc.createAttribute("tag2ID");
            attr4.setValue("002");
            art4.setAttributeNode(attr4);
            commonObjects1.appendChild(art4);

            Element art411 = doc.createElement("CompositionalClass");
            art411.appendChild(doc.createTextNode("S (stony)"));
            art4.appendChild(art411);

            Element art511 = doc.createElement("Diameter");
            art511.appendChild(doc.createTextNode("two hundred sixty-five"));
            art4.appendChild(art511);

            Element art611 = doc.createElement("YearofDiscovery");
            art611.appendChild(doc.createTextNode("one thousand eight hundred forty-nine"));
            art4.appendChild(art611);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("astronomy.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
