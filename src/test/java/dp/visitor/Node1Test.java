package dp.visitor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Node1Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node1 node1 = new NumNode1(2);
    Node1 node2 = new NumNode1(3);
    Node1 node3 = new AddNode1(node1, node2);
    Node1 node4 = new NumNode1(4);
    Node1 node5 = new AddNode1(node3, node4);

    // Exercise
    int actual = node5.calc();
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

}