package dp.visitor;

import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.assertj.core.api.Assertions.assertThat;

public class Node2Test {

  @Test
  public void testPrint() throws Exception {
    // Setup
    Node2 node1 = new NumNode2(2);
    Node2 node2 = new NumNode2(3);
    Node2 node3 = new AddNode2(node1, node2);
    Node2 node4 = new NumNode2(4);
    Node2 node5 = new AddNode2(node3, node4);

    try (Writer writer = new StringWriter()) {
      // Exercise
      node5.print(writer);
      String actual = writer.toString();
      String expected = "((2+3)+4)";

      // Verify
      assertThat(actual).isEqualTo(expected);
    }
  }

}