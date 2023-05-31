package com.cqut.service.impl;

import com.cqut.domain.goodserManager;
import com.cqut.mapper.GManagerMapper;
import com.cqut.service.GManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("GManagerService")
public class GManagerServiceImpl implements GManagerService {
    @Autowired
    public GManagerMapper GManagerMapper;
    @Override
    public List<goodserManager> getGManager(Map map) throws Exception {
        List<goodserManager> goodserManager = GManagerMapper.getGManager(map);
        if(goodserManager==null)
            throw new Exception("营销经理不存在");
        else
        {
            System.out.println(goodserManager);
            return goodserManager;
        }
    }

    @Override
    public List<goodserManager> getAllGManager() throws Exception {
        return GManagerMapper.getAllGManager();
    }

    @Override
    public void addGManager(goodserManager goodserManager) throws Exception {
        GManagerMapper.addGManager(goodserManager);
    }

    @Override
    public void delGManager(goodserManager goodserManager) throws Exception {
        GManagerMapper.delGManager(goodserManager);
    }

    @Override
    public void updateGManager(goodserManager goodserManager) throws Exception {
        GManagerMapper.updateGManager(goodserManager);
    }
}
