package than.phyo.jagarafixer;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Qualcomm {
	public static void rawproRead(String a) {
		DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
		try {
			docBuilder.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			// parse xml
			DocumentBuilder db = docBuilder.newDocumentBuilder();
			Document doc = db.parse(new File("C:\\Users\\Than Phyo\\Desktop\\rawprogram0.xml"));

			// optional, but recommended
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());

			// get <program>
			NodeList list = doc.getElementsByTagName("program");
			for (int attritubes = 0; attritubes < list.getLength(); attritubes++) {
				Node node = list.item(attritubes);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
//					System.out.println(element.getAttribute("label"));
					a = element.getAttribute("filename");
//					System.out.println(data);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
