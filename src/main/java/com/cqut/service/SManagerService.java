package com.cqut.service;

import com.cqut.domain.saleManager;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SManagerService {
    List<saleManager> getSManager(Map map) throws Exception;
    void addSManager(saleManager saleManager) throws Exception;
    void delSManager(saleManager saleManager) throws Exception;
    void updateSManager(saleManager saleManager) throws Exception;

}
