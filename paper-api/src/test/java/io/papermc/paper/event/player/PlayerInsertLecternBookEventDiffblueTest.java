package io.papermc.paper.event.player;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerInsertLecternBookEventDiffblueTest {
  /**
   * Test {@link PlayerInsertLecternBookEvent#getLectern()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getState()} return {@link Lectern}.
   *   <li>Then calls {@link Block#getState()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInsertLecternBookEvent#getLectern()}
   */
  @Test
  @DisplayName("Test getLectern(); given Block getState() return Lectern; then calls getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Lectern PlayerInsertLecternBookEvent.getLectern()"})
  void testGetLectern_givenBlockGetStateReturnLectern_thenCallsGetState() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getState()).thenReturn(mock(Lectern.class));
    PlayerInsertLecternBookEvent playerInsertLecternBookEvent =
        new PlayerInsertLecternBookEvent(mock(Player.class), block, null);

    // Act
    playerInsertLecternBookEvent.getLectern();

    // Assert
    verify(block).getState();
  }
}
