package by.htp.task08.controller;

import by.htp.task08.controller.command.Command;
import by.htp.task08.controller.command.CommandProvider;
import by.htp.task08.service.ServiceException;

public class Controller {

	private static final String WHITESPACES = "\\s+";

	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) throws ServiceException {
		String commandName = request.split(WHITESPACES, 2)[0];
		Command command = provider.takeCommand(commandName);
		return command.execute(request);
	}
}