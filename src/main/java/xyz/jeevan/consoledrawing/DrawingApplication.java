package xyz.jeevan.consoledrawing;

import java.util.Scanner;
import xyz.jeevan.consoledrawing.command.Command;
import xyz.jeevan.consoledrawing.command.factory.CommandFactory;
import xyz.jeevan.consoledrawing.drawable.Canvas;

public class DrawingApplication {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Canvas canvas = null;

    while (true) {
      System.out.print("Enter command -> ");
      Command command = CommandFactory.getCommand(scanner.nextLine());
      canvas = command.execute(canvas);
      System.out.println();
    }
  }

}
