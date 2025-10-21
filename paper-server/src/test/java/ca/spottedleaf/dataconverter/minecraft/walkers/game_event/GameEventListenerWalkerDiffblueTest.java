package ca.spottedleaf.dataconverter.minecraft.walkers.game_event;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GameEventListenerWalkerDiffblueTest {
  /**
   * Test {@link GameEventListenerWalker#walk(MapType, long, long)} with {@code data}, {@code
   * fromVersion}, {@code toVersion}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GameEventListenerWalker#walk(MapType, long, long)}
   */
  @Test
  @DisplayName(
      "Test walk(MapType, long, long) with 'data', 'fromVersion', 'toVersion'; when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapType GameEventListenerWalker.walk(MapType, long, long)"})
  void testWalkWithDataFromVersionToVersion_whenNBTMapType_thenReturnNull() {
    // Arrange
    GameEventListenerWalker gameEventListenerWalker = new GameEventListenerWalker();

    // Act and Assert
    assertNull(gameEventListenerWalker.walk(new NBTMapType(), 1L, 1L));
  }
}
