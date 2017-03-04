package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Controller;
/**
 * This class builds the Search Player panel. 
 * @author Justin Wong
 *
 */
@SuppressWarnings("serial")
public class SearchPlyPanel extends PanelOutLine{
	
	private JTextField LNtext;
	private JTextField FNtext;
	private JLabel LNLabel;
	private JLabel FNLabel;
	private JButton search;
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private JTable stat_table;
	private JScrollPane stat_scrollPane;
	
	private JTable contract_table;
	private JScrollPane contract_scrollPane;
	
	private JTable manager_table;
	private JScrollPane manager_scrollPane;
	
	
	public SearchPlyPanel(){
		
		this.setLayout(null);
		
	    LNtext = new JTextField();
	    FNtext = new JTextField();
	
		LNLabel = new JLabel("Last Name");
		FNLabel = new JLabel("First Name");
		
		table = new JTable();
		scrollPane = new JScrollPane();
		
		stat_table = new JTable();
		stat_scrollPane = new JScrollPane();
		
		contract_table = new JTable();
		contract_scrollPane = new JScrollPane();
		
		manager_table = new JTable();
		manager_scrollPane = new JScrollPane();
		
		search = new JButton("Search");
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try {
					retrievePly();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		setLayout();
		
		this.add(LNLabel);
		this.add(LNtext);
		this.add(FNtext);
		this.add(FNLabel);
		this.add(search);
		this.add(scrollPane);
		this.add(stat_scrollPane);
		this.add(contract_scrollPane);
		this.add(manager_scrollPane);
		
		
	}
	/**
	 * This method displays all the JTables on the Search Player panel. 
	 * @throws SQLException
	 * @throws IOException
	 */
	private void retrievePly() throws SQLException, IOException{
		scrollPane.setVisible(true);
		stat_scrollPane.setVisible(true);
		contract_scrollPane.setVisible(true);
		manager_scrollPane.setVisible(true);
		
		String firstNameSea = removeSpace(FNtext.getText());
		String lastNameSea = removeSpace(LNtext.getText());
		
		if(FNtext.getText().isEmpty()){
			table = Controller.searchSingleName("lastName", lastNameSea);
			stat_table = Controller.searchSingleNameStat("lastName", lastNameSea);
			contract_table = Controller.searchSingleNameContract("lastName", lastNameSea);
			manager_table = Controller.searchSingleAgent("lastName", lastNameSea);
		}else if(LNtext.getText().isEmpty()){
			table = Controller.searchSingleName("firstName", firstNameSea);
			stat_table = Controller.searchSingleNameStat("firstName", firstNameSea);
			contract_table = Controller.searchSingleNameContract("firstName", firstNameSea);
			manager_table = Controller.searchSingleAgent("firstName", firstNameSea);
		}else{
			table = Controller.searchFullName(firstNameSea,lastNameSea);
			stat_table = Controller.searchFullNameStat(firstNameSea, lastNameSea);
			contract_table = Controller.searchFullNameContract(firstNameSea, lastNameSea);
			manager_table = Controller.searchFullAgent(firstNameSea, lastNameSea);
		}
		
		scrollPane.setViewportView(table);
		stat_scrollPane.setViewportView(stat_table);
		contract_scrollPane.setViewportView(contract_table);
		manager_scrollPane.setViewportView(manager_table);
		
		scrollPane.setBounds(5, 100, table.getColumnCount() * 75, (table.getRowCount()+1)*18);
		stat_scrollPane.setBounds(5, 125 + scrollPane.getHeight(), stat_table.getColumnCount() * 75,
				(stat_table.getRowCount()+1)*18);
		contract_scrollPane.setBounds(5, 150 + stat_scrollPane.getHeight() + scrollPane.getHeight(), contract_table.getColumnCount()*100, 
				(contract_table.getRowCount()+1)*18);
		manager_scrollPane.setBounds(5, 175 + stat_scrollPane.getHeight() + scrollPane.getHeight() + contract_scrollPane.getHeight(), manager_table.getColumnCount()*125,
				(manager_table.getRowCount()+1)*18);
	}
	/**
	 * Sets the layout of the panel. 
	 */
	private void setLayout(){
		LNtext.setBounds(this.getHeight()/2, this.getHeight()/2, 200, 20);
		FNtext.setBounds(this.getHeight()/2, this.getHeight()/2 + 30, 200, 20);
		
		LNLabel.setBounds(this.getHeight()/2 + 200, this.getHeight()/2, 150, 20);
		FNLabel.setBounds(this.getHeight()/2 + 200, this.getHeight()/2 + 30, 150, 20);
		
		search.setBounds(this.getHeight()/2 + 4, this.getHeight()/2 + 60, 80,20);
		
	}
	/**
	 * Removes unnecessary spaces. 
	 * @param name name of the player. 
	 * @return a truncated string without any spaces in the beginning. 
	 */
	private String removeSpace(String name){
		StringBuilder firstName = new StringBuilder(name);
		if(!name.isEmpty()){
			while(firstName.length() != 0 && firstName.charAt(0) == ' '){
				firstName.deleteCharAt(0);
			}
		}
		return firstName.toString();
	}

}
