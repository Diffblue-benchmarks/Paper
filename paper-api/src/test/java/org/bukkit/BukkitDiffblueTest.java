package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BukkitDiffblueTest {
  /**
   * Test {@link Bukkit#getAverageTickTime()}.
   *
   * <p>Method under test: {@link Bukkit#getAverageTickTime()}
   */
  @Test
  @DisplayName("Test getAverageTickTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Bukkit.getAverageTickTime()"})
  void testGetAverageTickTime() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Bukkit.getAverageTickTime());
  }

  /**
   * Test {@link Bukkit#isOwnedByCurrentRegion(Block)} with {@code block}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Bukkit#isOwnedByCurrentRegion(Block)}
   */
  @Test
  @DisplayName(
      "Test isOwnedByCurrentRegion(Block) with 'block'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Bukkit.isOwnedByCurrentRegion(Block)"})
  void testIsOwnedByCurrentRegionWithBlock_thenThrowUnsupportedOperationException() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getLocation()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> Bukkit.isOwnedByCurrentRegion(block));
    verify(block).getLocation();
  }
}
