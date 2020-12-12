package by.htp.task08.service.impl;

import by.htp.task08.dao.DaoException;
import by.htp.task08.dao.DaoProvider;
import by.htp.task08.dao.UserDao;
import by.htp.task08.dao.impl.FileUserDao;
import by.htp.task08.service.ServiceException;
import by.htp.task08.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String login, String password) throws ServiceException {
		boolean result;
		if (login == null || password == null || login.length() < 4 || password.length() < 5) {
			result = false;
		} else {
			DaoProvider provider = DaoProvider.getInstance();
			UserDao userDao = provider.getUserDao();
			try {
				result = userDao.authorization(login, password);
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
		}
		return result;
	}
}

	


