import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import panels.AddPlyPanel;
import panels.GamePanel;
import panels.SearchPlyPanel;
import panels.SearchStatPanel;
import panels.SearchTMPanel;

/**
 * 
 * @author Phil Adriaan
 * @author Justin Wong
 * @author Derrick Minker
 * 
 *         Main class starts the program.
 */
public class Main
{
  /**
   * Starts the program.
   * 
   * @param args Command line arguments.
   */
  public static void main(final String[] args)
  {
    start();
  }

  /**
   * Start the UI.
   */
  public static void start()
  {
    final JFrame frame = new JFrame();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);

    final GamePanel gamepanel = new GamePanel();
    SearchPlyPanel searchPly = new SearchPlyPanel();
    final SearchTMPanel searchTM = new SearchTMPanel();
    final SearchStatPanel searchStat = new SearchStatPanel();
    final AddPlyPanel addPly = new AddPlyPanel();

    final JTabbedPane tab = new JTabbedPane();
    tab.setBackground(Color.white);

    tab.add(searchPly, "Search Player");
    tab.add(searchTM, "Search Team");
    tab.add(gamepanel, "Search Game");
    tab.add(searchStat, "Search Statistics");
    tab.add(addPly, "Add Player");

    frame.add(tab);
    frame.setSize(900, 500);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}