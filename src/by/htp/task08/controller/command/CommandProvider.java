package by.htp.task08.controller.command;
import by.htp.task08.controller.command.implement.AddNewProductCommand;
import by.htp.task08.controller.command.implement.FindProductCommand;
import by.htp.task08.controller.command.implement.LoginCommand;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("login", new LoginCommand());
        commands.put("findProduct", new FindProductCommand());
        commands.put("addProduct", new AddNewProductCommand());
    }

    public Command takeCommand(String commandName) {
        return commands.get(commandName);
    }
}