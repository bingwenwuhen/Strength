package cn.com.ch1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Administrator on 2016/8/9.
 */
@Data
@AllArgsConstructor
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;

    private int _priceCode;

}
