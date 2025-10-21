package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDyeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDyeEvent#EntityDyeEvent(Entity, DyeColor, Player)}
   *   <li>{@link EntityDyeEvent#setCancelled(boolean)}
   *   <li>{@link EntityDyeEvent#setColor(DyeColor)}
   *   <li>{@link EntityDyeEvent#getHandlerList()}
   *   <li>{@link EntityDyeEvent#getColor()}
   *   <li>{@link EntityDyeEvent#getHandlers()}
   *   <li>{@link EntityDyeEvent#getPlayer()}
   *   <li>{@link EntityDyeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDyeEvent.<init>(Entity, DyeColor, Player)",
    "DyeColor EntityDyeEvent.getColor()",
    "HandlerList EntityDyeEvent.getHandlerList()",
    "HandlerList EntityDyeEvent.getHandlers()",
    "Player EntityDyeEvent.getPlayer()",
    "boolean EntityDyeEvent.isCancelled()",
    "void EntityDyeEvent.setCancelled(boolean)",
    "void EntityDyeEvent.setColor(DyeColor)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);

    // Act
    EntityDyeEvent actualEntityDyeEvent = new EntityDyeEvent(entity, DyeColor.WHITE, player);
    actualEntityDyeEvent.setCancelled(true);
    actualEntityDyeEvent.setColor(DyeColor.WHITE);
    HandlerList actualHandlerList = actualEntityDyeEvent.getHandlerList();
    DyeColor actualColor = actualEntityDyeEvent.getColor();
    HandlerList actualHandlers = actualEntityDyeEvent.getHandlers();
    Player actualPlayer = actualEntityDyeEvent.getPlayer();
    boolean actualIsCancelledResult = actualEntityDyeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(DyeColor.WHITE, actualColor);
    assertFalse(actualEntityDyeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityDyeEvent.getEntity());
    assertSame(player, actualPlayer);
  }
}
