
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.swing.JTable;
import javax.swing.JTextField;

import enums.FieldEnum;
import enums.StatEnum;

/**
 * This class contains all the methods for querying the database.
 * 
 * @author Derrick Mick, Phil Adriaan, Justin Wong
 * 
 */

public class Controller
{
  /**
   * Seaches personal information about the player when the user only types in
   * one name.
   * 
   * @param name_type search by first or last name.
   * @param name name of the individual.
   * @return JTable consisting of the player information.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchSingleName(String name_type, String name) throws SQLException,
      IOException
  {

    return buildTable("Select* FROM (SELECT playerID as 'Player ID', firstName as 'First Name', " +
                      "lastName as 'Last Name', nationality as Nationality, weight as Weight, " +
                      "position as Position, college as College, height as Height, ethnicity as Ethnicity, " +
                      "2013 - birthday as Age FROM Player WHERE " +
                      name_type +
                      "= '" +
                      name +
                      "') as m");
  }

  /**
   * Searches personal infromation on the player based on their first and last
   * name.
   * 
   * @param fname player's first name.
   * @param lname player's last name.
   * @return JTable consisting of the player information.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchFullName(String fname, String lname) throws SQLException,
      IOException
  {
    return buildTable("SELECT* FROM (SELECT playerID as 'Player ID', firstName as 'First Name', " +
                      "lastName as 'Last Name', nationality as Nationality, weight as Weight, " +
                      "position as Position, college as College, height as Height, ethnicity as Ethnicity, " +
                      "2013 - birthday as Age FROM Player WHERE firstName = '" +
                      fname +
                      "' and lastName = '" + lname + "') as m");
  }

  /**
   * Searches the player's stats given their first and last name.
   * 
   * @param fname the player's first name.
   * @param lname the player's last name.
   * @return JTable consisting of the player stats.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchFullNameStat(String fname, String lname) throws SQLException,
      IOException
  {
    return buildTable("Select* FROM (SELECT Player.playerID as 'Player ID', firstName as 'First Name', " +
                      "lastName as 'Last Name', avg(minutes) as Minutes, " +
                      "avg(blocks) as Blocks, avg(steals) as Steals, avg(assist) as Assist, " +
                      "avg(offRebounds + defRebounds) as Rebounds, avg(turnovers) as Turnovers, " +
                      "avg(2*(FGM-3PM) + 3*(3PM) + FTM) as Points FROM Player, BoxScore " +
                      "Where Player.playerID = BoxScore.playerID and lastName = '" +
                      lname +
                      "' and firstName = '" +
                      fname +
                      "' " +
                      " group by BoxScore.playerID) as m");
  }

  /**
   * Provides the player's contract information.
   * 
   * @param fname the player's first name.
   * @param lname the player's last name.
   * @return JTable consisting of the player stats.
   * @throws SQLException
   * @throws IOException
   */

  public static JTable searchFullNameContract(String fname, String lname) throws SQLException,
      IOException
  {
    return buildTable("SELECT* FROM (SELECT Contract.playerID as 'Player ID', contractID as 'Contract ID', startYear " +
                      "as 'Year Start', endYear as 'Year End', salary as Salary FROM Contract, (SELECT playerID " +
                      "FROM Player WHERE lastName = '" +
                      lname +
                      "' and firstName = '" +
                      fname + "') as id WHERE Contract.playerID = id.playerID) as m");
  }

