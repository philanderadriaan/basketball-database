
package panels;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import controller.Controller;
import enums.StatEnum;

/**
 * @author Phil Adriaan
 * 
 *         Panel for showing stats.
 */
public class SearchStatPanel extends PanelOutLine
{
  /**
   * Current stat showing.
   */
  StatEnum stat = StatEnum.SCORING;
  /**
   * Current year.
   */
  int year = 2013;
  /**
   * Current pane for storing stats.
   */
  public JScrollPane current_pane = null;

  /**
   * Initiates the panel to show stats.
   */
  public SearchStatPanel()
  {
    super.setUp();
    setLayout(new BorderLayout());
    add(comboPanel(), BorderLayout.NORTH);
    current_pane = new JScrollPane(Controller.getStat(stat, year));
    add(current_pane);
  }

  /**
   * 
   * @return Combobox selecting stat category.
   */
  private JComboBox statCombo()
  {
    final String[] category =
        {"Scoring", "Rebounds", "Field Goals", "Free-Throws", "3-Points", "Assists", "Steals",
            "Blocks", "Fouls", "Minutes", "Turnovers"};
    final StatEnum[] stats =
        {StatEnum.SCORING, StatEnum.REBOUND, StatEnum.FIELD_GOAL, StatEnum.FREE_THROW,
            StatEnum.THREE_POINTER, StatEnum.ASSIST, StatEnum.STEAL, StatEnum.BLOCK,
            StatEnum.FOUL, StatEnum.MINUTE, StatEnum.TURNOVER};
    final JComboBox combo = new JComboBox();
    for (int i = 0; i < category.length; i++)
    {
      combo.addItem(category[i]);
    }
    combo.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        int n = 0;
        for (int i = 1; i < category.length; i++)
        {
          if (category[i].equals(e.getItem()))
          {
            n = i;
          }
        }
        stat = stats[n];
        current_pane.setViewportView(Controller.getStat(stat, year));
      }
    });
    return combo;
  }

  /**
   * 
   * @return Combo box selecting year.
   */
  private JComboBox yearCombo()
  {
    final JComboBox combo = new JComboBox();
    for (int i = 2013; i >= 1946; i--)
    {
      combo.addItem(i);
    }
    combo.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        year = (Integer) e.getItem();
        current_pane.setViewportView(Controller.getStat(stat, year));

      }
    });
    return combo;
  }

  /**
   * 
   * @return Panel for storing combo boxes.
   */
  private PanelOutLine comboPanel()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.add(new JLabel("Year"));
    panel.add(yearCombo());
    panel.add(new JLabel("Category"));
    panel.add(statCombo());
    return panel;
  }
}
