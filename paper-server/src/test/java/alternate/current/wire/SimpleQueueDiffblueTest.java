package alternate.current.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleQueueDiffblueTest {
  @InjectMocks private SimpleQueue simpleQueue;

  @Mock private WireNode wireNode;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleQueue}
   *   <li>{@link SimpleQueue#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleQueue.<init>()", "int SimpleQueue.size()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleQueue().size());
  }

  /**
   * Test {@link SimpleQueue#offer(WireNode)} with {@code node}.
   *
   * <ul>
   *   <li>When {@link WireNode}.
   *   <li>Then {@link SimpleQueue} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleQueue#offer(WireNode)}
   */
  @Test
  @DisplayName("Test offer(WireNode) with 'node'; when WireNode; then SimpleQueue size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleQueue.offer(WireNode)"})
  void testOfferWithNode_whenWireNode_thenSimpleQueueSizeIsOne() {
    // Arrange and Act
    boolean actualOfferResult = simpleQueue.offer(wireNode);

    // Assert
    assertEquals(1, simpleQueue.size());
    assertTrue(actualOfferResult);
  }

  /**
   * Test {@link SimpleQueue#poll()}.
   *
   * <p>Method under test: {@link SimpleQueue#poll()}
   */
  @Test
  @DisplayName("Test poll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WireNode SimpleQueue.poll()"})
  void testPoll() {
    // Arrange, Act and Assert
    assertNull(new SimpleQueue().poll());
  }

  /**
   * Test {@link SimpleQueue#peek()}.
   *
   * <p>Method under test: {@link SimpleQueue#peek()}
   */
  @Test
  @DisplayName("Test peek()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WireNode SimpleQueue.peek()"})
  void testPeek() {
    // Arrange, Act and Assert
    assertNull(new SimpleQueue().peek());
  }

  /**
   * Test {@link SimpleQueue#clear()}.
   *
   * <p>Method under test: {@link SimpleQueue#clear()}
   */
  @Test
  @DisplayName("Test clear()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleQueue.clear()"})
  void testClear() {
    // Arrange and Act
    simpleQueue.clear();

    // Assert
    assertTrue(simpleQueue.isEmpty());
  }

  /**
   * Test {@link SimpleQueue#iterator()}.
   *
   * <p>Method under test: {@link SimpleQueue#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator SimpleQueue.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new SimpleQueue().iterator().hasNext());
  }
}
