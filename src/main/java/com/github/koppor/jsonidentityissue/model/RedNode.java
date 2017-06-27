package com.github.koppor.jsonidentityissue.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl=RedNode.class)
public class RedNode extends Node {

    public String redProperty = "red";

    public RedNode() {
        super();
    }

    public RedNode(String id) {
        super(id);
        this.content = "red " + id;
    }

    @Override
    public String getType() {
        return "RedNode";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedNode redNode = (RedNode) o;

        return redProperty != null ? redProperty.equals(redNode.redProperty) : redNode.redProperty == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), redProperty);
    }
}
