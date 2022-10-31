package than.phyo.jagarafixer.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import than.phyo.jagarafixer.model.QRawModel;
import than.phyo.jagarafixer.service.Qualcomm;

public class UIController implements Initializable {
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
	
	@FXML
	private TextArea textArea;

	@FXML
	private TextField firmwarePath;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		partitionName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("label"));
		fileName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("fileName"));
		startBye.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("startByte"));
		startSector.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("startSec"));
		fileSize.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("sizeKB"));

//		Qualcomm.rawproRead(tableView);
//		tableView.getItems().add(new QRawModel(partitionName.setCellValueFactory(new PropertyValueFactory<QRawModel, String>("partitionName"))));
//		rawproRead();
	}
	
	public void fileChoose() {
		Qualcomm.fileChoose(firmwarePath);
		Qualcomm.rawproRead(tableView);
		textArea.setText("Hello Hello Hello Hello");
	}
}
