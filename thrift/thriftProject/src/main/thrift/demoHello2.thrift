# 命名空间的定义，注意java关键字
namespace java thrift

# 结构体定义
struct Request {
    1:required string paramJSON;
    2:required string serviceName;
}

# 另一个结构体定义
struct Reponse {
    1:required RESCODE responseCode;
    2:required string responseJSON;
}

exception ServiceException {
    1:required EXCODE exceptionCode;
    2:required string exceptionMess;
}

# 枚举定义
enum RESCODE {
    _200 = 200;
    _500 = 500;
    _400 = 400;
}

# 另一个枚举定义
enum EXCODE {
    PARAMNOTFOUND = 2001;
    SERVICENOTFOUND = 2002;
}

# 服务定义
service HelloService {
    Reponse send(1:Request request) throws (1:ServiceException e);
}