  /**
   * Provides the player's game statistics when only one name is searched in the
   * first or last name.
   * 
   * @param name_type the name type to search for, last or first
   * @param name the name
   * @return JTable consisting of the player game statistics.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchSingleNameStat(String name_type, String name)
      throws SQLException, IOException
  {
    return buildTable("Select* FROM (SELECT Player.playerID as 'Player ID', firstName as 'First Name', " +
                      "lastName as 'Last Name', avg(minutes) as Minutes, " +
                      "avg(blocks) as Blocks, avg(steals) as Steals, avg(assist) as Assist, " +
                      "avg(offRebounds + defRebounds) as Rebounds, avg(turnovers) as Turnovers, " +
                      "avg(2*(FGM-3PM) + 3*(3PM) + FTM) as Points FROM Player, BoxScore " +
                      "Where Player.playerID = BoxScore.playerID and " +
                      name_type +
                      " = '" +
                      name + "'" + " group by BoxScore.playerID) as m");
  }

  /**
   * Searchs a player's ID given either their first or last name.
   * 
   * @param name_type search either last or first name.
   * @param name the first or last name to be searched.
   * @return JTable consisting of the player contract information.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchSingleNameContract(String name_type, String name)
      throws SQLException, IOException
  {
    return buildTable("SELECT* FROM (SELECT Contract.playerID as 'Player ID', contractID as 'Contract ID', startYear " +
                      "as 'Year Start', endYear as 'Year End', salary as Salary FROM Contract, (SELECT playerID " +
                      "FROM Player WHERE " +
                      name_type +
                      " = '" +
                      name +
                      "') as id WHERE Contract.playerID = id.playerID) as m");

  }

  /**
   * Searchs for the player's agent.
   * 
   * @param name_type search either last or first name.
   * @param name the first or last name to be searched.
   * @return JTable consisting of the player's agent information.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchSingleAgent(String name_type, String name) throws SQLException,
      IOException
  {
    return buildTable("SELECT* FROM (SELECT id.playerID as 'Player ID',agentName as 'Agent Name', Agent.agentEmail as 'Agent Email', agency as Agency," +
                      "phone as 'Phone Number' FROM Agent, Manager, (SELECT playerID " +
                      "FROM Player WHERE " +
                      name_type +
                      " = '" +
                      name +
                      "') as id " +
                      "WHERE id.playerID = Manager.playerID and Manager.agentEmail = Agent.agentEmail) as m;");
  }

  /**
   * Search's for the player's agent.
   * 
   * @param fname the first name to search.
   * @param lname the last name to search.
   * @return JTable consisting of the player's agent information.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchFullAgent(String fname, String lname) throws SQLException,
      IOException
  {
    return buildTable("SELECT* FROM (SELECT id.playerID as 'Player ID', agentName as 'Agent Name', Agent.agentEmail as 'Agent Email', agency as Agency," +
                      "phone as 'Phone Number' FROM Agent, Manager, (SELECT playerID " +
                      "FROM Player WHERE lastName = '" +
                      lname +
                      "' and firstName = '" +
                      fname +
                      "') as id " +
                      "WHERE id.playerID = Manager.playerID and Manager.agentEmail = Agent.agentEmail) as m;");
  }

  /**
   * Provides the teams information.
   * 
   * @param team the team to be searched for.
   * @return JTable of a team's informaton.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchTeam(String team) throws SQLException, IOException
  {
    return buildTable("SELECT* FROM (SELECT teamID as 'Team ID', teamName as Team, owner as Owner, division as Division, " +
                      "conference as Conference, city as City, mascot as Mascot FROM Team WHERE teamName = '" +
                      team + "' ) as m");
  }

  /**
   * Searches for the teams arena information.
   * 
   * @param team the team to be searched for
   * @return JTable of a team's arena.
   * @throws SQLException
   * @throws IOException
   */
  public static JTable searchArena(String team) throws SQLException, IOException
  {
    return buildTable("SELECT* FROM (SELECT arenaID as 'Arena ID', " +
                      "arenaName as 'Arena Name', cityTeam.city as 'City', capacity as 'Capacity' FROM Arena, (" +
                      "SELECT city FROM Team WHERE Team.teamName = '" + team +
                      "') as cityTeam " + "WHERE Arena.city = cityTeam.city) as m");
  }

