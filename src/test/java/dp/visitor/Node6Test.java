package dp.visitor;

import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.assertj.core.api.Assertions.assertThat;

public class Node6Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node6 node1 = new NumNode6(2);
    Node6 node2 = new NumNode6(3);
    Node6 node3 = new AddNode6(node1, node2);
    Node6 node4 = new NumNode6(4);
    Node6 node5 = new AddNode6(node3, node4);
    Calculator6 calculator = new Calculator6();

    // Exercise
    int actual = node5.accept(calculator, null);
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testPrint() throws Exception {
    // Setup
    Node6 node1 = new NumNode6(2);
    Node6 node2 = new NumNode6(3);
    Node6 node3 = new AddNode6(node1, node2);
    Node6 node4 = new NumNode6(4);
    Node6 node5 = new AddNode6(node3, node4);

    try (Writer writer = new StringWriter()) {
      Printer6 printer = new Printer6();

      // Exercise
      node5.accept(printer, writer);
      String actual = writer.toString();
      String expected = "((2+3)+4)";

      // Verify
      assertThat(actual).isEqualTo(expected);
    }
  }

}