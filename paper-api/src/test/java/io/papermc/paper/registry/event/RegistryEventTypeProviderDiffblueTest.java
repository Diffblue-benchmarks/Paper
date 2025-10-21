package io.papermc.paper.registry.event;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryEventTypeProviderDiffblueTest {
  /**
   * Test {@link RegistryEventTypeProvider#provider()}.
   *
   * <p>Method under test: {@link RegistryEventTypeProvider#provider()}
   */
  @Test
  @DisplayName("Test provider()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryEventTypeProvider RegistryEventTypeProvider.provider()"})
  void testProvider() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RegistryEventTypeProvider.provider());
  }
}
