package alternate.current.wire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WireConnectionManagerDiffblueTest {
  @Mock private WireNode wireNode;

  /**
   * Test {@link WireConnectionManager#WireConnectionManager(WireNode)}.
   *
   * <p>Method under test: {@link WireConnectionManager#WireConnectionManager(WireNode)}
   */
  @Test
  @DisplayName("Test new WireConnectionManager(WireNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WireConnectionManager.<init>(WireNode)"})
  void testNewWireConnectionManager() {
    // Arrange and Act
    WireConnectionManager actualWireConnectionManager = new WireConnectionManager(wireNode);

    // Assert
    assertEquals(-1, actualWireConnectionManager.iFlowDir);
    assertEquals(0, actualWireConnectionManager.total);
  }
}
