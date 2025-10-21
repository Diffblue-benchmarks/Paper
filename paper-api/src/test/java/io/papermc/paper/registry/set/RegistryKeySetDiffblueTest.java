package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.bukkit.Keyed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryKeySetDiffblueTest {
  /**
   * Test {@link RegistryKeySet#size()}.
   *
   * <p>Method under test: {@link RegistryKeySet#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RegistryKeySet.size()"})
  void testSize() {
    // Arrange
    RegistryKeySetImpl<Keyed> registryKeySetImpl =
        new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertEquals(0, registryKeySetImpl.size());
  }

  /**
   * Test {@link RegistryKeySet#iterator()}.
   *
   * <p>Method under test: {@link RegistryKeySet#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator RegistryKeySet.iterator()"})
  void testIterator() {
    // Arrange
    RegistryKeySetImpl<Keyed> registryKeySetImpl =
        new RegistryKeySetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertFalse(registryKeySetImpl.iterator().hasNext());
  }
}
