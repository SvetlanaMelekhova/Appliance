package by.htp.task08.service;

import java.util.List;

import by.htp.task08.entity.Appliance;

public interface ApplianceService {

	Appliance findProduct(String request) throws ServiceException;

	boolean addNewProduct(String request) throws ServiceException;
}
