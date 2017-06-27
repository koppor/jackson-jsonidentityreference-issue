package com.github.koppor.jsonidentityissue.model;

public class RedNode extends Node {

    public String redProperty = "red";

    public RedNode(String id) {
        super(id);
        this.content = "red " + id;
    }

}
