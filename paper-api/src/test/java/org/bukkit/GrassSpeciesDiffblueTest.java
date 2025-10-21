package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrassSpeciesDiffblueTest {
  /**
   * Test {@link GrassSpecies#getByData(byte)}.
   *
   * <p>Method under test: {@link GrassSpecies#getByData(byte)}
   */
  @Test
  @DisplayName("Test getByData(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GrassSpecies GrassSpecies.getByData(byte)"})
  void testGetByData() {
    // Arrange, Act and Assert
    assertNull(GrassSpecies.getByData((byte) 'A'));
  }
}
