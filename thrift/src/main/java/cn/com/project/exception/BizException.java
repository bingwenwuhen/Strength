package cn.com.project.exception;

import lombok.Data;

/**
 * Created by xiaxuan on 16/9/5.
 * 业务处理异常，这个异常负责大多数场景中告知上层调用者处理过程中出现了问题。
 * 其中该异常中有一个ResponseCode枚举，描述了具体的处理问题
 */
@Data
public class BizException extends Exception {

    /**
     * 异常响应编码
     */
    private ResponseCode responseCode;

    public BizException(String msg, ResponseCode responseCode) {
        super(msg);
        this.responseCode = responseCode;
    }
}
