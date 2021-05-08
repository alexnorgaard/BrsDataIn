package DAO;

import DAL.ICompartmentDTO;

public interface ICompartmentDAO {

  void createCompartment(ICompartmentDTO compartment) throws ICompartmentDAO.DALException;
  ICompartmentDTO getCompartment(int compartmentId) throws ICompartmentDAO.DALException;
  void updateCompartment(ICompartmentDTO compartment) throws ICompartmentDAO.DALException;
  void deleteCompartment(int compartmentId) throws ICompartmentDAO.DALException;

  public class DALException extends Exception{

    public DALException(String message) {
    }
  }
}
