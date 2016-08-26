namespace java project

# 这个结构体定义了服务调用者的请求信息
struct Request {
    # 传递的参数信息，使用格式进行标示
    1:required binary paramJSON;
    # 服务调用者请求的服务名，使用serviceName属性进行传递
    2:required string serviceName;
}
# 这个结构体，定义了服务提供者的返回信息
struct Response {
    # RESCODE 是处理状态代码，是一个枚举类型，例如RESCODE._200表示处理成功
    1:required RESCODE responseCode;
    # 返回的处理结果，同样使用JSON格式进行描述
    2:required binary responseJSON;
}

exception ServiceException {
    # EXCODE 是异常代码，也是一个枚举类型
    # 例如EXCODE.PARAMNOTFOUND表示需要的请求参数没有找到
    1:required EXCODE exceptionCode;
    # 异常的描述信息，使用字符串进行描述
    2:required string exceptionMess;

}

# 这个枚举结构，描述各种服务提供者的响应代码
enum RESCODE {
    _200=200;
    _500=500;
    _400=400;
}

# 这个枚举结构，描述各种服务提供者的异常种类
enum EXCODE {
    PARAMNOTFOUND = 2001;
    SERVICENOTFOUND = 2002;
}

service DIYFrameworkService {
    Response send(1:required Request request) throws (1:required ServiceException e);
}