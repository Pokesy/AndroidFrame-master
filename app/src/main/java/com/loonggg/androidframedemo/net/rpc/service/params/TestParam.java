package com.loonggg.androidframedemo.net.rpc.service.params;

/**
 * Created by loonggg on 16/9/16.
 */

public class TestParam {
    private String key;
    private int pno;
    private int ps;
    private String dtype;
    public TestParam(String key,int pno,int ps,String dtype){
        this.key = key;
        this.pno =pno;
        this.ps = ps;
        this.dtype = dtype;
    }

}
