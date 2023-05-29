package com.cqut.mapper;

import com.cqut.domain.saleManager;

import java.util.List;
import java.util.Map;

public interface SManagerMapper {
    List<saleManager> getSManager(Map map);
    void addSManager(saleManager saleManager);
    void delSManager(saleManager saleManager);
    void updateSManager(saleManager saleManager);
}
