package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MyList<T> extends Proxy{
    private List<T> list;
    public MyList(){list=new ArrayList<>();}
    public void add(T t){list.add(t);}
    public int size(){return list.size();}
    public T get(int i){return list.get(i);}
    public List<T> get(){return list;}
}
