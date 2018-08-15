package xyz.jeevan.consoledrawing.enums;

import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

  @Test
  public void shouldProvideQuitCommand() {
    String command = Command.QUIT.getCommandInput();
    Assert.assertEquals("Q", command);
  }

  @Test
  public void shouldProviceClearCommand() {
    String command = Command.CLEAR.getCommandInput();
    Assert.assertEquals("C", command);
  }
}
