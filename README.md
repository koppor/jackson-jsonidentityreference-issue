# Issue with JsonIdentityInfo

This repository demonstrates issues with inheritance and `@JsonIdentityInfo`.

When executing the test cases, following output is produced:

> abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information

The setting:

- Graph with nodes and edges
- Nodes can be either red or green typed. This is done via inheritance. In the graph, these are listed in the Graph explicitly
- Edges connect `Node`s
- `Node` is `abstract`, whereas `GreenNode` and `RedNode` are concrete classes
- `RedNode` and `GreenNode` differ by their properties

When reading a JSON string of a graph, the expectation is that the reference in the each edge are appropriately instantiated.

## More reading

- [Jackson deserialization on multiple types](https://stackoverflow.com/q/32766922/873282): A comment suggests to use `@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")`.
  This does not help in our setting, as we enlist red and green nodes separately.
