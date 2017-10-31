package dp.visitor;

import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.assertj.core.api.Assertions.assertThat;

public class Node7Test {

  @Test
  public void testCalc() throws Exception {
    // Setup
    Node7 node1 = new NumNode7(2);
    Node7 node2 = new NumNode7(3);
    Node7 node3 = new AddNode7(node1, node2);
    Node7 node4 = new NumNode7(4);
    Node7 node5 = new AddNode7(node3, node4);
    Calculator7 calculator = new Calculator7();

    // Exercise
    int actual = node5.accept(calculator, null);
    int expected = 2 + 3 + 4;

    // Verify
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testPrint() throws Exception {
    // Setup
    Node7 node1 = new NumNode7(2);
    Node7 node2 = new NumNode7(3);
    Node7 node3 = new AddNode7(node1, node2);
    Node7 node4 = new NumNode7(4);
    Node7 node5 = new AddNode7(node3, node4);

    try (Writer writer = new StringWriter()) {
      Printer7 printer = new Printer7();

      // Exercise
      node5.accept(printer, writer);
      String actual = writer.toString();
      String expected = "((2+3)+4)";

      // Verify
      assertThat(actual).isEqualTo(expected);
    }
  }

}