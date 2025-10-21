package io.papermc.paper.registry.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistryValueSetDiffblueTest {
  /**
   * Test {@link RegistryValueSet#size()}.
   *
   * <p>Method under test: {@link RegistryValueSet#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RegistryValueSet.size()"})
  void testSize() {
    // Arrange
    RegistryValueSetImpl<Object> registryValueSetImpl =
        new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertEquals(0, registryValueSetImpl.size());
  }

  /**
   * Test {@link RegistryValueSet#iterator()}.
   *
   * <p>Method under test: {@link RegistryValueSet#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator RegistryValueSet.iterator()"})
  void testIterator() {
    // Arrange
    RegistryValueSetImpl<Object> registryValueSetImpl =
        new RegistryValueSetImpl<>(null, new ArrayList<>());

    // Act and Assert
    assertFalse(registryValueSetImpl.iterator().hasNext());
  }
}
