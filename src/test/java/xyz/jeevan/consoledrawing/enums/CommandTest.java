package xyz.jeevan.consoledrawing.enums;

import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

  @Test
  public void shouldProvideCorrectCommand() {
    String command = Command.QUIT.getCommandInput();
    Assert.assertEquals("Q", command);
  }

}
