package by.htp.task08.dao;

import by.htp.task08.dao.impl.FileApplianceDao;
import by.htp.task08.dao.impl.FileUserDao;

public class DaoProvider {

	private static final DaoProvider INSTANCE = new DaoProvider();
	private final UserDao userDao = new FileUserDao();
	private final ApplianceDao applianceDao = new FileApplianceDao();

	private DaoProvider() { }

	public static DaoProvider getInstance() {
		return INSTANCE;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public ApplianceDao getApplianceDao() {
		return applianceDao;
	}

}
