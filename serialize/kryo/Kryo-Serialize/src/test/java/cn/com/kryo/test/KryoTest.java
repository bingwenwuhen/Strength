package cn.com.kryo.test;

import cn.com.kryo.bean.CustomCategoryDto;
import cn.com.kryo.bean.CustomItemDto;
import cn.com.kryo.serialize.ObjectId;
import cn.com.kryo.serialize.SerializeUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by xiaxuan on 16/11/23.
 */
public class KryoTest {

    Logger logger = LogManager.getLogger(KryoTest.class);

    private long time;

    @BeforeTest
    public void before() {
        time = System.currentTimeMillis();
    }

    @AfterTest
    public void after() {
        logger.info("cost: " + (System.currentTimeMillis() - time));
//        System.out.println(System.curr entTimeMillis() - time);
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void testObject() {
        CustomItemDto val = new CustomItemDto();
        val.setId(Long.parseLong(String.valueOf(1)));
        val.setItemCode("");
        val.setItemDespositPrice(32.45);
        val.setItemMemo(null);
        val.setItemName("张金");
        val.setItemPrice(89.02);
        val.setSort(10);

        String a = SerializeUtils.serializationObject(val);
        CustomItemDto newValue = SerializeUtils.deserializationObject(a, CustomItemDto.class);
        Assert.assertEquals(val.getId(), newValue.getId());
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void testList() {
        List<CustomItemDto> lst = new ArrayList<CustomItemDto>();
        for (int i = 0; i < 10; i++) {
            CustomItemDto val = new CustomItemDto();
            val.setId(Long.parseLong(String.valueOf(i)));
            val.setItemCode("");
            val.setItemDespositPrice(32.45);
            val.setItemMemo(null);
            val.setItemName("张金");
            val.setItemPrice(89.02);
            val.setSort(10);
            lst.add(val);
        }
        String a = SerializeUtils.serializationList(lst, CustomItemDto.class);
        List<CustomItemDto> newValue = SerializeUtils.deserializationList(a, CustomItemDto.class);
        Assert.assertEquals(lst.size(), newValue.size());
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void testBean() {
        List<CustomCategoryDto> lst = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            CustomCategoryDto dto = new CustomCategoryDto();
            dto.setCategoryCode("ABCD_001");
            dto.setCategoryName("呼吸系统");
            for (int i = 0; i < 10; i++) {
                CustomItemDto val = new CustomItemDto();
                val.setId(Long.parseLong(String.valueOf(i)));
                val.setItemCode("");
                val.setItemDespositPrice(32.45);
                val.setItemMemo(null);
                val.setItemName("张金");
                val.setItemPrice(89.02);
                val.setSort(10);
                dto.getCustomItemList().add(val);
            }
            for (int i = 0; i < 10; i++) {
                CustomItemDto val = new CustomItemDto();
                val.setId(Long.parseLong(String.valueOf(i)));
                val.setItemCode("");
                val.setItemDespositPrice(32.45);
                val.setItemMemo(null);
                val.setItemName("张金");
                val.setItemPrice(89.02);
                val.setSort(10);
                dto.getCustomItemSet().add(val);
            }
            for (int i = 0; i < 10; i++) {
                CustomItemDto val = new CustomItemDto();
                val.setId(Long.parseLong(String.valueOf(i)));
                val.setItemCode("");
                val.setItemDespositPrice(32.45);
                val.setItemMemo(null);
                val.setItemName("张金");
                val.setItemPrice(89.02);
                val.setSort(10);
                dto.getCustomItemMap().put(String.valueOf(i), val);
            }
            lst.add(dto);
        }

        String a = SerializeUtils.serializationList(lst, CustomCategoryDto.class);
        List<CustomCategoryDto> newValue = SerializeUtils.deserializationList(a, CustomCategoryDto.class);
        Assert.assertEquals(lst.size(), newValue.size());
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void testMap() {
        Map<String, CustomItemDto> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            CustomItemDto val = new CustomItemDto();
            val.setId(Long.parseLong(String.valueOf(i)));
            val.setItemCode("");
            val.setItemDespositPrice(32.45);
            val.setItemMemo(null);
            val.setItemName("张金");
            val.setItemPrice(89.02);
            val.setSort(10);
            map.put(new ObjectId().toString(), val);
        }
        String a = SerializeUtils.serializationMap(map, CustomItemDto.class);
        Map<String, CustomItemDto> newValue = SerializeUtils.deserializationMap(a, CustomItemDto.class);
        Assert.assertEquals(map.size(), newValue.size());
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void testSet() {
        Set<CustomItemDto> set = new HashSet<CustomItemDto>();
        for (int i = 0; i < 10; i++) {
            CustomItemDto val = new CustomItemDto();
            val.setId(Long.parseLong(String.valueOf(i)));
            val.setItemCode("");
            val.setItemDespositPrice(32.45);
            val.setItemMemo(null);
            val.setItemName("金星");
            val.setItemPrice(89.02);
            val.setSort(10);
            set.add(val);
        }

        String a = SerializeUtils.serializationSet(set, CustomItemDto.class);
        Set<CustomItemDto> newValue = SerializeUtils.deserializationSet(a, CustomItemDto.class);
        Assert.assertEquals(set.size(), newValue.size());

    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void bigDataSerialize() {
        List<CustomItemDto> customItemDtos = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            CustomItemDto val = new CustomItemDto();
            val.setId(Long.parseLong(String.valueOf(i)));
            val.setItemCode("");
            val.setItemDespositPrice(32.45);
            val.setItemMemo(null);
            val.setItemName("张金");
            val.setItemPrice(89.02);
            val.setSort(10);
            customItemDtos.add(val);
        }
        long time = System.currentTimeMillis();
        String a = SerializeUtils.serializationList(customItemDtos, CustomItemDto.class);
//        List<CustomItemDto> newValue = SerializeUtils.deserializationList(a, CustomItemDto.class);
//        Assert.assertEquals(customItemDtos.size(), newValue.size());
        long end = System.currentTimeMillis();
        logger.debug(end - time);
    }
}
