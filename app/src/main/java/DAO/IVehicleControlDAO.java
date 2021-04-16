package DAO;

import DAL.IVehicleControlDTO;

public interface IVehicleControlDAO {

  void createVehicleControl(IVehicleControlDTO vehicleControl) throws IVehicleControlDAO.DALException;
  IVehicleControlDTO getVehicleControl(int vehicleControlId) throws IVehicleControlDAO.DALException;
  void updateVehicleControl(IVehicleControlDTO vehicleControl) throws IVehicleControlDAO.DALException;
  void deleteVehicleControl(int vehicleControlId) throws IVehicleControlDAO.DALException;

  public class DALException extends Exception{

  }
}
