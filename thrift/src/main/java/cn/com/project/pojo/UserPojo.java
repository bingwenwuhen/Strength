package cn.com.project.pojo;

import lombok.Data;

/**
 * 用户信息
 * Created by xiaxuan on 16/8/30.
 */
@Data
public class UserPojo extends AbstractPojo{

    private String userName;

    private Integer userSex;

    private String userAddr;
}
