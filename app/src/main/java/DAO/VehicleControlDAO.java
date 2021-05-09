package DAO;

import DAL.IVehicleControlDTO;
import DAL.VehicleControlDTO;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class VehicleControlDAO implements IVehicleControlDAO {

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/db?user=soren&password=password");
  }

  @Override
  public void createVehicleControl(IVehicleControlDTO vehicleControl) throws DALException {
    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM vehicle_control WHERE vehicle_control_id = " + vehicleControl.getVehicleControlId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new IVehicleControlDAO.DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO vehicle_control VALUES (?,?,?)");


      prepState.setInt(1,vehicleControl.getVehicleControlId());
      prepState.setInt(2,vehicleControl.getUserId());
      prepState.setInt(3,vehicleControl.getVehicleId());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new IVehicleControlDAO.DALException(e.getMessage());
    }
  }

  @Override
  public IVehicleControlDTO getVehicleControl(int vehicleControlId) throws DALException {
    IVehicleControlDTO vehicleControl = new VehicleControlDTO();

    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM vehicle_control WHERE vehicle_control_id = " + vehicleControlId);
      rs.next();

      vehicleControl.setVehicleControlId(rs.getInt("vehicle_id"));
      vehicleControl.setUserId(rs.getInt("people_id"));
      vehicleControl.setVehicleId(rs.getInt("vehicles_id"));

    } catch (SQLException e) {
      throw new IVehicleControlDAO.DALException(e.getMessage());
    }
    return vehicleControl;
  }

  @Override
  public void updateVehicleControl(IVehicleControlDTO vehicleControl) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE vehicle_control SET people_id = ?, vehicles_id = ? WHERE vehicle_control_id = ?");

      st.setInt(1,vehicleControl.getUserId());
      st.setInt(2,vehicleControl.getVehicleId());
      st.setInt(3,vehicleControl.getVehicleControlId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new IVehicleControlDAO.DALException(e.getMessage());
    }
  }

  @Override
  public void deleteVehicleControl(int vehicleControlId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM vehicle_control WHERE vehicle_control_id = ?");

      st.setInt(1,vehicleControlId);

    } catch (SQLException e) {
      throw new IVehicleControlDAO.DALException(e.getMessage());
    }
  }
}
