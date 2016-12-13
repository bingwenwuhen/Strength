package cn.com.demo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;
import thrift.*;

/**
 * 我们定义了一个HelloWorldService.Iface接口的具体实现
 * 注意，这个父级接口：HelloWorldService.Iface是由thrift的代码生成工具生成的
 * 要运行这段代码，要导入maven-log4j的支持，否则修改LOGGER.INFO方法
 * Created by xiaxuan on 16/8/25.
 */
public class HelloWorldServiceImpl implements HelloService.Iface {

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(HelloWorldServiceImpl.class);


    /**
     * 在接口定义中，只有一个方法需要实现
     * HelloWorldServiceImpl.send(Request request)
     * 你可以理解成这个接口的方法接收客户端的一个request对象，并且在处理完成后向客户端返回一个Reponse对象
     * Request对象和Reponse对象都是由IDL定义的结构，并通过代码生成工具生成相应的java代码
     */
    @Override
    public Reponse send(Request request) throws ServiceException, TException {
        /**
         * 这里就是进行具体的业务处理
         */
        String json = request.getParamJSON();
        String serviceName = request.getServiceName();
        HelloWorldServiceImpl.LOGGER.info("得到的json：" + json + "得到的serviceName : " + serviceName);

        //构造返回信息
        Reponse response = new Reponse();
        response.setResponseCode(RESCODE._200);
        response.setResponseJSON("{\"user\":\"xiaxuan\"}");
        return response;
    }
}
