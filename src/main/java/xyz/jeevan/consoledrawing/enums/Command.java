package xyz.jeevan.consoledrawing.enums;

public enum Command {
  QUIT("Q"), CLEAR("C");

  private final String commandInput;

  Command(final String commandInput) {
    this.commandInput = commandInput;
  }

  public String getCommandInput() {
    return this.commandInput;
  }
}
