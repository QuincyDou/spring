package org.doukang.springtest.aop.advice;

import java.sql.SQLException;

public class ExceptionService
{
    public void throwRuntimeExp()
    {
        throw new RuntimeException("运行异常");
    }
    
    public void throwSQLExp() throws SQLException
    {
        throw new SQLException("数据更新操作异常");
    }
}
