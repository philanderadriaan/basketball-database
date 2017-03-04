
package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import panels.AddPlyPanel;
import enums.PanelEnum;

/**
 * @author Phil Adriaan
 * 
 *         Action to go back to form panel.
 */
public class Back extends AbstractAction
{
  /**
   * Panel for the action.
   */
  AddPlyPanel my_panel;

  /**
   * Initialize the action.
   */
  public Back(AddPlyPanel panel)
  {
    // TODO Auto-generated constructor stub
    super("Back");
    my_panel = panel;
  }

  @Override
  public void actionPerformed(ActionEvent arg0)
  {
    // TODO Auto-generated method stub
    my_panel.switchPanel(PanelEnum.FORM, null);
  }

}
