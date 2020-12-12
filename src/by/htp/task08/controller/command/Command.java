package by.htp.task08.controller.command;

import by.htp.task08.service.ServiceException;

public interface Command {

    String execute(String request) throws ServiceException;
}
