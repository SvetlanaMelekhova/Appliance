package by.htp.task08.main;

import by.htp.task08.controller.Controller;
import by.htp.task08.service.ApplianceService;
import by.htp.task08.service.ServiceException;
import by.htp.task08.service.ServiceProvider;
import by.htp.task08.service.UserService;
import by.htp.task08.view.View;

public class Main {

	public static void main(String[] args) throws ServiceException {
		String command;
		String response;
		Controller controller = new Controller();

		command = "login login=polk password=12345";
		response = controller.doAction(command);
		View.print(response);
		View.splitActions();

		command = "addProduct Oven : BRAND=ATLANT, PRICE=250, POWER_CONSUMPTION=6000, WEIGHT=13, CAPACITY=34, DEPTH=70, HEIGHT=50, WIDTH=80";
		response = controller.doAction(command);
		View.print(response);
		View.splitActions();

		command = "findProduct Speaker CORD_LENGTH=3";
		response = controller.doAction(command);
		View.print(response);
		View.splitActions();

		command = "findProduct Laptop BATTERY_CAPACITY=3";
		response = controller.doAction(command);
		View.print(response);
		View.splitActions();

	}
}
