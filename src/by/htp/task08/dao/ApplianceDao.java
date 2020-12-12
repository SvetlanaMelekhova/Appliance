package by.htp.task08.dao;

import by.htp.task08.entity.Appliance;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ApplianceDao {

	List<String> findProduct(String productName, String productSpecType, String productSpecValue) throws DaoException;

	boolean addProductToFile(String request) throws DaoException, IOException;
}