package com.amos.hibernate.core.impl;

import com.amos.hibernate.core.ExceptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模块名称: hibernate
 * 模块描述: ExceptionService
 *
 * @author amos.wang
 * @date 11/20/2020 3:31 PM
 */
@Service("exceptionService")
public class ExceptionServiceImpl implements ExceptionService {

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runtime(String name) {
        throw new RuntimeException(name);
    }

}
