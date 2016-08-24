package cn.com.demo1;

import org.apache.thrift.TException;
import thrift.HelloWorldService;

/**
 * Created by xiaxuan on 16/8/24.
 */
public class HelloServiceImpl implements HelloWorldService.Iface {

    @Override
    public String sayHello(String username) throws TException {
        return "Hi " + username + ", Welcome to the thrift's world";
    }
}
