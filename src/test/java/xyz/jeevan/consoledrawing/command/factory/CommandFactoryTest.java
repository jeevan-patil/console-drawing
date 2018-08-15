package xyz.jeevan.consoledrawing.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import xyz.jeevan.consoledrawing.command.Command;
import xyz.jeevan.consoledrawing.command.DrawCommand;
import xyz.jeevan.consoledrawing.command.QuitCommand;

public class CommandFactoryTest {

  @Test
  public void shouldProvideDrawCommand() {
    final String commandInput = "C 20 4";
    Command command = CommandFactory.getCommand(commandInput);

    assertNotNull(command);
    assertTrue(command instanceof DrawCommand);
  }

  @Test
  public void shouldProvideQuitCommand() {
    final String commandInput = "Q";
    Command command = CommandFactory.getCommand(commandInput);

    assertTrue(command instanceof QuitCommand);
  }

}
