package dp.visitor;

import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.assertj.core.api.Assertions.assertThat;

public class Node5Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node5 node1 = new NumNode5(2);
    Node5 node2 = new NumNode5(3);
    Node5 node3 = new AddNode5(node1, node2);
    Node5 node4 = new NumNode5(4);
    Node5 node5 = new AddNode5(node3, node4);
    Calculator5 calculator = new Calculator5();

    // Exercise
    int actual = node5.accept(calculator);
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testPrint() throws Exception {
    // Setup
    Node5 node1 = new NumNode5(2);
    Node5 node2 = new NumNode5(3);
    Node5 node3 = new AddNode5(node1, node2);
    Node5 node4 = new NumNode5(4);
    Node5 node5 = new AddNode5(node3, node4);

    try (Writer writer = new StringWriter()) {
      Printer5 printer = new Printer5(writer);

      // Exercise
      node5.accept(printer);
      String actual = writer.toString();
      String expected = "((2+3)+4)";

      // Verify
      assertThat(actual).isEqualTo(expected);
    }
  }

}