package model;

/**
 * Created by sunil on 5/25/16.
 */
public class Users {


   public Users(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    String password;
    int userid;

    public Users(String password, int userid, String userName) {
        this.password = password;
        this.userid = userid;
        this.userName = userName;
    }

    String userName;






}
