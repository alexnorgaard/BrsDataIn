package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import DAL.Container;
import DAL.IContainerDTO;
import DAL.IVehicleControlDTO;
import DAL.VehicleControlDTO;

public class ContainerDAO implements IContainerDAO{

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/db?user=soren&password=password");
  }

  @Override
  public void createContainer(IContainerDTO container) throws DALException {
    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM containers WHERE containers_id = " + container.getContainerId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new IContainerDAO.DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO containers VALUES (?,?,?,?)");


      prepState.setInt(1,container.getContainerId());
      prepState.setInt(2,container.getLicense());
      prepState.setString(3,container.getContainerType());
      prepState.setString(4,container.getUnitResponsible());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new IContainerDAO.DALException(e.getMessage());
    }
  }

  @Override
  public IContainerDTO getContainer(int containerId) throws DALException {
    IContainerDTO container = new Container();

    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM containers WHERE containers_id = " + containerId);
      rs.next();

      container.setContainerId(rs.getInt("containers_id"));
      container.setLicense(rs.getInt("license"));
      container.setContainerType(rs.getString("container_type"));
      container.setUnitResponsible(rs.getString("unit_responsible"));

    } catch (SQLException e) {
      throw new IContainerDAO.DALException(e.getMessage());
    }
    return container;
  }

  @Override
  public void updateContainer(IContainerDTO container) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE containers SET license = ?, container_type = ?, unit_responsible = ?, WHERE containers_id = ?");

      st.setInt(1,container.getLicense());
      st.setString(2,container.getContainerType());
      st.setString(3,container.getUnitResponsible());
      st.setInt(4,container.getContainerId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new IContainerDAO.DALException(e.getMessage());
    }
  }

  @Override
  public void deleteContainer(int containerId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM containers WHERE containers_id = ?");

      st.setInt(1,containerId);

    } catch (SQLException e) {
      throw new IContainerDAO.DALException(e.getMessage());
    }
  }
}
