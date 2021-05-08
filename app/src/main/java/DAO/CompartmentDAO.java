package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import DAL.CompartmentDTO;
import DAL.ICompartmentDTO;

public class CompartmentDAO implements ICompartmentDAO {

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("130.225.170.83");
  }

  @Override
  public void createCompartment(ICompartmentDTO compartment) throws DALException {
    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM compartments WHERE compartments_id = " + compartment.getCompartmentId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new ICompartmentDAO.DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO vehicle_control VALUES (?,?,?,?)");


      prepState.setInt(1,compartment.getCompartmentId());
      prepState.setString(2,compartment.getCompartmentName());
      prepState.setInt(3,compartment.getVehicleId());
      prepState.setInt(4,compartment.getContainerId());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new ICompartmentDAO.DALException(e.getMessage());
    }
  }

  @Override
  public ICompartmentDTO getCompartment(int compartmentId) throws DALException {
    ICompartmentDTO compartment = new CompartmentDTO();

    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM compartments WHERE compartments_id = " + compartmentId);
      rs.next();

      compartment.setCompartmentId(rs.getInt("compartments_id"));
      compartment.setCompartmentName(rs.getString("compartment_name"));
      compartment.setVehicleId(rs.getInt("vehicles_id"));
      compartment.setContainerId(rs.getInt("containers_id"));

    } catch (SQLException e) {
      throw new ICompartmentDAO.DALException(e.getMessage());
    }
    return compartment;
  }

  @Override
  public void updateCompartment(ICompartmentDTO compartment) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE compartments SET compartment_name = ?, vehicles_id = ?, containers_id = ?, WHERE compartments_id = ?");

      st.setString(1,compartment.getCompartmentName());
      st.setInt(2,compartment.getVehicleId());
      st.setInt(3,compartment.getContainerId());
      st.setInt(4,compartment.getCompartmentId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new ICompartmentDAO.DALException(e.getMessage());
    }
  }

  @Override
  public void deleteCompartment(int compartmentId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM compartments WHERE compartments_id = ?");

      st.setInt(1,compartmentId);

    } catch (SQLException e) {
      throw new ICompartmentDAO.DALException(e.getMessage());
    }
  }
}
