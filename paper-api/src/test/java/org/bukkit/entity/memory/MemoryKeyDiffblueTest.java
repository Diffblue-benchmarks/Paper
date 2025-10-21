package org.bukkit.entity.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemoryKeyDiffblueTest {
  /**
   * Test {@link MemoryKey#getByKey(NamespacedKey)}.
   *
   * <p>Method under test: {@link MemoryKey#getByKey(NamespacedKey)}
   */
  @Test
  @DisplayName("Test getByKey(NamespacedKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MemoryKey MemoryKey.getByKey(NamespacedKey)"})
  void testGetByKey() {
    // Arrange and Act
    MemoryKey<?> actualByKey = MemoryKey.getByKey(NamespacedKey.randomKey());

    // Assert
    assertNull(actualByKey);
  }

  /**
   * Test {@link MemoryKey#values()}.
   *
   * <p>Method under test: {@link MemoryKey#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MemoryKey.values()"})
  void testValues() {
    // Arrange and Act
    Set<MemoryKey<?>> actualValuesResult = MemoryKey.values();

    // Assert
    assertEquals(41, actualValuesResult.size());
  }
}
