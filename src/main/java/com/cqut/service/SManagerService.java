package com.cqut.service;

import com.cqut.domain.saleManager;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface SManagerService {
    List<saleManager> getSManager() throws Exception;
    void addSManager(saleManager saleManager) throws Exception;
    void delSManager(saleManager saleManager) throws Exception;
    void updateSManager(saleManager saleManager) throws Exception;

}
