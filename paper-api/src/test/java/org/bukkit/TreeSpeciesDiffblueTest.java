package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeSpeciesDiffblueTest {
  /**
   * Test {@link TreeSpecies#getByData(byte)}.
   *
   * <p>Method under test: {@link TreeSpecies#getByData(byte)}
   */
  @Test
  @DisplayName("Test getByData(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSpecies TreeSpecies.getByData(byte)"})
  void testGetByData() {
    // Arrange, Act and Assert
    assertNull(TreeSpecies.getByData((byte) 'A'));
  }
}
