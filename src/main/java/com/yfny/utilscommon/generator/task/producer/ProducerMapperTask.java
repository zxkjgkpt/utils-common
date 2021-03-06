package com.yfny.utilscommon.generator.task.producer;

import com.yfny.utilscommon.generator.task.base.AbstractTask;
import com.yfny.utilscommon.generator.utils.ConfigUtil;
import com.yfny.utilscommon.generator.utils.FileUtil;
import com.yfny.utilscommon.generator.utils.FreemarketConfigUtils;
import com.yfny.utilscommon.generator.utils.StringUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器生产者（微服务）数据交互层任务
 * Created by jisongZhou on 2019/3/26.
 **/
public class ProducerMapperTask extends AbstractTask {

    public ProducerMapperTask(String className, String description) {
        super(className, description);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成Mapper填充数据
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        dataMap.put("MapperPackageName", ConfigUtil.getConfiguration().getPath().getMapper());
        dataMap.put("SqlBuilderPackageName", ConfigUtil.getConfiguration().getPath().getSqlbuilder());
        dataMap.put("BaseEntityPackageName", ConfigUtil.getConfiguration().getEntityPackageName());
        dataMap.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
        dataMap.put("Author", ConfigUtil.getConfiguration().getAuthor());
        dataMap.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dataMap.put("ClassName", className);
        dataMap.put("Description", StringUtil.isBlank(description) ? className : description);
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getMapper());
        String fileName = className + "Mapper.java";
        // 生成Mapper文件
        System.out.println("Generating " + fileName);
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_PRODUCER_MAPPER, dataMap, filePath + fileName);
    }
}
