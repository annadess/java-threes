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

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that can save information to a file and load it back into memory.
 * Usually used in combination with {@code JsonManager} class to save an object to a save file
 * and to load a save file back to create the object stored in it.
 * 
 * @author annadess
 */
public class PersistencyManager {

	private static final Logger logger = LoggerFactory.getLogger(PersistencyManager.class);
	
	/**
	 * The default directory for saving files.
	 */
	public static final File saveFolder = new File(
			new StringBuilder().append(System.getProperty("user.home")).append("/saves").toString());

	/**
	 * Returns the first line from the passed input file.
	 * The intent of this is to read a JSON file and return the information.
	 * 
	 * @param inputFile the file that will be read from
	 * @return the first line from the passed input file
	 */
	public static String openFromFile(File inputFile) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));) {
			return reader.readLine();
		} catch (FileNotFoundException e) {
			logger.debug("File user tried to load can't be found.");
			logger.debug(ExceptionUtils.getStackTrace(e));
			return null;
		} catch (IOException e) {
			logger.debug("File user tried to load couldn't be loaded.");
			logger.debug(ExceptionUtils.getStackTrace(e));
			return null;
		}
	}

	/**
	 * Saves the passed text into the output file specified.
	 * The intent of this is to write a JSON syntax to a file.
	 * 
	 * @param outputFile the file specified to save the text to
	 * @param outputInfo the text specified to save it
	 */
	public static void saveToFile(File outputFile, String outputInfo) {
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));) {
			writer.write(outputInfo);
		} catch (IOException e) {
			logger.debug("File user tried to save couldn't be written.");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	/**
	 * This method will create the default save directory if it doesn't exist already.
	 */
	public static void createSaveDir() {
		if(!saveFolder.exists()){
			logger.info("The save folder has been created.");
		}
		saveFolder.mkdir();
	}

	/**
	 * Returns the *.json files in the default save directory.
	 * @return the *.json files in the default save directory
	 */
	public static List<File> getAllSaveFiles() {
		return Arrays.asList(saveFolder.listFiles()).stream().filter(t -> t.toString().endsWith(".json"))
				.collect(Collectors.toList());
	}
}
