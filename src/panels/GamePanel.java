package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.Controller;

/**
 * This class represents the search game tab. In general A user 
 * can select the two teams they want to compare and a list af 
 * all games played between the two clubs will appear in order 
 * of the year played. The user can click click the game they 
 * want to view and see the box score of that game.
 * 
 */
public class GamePanel extends PanelOutLine {

	private static final long serialVersionUID = 1L;
	private Object[] teams;
	private JComboBox teamOneBox;
	private JComboBox teamTwoBox;	
	private int prevBoxOneItem = 0;
	private int prevBoxTwoItem = 1;
	private JScrollPane pane;
    
	public GamePanel() {
		teams = Controller.getTeams();
		teamOneBox = new JComboBox(teams);
		teamTwoBox = new JComboBox(teams);
		//teamTwoBox.setSelectedIndex(1);
		setLayout(new BorderLayout());
		init();
		addActions();
	}

	private void init() {
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(2, 2));
		north.add(new JLabel("Home Team"));
		north.add(teamOneBox);

		north.add(new JLabel("Visiting Team"));
		north.add(teamTwoBox);

		pane = new JScrollPane();
		setTable();
		add(north, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);

	}
    JTable tbl;
    
    /*
     * Sets the current table view.
     */
	private void setTable() {
		
		try {
			  tbl = Controller.buildTable("SELECT home.date AS 'Season', " +
					 "home.gameid AS 'Game', " +
					 "Home.teamName AS 'Home', " +
					 "Visitor.teamName AS 'Visitor' " +
			   "FROM (SELECT `teamName`, `date`, gameID " +
					   "FROM team, game " + 
					   "WHERE team1id = teamid and teamName = '"+ String.valueOf(teamOneBox.getSelectedItem()) +"') Home, " + 
					"(SELECT `teamName`, `DATE`, gameID " + 
						"FROM team, game " + 
						"WHERE team2id = teamid AND teamName = '"+ String.valueOf(teamTwoBox.getSelectedItem()) +"') Visitor " +
			  "WHERE home.`gameID` = visitor.`gameID`  ");
			
			tbl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent event) {
					
				    int row = tbl.rowAtPoint(event.getPoint());
				    //int col = tbl.columnAtPoint(event.getPoint());
			
				    int gameID = Integer.valueOf((String) tbl.getValueAt(row, 1));
				    int year = Integer.valueOf((String) tbl.getValueAt(row, 0));
				    
				    try {
						tbl = Controller.buildTable("SELECT player.`firstName`, " + 
							"player.lastName, " +
							"blocks AS BLKS,  " +
							"steals AS STLS, " +
							"offRebounds AS OReb, " +
							"defRebounds AS DReb, " +
							"3PA, " +
							"ejections, " +
							"technicals AS TF, " +
							"minutes AS MIN, " +
							"turnovers AS TRNOVR, " +
							"flagrant AS FF, " +
							"FTA, FTM, FGA, FGM, 3PA, 3PM FROM " +  
							"(SELECT home.date AS 'Season', home.gameid AS 'Game', Home.teamName AS 'Home',  " +
							"Visitor.teamName AS 'Visitor' " +
							"FROM (SELECT `teamName`, `date`, gameID  " +
							"FROM team, game  " +
							"WHERE team1id = teamid AND teamName = '"  + String.valueOf(teamOneBox.getSelectedItem()) + "') Home, " + 
							"(SELECT `teamName`, `DATE`, gameID  " +
							"FROM team, game  " +
							"WHERE team2id = teamid AND teamName = '"  + String.valueOf(teamTwoBox.getSelectedItem()) + "') Visitor " +
							"WHERE home.`gameID` = visitor.`gameID`) games  " +
							"NATURAL JOIN boxscore NATURAL JOIN playsfor NATURAL JOIN player " +
							"WHERE game = '"+ gameID +"' AND boxscore.`gameID` = '"+ gameID +"' AND year = " + year + " ");
						pane.setViewportView(tbl);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			pane.setViewportView(tbl);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}



	private void addActions() {

		teamOneBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JComboBox jcmbType = (JComboBox) e.getSource();
				if (jcmbType.getSelectedIndex() == teamTwoBox
						.getSelectedIndex()) {
					teamOneBox.setSelectedIndex(prevBoxTwoItem);
					teamTwoBox.setSelectedIndex(prevBoxOneItem);
				}
				prevBoxOneItem = teamOneBox.getSelectedIndex();
				prevBoxTwoItem = teamTwoBox.getSelectedIndex();
				setTable();

			}
		});

		teamTwoBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JComboBox jcmbType = (JComboBox) e.getSource();
				if (jcmbType.getSelectedIndex() == teamOneBox
						.getSelectedIndex()) {
					teamTwoBox.setSelectedIndex(prevBoxOneItem);
					teamOneBox.setSelectedIndex(prevBoxTwoItem);
				}
				prevBoxOneItem = teamOneBox.getSelectedIndex();
				prevBoxTwoItem = teamTwoBox.getSelectedIndex();
				setTable();
			}
		});
	}
}
