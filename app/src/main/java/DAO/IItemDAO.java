package DAO;

import DAL.IItemDTO;

public interface IItemDAO {

  void createItem(IItemDTO item) throws IItemDAO.DALException;
  IItemDTO getItem(int itemId) throws IItemDAO.DALException;
  void updateItem(IItemDTO item) throws IItemDAO.DALException;
  void deleteItem(int itemId) throws IItemDAO.DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
