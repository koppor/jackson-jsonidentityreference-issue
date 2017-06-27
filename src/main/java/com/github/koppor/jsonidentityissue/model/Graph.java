package com.github.koppor.jsonidentityissue.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<GreenNode> greenNodes = new ArrayList();
    public List<RedNode> redNodes = new ArrayList();

    public List<Edge> edges = new ArrayList();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (!greenNodes.equals(graph.greenNodes)) return false;
        if (!redNodes.equals(graph.redNodes)) return false;
        return edges.equals(graph.edges);
    }

    @Override
    public int hashCode() {
        int result = greenNodes.hashCode();
        result = 31 * result + redNodes.hashCode();
        result = 31 * result + edges.hashCode();
        return result;
    }
}
