package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryKeySetImplDiffblueTest {
  /**
   * Test {@link RegistryKeySetImpl#values()}.
   *
   * <p>Method under test: {@link RegistryKeySetImpl#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List RegistryKeySetImpl.values()"})
  void testValues() {
    // Arrange
    RegistryKeySetImpl<Keyed> registryKeySetImpl =
        new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertTrue(registryKeySetImpl.values().isEmpty());
  }
}
