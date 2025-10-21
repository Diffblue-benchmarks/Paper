package org.bukkit.event.player;

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
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerInteractEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerInteractEntityEvent#PlayerInteractEntityEvent(Player, Entity,
   *       EquipmentSlot)}
   *   <li>{@link PlayerInteractEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerInteractEntityEvent#getHandlerList()}
   *   <li>{@link PlayerInteractEntityEvent#getHand()}
   *   <li>{@link PlayerInteractEntityEvent#getHandlers()}
   *   <li>{@link PlayerInteractEntityEvent#getRightClicked()}
   *   <li>{@link PlayerInteractEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractEntityEvent.<init>(Player, Entity, EquipmentSlot)",
    "EquipmentSlot PlayerInteractEntityEvent.getHand()",
    "HandlerList PlayerInteractEntityEvent.getHandlerList()",
    "HandlerList PlayerInteractEntityEvent.getHandlers()",
    "Entity PlayerInteractEntityEvent.getRightClicked()",
    "boolean PlayerInteractEntityEvent.isCancelled()",
    "void PlayerInteractEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity clickedEntity = mock(Entity.class);

    // Act
    PlayerInteractEntityEvent actualPlayerInteractEntityEvent =
        new PlayerInteractEntityEvent(player, clickedEntity, EquipmentSlot.HAND);
    actualPlayerInteractEntityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerInteractEntityEvent.getHandlerList();
    EquipmentSlot actualHand = actualPlayerInteractEntityEvent.getHand();
    HandlerList actualHandlers = actualPlayerInteractEntityEvent.getHandlers();
    Entity actualRightClicked = actualPlayerInteractEntityEvent.getRightClicked();
    boolean actualIsCancelledResult = actualPlayerInteractEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualPlayerInteractEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(clickedEntity, actualRightClicked);
    assertSame(player, actualPlayerInteractEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractEntityEvent#PlayerInteractEntityEvent(Player, Entity)}.
   *
   * <p>Method under test: {@link PlayerInteractEntityEvent#PlayerInteractEntityEvent(Player,
   * Entity)}
   */
  @Test
  @DisplayName("Test new PlayerInteractEntityEvent(Player, Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractEntityEvent.<init>(Player, Entity)"})
  void testNewPlayerInteractEntityEvent() {
    // Arrange
    Player player = mock(Player.class);
    Entity clickedEntity = mock(Entity.class);

    // Act
    PlayerInteractEntityEvent actualPlayerInteractEntityEvent =
        new PlayerInteractEntityEvent(player, clickedEntity);

    // Assert
    assertEquals("PlayerInteractEntityEvent", actualPlayerInteractEntityEvent.getEventName());
    assertEquals(0, actualPlayerInteractEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractEntityEvent.getHand());
    assertFalse(actualPlayerInteractEntityEvent.isAsynchronous());
    assertFalse(actualPlayerInteractEntityEvent.isCancelled());
    assertSame(clickedEntity, actualPlayerInteractEntityEvent.getRightClicked());
    assertSame(player, actualPlayerInteractEntityEvent.getPlayer());
  }
}
