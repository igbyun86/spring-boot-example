package com.ig.springboot.model;

import org.springframework.hateoas.RepresentationModel;

public class BangsongResource extends RepresentationModel {

    private String title;

    public BangsongResource(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
