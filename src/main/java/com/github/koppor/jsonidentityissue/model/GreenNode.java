package com.github.koppor.jsonidentityissue.model;

public class GreenNode extends Node {

    public String greenProperty = "green";

    public GreenNode() {
        super();
    }

    public GreenNode(String id) {
        super(id);
        this.content = "green " + id;
    }

}
