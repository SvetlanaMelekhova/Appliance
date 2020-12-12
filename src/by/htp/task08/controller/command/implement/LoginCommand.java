package by.htp.task08.controller.command.implement;

import by.htp.task08.controller.command.Command;
import by.htp.task08.service.ServiceException;
import by.htp.task08.service.ServiceProvider;
import by.htp.task08.service.UserService;

public class LoginCommand implements Command {

    private static final String WHITESPACES = "\\s+";
    private static final String EQUAL_SIGN = "=";

    @Override
    public String execute(String request) throws ServiceException {
        String[] params = request.split(WHITESPACES);
        String login = params[1].split(EQUAL_SIGN)[1];
        String password = params[2].split(EQUAL_SIGN)[1];
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        boolean result = userService.login(login, password);

        return result ? "Login successful." : "Please check username or password.";
    }
}
