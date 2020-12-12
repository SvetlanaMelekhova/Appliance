package by.htp.task08.controller.command.implement;
import by.htp.task08.controller.command.Command;
import by.htp.task08.entity.Appliance;
import by.htp.task08.service.ApplianceService;
import by.htp.task08.service.ServiceException;
import by.htp.task08.service.ServiceProvider;

public class FindProductCommand implements Command {

    @Override
    public String execute(String request) throws ServiceException {
        ServiceProvider provider = ServiceProvider.getInstance();
        ApplianceService applianceService = provider.getApplianceService();
        Appliance product = applianceService.findProduct(request);
        String productRepresentation = product.toString();
        return !productRepresentation.isEmpty() ? productRepresentation : "Прибор не был найден.";
    }
}