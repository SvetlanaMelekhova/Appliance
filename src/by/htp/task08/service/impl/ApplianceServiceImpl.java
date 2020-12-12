package by.htp.task08.service.impl;

import java.io.IOException;
import java.util.List;

import by.htp.task08.dao.ApplianceDao;
import by.htp.task08.dao.DaoException;
import by.htp.task08.dao.DaoProvider;
import by.htp.task08.entity.Appliance;
import by.htp.task08.entity.electronic.portable.Laptop;
import by.htp.task08.entity.electronic.portable.TabletPC;
import by.htp.task08.entity.technic.cleaning.VacuumCleaner;
import by.htp.task08.entity.technic.kitchen.Oven;
import by.htp.task08.entity.technic.kitchen.Refrigerator;
import by.htp.task08.entity.technic.sound.Range;
import by.htp.task08.entity.technic.sound.Speaker;
import by.htp.task08.service.ApplianceService;
import by.htp.task08.service.ServiceException;

public class ApplianceServiceImpl implements ApplianceService {

	private static final String WHITESPACES = "\\s+";
	private static final String EQUAL_SIGN = "=";
	private static final String HYPHEN = "-";

	@Override
	public Appliance findProduct(String request) throws ServiceException {
		String[] params = request.split(WHITESPACES);
		String productName = params[1];
		String productSpecType = params[2].split(EQUAL_SIGN)[0];
		String productSpecValue = params[2].split(EQUAL_SIGN)[1];

		DaoProvider provider = DaoProvider.getInstance();
		ApplianceDao applianceDao = provider.getApplianceDao();
		List<String> data;
		try {
			data = applianceDao.findProduct(productName, productSpecType, productSpecValue);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		Appliance appliance = null;
		switch (productName) {
			case "Oven":
				appliance = new Oven(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)), Double.parseDouble(data.get(6)), Double.parseDouble(data.get(7)));
				break;
			case "Refrigerator":
				appliance = new Refrigerator(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4)), Double.parseDouble(data.get(5)), Integer.parseInt(data.get(6)), Integer.parseInt(data.get(7)));
				break;
			case "VacuumCleaner":
				appliance = new VacuumCleaner(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), data.get(3).charAt(0), data.get(4), data.get(5), Integer.parseInt(data.get(6)), Integer.parseInt(data.get(7)));
				break;
			case "Speaker":
				appliance = new Speaker(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), getRange(data), Integer.parseInt(data.get(5)));
				break;
			case "Laptop":
				appliance = new Laptop(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), data.get(3), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)), Double.parseDouble(data.get(6)), Double.parseDouble(data.get(7)));
				break;
			case "TabletPC":
				appliance = new TabletPC(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Double.parseDouble(data.get(3)), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)), data.get(6));
				break;
			default:
				break;
		}
		return appliance;
	}

	@Override
	public boolean addNewProduct(String request) throws ServiceException {
		DaoProvider provider = DaoProvider.getInstance();
		ApplianceDao applianceDao = provider.getApplianceDao();
		boolean result;
		try {
			result = applianceDao.addProductToFile(request);
		} catch (DaoException | IOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	private Range getRange(List<String> data) {
		String[] r = data.get(4).split(HYPHEN);
		return new Range(Double.parseDouble(r[0]), Double.parseDouble(r[1]));
	}
}