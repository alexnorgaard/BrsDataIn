package DAL;

import java.io.Serializable;

public class PersonDTO implements Serializable, IPersonDTO {
    private int userID, phoneNum, maNum;
    private String firstName, lastName, rank, email, password;


    @Override
    public int getUserId() {
        return userID;
    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int getMANum() {
        return maNum;
    }

    @Override
    public void setMANum(int maNum) {
        this.maNum = maNum;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int getPhoneNum() {
        return phoneNum;
    }

    @Override
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
