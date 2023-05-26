package com.cqut.mapper;

import com.cqut.domain.saleManager;

import java.util.List;

public interface SManagerMapper {
    List<saleManager> getSManager();
    void addSManager(saleManager saleManager);
    void delSManager(saleManager saleManager);
    void updateSManager(saleManager saleManager);
}
