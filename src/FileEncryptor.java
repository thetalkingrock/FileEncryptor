/**
 * This application takes in the path to a file supplied by the user
 * and the shift to be used in the encryption process. If the file is found
 * and is readable, the contents are read, shifted, and placed back in the file.
 * Otherwise, an error message is displayed. Characters not in 
 * the Latin alphabet are unaffected. The number entered for the shift
 * must be between 0 and 25.
 * 
 * @author John Rock
 * @version 1.0
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
	TextField fileName;
	TextField shift;
	Scanner connector;
	PrintWriter writer;
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
		fileName = new TextField();
		fileName.setPrefColumnCount(15);
		fileName.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				/*fileToEncode = new File(fileName.getText());
				if(!fileToEncode.exists()){
					fileName.setText("Error: cannot connect.");
					fileToEncode = null;
				}*/
			}
		});
		
		beforeShift = new Label("Enter shift for cipher: ");
		shift = new TextField();
		shift.setPrefColumnCount(15);
		shift.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent ae){
				
				fileToEncode = new File(fileName.getText());
				if(!fileToEncode.exists()){
					fileName.setText("Error: cannot connect.");
					fileToEncode = null;
				}
				
				if(fileToEncode == null){
					
					shift.setText("Enter name of file");
					return;
					
				}
				
				try{
					
					int shiftValue;
				
					shiftValue = Integer.parseInt(shift.getText().trim().toString());
					if(shiftValue < 0 || shiftValue > 25){
						
						shift.setText("Invalid number");
						return;
					}
					encode(shiftValue);
					
				}catch(NumberFormatException e){
					
					shift.setText("Enter a number");
					
				}
				
			}
			
		});
		
		root.getChildren().addAll(beforeFile, fileName, beforeShift, shift);
		
		stage.show();
		
	}
	
	public void encode(int shift){
			
		try{
			
			connector = new Scanner(fileToEncode);
			StringBuilder fileContents = new StringBuilder();
			
			while(connector.hasNextLine()){
				
				String line = connector.nextLine();
				
				for(char c : line.toCharArray())
				{
					if(c >= 97 && c <= 122)
					{
						if(c + shift > 122)
						{
							int diff = (c + shift) - 122;
							fileContents.append((char)(97 + diff - 1));
						}
						else
							fileContents.append((char)(c + shift));
					}
					else if(c >= 65 && c <= 90)
					{
						if(c + shift > 90)
						{
							int diff = (c + shift) - 90;
							fileContents.append((char)(65 + diff - 1));
						}
						else
							fileContents.append((char)(c + shift));	
					}
					else
					{
						fileContents.append(c);
					}
				}
				fileContents.append("\n");
			}
			
			writer = new PrintWriter(fileToEncode);
			
			writer.println(fileContents.toString());
			
			
			
			
		}catch(FileNotFoundException e){
			
			fileName.setText("Can't connect to file");
			
		}finally{
			connector.close();
			writer.close();
		}
		
		
	}

}
