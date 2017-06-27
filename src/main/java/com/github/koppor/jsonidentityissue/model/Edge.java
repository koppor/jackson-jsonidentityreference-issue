package com.github.koppor.jsonidentityissue.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

public class Edge {

    @JsonIdentityReference(alwaysAsId = true)
    public Node source;

    @JsonIdentityReference(alwaysAsId = true)
    public Node target;

}
