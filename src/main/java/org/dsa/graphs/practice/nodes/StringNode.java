
package org.dsa.graphs.practice.nodes;

import java.util.ArrayList;
import java.util.List;

class StringNode {
    public String val;
    public List<StringNode> neighbors;

    public StringNode(String val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<String> nbVals = new ArrayList<>();
        for (StringNode nb : neighbors) nbVals.add(nb.val);
        return "Node(" + val + ") --> " + nbVals;
    }
}