package com.masai.question1.modeldto;

import com.masai.question1.model.Entry;

import java.security.KeyStore;
import java.util.List;

public class Apidata {

    private Integer count;

    private List<KeyStore.Entry> entries;

    public Apidata() {
    }

    public Apidata(Integer count, List<KeyStore.Entry> entries) {
        this.count = count;
        this.entries = entries;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<KeyStore.Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<KeyStore.Entry> entries) {
        this.entries = entries;
    }
}
