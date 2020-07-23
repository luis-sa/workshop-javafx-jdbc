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
		/*A inserção da expressão "synchronized foi feita para impedir que haja qualquer interrupção 
		 * quando da execução do código de loadView abaixo."*/
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load(); //É um VBox pois estou trabalhando todo meu programa em VBox
			
			Scene mainScene = Main.getMainScene(); //Referencio dentro do meu método a cena da página principal
			
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); //Estou pegando informações da cena principal, mantendo a existência do menu em todas as páginas que possa abrir
			
			Node mainMenu = mainVBox.getChildren().get(0); /*O código anterior cria a vaiável mainBox, em que eu eu peguei tudo que existia dentro da VBox, que está dentro do Scroll Pane na MainView. Os
			nomes (VBox) e (Scroll Pane direciona meu código para pegar o que eu quero. getChildren permite que eu escolha todos os filhos presentes no VBox que estou pegando. o get(0) faz com que
			eu pegue somente o primeiro filho declarado na VBox, que é o menu.*/
			mainVBox.getChildren().clear(); /*Após pegar somente o menu, apago tudo que existia dentro do menu, todos os filhos que estavam ali dentro do menu.*/
			mainVBox.getChildren().add(mainMenu); /*dentro do meu VBox que criei pegando o VBox da Main view, eu coloco o menu que tratei acima (eliminando todos os filhos)*/
			mainVBox.getChildren().addAll(newVBox.getChildren()); /*Insiro dentro do mainBox que crirei todos os filhos do VBox que peguei. Assim, eu garanto que sempre que 
			abrir uma nova tela, os filhos do meu menu se mantenham. Ou seja, sempre que abrir uma tela eu fico com os links de direcionamento intactos.*/
			
					
		}
		catch (IOException e) {
			Alerts.showAlert("IOException", "Error Loadind View", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
	

}
