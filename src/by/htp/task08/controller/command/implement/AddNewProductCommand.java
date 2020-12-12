package by.htp.task08.controller.command.implement;

import by.htp.task08.controller.command.Command;
import by.htp.task08.service.ApplianceService;
import by.htp.task08.service.ServiceException;
import by.htp.task08.service.ServiceProvider;

public class AddNewProductCommand implements Command {

    @Override
    public String execute(String request) throws ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        ApplianceService applianceService = provider.getApplianceService();
        boolean result = applianceService.addNewProduct(request);
        return result ?  "Прибор был успешно добавлен." : "Данный прибор уже есть в базе.";
    }
}