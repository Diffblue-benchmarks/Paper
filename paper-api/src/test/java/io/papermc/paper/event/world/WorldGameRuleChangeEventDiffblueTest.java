package io.papermc.paper.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldGameRuleChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorldGameRuleChangeEvent#WorldGameRuleChangeEvent(World, CommandSender, GameRule,
   *       String)}
   *   <li>{@link WorldGameRuleChangeEvent#setCancelled(boolean)}
   *   <li>{@link WorldGameRuleChangeEvent#setValue(String)}
   *   <li>{@link WorldGameRuleChangeEvent#getHandlerList()}
   *   <li>{@link WorldGameRuleChangeEvent#getCommandSender()}
   *   <li>{@link WorldGameRuleChangeEvent#getGameRule()}
   *   <li>{@link WorldGameRuleChangeEvent#getHandlers()}
   *   <li>{@link WorldGameRuleChangeEvent#getValue()}
   *   <li>{@link WorldGameRuleChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorldGameRuleChangeEvent.<init>(World, CommandSender, GameRule, String)",
    "CommandSender WorldGameRuleChangeEvent.getCommandSender()",
    "GameRule WorldGameRuleChangeEvent.getGameRule()",
    "HandlerList WorldGameRuleChangeEvent.getHandlerList()",
    "HandlerList WorldGameRuleChangeEvent.getHandlers()",
    "String WorldGameRuleChangeEvent.getValue()",
    "boolean WorldGameRuleChangeEvent.isCancelled()",
    "void WorldGameRuleChangeEvent.setCancelled(boolean)",
    "void WorldGameRuleChangeEvent.setValue(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    BufferedCommandSender commandSender = new BufferedCommandSender();

    // Act
    WorldGameRuleChangeEvent actualWorldGameRuleChangeEvent =
        new WorldGameRuleChangeEvent(world, commandSender, null, "42");
    actualWorldGameRuleChangeEvent.setCancelled(true);
    actualWorldGameRuleChangeEvent.setValue("42");
    HandlerList actualHandlerList = actualWorldGameRuleChangeEvent.getHandlerList();
    CommandSender actualCommandSender = actualWorldGameRuleChangeEvent.getCommandSender();
    GameRule<?> actualGameRule = actualWorldGameRuleChangeEvent.getGameRule();
    HandlerList actualHandlers = actualWorldGameRuleChangeEvent.getHandlers();
    String actualValue = actualWorldGameRuleChangeEvent.getValue();
    boolean actualIsCancelledResult = actualWorldGameRuleChangeEvent.isCancelled();

    // Assert
    assertEquals("42", actualValue);
    assertNull(actualGameRule);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualWorldGameRuleChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(commandSender, actualCommandSender);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorldGameRuleChangeEvent.getWorld());
  }
}
