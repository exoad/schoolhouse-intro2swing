package day2;

import javax.swing.*;
import java.awt.*;

public class SwingTesting
{
  public static class MyComponent
      extends JFrame
      implements
      Runnable
  {
    public MyComponent()
    {
      super("Testing Swing");
      setPreferredSize(new Dimension(400, 530));
      JPanel pane = new JPanel();
      pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
      pane.setPreferredSize(getPreferredSize());
      pane.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
      setContentPane(pane);

      // start putting your components here

    }

    @Override public void run()
    {
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
  }

  public static void main(String... args)
  {
    SwingUtilities.invokeLater(new MyComponent());
  }
}
