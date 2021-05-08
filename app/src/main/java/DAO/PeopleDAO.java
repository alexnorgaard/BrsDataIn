package DAO;

import DAL.IPersonDTO;
import DAL.PersonDTO;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class PeopleDAO implements IPeopleDAO {
  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("130.225.170.83");
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
  public IPersonDTO getPerson(int brugerId) throws DALException {
    IPersonDTO person = new PersonDTO();


    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM people WHERE people_id = " + brugerId);
      rs.next();

      person.setUserId(rs.getInt("people_id"));
      person.setMANum(rs.getInt("MA_number"));
      person.setFirstName(rs.getString("name_first"));
      person.setLastName(rs.getString("name_last"));
      person.setRank(rs.getString("rank"));
      person.setPhoneNum(rs.getInt("phone"));
      person.setEmail(rs.getString("email"));
      person.setPassword(rs.getString("phone"));


    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
    return person;
  }

  @Override
  public void updateUser(IPersonDTO person) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE people SET MA_number = ?, name_first = ?, name_last = ?, rank = ?, phone = ?, email = ? WHERE people_id = ?");

      st.setInt(1,person.getMANum());
      st.setString(2,person.getFirstName());
      st.setString(3,person.getLastName());
      st.setString(4,person.getRank());
      st.setInt(5,person.getPhoneNum());
      st.setString(6,person.getEmail());
      st.setInt(7,person.getUserId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public void deleteUser(int brugerId) throws DALException {
    try (Connection c = createConnection()){
     PreparedStatement st = c.prepareStatement("DELETE * FROM people WHERE people_id = ?");

     st.setInt(1,brugerId);

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }
}
