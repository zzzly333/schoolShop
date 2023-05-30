package com.cqut.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Object> list;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
    public void add(Object object){
        if(object == null)
            object = new ArrayList<>();
        this.list.add(object);
    }
}
