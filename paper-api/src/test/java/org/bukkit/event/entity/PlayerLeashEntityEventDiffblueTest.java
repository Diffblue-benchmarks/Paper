package org.bukkit.event.entity;

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

class PlayerLeashEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerLeashEntityEvent#PlayerLeashEntityEvent(Entity, Entity, Player,
   *       EquipmentSlot)}
   *   <li>{@link PlayerLeashEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerLeashEntityEvent#getHandlerList()}
   *   <li>{@link PlayerLeashEntityEvent#getEntity()}
   *   <li>{@link PlayerLeashEntityEvent#getHand()}
   *   <li>{@link PlayerLeashEntityEvent#getHandlers()}
   *   <li>{@link PlayerLeashEntityEvent#getLeashHolder()}
   *   <li>{@link PlayerLeashEntityEvent#getPlayer()}
   *   <li>{@link PlayerLeashEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLeashEntityEvent.<init>(Entity, Entity, Player, EquipmentSlot)",
    "Entity PlayerLeashEntityEvent.getEntity()",
    "EquipmentSlot PlayerLeashEntityEvent.getHand()",
    "HandlerList PlayerLeashEntityEvent.getHandlerList()",
    "HandlerList PlayerLeashEntityEvent.getHandlers()",
    "Entity PlayerLeashEntityEvent.getLeashHolder()",
    "Player PlayerLeashEntityEvent.getPlayer()",
    "boolean PlayerLeashEntityEvent.isCancelled()",
    "void PlayerLeashEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity leashHolder = mock(Entity.class);
    Player leasher = mock(Player.class);

    // Act
    PlayerLeashEntityEvent actualPlayerLeashEntityEvent =
        new PlayerLeashEntityEvent(entity, leashHolder, leasher, EquipmentSlot.HAND);
    actualPlayerLeashEntityEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerLeashEntityEvent.getHandlerList();
    Entity actualEntity = actualPlayerLeashEntityEvent.getEntity();
    EquipmentSlot actualHand = actualPlayerLeashEntityEvent.getHand();
    HandlerList actualHandlers = actualPlayerLeashEntityEvent.getHandlers();
    Entity actualLeashHolder = actualPlayerLeashEntityEvent.getLeashHolder();
    Player actualPlayer = actualPlayerLeashEntityEvent.getPlayer();
    boolean actualIsCancelledResult = actualPlayerLeashEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualPlayerLeashEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntity);
    assertSame(leashHolder, actualLeashHolder);
    assertSame(leasher, actualPlayer);
  }

  /**
   * Test {@link PlayerLeashEntityEvent#PlayerLeashEntityEvent(Entity, Entity, Player)}.
   *
   * <p>Method under test: {@link PlayerLeashEntityEvent#PlayerLeashEntityEvent(Entity, Entity,
   * Player)}
   */
  @Test
  @DisplayName("Test new PlayerLeashEntityEvent(Entity, Entity, Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerLeashEntityEvent.<init>(Entity, Entity, Player)"})
  void testNewPlayerLeashEntityEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity leashHolder = mock(Entity.class);
    Player leasher = mock(Player.class);

    // Act
    PlayerLeashEntityEvent actualPlayerLeashEntityEvent =
        new PlayerLeashEntityEvent(entity, leashHolder, leasher);

    // Assert
    assertEquals("PlayerLeashEntityEvent", actualPlayerLeashEntityEvent.getEventName());
    assertEquals(0, actualPlayerLeashEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerLeashEntityEvent.getHand());
    assertFalse(actualPlayerLeashEntityEvent.isAsynchronous());
    assertFalse(actualPlayerLeashEntityEvent.isCancelled());
    assertSame(entity, actualPlayerLeashEntityEvent.getEntity());
    assertSame(leashHolder, actualPlayerLeashEntityEvent.getLeashHolder());
    assertSame(leasher, actualPlayerLeashEntityEvent.getPlayer());
  }
}
