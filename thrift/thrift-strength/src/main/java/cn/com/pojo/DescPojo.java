package cn.com.pojo;

import cn.com.exception.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by xiaxuan on 16/8/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescPojo implements Serializable {

    /**
     * 接口请求的返回代码，从这个代码中可以识别接口调用是否成功，以及调用失败时的错误类型，具体的code定义参考技术文档
     */
    private ResponseCode result_code;

    /**
     * 错误的中文描述，错误信息的详细中文描述
     */
    private String result_msg = "";

}
