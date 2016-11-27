package cn.com.hessian.servlet;

import cn.com.hessian.service.HelloService;
import com.caucho.hessian.server.HessianServlet;

/**
 * Created by xiaxuan on 16/11/14.
 */
public class HelloServlet extends HessianServlet implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
