package by.htp.task08.service;

public interface UserService {

	boolean login(String login, String password) throws ServiceException;
}
