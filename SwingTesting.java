
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.LayerUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class SwingTesting
{
  public static class BlurFilter extends LayerUI< Component >
  {
    private BufferedImageOp blurImageOperation;

    static final int BLUR_FACTOR = 25;

    public BlurFilter()
    {
      float[] matrix = new float[BLUR_FACTOR * BLUR_FACTOR];
      float blurFractional = 1F / (BLUR_FACTOR * BLUR_FACTOR);
      for (int i = 0; i < BLUR_FACTOR * BLUR_FACTOR; i++)
        matrix[i] = blurFractional;
      blurImageOperation = new ConvolveOp(new Kernel(BLUR_FACTOR, BLUR_FACTOR, matrix));
    }

    @Override public void paint(Graphics g, JComponent under)
    {
      if(under.getWidth() == 0 || under.getHeight() == 0)
        return;
      BufferedImage result = new BufferedImage(under.getWidth(), under.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = result.createGraphics();
      g2.setClip(g.getClip());
      super.paint(g2, under);
      g2.dispose();
      Graphics2D g22 = (Graphics2D) g;
      g22.drawImage(result, blurImageOperation, 0, 0);
      g22.dispose();
      g.dispose();
    }
  }

  public static class MyCanvas
      extends JPanel
  {
    Image scaledImage;

    public MyCanvas()
    {
      BufferedImage waterMelonImage = null;
      try
      {
        waterMelonImage = ImageIO.read(new File("./watermelon.jpg"));
      } catch (IOException e)
      {
        e.printStackTrace();
      }

      scaledImage = waterMelonImage.getScaledInstance(1920, 1080, Image.SCALE_REPLICATE);
    }

    @Override public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(scaledImage, 0, 0, null);
      g2.dispose();
    }
  }

  public static class MyComponent
      extends JFrame
      implements
      Runnable
  {
    public MyComponent()
    {
      super("Testing Swing");
      setPreferredSize(new Dimension(1920, 1080));

      JLayer<Component> blurredImage = new JLayer<>(new MyCanvas(), new BlurFilter());
      add(blurredImage);
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
    SchoolhouseTheme.setup();
    SwingUtilities.invokeLater(new MyComponent());
  }
}