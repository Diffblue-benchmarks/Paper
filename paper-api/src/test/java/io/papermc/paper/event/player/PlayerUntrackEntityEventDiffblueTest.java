package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerUntrackEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerUntrackEntityEvent#PlayerUntrackEntityEvent(Player, Entity)}
   *   <li>{@link PlayerUntrackEntityEvent#getHandlerList()}
   *   <li>{@link PlayerUntrackEntityEvent#getEntity()}
   *   <li>{@link PlayerUntrackEntityEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerUntrackEntityEvent.<init>(Player, Entity)",
    "Entity PlayerUntrackEntityEvent.getEntity()",
    "HandlerList PlayerUntrackEntityEvent.getHandlerList()",
    "HandlerList PlayerUntrackEntityEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);

    // Act
    PlayerUntrackEntityEvent actualPlayerUntrackEntityEvent =
        new PlayerUntrackEntityEvent(player, entity);
    HandlerList actualHandlerList = actualPlayerUntrackEntityEvent.getHandlerList();
    Entity actualEntity = actualPlayerUntrackEntityEvent.getEntity();
    HandlerList actualHandlers = actualPlayerUntrackEntityEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerUntrackEntityEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerUntrackEntityEvent.getPlayer());
  }
}
