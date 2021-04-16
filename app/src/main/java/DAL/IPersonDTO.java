package DAL;

public interface IPersonDTO {
    int getUserId();
    void setUserId(int userId);

    int getMANum();
    void setMANum(int MANum);

    String getFirstName();
    void setFirstName(String FirstName);

    String getLastName();
    void setLastName(String LastName);

    String getRank();
    void setRank(String Rank);

    int getPhoneNum();
    void setPhoneNum(int PhoneNum);

    String getEmail();
    void setEmail(String Email);

    void setPassword(String Password);


}
