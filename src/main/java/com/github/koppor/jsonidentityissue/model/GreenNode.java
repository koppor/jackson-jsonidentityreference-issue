package com.github.koppor.jsonidentityissue.model;

public class GreenNode extends Node
{

  public String greenProperty = "green";

  public GreenNode()
  {
    super();
  }

  public GreenNode(String id)
  {
    super(id);
    this.content = "green " + id;
  }


  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GreenNode greenNode = (GreenNode) o;

    return greenProperty != null ? greenProperty.equals(greenNode.greenProperty) : greenNode.greenProperty == null;
  }

  @Override
  public int hashCode()
  {
    return greenProperty != null ? greenProperty.hashCode() : 0;
  }
}
