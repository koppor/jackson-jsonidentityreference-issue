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

- [Jackson deserialize JsonIdentityReference (alwaysAsId = true)](https://stackoverflow.com/q/18306040/873282):
  The solution proposes a separate setter for `String`.
  In our case, this only works if `Edge` would have a link to all known nodes to establish a proper link.
- [Jackson deserialization on multiple types](https://stackoverflow.com/q/32766922/873282):
  A comment suggests to use `@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")`.
  This does not help in our setting, as we enlist red and green nodes separately.
- [Jackson deserialization on multiple types](https://stackoverflow.com/q/32766922/873282):
  [The answer](https://stackoverflow.com/a/32777371/873282) Shows how to plugin custom deserializers.
- [Jackson: referencing the same object](https://stackoverflow.com/q/37640985/873282):
  Treating marshalling only.
- [Jackson mapper write id instead of entire object](https://stackoverflow.com/q/28147484/873282):
  No detailed answers existing
- [Dynamic polymorphic type handling with Jackson](https://www.dilipkumarg.com/dynamic-polymorphic-type-handling-jackson/):
  Proposal to use [`@JSonTypeResolver`](https://fasterxml.github.io/jackson-databind/javadoc/2.4/com/fasterxml/jackson/databind/annotation/JsonTypeResolver.html).
