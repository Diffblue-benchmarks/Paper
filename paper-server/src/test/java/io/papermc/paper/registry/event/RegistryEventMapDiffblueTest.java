package io.papermc.paper.registry.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.RegistryKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEventMapDiffblueTest {
  /**
   * Test {@link RegistryEventMap#hasHandlers(RegistryKey)}.
   *
   * <p>Method under test: {@link RegistryEventMap#hasHandlers(RegistryKey)}
   */
  @Test
  @DisplayName("Test hasHandlers(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegistryEventMap.hasHandlers(RegistryKey)"})
  void testHasHandlers() {
    // Arrange, Act and Assert
    assertFalse(new RegistryEventMap("Name").hasHandlers(null));
  }
}
