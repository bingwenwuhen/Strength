package cn.com.hessian.test;

import cn.com.hessian.service.HelloService;
import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by xiaxuan on 16/11/14.
 */
public class Client {

    public static void main(String[] args) throws MalformedURLException {
        String uri = "http://localhost:8080/hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService helloService = (HelloService) factory.create(HelloService.class, uri);
        System.out.println(helloService.sayHello("xiaxuan"));

    }
}
