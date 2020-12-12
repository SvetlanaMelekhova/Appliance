package by.htp.task08.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.task08.dao.ApplianceDao;
import by.htp.task08.dao.DaoException;
import by.htp.task08.entity.Appliance;

public class FileApplianceDao implements ApplianceDao {

	private static final String RESOURCES_DB_TXT = "/resources/db.txt";
	private static final String USER_TXT = "user.txt";
	private static final String WHITESPACES = "\\s+";
	private static final String EQUAL_SIGN = "=";

	@Override
	public List <String> findProduct(String productName,  String productType , String productValue) throws DaoException {
		String product = "";
		List<String> products = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty(USER_TXT) + RESOURCES_DB_TXT))) {
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.contains(productName) && checkData(currentLine, productType, productValue)) {
					product=currentLine;
					products.add(product);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			throw new DaoException("Please check filename and path.", e);
		} catch (IOException e) {
			throw new DaoException("Please check file.", e);
		}
		return products;
	}

	@Override
	public boolean addProductToFile(String request) throws DaoException {
		int linesBefore = 0;
		int linesAfter = 0;
		if (!isProductExist(request)) {
			String newProduct = request.split(WHITESPACES, 2)[1];
			linesBefore = countLines();
			saveToFile(newProduct);
			linesAfter = countLines();
		}
		return linesAfter > linesBefore;
	}

	private boolean checkData(String currentLine, String productSpecType, String productSpecValue) {
		String[] step = currentLine.split(WHITESPACES);
		Map<String, String> map = new HashMap<>();
		for (String str : step) {
			String[] result = str.split(EQUAL_SIGN);
			map.put(result[0], result[1]);
		}
		return map.get(productSpecType).equals(productSpecValue);
	}

	private boolean isProductExist(String request) throws DaoException {
		boolean flag = true;
		String params = request.split(WHITESPACES, 2)[1];
		String productName = params.split(WHITESPACES)[0].trim();
		String[] step = params.split(WHITESPACES);
		for (String str : step) {
			String[] result = str.split(EQUAL_SIGN);
			if (findProduct(productName, result[0], result[1]).isEmpty()) {
				flag = false;
			}
		}
		return flag;
	}

	private void saveToFile(String newProduct) throws DaoException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESOURCES_DB_TXT, true))) {
			writer.append(newProduct);
		} catch (FileNotFoundException e) {
			throw new DaoException("Файл не найден.", e);
		} catch (IOException e) {
			throw new DaoException("Проверьте файл.", e);
		}
	}

	private int countLines() throws DaoException {
		int lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(RESOURCES_DB_TXT))) {
			while (reader.readLine() != null) {
				lines++;
			}
		} catch (FileNotFoundException e) {
			throw new DaoException("Файл не найден.", e);
		} catch (IOException e) {
			throw new DaoException("Проверьте файл.", e);
		}
		return lines;
	}
}