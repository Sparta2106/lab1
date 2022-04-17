package com.testing.dom;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;
        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import java.io.File;

public class parse {
    public static void main(String[] args) {
        try{
            File inputFile = new File("astronomy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
            Document doc = dBuider.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Element principle: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("LargestAsteroids");
            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                System.out.println("\nElement : "+nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;

                    System.out.println("CompositionalClass : "
                            +eElement
                            .getElementsByTagName("CompositionalClass")
                            .item(0)
                            .getTextContent());
                    System.out.println("Diameter : "
                            +eElement
                            .getElementsByTagName("Diameter")
                            .item(0)
                            .getTextContent());
                    System.out.println("YearofDiscovery : "
                            +eElement
                            .getElementsByTagName("YearofDiscovery")
                            .item(0)
                            .getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
