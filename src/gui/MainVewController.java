package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainVewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.print("OnMenuAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.print("OnMenuAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.print("OnMenuAction");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	

}
