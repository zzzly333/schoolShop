package com.cqut.mapper;

import com.cqut.domain.goodserManager;

import java.util.List;

public interface GManagerMapper {
    List<goodserManager> getGManager();
    void addGManager(goodserManager goodserManager);
    void delGManager(goodserManager goodserManager);
    void updateGManager(goodserManager goodserManager);
}
