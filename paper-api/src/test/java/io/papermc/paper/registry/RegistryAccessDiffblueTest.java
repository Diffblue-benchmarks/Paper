package io.papermc.paper.registry;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryAccessDiffblueTest {
  /**
   * Test {@link RegistryAccess#registryAccess()}.
   *
   * <p>Method under test: {@link RegistryAccess#registryAccess()}
   */
  @Test
  @DisplayName("Test registryAccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryAccess RegistryAccess.registryAccess()"})
  void testRegistryAccess() {
    // Arrange, Act and Assert
    assertTrue(RegistryAccess.registryAccess() instanceof TestRegistryAccess);
  }
}
