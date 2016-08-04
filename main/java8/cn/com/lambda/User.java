package cn.com.lambda;

/**
 * Created by Administrator on 2016/8/2.
 */
public class User {

    private Long id;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
