package b;

import java.util.List;

public class ResponseDetails {
	private String ststusCode;
	private String status;
	private String message;
	private List<Employee> data;
	private Employee singleData;

	public ResponseDetails() {
		super();
	}

	public Employee getSingleData() {
		return singleData;
	}

	public void setSingleData(Employee singleData) {
		this.singleData = singleData;
	}

	public ResponseDetails(String ststusCode, String status, String message, Employee data) {
		super();
		this.ststusCode = ststusCode;
		this.status = status;
		this.message = message;
		this.singleData = data;
	}

	public ResponseDetails(String ststusCode, String status, String message, List<Employee> data) {
		super();
		this.ststusCode = ststusCode;
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStstusCode() {
		return ststusCode;
	}

	public void setStstusCode(String ststusCode) {
		this.ststusCode = ststusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

}