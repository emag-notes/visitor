package dp.visitor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Node4Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node4 node1 = new NumNode4(2);
    Node4 node2 = new NumNode4(3);
    Node4 node3 = new AddNode4(node1, node2);
    Node4 node4 = new NumNode4(4);
    Node4 node5 = new AddNode4(node3, node4);

    // Exercise
    int actual = new Calculator4().calc(node5);
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

}