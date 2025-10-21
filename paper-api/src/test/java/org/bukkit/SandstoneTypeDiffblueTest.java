package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SandstoneTypeDiffblueTest {
  /**
   * Test {@link SandstoneType#getByData(byte)}.
   *
   * <p>Method under test: {@link SandstoneType#getByData(byte)}
   */
  @Test
  @DisplayName("Test getByData(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SandstoneType SandstoneType.getByData(byte)"})
  void testGetByData() {
    // Arrange, Act and Assert
    assertNull(SandstoneType.getByData((byte) 'A'));
  }
}
