package com.github.koppor.jsonidentityissue.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class GraphTest
{
  private final String jsonStr = "{\n" +
    "  \"greenNodes\" : [ {\n" +
//    "    \"type\" : \"GreenNode\",\n" +
    "    \"id\" : \"g\",\n" +
    "    \"content\" : \"green g\",\n" +
    "    \"greenProperty\" : \"green\"\n" +
    "  } ],\n" +
    "  \"redNodes\" : [ {\n" +
//    "    \"type\" : \"RedNode\",\n" +
    "    \"id\" : \"r\",\n" +
    "    \"content\" : \"red r\",\n" +
    "    \"redProperty\" : \"red\"\n" +
    "  } ],\n" +
    "  \"edges\" : [ {\n" +
    "    \"source\" : \"g\",\n" +
    "    \"target\" : \"r\"\n" +
    "  } ]\n" +
    "}";

  private final ObjectMapper objectMapper = new ObjectMapper();
  private Graph g;

  @Before
  public void setup()
  {
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
  public void jsonCanBeGenerated() throws Exception
  {
    JSONAssert.assertEquals(jsonStr, objectMapper.writeValueAsString(g), true);
  }

  @Test
  public void jsonCanBeParsed() throws Exception
  {
    Assert.assertEquals(g, objectMapper.readValue(jsonStr, Graph.class));
  }
}
