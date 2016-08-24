namespace java thrift
service HelloService {
    Reponse send(1:Request request) throws (1:ServiceException e);
}