package com.github.koppor.jsonidentityissue.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    private final String jsonStr = "{\"greenNodes\":[{\"id\":\"g\",\"content\":\"green g\",\"greenProperty\":\"green\"}],\"redNodes\":[{\"id\":\"r\",\"content\":\"red r\",\"redProperty\":\"red\"}],\"edges\":[{\"source\":\"g\",\"target\":\"r\"}]}";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Graph g;

    @Before
    public void setup() {
        g = new Graph();

        GreenNode n1 = new GreenNode("g");
        g.greenNodes.add(n1);

        RedNode n2 = new RedNode("r");
        g.redNodes.add(n2);

        Edge e = new Edge();
        e.source = n1;
        e.target = n2;
        g.edges.add(e);
    }

    @Test
    public void jsonCanBeGenerated() throws Exception {
        Assert.assertEquals(jsonStr, objectMapper.writeValueAsString(g));
    }

    @Test
    public void jsonCanBeParsed() throws Exception {
        Assert.assertEquals(g, objectMapper.readValue(jsonStr, Graph.class));
    }



}
