package xyz.jeevan.consoledrawing.command.factory;

import xyz.jeevan.consoledrawing.command.ClearCommand;
import xyz.jeevan.consoledrawing.command.DrawCommand;
import xyz.jeevan.consoledrawing.command.QuitCommand;
import xyz.jeevan.consoledrawing.enums.Command;

public class CommandFactory {

  private CommandFactory() {
  }

  public static xyz.jeevan.consoledrawing.command.Command getCommand(final String input) {
    if (input == null) {
      throw new IllegalArgumentException("Command can not be null");
    }

    if (Command.QUIT.getCommandInput().equalsIgnoreCase(input)) {
      return new QuitCommand();
    } else if (input.toUpperCase().startsWith(Command.CLEAR.getCommandInput())) {
      if (input.trim().length() == 1) {
        return new ClearCommand();
      }
    }

    return new DrawCommand(input);
  }
}
