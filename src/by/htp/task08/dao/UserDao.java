package by.htp.task08.dao;

public interface UserDao {

	boolean authorization(String login, String password) throws DaoException;

	boolean checkCredentials(String currentLine, String productSpecType, String productSpecValue);
}