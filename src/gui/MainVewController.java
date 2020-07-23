package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

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
		loadView("/gui/DepartmentListVBox.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/AboutView.fxml");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized void loadView(String absoluteName) {
		/*A inser��o da express�o "synchronized foi feita para impedir que haja qualquer interrup��o 
		 * quando da execu��o do c�digo de loadView abaixo."*/
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load(); //� um VBox pois estou trabalhando todo meu programa em VBox
			
			Scene mainScene = Main.getMainScene(); //Referencio dentro do meu m�todo a cena da p�gina principal
			
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); //Estou pegando informa��es da cena principal, mantendo a exist�ncia do menu em todas as p�ginas que possa abrir
			
			Node mainMenu = mainVBox.getChildren().get(0); /*O c�digo anterior cria a vai�vel mainBox, em que eu eu peguei tudo que existia dentro da VBox, que est� dentro do Scroll Pane na MainView. Os
			nomes (VBox) e (Scroll Pane direciona meu c�digo para pegar o que eu quero. getChildren permite que eu escolha todos os filhos presentes no VBox que estou pegando. o get(0) faz com que
			eu pegue somente o primeiro filho declarado na VBox, que � o menu.*/
			mainVBox.getChildren().clear(); /*Ap�s pegar somente o menu, apago tudo que existia dentro do menu, todos os filhos que estavam ali dentro do menu.*/
			mainVBox.getChildren().add(mainMenu); /*dentro do meu VBox que criei pegando o VBox da Main view, eu coloco o menu que tratei acima (eliminando todos os filhos)*/
			mainVBox.getChildren().addAll(newVBox.getChildren()); /*Insiro dentro do mainBox que crirei todos os filhos do VBox que peguei. Assim, eu garanto que sempre que 
			abrir uma nova tela, os filhos do meu menu se mantenham. Ou seja, sempre que abrir uma tela eu fico com os links de direcionamento intactos.*/
			
					
		}
		catch (IOException e) {
			Alerts.showAlert("IOException", "Error Loadind View", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
	

}
