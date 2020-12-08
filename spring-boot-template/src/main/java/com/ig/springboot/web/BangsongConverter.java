package com.ig.springboot.web;

import com.ig.springboot.model.Bangsong;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class BangsongConverter implements Converter<String, Bangsong> {


    @Override
    public Bangsong convert(String id) {
        Bangsong bangsong = new Bangsong();
        bangsong.setId(Integer.parseInt(id));
        return bangsong;
    }
}
