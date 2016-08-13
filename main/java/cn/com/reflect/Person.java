package cn.com.reflect;

/**
 * Created by xiaxuan on 16/8/5.
 */
public class Person {

    private String username;

    public Person(String usernmae) {
        this.username = usernmae;
    }

    public String getUsername() {
        return username;
    }

    public Person() {
    }

    public void setUsername(String usernmae) {
        this.username = usernmae;
    }
}
