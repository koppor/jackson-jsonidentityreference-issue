package com.github.koppor.jsonidentityissue.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl=GreenNode.class)
public class GreenNode extends Node {

    public String greenProperty = "green";

    public GreenNode() {
        super();
    }

    public GreenNode(String id) {
        super(id);
        this.content = "green " + id;
    }

    @Override
    public String getType() {
        return "GreeNode";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GreenNode greenNode = (GreenNode) o;

        return greenProperty != null ? greenProperty.equals(greenNode.greenProperty) : greenNode.greenProperty == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), greenProperty);
    }
}
