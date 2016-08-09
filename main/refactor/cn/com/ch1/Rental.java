package cn.com.ch1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Administrator on 2016/8/9.
 */
@Data
@AllArgsConstructor
public class Rental {

    private Movie _movie;

    private int _daysRented;

}
