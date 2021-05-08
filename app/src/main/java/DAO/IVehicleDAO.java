package DAO;

import DAL.IVehicleDTO;

public interface IVehicleDAO {

  void createVehicle(IVehicleDTO vehicle) throws IVehicleDAO.DALException;
  IVehicleDTO getVehicle(int vehicleId) throws IVehicleDAO.DALException;
  void updateVehicle(IVehicleDTO vehicle) throws IVehicleDAO.DALException;
  void deleteVehicle(int vehicleId) throws IVehicleDAO.DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
