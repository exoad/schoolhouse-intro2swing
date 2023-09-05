package day2.tasks;

import javax.swing.*;
import java.awt.*;

public class Task1
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
      JLabel myColoredLabel = new JLabel("#3d03fc");
      myColoredLabel.setForeground(new Color(61, 3, 252));
      add(myColoredLabel);
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
