package com.amos.hibernate.core;

/**
 * 模块名称: hibernate
 * 模块描述: ExceptionService
 *
 * @author amos.wang
 * @date 11/20/2020 3:30 PM
 */
public interface ExceptionService {

    /**
     * throw runtime exception
     *
     * @param name exception name
     */
    void runtime(String name);

}
