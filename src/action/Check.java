
package action;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.JTextField;

import panels.AddPlyPanel;
import controller.Controller;
import enums.FieldEnum;
import enums.PanelEnum;

/**
 * @author Phil Adriaan
 * 
 *         Action to check for errors in forms.
 */
public class Check extends AbstractAction
{
  /**
   * Panel holding the form.
   */
  AddPlyPanel my_panel;
  /**
   * Labels for fields.
   */
  Map<FieldEnum, String> my_labels;
  /**
   * Fields input by user.
   */
  Map<FieldEnum, JTextField> my_fields;
  /**
   * Error messages.
   */
  List<String> message = new ArrayList<String>();

  /**
   * Initiates the action.
   * 
   * @param panel Panel holding the form.
   * @param labels Labels for fields.
   * @param fields Input by user.
   */
  public Check(AddPlyPanel panel, Map<FieldEnum, String> labels,
               Map<FieldEnum, JTextField> fields)
  {
    // TODO Auto-generated constructor stub
    super("Add");
    my_panel = panel;
    my_labels = labels;
    my_fields = fields;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    // Check for empty fields
    for (FieldEnum i : FieldEnum.values())
    {
      if (my_fields.get(i).getText().isEmpty())
      {
        message.add(my_labels.get(i) + " field cannot be empty!");
      }
    }

    // Check for numerical errors
    List<FieldEnum> potential_numbers = new ArrayList<FieldEnum>();
    potential_numbers.add(FieldEnum.BIRTH_YEAR);
    potential_numbers.add(FieldEnum.WEIGHT);
    potential_numbers.add(FieldEnum.SALARY);
    potential_numbers.add(FieldEnum.CONTRACT_EXPIRE);
    for (FieldEnum i : potential_numbers)
    {
      try
      {
        Integer.parseInt(my_fields.get(i).getText());
      }
      catch (NumberFormatException exception)
      {
        message.add(my_labels.get(i) + " field must be a number!");
      }
    }

    // Check for invalid teams
    JTable table = null;
    try
    {
      table = Controller.buildTable("select teamName, teamID from team");
    }
    catch (SQLException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    catch (IOException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    boolean found = false;
    int team_id = 0;
    for (int i = 0; i < table.getRowCount(); i++)
    {
      if (my_fields.get(FieldEnum.TEAM).getText().toLowerCase()
          .contains(((String) table.getValueAt(i, 0)).toLowerCase()))
      {
        found = true;
        team_id = Integer.valueOf((String) table.getValueAt(i, 1));
        break;
      }
    }
    if (!found)
    {
      message.add(my_labels.get(FieldEnum.TEAM) + " field don't have valid team name!");
    }

    if (!my_fields.get(FieldEnum.AGENT_EMAIL).getText().toLowerCase().contains("@"))
    {
      message.add(my_labels.get(FieldEnum.TEAM) + " field don't have valid email address!");
    }

    if (message.isEmpty())
    {
      Controller.addPlayer(my_fields, team_id);
      for (FieldEnum i : FieldEnum.values())
      {
        my_fields.get(i).setText("");
      }
      my_panel.switchPanel(PanelEnum.SUCCESS, null);
    }
    else
    {
      my_panel.switchPanel(PanelEnum.FAIL, message);
    }
  }
}
