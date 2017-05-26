package annadess.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersistencyManager {
	
	public static final File saveFolder = new File(new StringBuilder().append(System.getProperty("user.home")).append("/saves").toString());
	
	public static String openFromFile(File inputFile){
		String returnString = null;
		try (BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),"UTF-8"));) {
			returnString = reader.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnString;
	}
	
	public static void saveToFile(File outputFile, String outputInfo){
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF-8"));) {
			writer.write(outputInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createSaveDir(){
		saveFolder.mkdir();
	}
	
	public static List<File> getAllSaveFiles(){
		return Arrays.asList(saveFolder.listFiles()).stream().filter(t-> t.toString().endsWith(".json")).collect(Collectors.toList());
	}
}
