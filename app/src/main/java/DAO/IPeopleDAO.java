package DAO;

import DAL.IPersonDTO;

public interface IPeopleDAO {

    void createUser(IPersonDTO person) throws  DALException;
    IPersonDTO getPerson(int userId) throws DALException;
    void updateUser(IPersonDTO person) throws DALException;


    public class DALException extends Exception{

    }
}
