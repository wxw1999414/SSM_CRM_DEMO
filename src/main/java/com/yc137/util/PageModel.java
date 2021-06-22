package com.yc137.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chaun
 */
public class PageModel<T>{

    private int size;
    private int nowPage;
    private int sumCount;
    private int sumPage;
    /**存放数据的集合*/
    private List<T> list;
    /**
     * 条件查询对象
     */
    private Map<String,Object> map=new HashMap<>();


    /**生成get / set 方法*/
    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int Page) {
        this.nowPage = Page;
    }

    public int getSumCount() {
        return sumCount;
    }

    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
        //计算页数
        this.sumPage = this.sumCount/this.size;
        //取模 如果大于0 则加1
        if((this.sumCount%this.size)>0){
            this.sumPage ++;
        }

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "currentPage=" + nowPage +
                ", sumCount=" + sumCount +
                ", size=" + size +
                ", sumPage=" + sumPage +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
