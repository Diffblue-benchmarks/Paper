package io.papermc.paper.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldDifficultyChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldDifficultyChangeEvent#WorldDifficultyChangeEvent(World, CommandSourceStack,
   *       Difficulty)}
   *   <li>{@link WorldDifficultyChangeEvent#getHandlerList()}
   *   <li>{@link WorldDifficultyChangeEvent#getCommandSource()}
   *   <li>{@link WorldDifficultyChangeEvent#getDifficulty()}
   *   <li>{@link WorldDifficultyChangeEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldDifficultyChangeEvent.<init>(World, CommandSourceStack, Difficulty)",
    "CommandSourceStack WorldDifficultyChangeEvent.getCommandSource()",
    "Difficulty WorldDifficultyChangeEvent.getDifficulty()",
    "HandlerList WorldDifficultyChangeEvent.getHandlerList()",
    "HandlerList WorldDifficultyChangeEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    CommandSourceStack commandSource = mock(CommandSourceStack.class);

    // Act
    WorldDifficultyChangeEvent actualWorldDifficultyChangeEvent =
        new WorldDifficultyChangeEvent(world, commandSource, Difficulty.PEACEFUL);
    HandlerList actualHandlerList = actualWorldDifficultyChangeEvent.getHandlerList();
    CommandSourceStack actualCommandSource = actualWorldDifficultyChangeEvent.getCommandSource();
    Difficulty actualDifficulty = actualWorldDifficultyChangeEvent.getDifficulty();
    HandlerList actualHandlers = actualWorldDifficultyChangeEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Difficulty.PEACEFUL, actualDifficulty);
    assertFalse(actualWorldDifficultyChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(commandSource, actualCommandSource);
    assertSame(world, actualWorldDifficultyChangeEvent.getWorld());
  }
}