  /**
   * Get the stats from a category and year.
   * 
   * @param the_category Category of stat.
   * @param year Year of stat.
   * @return Table of stats.
   */
  public static JTable getStat(StatEnum the_category, int year)
  {
    JTable table = null;
    try
    {
      switch (the_category)
      {
        case SCORING:

          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(FTM * 1 + (FGM - 3PM) * 2 + 3PM * 3) as \"*PPG\", sum(FTM * 1 + (FGM - 3PM) * 2 + 3PM * 3) as PTS from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year +
                         " group by boxscore.playerID order by avg(FTM * 1 + (FGM - 3PM) * 2 + 3PM * 3) desc;");
          break;
        case REBOUND:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(offRebounds + defRebounds) as \"*RPG\", avg(offRebounds) as ORPG, avg(defRebounds) as DRPG, sum(offRebounds + defRebounds) as REB, sum(offRebounds) as OFF, sum(defRebounds) as DEF, sum(offRebounds + defRebounds) * 48 / sum(minutes) as RP48 from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year +
                         " group by boxscore.playerID order by avg(offRebounds + defRebounds) desc;");
          break;
        case FIELD_GOAL:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, sum(FGM) / sum(FGA) as \"*FG%\", avg(FGM) as FGMPG, avg(FGA) as FGAPG, sum(FGM) as FGM, sum(FGA) as FGA from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year +
                         " group by boxscore.playerID order by sum(FGM) / sum(FGA) desc;");
          break;
        case FREE_THROW:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, sum(FTM) / sum(FTA) as \"*FT%\", avg(FTM) as FTMPG, avg(FTA) as FTAPG, sum(FTM) as FTM, sum(FTA) as FTA from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year +
                         " group by boxscore.playerID order by sum(FTM) / sum(FTA) desc;");
          break;
        case THREE_POINTER:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, sum(3PM) / sum(3PA) as \"*3P%\", avg(3PM) as 3PMPG, avg(3PA) as 3PAPG, sum(3PM) as 3PM, sum(3PA) as 3PA from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year +
                         " group by boxscore.playerID order by sum(3PM) / sum(3PA) desc;");
          break;
        case ASSIST:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(assist) as \"*APG\", sum(assist) as AST, sum(assist) * 48 / sum(minutes) as AP48 from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(assist) desc;");
          break;
        case STEAL:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(steals) as \"*STPG\", sum(steals) as STL, sum(steals) * 48 / sum(minutes) as STP48, sum(steals) / sum(personalFouls) as \"ST/PF\" from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(steals) desc;");
          break;
        case BLOCK:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(blocks) as \"*BLKPG\", sum(blocks) as BLK, sum(blocks) * 48 / sum(minutes) as BLKP48, sum(blocks) / sum(personalFouls) as \"BLK/PF\" from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(blocks) desc;");
          break;
        case FOUL:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(personalFouls) as \"*PFPG\", sum(personalFouls) as PF, sum(personalFouls) * 48 / sum(minutes) as PFP48, sum(flagrant) as FLAG, sum(technicals) as TECH, sum(ejections) as EJECT from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(personalFouls) asc;");
          break;
        case MINUTE:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(minutes) as \"*MPG\", sum(minutes) as MIN, count(boxscore.gameID) as GP from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(minutes) desc;");
          break;
        case TURNOVER:
          table =
              buildTable("select null as Rank, concat(firstName, \" \", lastName) as Name, avg(turnovers) as \"*TOPG\", sum(turnovers) as \"TO\", sum(turnovers) * 48 / sum(minutes) as TOP48, sum(assist) / sum(turnovers) as \"AST/TO\", sum(steals) / sum(turnovers) as \"STL/TO\" from player, boxscore, game where player.playerID = boxscore.playerID and game.gameID = boxscore.gameID and game.date = " +
                         year + " group by boxscore.playerID order by avg(turnovers) asc;");
          break;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    for (int i = 0; i < table.getRowCount(); i++)
    {
      table.setValueAt(i + 1, i, 0);
    }
    return table;
  }

  /**
   * Gets next available id from a table.
   * 
   * @param id ID field.
   * @param table Table name
   * @return Next available id.
   */
  private static int availableID(String id, String table)
  {
    JTable id_table = null;
    try
    {
      id_table = buildTable("select " + id + " from " + table);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    int i = 1;
    boolean available = false;
    while (!available)
    {
      available = true;
      for (int j = 0; j < id_table.getRowCount(); j++)
      {
        if ((Integer.valueOf((String) id_table.getValueAt(j, 0))) == i)
        {
          available = false;
          i++;
        }
      }
    }
    return i;
  }

  /**
   * Adds a player to the database.
   * 
   * @param fields Fields containing information.
   * @param team_id Team that the player is signed.
   */
  public static void addPlayer(Map<FieldEnum, JTextField> fields, int team_id)
  {
    // add to player, manager, playsfor, contract
    int player_id = availableID("playerID", "player");
    int contract_id = availableID("contractID", "contract");
    try
    {
      Connection conn = getConnection();
      Statement stat = conn.createStatement();
      stat.execute("insert into player values (" + player_id + ", '" +
                   fields.get(FieldEnum.FIRST_NAME).getText() + "', '" +
                   fields.get(FieldEnum.LAST_NAME).getText() + "', '" +
                   fields.get(FieldEnum.NATIONALITY).getText() + "', " +
                   fields.get(FieldEnum.WEIGHT).getText() + ", '" +
                   fields.get(FieldEnum.POSITION).getText() + "', '" +
                   fields.get(FieldEnum.COLLEGE).getText() + "', '" +
                   fields.get(FieldEnum.HEIGHT).getText() + "', '" +
                   fields.get(FieldEnum.ETHNICITY).getText() + "', " +
                   fields.get(FieldEnum.BIRTH_YEAR).getText() + ");");
      conn.close();
      stat.close();

      conn = getConnection();
      stat = conn.createStatement();
      stat.execute("insert into manager values (" + player_id + ", '" +
                   fields.get(FieldEnum.AGENT_EMAIL).getText() + "');");
      conn.close();
      stat.close();

      conn = getConnection();
      stat = conn.createStatement();
      stat.execute("insert into playsfor values (" + player_id + ", " + 2013 + ", " + team_id +
                   ");");
      conn.close();
      stat.close();

      conn = getConnection();
      stat = conn.createStatement();
      stat.execute("insert into contract values (" + contract_id + ", " + player_id + ", " +
                   2013 + ", " + fields.get(FieldEnum.CONTRACT_EXPIRE).getText() + ", " +
                   fields.get(FieldEnum.SALARY).getText() + ");");
      conn.close();
      stat.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Gets a connection from the properties specified in the file
   * database.properties
   * 
   * @return the database connection
   */
  public static Connection getConnection() throws SQLException, IOException
  {
    Properties props = new Properties();
    FileInputStream in = new FileInputStream("database.properties");
    props.load(in);
    in.close();

    String drivers = props.getProperty("jdbc.drivers");
    if (drivers != null)
      System.setProperty("jdbc.drivers", drivers);
    String url = props.getProperty("jdbc.url");
    String username = props.getProperty("jdbc.username");
    String password = props.getProperty("jdbc.password");

    return DriverManager.getConnection(url, username, password);
  }

  /**
   * @return and array of all teams in the database.
   */
  public static Object[] getTeams()
  {
    ArrayList<String> teams = new ArrayList<String>();
    try
    {
      Connection conn = getConnection();
      Statement stat = conn.createStatement();
      stat.execute("SELECT teamName FROM Team");
      ResultSet result = stat.getResultSet();

      while (result.next())
      {
        teams.add(result.getString("teamName"));
      }
      conn.close();
      stat.close();
      result.close();
    }
    catch (Exception ex)
    {

    }

    return teams.toArray();
  }

  /**
   * Builds a JTable from the provided query.
   * @param query the query to execute
   * @return a JTable witht the results
   * @throws SQLException thows when the query is invalid
   * @throws IOException theows when metadata cannot be parsed correctly. 
   */
		 
  public static JTable buildTable(String query) throws SQLException, IOException
  {
    Connection conn = getConnection();
    Statement stat = conn.createStatement();

    stat.execute(query);

    ResultSet result = stat.getResultSet();
    ResultSetMetaData metaData = result.getMetaData();
    int columnCount = metaData.getColumnCount();

    Object[] headers = new Object[columnCount];
    for (int i = 0; i < columnCount; i++)
    {
      headers[i] = metaData.getColumnLabel(i + 1);
    }

    ArrayList<Object[]> rows = new ArrayList<Object[]>();
    while (result.next())
    {
      Object[] row = new Object[columnCount];

      for (int i = 0; i < columnCount; i++)
      {
        row[i] = result.getString(i + 1);
      }
      rows.add(row);
    }

    Object[][] data = new Object[rows.size()][columnCount];
    for (int i = 0; i < data.length; i++)
    {
      data[i] = rows.get(i);
    }
    conn.close();
    stat.close();
    result.close();

    return new JTable(data, headers)
    {
      @Override
      public boolean isCellEditable(int row, int column)
      {
        return false;
      };
    };
  }
}
