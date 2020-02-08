package com.t4cloud.t.user;

import com.t4cloud.t.common.config.GenConfig;
import com.t4cloud.t.common.utils.T4GenUtils;

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
        GenConfig config = new GenConfig();
        //设置模块的包名，可以为空
        config.setModuleName("user");
        //设置表前缀，可以为空
        config.setTablePrefix("sys");
        //设置需要生成的表名,数组形式，可以多个
        String[] tableNames = new String[]{"sys_user"};
        config.setTableName(tableNames);

        //开始生成
        T4GenUtils.gen(config);

    }

}