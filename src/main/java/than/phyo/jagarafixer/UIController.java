package than.phyo.jagarafixer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UIController extends Qualcomm implements Initializable {
	@FXML
	private TableView<QRawModel> tableView;

	@FXML
	private TableColumn<QRawModel, String> partitionName;

	@FXML
	private TableColumn<QRawModel, String> fileName;

	@FXML
	private TableColumn<QRawModel, String> startBye;

	@FXML
	private TableColumn<QRawModel, String> startSector;

	@FXML
	private TableColumn<QRawModel, String> fileSize;

	private ObservableList<QRawModel> qModel = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		char underScore = 98;
		System.out.println("start95byte95hex");
		partitionName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("label"));
		fileName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("fileName"));
//		startBye.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("start_byte_hex"));
//		startSector.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("label"));
//		fileSize.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("label"));

//		tableView.getItems().add(new QRawModel(partitionName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("partitionName"))));
		rawproRead();
	}

	public void rawproRead() {
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
					qModel.add(new QRawModel(element.getAttribute("filename"), element.getAttribute("label"),
							element.getAttribute("start_byte_hex"), element.getAttribute("start_sector"),
							element.getAttribute("size_in_KB")));
					tableView.setItems(qModel);
					System.out.println(element.getAttribute("StartByteHex"));
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
