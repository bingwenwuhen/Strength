package cn.com.exception;

/**
 * Created by xiaxuan on 16/11/26.
 */
public class JRedisCacheException extends RuntimeException {

    private static final long serialVersionUID = 2327704096678585610L;

    public JRedisCacheException(String e) {
        super(e);
    }

    public JRedisCacheException(String s, Throwable e) {
        super(s, e);
    }

    public JRedisCacheException(Throwable e) {
        super(e);
    }
}
