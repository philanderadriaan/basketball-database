package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;

/**
 * Sets the panel for the user to search for a team. 
 * @author Justin Wong
 *
 */
@SuppressWarnings("serial")
public class SearchTMPanel extends PanelOutLine{
	
	private Object[] teams;
	
	private JComboBox teams_list;
	
	private JTable team_info;
	private JScrollPane team_infoScroll;
	
	private JTable arena_info;
	private JScrollPane arena_scrollPane;
	
	public SearchTMPanel(){
		
		team_info = new JTable();
		team_infoScroll = new JScrollPane();
		
		arena_info = new JTable();
		arena_scrollPane = new JScrollPane();
		setPanel();
		
		teams_list.setBounds(this.getHeight()/2, this.getHeight()/2, 200, 30);
	
		this.add(teams_list);
		this.add(team_infoScroll);
		this.add(arena_scrollPane);
		
	}
	/**
	 * Sets up the layout of the panel. 
	 */
	private void setPanel(){
		this.setLayout(null);
		
		teams = Controller.getTeams();
		Arrays.sort(teams);
		
		teams_list = new JComboBox(teams);
		teams_list.setSelectedItem(null);
		
		teams_list.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectTeam();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	}
	/**
	 * This method displays all the JTables on the Search Team panel. 
	 * @throws SQLException
	 * @throws IOException
	 */
	private void selectTeam() throws SQLException, IOException{
		String team_selected = (String) teams_list.getSelectedItem();
		
		team_info = Controller.searchTeam(team_selected);
		arena_info = Controller.searchArena(team_selected);
		
		team_infoScroll.setViewportView(team_info);
		arena_scrollPane.setViewportView(arena_info);
		
		team_infoScroll.setBounds(5, 100, team_info.getColumnCount()*125, (team_info.getRowCount() + 1)*18);
		arena_scrollPane.setBounds(5, 125 + team_infoScroll.getHeight(), arena_info.getColumnCount()*150
				, (arena_info.getRowCount() + 1)*18);
	}

}
