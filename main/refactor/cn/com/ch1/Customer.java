package cn.com.ch1;

import lombok.Data;
import lombok.Getter;

import java.util.Vector;

/**
 * Created by Administrator on 2016/8/9.
 */
@Data
public class Customer {

    @Getter
    private String _name;

    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }


}
