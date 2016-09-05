package cn.com.project.Business;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaxuan on 16/9/5.
 */
public class BusinessServicesMapping {

    /**
     * 直接将服务名称和关联的类，放置到这常量中
     */
    private static final Map<String, String> SERVICES_MAPPING = new HashMap<>();

    static {
        SERVICES_MAPPING.put("queryUserDetailService", "business.impl.QueryUserDetailServiceImpl");
    }
}
