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

class PlayerShowEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerShowEntityEvent#PlayerShowEntityEvent(Player, Entity)}
   *   <li>{@link PlayerShowEntityEvent#getHandlerList()}
   *   <li>{@link PlayerShowEntityEvent#getEntity()}
   *   <li>{@link PlayerShowEntityEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerShowEntityEvent.<init>(Player, Entity)",
    "Entity PlayerShowEntityEvent.getEntity()",
    "HandlerList PlayerShowEntityEvent.getHandlerList()",
    "HandlerList PlayerShowEntityEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);

    // Act
    PlayerShowEntityEvent actualPlayerShowEntityEvent = new PlayerShowEntityEvent(player, entity);
    HandlerList actualHandlerList = actualPlayerShowEntityEvent.getHandlerList();
    Entity actualEntity = actualPlayerShowEntityEvent.getEntity();
    HandlerList actualHandlers = actualPlayerShowEntityEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerShowEntityEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerShowEntityEvent.getPlayer());
  }
}
