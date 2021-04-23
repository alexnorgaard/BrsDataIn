package DAO;

import DAL.IPersonDTO;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class PeopleDAO implements IPeopleDAO {
  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s160068?"
            + "user=s160068&password=D8meeg0vOUC5OjertVLZV"); //Ikke den rigtige connection URL. HUSK AT FIX!!!
  }


  @Override
  public void createUser(IPersonDTO person) throws DALException {

    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM people WHERE people_id = " + person.getUserId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO people VALUES (?,?,?,?,?,?,?)");


      prepState.setInt(1,person.getUserId());
      prepState.setInt(2,person.getMANum());
      prepState.setString(3,person.getFirstName());
      prepState.setString(4,person.getLastName());
      prepState.setString(5,person.getRank());
      prepState.setInt(6,person.getPhoneNum());
      prepState.setString(7,person.getEmail());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }

  }

  @Override
  public IPersonDTO getPerson(int userId) throws DALException {
    return null;
  }

  @Override
  public void updateUser(IPersonDTO person) throws DALException {

  }

  @Override
  public void deleteUser(int userId) throws DALException {

  }
}
