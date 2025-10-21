package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerTrackEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerTrackEntityEvent#PlayerTrackEntityEvent(Player, Entity)}
   *   <li>{@link PlayerTrackEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerTrackEntityEvent#getHandlerList()}
   *   <li>{@link PlayerTrackEntityEvent#getEntity()}
   *   <li>{@link PlayerTrackEntityEvent#getHandlers()}
   *   <li>{@link PlayerTrackEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTrackEntityEvent.<init>(Player, Entity)",
    "Entity PlayerTrackEntityEvent.getEntity()",
    "HandlerList PlayerTrackEntityEvent.getHandlerList()",
    "HandlerList PlayerTrackEntityEvent.getHandlers()",
    "boolean PlayerTrackEntityEvent.isCancelled()",
    "void PlayerTrackEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);

    // Act
    PlayerTrackEntityEvent actualPlayerTrackEntityEvent =
        new PlayerTrackEntityEvent(player, entity);
    actualPlayerTrackEntityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerTrackEntityEvent.getHandlerList();
    Entity actualEntity = actualPlayerTrackEntityEvent.getEntity();
    HandlerList actualHandlers = actualPlayerTrackEntityEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerTrackEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerTrackEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerTrackEntityEvent.getPlayer());
  }
}
