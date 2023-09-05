import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class Test
{

  public static void myFunction(String myString)
  {
    System.out.println(myString);
  }

  public interface AnonymousFunction
  {
    void fx(String string) {
      System.out.println(string);
    }
  }

  public interface OtherFunction
  {
    void viofdhbdhubdfhfiehfiufwh(String string);
  }

  public static void function2()
  {
    AnonymousFunction randomFunction = parameter1 -> System.out.print(parameter1);

    randomFunction.fx("Hello world");
  }

public static void main(String[] args) {
            UIDefaults defaults = UIManager.getDefaults();
            System.out.println(defaults.size()+ " properties defined !");
            String[ ] colName = {"Key", "Value"};
            String[ ][ ] rowData = new String[ defaults.size() ][ 2 ];
            int i = 0;
            for(Enumeration e = defaults.keys(); e.hasMoreElements(); i++){
                Object key = e.nextElement();
                rowData[ i ] [ 0 ] = key.toString();
                rowData[ i ] [ 1 ] = ""+defaults.get(key);
                System.out.println(rowData[i][0]+" ,, "+rowData[i][1]);
            }
            JFrame f = new JFrame("UIManager properties default values");
            JTable t = new JTable(rowData, colName);
            f.setContentPane(new JScrollPane(t));
            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }

}
