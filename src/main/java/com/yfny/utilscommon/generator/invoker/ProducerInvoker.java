package com.yfny.utilscommon.generator.invoker;

import com.yfny.utilscommon.generator.invoker.base.AbstractBuilder;
import com.yfny.utilscommon.generator.invoker.base.AbstractInvoker;
import com.yfny.utilscommon.generator.invoker.base.Invoker;
import com.yfny.utilscommon.generator.utils.StringUtil;

import java.sql.SQLException;

/**
 * 代码生成器服务生产者调度器
 * Created by jisongZhou on 2019/3/27.
 **/
public class ProducerInvoker extends AbstractInvoker {

    protected boolean isFirst = true;

    @Override
    protected void getTableInfos() throws SQLException {

    }

    @Override
    protected void initTasks() {
        taskQueue.initProducerTasks(className, description, isFirst);
    }

    public static class Builder extends AbstractBuilder {

        private ProducerInvoker invoker = new ProducerInvoker();

        public Builder setClassName(String className) {
            invoker.setClassName(className);
            return this;
        }

        public Builder setDescription(String description) {
            invoker.setDescription(description);
            return this;
        }

        public Builder setFirst(boolean isFirst) {
            invoker.setFirst(isFirst);
            return this;
        }

        @Override
        public Invoker build() {
            if (!isParamtersValid()) {
                return null;
            }
            return invoker;
        }

        @Override
        public void checkBeforeBuild() throws Exception {
            if (StringUtil.isBlank(invoker.getClassName())) {
                throw new Exception("ClassName can not be null, please set className.");
            }
        }
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }
}