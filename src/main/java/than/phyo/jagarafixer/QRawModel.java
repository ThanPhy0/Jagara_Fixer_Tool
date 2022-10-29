package than.phyo.jagarafixer;

import javafx.beans.property.StringProperty;

public class QRawModel {
	private String fileName;
	private String label;
	private String  sizeKB;
	private String  startByte;
	private String  startSec;

	public QRawModel(String fileName, String label, String sizeKB, String startByte, String startSec) {
		super();
		this.fileName = fileName;
		this.label = label;
		this.sizeKB = sizeKB;
		this.startByte = startByte;
		this.startSec = startSec;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSizeKB() {
		return sizeKB;
	}

	public void setSizeKB(String  sizeKB) {
		this.sizeKB = sizeKB;
	}

	public String getStartByte() {
		return startByte;
	}

	public void setStartByte(String  startByte) {
		this.startByte = startByte;
	}

	public String getStartSec() {
		return startSec;
	}

	public void setStartSec(String  startSec) {
		this.startSec = startSec;
	}

}