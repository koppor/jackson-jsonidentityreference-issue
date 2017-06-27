package com.github.koppor.jsonidentityissue.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

public class Edge {

    @JsonIdentityReference(alwaysAsId = true)
    public Node source;

    @JsonIdentityReference(alwaysAsId = true)
    public Node target;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (source != null ? !source.equals(edge.source) : edge.source != null) return false;
        return target != null ? target.equals(edge.target) : edge.target == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
    }
}
