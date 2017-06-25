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

	public static void main(String[] args) {
		
		launch(args);
	}
	
	public void start(Stage stage){
		
		stage.setTitle("File Encryptor");
		
		FlowPane root = new FlowPane();
		
		Scene scene = new Scene(root, 400, 400);
		
		stage.setScene(scene);
		
		stage.show();
		
	}
	

}
