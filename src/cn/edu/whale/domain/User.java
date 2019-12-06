package cn.edu.whale.domain;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:42 2019/11/2
 * @Modified By：
 */
public class User {
    private int uid;
    private String username;
    private String password;
    private String userphone;
    private String email;

    public User(int uid, String username, String password, String userphone, String email) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.userphone = userphone;
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public void setUsername() {
    }
}
