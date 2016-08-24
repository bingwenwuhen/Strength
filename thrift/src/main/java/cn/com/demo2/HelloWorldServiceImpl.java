package cn.com.demo2;

import org.apache.thrift.TException;
import thrift.HelloWorldService;

/**
 * 我们定义了一个HelloWorldService.Iface接口的具体实现
 * 注意，这个父级接口：HelloWorldService.Iface是由thrift的代码生成工具生成的
 * 要运行这段代码，要导入maven-log4j的支持，否则修改LOGGER.INFO方法
 * Created by xiaxuan on 16/8/25.
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    @Override
    public String sayHello(String username) throws TException {
        return null;
    }
}
