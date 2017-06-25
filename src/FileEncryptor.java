/**
 * This application takes in the path to a file supplied by the user
 * and the shift to be used in the encryption process. If the file is found
 * and is readable, the contents are read, shifted, and placed back in the file.
 * Otherwise, an error message is displayed.   
 * 
 * @author John Rock
 * @version 0.0
 * 
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileEncryptor extends Application {

	Label beforeFile;
	Label beforeShift;
	TextField file;
	TextField shift;
	
	File fileToEncode = null;
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		
		stage.setTitle("File Encryptor");
		
		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 300, 250);
		
		stage.setScene(scene);
		
		beforeFile = new Label("Enter path to file:       ");
		file = new TextField();
		file.setPrefColumnCount(15);
		file.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				fileToEncode = new File(file.getText());
				if(!fileToEncode.exists()){
					file.setText("Error: cannot connect.");
				}
			}
		});
		
		beforeShift = new Label("Enter shift for cipher: ");
		shift = new TextField();
		shift.setPrefColumnCount(15);
		
		root.getChildren().addAll(beforeFile, file, beforeShift, shift);
		
		stage.show();
		
	}
	

}
