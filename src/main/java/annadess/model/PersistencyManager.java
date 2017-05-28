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

public class PersistencyManager {

	private static final Logger logger = LoggerFactory.getLogger(PersistencyManager.class);
	public static final File saveFolder = new File(
			new StringBuilder().append(System.getProperty("user.home")).append("/saves").toString());

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

	public static void saveToFile(File outputFile, String outputInfo) {
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));) {
			writer.write(outputInfo);
		} catch (IOException e) {
			logger.debug("File user tried to save couldn't be written.");
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	public static void createSaveDir() {
		saveFolder.mkdir();
	}

	public static List<File> getAllSaveFiles() {
		return Arrays.asList(saveFolder.listFiles()).stream().filter(t -> t.toString().endsWith(".json"))
				.collect(Collectors.toList());
	}
}
