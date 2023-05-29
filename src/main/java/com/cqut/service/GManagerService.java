package com.cqut.service;

import com.cqut.domain.goodserManager;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface GManagerService {
    List<goodserManager> getGManager(Map map) throws Exception;
    void addGManager(goodserManager goodserManager) throws Exception;
    void delGManager(goodserManager goodserManager) throws Exception;
    void updateGManager(goodserManager goodserManager) throws Exception;

}
