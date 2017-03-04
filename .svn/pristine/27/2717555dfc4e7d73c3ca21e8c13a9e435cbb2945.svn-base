
package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import action.Back;
import action.Check;
import enums.FieldEnum;
import enums.PanelEnum;

/**
 * @author Phil Adriaan
 * 
 *         Panel to add new players.
 */	
public class AddPlyPanel extends PanelOutLine
{
  Map<FieldEnum, String> labels = new HashMap<FieldEnum, String>();
  Map<FieldEnum, JTextField> fields = new HashMap<FieldEnum, JTextField>();
  PanelEnum current_enum = PanelEnum.FORM;
  PanelOutLine current_panel;

  /**
   * Initiate the panel.
   */
  public AddPlyPanel()
  {
    // TODO Auto-generated constructor stub
    super.setUp();
    setLayout(new GridLayout(1, 1));
    labels.put(FieldEnum.FIRST_NAME, "First Name");
    labels.put(FieldEnum.LAST_NAME, "Last Name");
    labels.put(FieldEnum.POSITION, "Position");
    labels.put(FieldEnum.COLLEGE, "College");
    labels.put(FieldEnum.BIRTH_YEAR, "Birth Year");
    labels.put(FieldEnum.HEIGHT, "Height (m)");
    labels.put(FieldEnum.WEIGHT, "Weight (lbs)");
    labels.put(FieldEnum.NATIONALITY, "Nationality");
    labels.put(FieldEnum.ETHNICITY, "Ethnicity");
    labels.put(FieldEnum.AGENT_EMAIL, "Agent's E-mail");
    labels.put(FieldEnum.TEAM, "Team Signed");
    labels.put(FieldEnum.SALARY, "Salary");
    labels.put(FieldEnum.CONTRACT_EXPIRE, "Contract Expiration");
    for (FieldEnum i : FieldEnum.values())
    {
      fields.put(i, new JTextField(50));
    }
    current_panel = form();
    add(current_panel);
  }

  /**
   * Switches the panel.
   * 
   * @param the_enum Next panel.
   * @param message Error message.
   */
  public void switchPanel(PanelEnum the_enum, List<String> message)
  {
    remove(current_panel);
    switch (the_enum)
    {
      case FORM:
        current_panel = form();
        break;
      case FAIL:
        current_panel = fail(message);
        break;
      case SUCCESS:
        current_panel = success();
        break;
    }
    current_enum = the_enum;
    add(current_panel);
  }

  /**
   * Creates a panel containing a field.
   * 
   * @param field Field to be added.
   * @return Panel containing the field.
   */
  private PanelOutLine field(final FieldEnum field)
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.add(fields.get(field));
    return panel;
  }

  /**
   * 
   * @return Panel at top-right.
   */
  private PanelOutLine topRight()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new GridLayout(FieldEnum.values().length, 1));
    panel.add(field(FieldEnum.FIRST_NAME));
    panel.add(field(FieldEnum.LAST_NAME));
    panel.add(field(FieldEnum.POSITION));
    panel.add(field(FieldEnum.COLLEGE));
    panel.add(field(FieldEnum.BIRTH_YEAR));
    panel.add(field(FieldEnum.HEIGHT));
    panel.add(field(FieldEnum.WEIGHT));
    panel.add(field(FieldEnum.NATIONALITY));
    panel.add(field(FieldEnum.ETHNICITY));
    panel.add(field(FieldEnum.AGENT_EMAIL));
    panel.add(field(FieldEnum.TEAM));
    panel.add(field(FieldEnum.SALARY));
    panel.add(field(FieldEnum.CONTRACT_EXPIRE));
    return panel;
  }

  /**
   * 
   * @param field Type of field.
   * @return Label of that field.
   */
  private JLabel label(final FieldEnum field)
  {
    final JLabel label = new JLabel(labels.get(field));
    label.setHorizontalAlignment(SwingConstants.RIGHT);
    return label;
  }

  /**
   * 
   * @return Panel for top-left.
   */
  private PanelOutLine topLeft()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new GridLayout(FieldEnum.values().length, 1));
    panel.add(label(FieldEnum.FIRST_NAME));
    panel.add(label(FieldEnum.LAST_NAME));
    panel.add(label(FieldEnum.POSITION));
    panel.add(label(FieldEnum.COLLEGE));
    panel.add(label(FieldEnum.BIRTH_YEAR));
    panel.add(label(FieldEnum.HEIGHT));
    panel.add(label(FieldEnum.WEIGHT));
    panel.add(label(FieldEnum.NATIONALITY));
    panel.add(label(FieldEnum.ETHNICITY));
    panel.add(label(FieldEnum.AGENT_EMAIL));
    panel.add(label(FieldEnum.TEAM));
    panel.add(label(FieldEnum.SALARY));
    panel.add(label(FieldEnum.CONTRACT_EXPIRE));
    return panel;
  }

  /**
   * 
   * @return Top panel.
   */
  private PanelOutLine top()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new BorderLayout());
    panel.add(topLeft(), BorderLayout.WEST);
    panel.add(topRight(), BorderLayout.CENTER);
    return panel;
  }

  /**
   * 
   * @return Panel containing form.
   */
  private PanelOutLine form()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new BorderLayout());
    panel.add(top());
    panel.add(new JButton(new Check(this, labels, fields)), BorderLayout.SOUTH);
    return panel;
  }

  /**
   * 
   * @param message Error message.
   * @return Panel containing error message.
   */
  private PanelOutLine message(List<String> message)
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new GridLayout(message.size(), 1));
    for (String i : message)
    {
      JLabel label = new JLabel(i);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(label);
    }
    return panel;
  }

  /**
   * 
   * @param message Error message
   * @return Panel in case of failure.
   */
  private PanelOutLine fail(List<String> message)
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new BorderLayout());
    JLabel label = new JLabel("You Failed!");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label, BorderLayout.NORTH);
    panel.add(message(message));
    panel.add(new JButton(new Back(this)), BorderLayout.SOUTH);
    return panel;
  }

  /**
   * 
   * @return Panel when adding player is a success.
   */
  private PanelOutLine success()
  {
    final PanelOutLine panel = new PanelOutLine();
    panel.setUp();
    panel.setLayout(new BorderLayout());
    JLabel label = new JLabel("Player added...");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label);
    panel.add(new JButton(new Back(this)), BorderLayout.SOUTH);
    return panel;
  }
}
