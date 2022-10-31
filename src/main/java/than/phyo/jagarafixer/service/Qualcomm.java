package than.phyo.jagarafixer.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import than.phyo.jagarafixer.model.QRawModel;

public class Qualcomm {

	private static ObservableList<QRawModel> qRaw = FXCollections.observableArrayList();

	private static String replacePath;
	
	public static void rawproRead(TableView<QRawModel> tableView) {
		DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
		try {
			docBuilder.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			// parse xml
			DocumentBuilder db = docBuilder.newDocumentBuilder();
			Document doc = db.parse(replacePath);
//			Document doc = db.parse(new File("C:\\Users\\Than Phyo\\Desktop\\rawprogram0.xml"));

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
//					qRaw.add(new QRawModel(element.getAttribute("filename"), element.getAttribute("label"),
//							element.getAttribute("start_byte_hex"), element.getAttribute("start_sector"),
//							element.getAttribute("size_in_KB")));
					List<String> data = new ArrayList<>();
					String [] ary = {element.getAttribute("filename"), element.getAttribute("label"),
							element.getAttribute("start_byte_hex"), element.getAttribute("start_sector"),
							element.getAttribute("size_in_KB")};
					if(element.getAttribute("filename") != "") {
						System.out.println(ary[0]);
						qRaw.add(new QRawModel(ary[0], ary[1], ary[2], ary[3], ary[4]));
					}
					tableView.setItems(qRaw);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileChoose(TextField txField) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter(".xml", "*.xml"));
		File file = fc.showOpenDialog(null);
		if (file == null) return;
		String filePath = file.getAbsolutePath();
		replacePath = filePath.replace("\\" , "\\\\");
		txField.setText(filePath);
		System.out.println(replacePath);
	}
}
