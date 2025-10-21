package org.bukkit.event.player;

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

class PlayerHideEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerHideEntityEvent#PlayerHideEntityEvent(Player, Entity)}
   *   <li>{@link PlayerHideEntityEvent#getHandlerList()}
   *   <li>{@link PlayerHideEntityEvent#getEntity()}
   *   <li>{@link PlayerHideEntityEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerHideEntityEvent.<init>(Player, Entity)",
    "Entity PlayerHideEntityEvent.getEntity()",
    "HandlerList PlayerHideEntityEvent.getHandlerList()",
    "HandlerList PlayerHideEntityEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);

    // Act
    PlayerHideEntityEvent actualPlayerHideEntityEvent = new PlayerHideEntityEvent(player, entity);
    HandlerList actualHandlerList = actualPlayerHideEntityEvent.getHandlerList();
    Entity actualEntity = actualPlayerHideEntityEvent.getEntity();
    HandlerList actualHandlers = actualPlayerHideEntityEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerHideEntityEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerHideEntityEvent.getPlayer());
  }
}
