package cn.com.pojo;

import cn.com.exception.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiaxuan on 16/9/5.
 * 该数据体用于进行返回信息描述
 */
@Data
public class BusinessResponsePojo implements Serializable {

    public BusinessResponsePojo() {
        this.desc = new DescPojo();
    }

    public BusinessResponsePojo(AbstractPojo data, String result_msg, ResponseCode result_code) {
        this.data = data;
        this.desc = new DescPojo(result_code, result_msg);
    }

    /**
     * 返回的请求结果查询
     */
    private AbstractPojo data;

    private DescPojo desc;


}
