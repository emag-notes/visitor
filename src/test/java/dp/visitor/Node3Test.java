package dp.visitor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Node3Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node3 node1 = new NumNode3(2);
    Node3 node2 = new NumNode3(3);
    Node3 node3 = new AddNode3(node1, node2);
    Node3 node4 = new NumNode3(4);
    Node3 node5 = new AddNode3(node3, node4);

    // Exercise
    int actual = new Calculator3().calc(node5);
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

}