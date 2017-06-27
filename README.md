# Issue with JsonIdentityInfo

This repository demonstrates issues with inheritance and `@JsonIdentityInfo`.

When executing the test cases, following output is produced:

> abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information

The setting:

- Graph with Nodes and Edges
- Nodes can be either red or green typed. This is done via inheritance
- `Node` is `abstract`, whereas `GreenNode` and `RedNode` are concrete classes
- `RedNode` and `GreenNode` differ by their properties

When reading a JSON string of a graph, the expectation is that the appropriate sub classes of `Node` are instantiated, because the properties of each sub class differ.
