package com.cqut.service.impl;

import com.cqut.domain.saleManager;
import com.cqut.mapper.SManagerMapper;
import com.cqut.service.SManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SManagerService")
public class SManagerServiceImpl implements SManagerService {
    @Autowired
    public SManagerMapper SManagerMapper;
    @Override
    public List<saleManager> getSManager() throws Exception {
        List<saleManager> saleManager = SManagerMapper.getSManager();
        if(saleManager==null)
            throw new Exception("营销经理不存在");
        else
        {
            System.out.println(saleManager);
            return saleManager;
        }
    }

    @Override
    public void addSManager(saleManager saleManager) throws Exception {
        SManagerMapper.addSManager(saleManager);
    }

    @Override
    public void delSManager(saleManager saleManager) throws Exception {
        SManagerMapper.delSManager(saleManager);
    }

    @Override
    public void updateSManager(saleManager saleManager) throws Exception {
        SManagerMapper.updateSManager(saleManager);
    }
}
