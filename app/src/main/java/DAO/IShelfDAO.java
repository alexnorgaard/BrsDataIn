package DAO;

import DAL.IShelfDTO;

public interface IShelfDAO {

  void createShelf(IShelfDTO shelf) throws IShelfDAO.DALException;
  IShelfDTO getShelf(int shelfId) throws IShelfDAO.DALException;
  void updateShelf(IShelfDTO shelf) throws IShelfDAO.DALException;
  void deleteShelf(int shelfId) throws IShelfDAO.DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
