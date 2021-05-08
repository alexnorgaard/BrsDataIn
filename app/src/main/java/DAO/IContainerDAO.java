package DAO;

import DAL.IContainerDTO;

public interface IContainerDAO {

  void createContainer(IContainerDTO container) throws IContainerDAO.DALException;
  IContainerDTO getContainer(int containerId) throws IContainerDAO.DALException;
  void updateContainer(IContainerDTO container) throws IContainerDAO.DALException;
  void deleteContainer(int containerId) throws IContainerDAO.DALException;

  public class DALException extends Exception{

    public DALException(String message) {
    }
  }
}
