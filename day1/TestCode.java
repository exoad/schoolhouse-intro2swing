package day1;

import javax.swing.*;
import java.awt.Dimension;

public class TestCode
{
  public static class MyWindow
      extends JFrame
  {
    public MyWindow()
    {
      super("Hello World!");
      setPreferredSize(new Dimension(400, 400));
      JLabel label_1 = new JLabel("Hi " + System.getProperty("user.name") + ", how are you?");
      add(label_1);
    }
  }

  public static void main(String... args)
  {
    SwingUtilities.invokeLater(() -> {
      MyWindow program = new MyWindow();
      program.pack();
      program.setLocationRelativeTo(null);
      program.setVisible(true);
    });
  }
}
