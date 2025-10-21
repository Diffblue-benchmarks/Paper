package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.boss.DragonBattle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DragonEggFormEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DragonEggFormEvent#DragonEggFormEvent(Block, BlockState, DragonBattle)}
   *   <li>{@link DragonEggFormEvent#getHandlerList()}
   *   <li>{@link DragonEggFormEvent#getDragonBattle()}
   *   <li>{@link DragonEggFormEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DragonEggFormEvent.<init>(Block, BlockState, DragonBattle)",
    "DragonBattle DragonEggFormEvent.getDragonBattle()",
    "HandlerList DragonEggFormEvent.getHandlerList()",
    "HandlerList DragonEggFormEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block block = mock(Block.class);
    BlockState newState = mock(BlockState.class);
    DragonBattle dragonBattle = mock(DragonBattle.class);

    // Act
    DragonEggFormEvent actualDragonEggFormEvent =
        new DragonEggFormEvent(block, newState, dragonBattle);
    HandlerList actualHandlerList = actualDragonEggFormEvent.getHandlerList();
    DragonBattle actualDragonBattle = actualDragonEggFormEvent.getDragonBattle();
    HandlerList actualHandlers = actualDragonEggFormEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualDragonEggFormEvent.isAsynchronous());
    assertFalse(actualDragonEggFormEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualDragonEggFormEvent.getBlock());
    assertSame(newState, actualDragonEggFormEvent.getNewState());
    assertSame(dragonBattle, actualDragonBattle);
  }
}
