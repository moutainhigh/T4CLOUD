package com.t4cloud.t.gen;

import com.t4cloud.t.base.config.GenCodeConfig;
import com.t4cloud.t.base.utils.T4GenUtil;

/**
 * 单表代码生成器
 *
 * <p>
 * --------------------
 *
 * @author TeaR
 * @date 2020/2/7 17:29
 */
public class T4GenCode {

    public static void main(String[] args) {

        //配置参数
        GenCodeConfig config = new GenCodeConfig();
        //设置模块的包名，可以为空
        config.setModuleName("system");
        //设置模块名（不写会自动生成的）
//        config.setServerName("T4Cloud-System");
        //设置表前缀，可以为空
//        config.setTablePrefix("");
        //modal表单样式
//        config.setDrawer(true);
        //是否生成feignClient
        config.setFeignClient(false);

        //是否为树结构，如果是树结构，需要有parentId这个字段
        config.setTree(false);

        //设置需要生成的表名,数组形式，可以多个
        String[] tableNames = new String[]{"sys_dict","sys_dict_value"};

        config.setTableName(tableNames);

        //开始生成
        T4GenUtil.gen(config);

    }

}