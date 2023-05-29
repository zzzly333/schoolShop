package com.cqut.mapper;

import com.cqut.domain.goodserManager;

import java.util.List;
import java.util.Map;

public interface GManagerMapper {
    List<goodserManager> getGManager(Map map);
    void addGManager(goodserManager goodserManager);
    void delGManager(goodserManager goodserManager);
    void updateGManager(goodserManager goodserManager);
}
