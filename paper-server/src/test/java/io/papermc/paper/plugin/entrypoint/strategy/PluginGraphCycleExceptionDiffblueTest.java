package io.papermc.paper.plugin.entrypoint.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginGraphCycleExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginGraphCycleException#PluginGraphCycleException(List)}
   *   <li>{@link PluginGraphCycleException#getCycles()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginGraphCycleException.<init>(List)",
    "List PluginGraphCycleException.getCycles()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<List<String>> cycles = new ArrayList<>();

    // Act
    PluginGraphCycleException actualPluginGraphCycleException =
        new PluginGraphCycleException(cycles);
    List<List<String>> actualCycles = actualPluginGraphCycleException.getCycles();

    // Assert
    assertNull(actualPluginGraphCycleException.getMessage());
    assertNull(actualPluginGraphCycleException.getCause());
    assertEquals(0, actualPluginGraphCycleException.getSuppressed().length);
    assertTrue(actualCycles.isEmpty());
    assertSame(cycles, actualCycles);
  }
}
