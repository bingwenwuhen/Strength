package cn.com.transientdemo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by xiaxuan on 16/9/24.
 */
public class User implements Serializable {

    private String username;
    
    private transient String password;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
