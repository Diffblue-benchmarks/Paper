package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.entity.EntityUnleashEvent.UnleashReason;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerUnleashEntityEventDiffblueTest {
  /**
   * Test {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player)}.
   *
   * <p>Method under test: {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player)}
   */
  @Test
  @DisplayName("Test new PlayerUnleashEntityEvent(Entity, Player)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerUnleashEntityEvent.<init>(Entity, Player)"})
  void testNewPlayerUnleashEntityEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);

    // Act
    PlayerUnleashEntityEvent actualPlayerUnleashEntityEvent =
        new PlayerUnleashEntityEvent(entity, player);

    // Assert
    assertEquals("PlayerUnleashEntityEvent", actualPlayerUnleashEntityEvent.getEventName());
    assertNull(actualPlayerUnleashEntityEvent.getEntityType());
    assertEquals(0, actualPlayerUnleashEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(UnleashReason.PLAYER_UNLEASH, actualPlayerUnleashEntityEvent.getReason());
    assertEquals(EquipmentSlot.HAND, actualPlayerUnleashEntityEvent.getHand());
    assertFalse(actualPlayerUnleashEntityEvent.isAsynchronous());
    assertFalse(actualPlayerUnleashEntityEvent.isDropLeash());
    assertFalse(actualPlayerUnleashEntityEvent.isCancelled());
    assertSame(entity, actualPlayerUnleashEntityEvent.getEntity());
    assertSame(player, actualPlayerUnleashEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player, EquipmentSlot)}.
   *
   * <p>Method under test: {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player,
   * EquipmentSlot)}
   */
  @Test
  @DisplayName("Test new PlayerUnleashEntityEvent(Entity, Player, EquipmentSlot)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerUnleashEntityEvent.<init>(Entity, Player, EquipmentSlot)"})
  void testNewPlayerUnleashEntityEvent2() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);

    // Act
    PlayerUnleashEntityEvent actualPlayerUnleashEntityEvent =
        new PlayerUnleashEntityEvent(entity, player, EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerUnleashEntityEvent", actualPlayerUnleashEntityEvent.getEventName());
    assertNull(actualPlayerUnleashEntityEvent.getEntityType());
    assertEquals(0, actualPlayerUnleashEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(UnleashReason.PLAYER_UNLEASH, actualPlayerUnleashEntityEvent.getReason());
    assertEquals(EquipmentSlot.HAND, actualPlayerUnleashEntityEvent.getHand());
    assertFalse(actualPlayerUnleashEntityEvent.isAsynchronous());
    assertFalse(actualPlayerUnleashEntityEvent.isDropLeash());
    assertFalse(actualPlayerUnleashEntityEvent.isCancelled());
    assertSame(entity, actualPlayerUnleashEntityEvent.getEntity());
    assertSame(player, actualPlayerUnleashEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player, EquipmentSlot,
   * boolean)}.
   *
   * <p>Method under test: {@link PlayerUnleashEntityEvent#PlayerUnleashEntityEvent(Entity, Player,
   * EquipmentSlot, boolean)}
   */
  @Test
  @DisplayName("Test new PlayerUnleashEntityEvent(Entity, Player, EquipmentSlot, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerUnleashEntityEvent.<init>(Entity, Player, EquipmentSlot, boolean)"
  })
  void testNewPlayerUnleashEntityEvent3() {
    // Arrange
    Entity entity = mock(Entity.class);
    Player player = mock(Player.class);

    // Act
    PlayerUnleashEntityEvent actualPlayerUnleashEntityEvent =
        new PlayerUnleashEntityEvent(entity, player, EquipmentSlot.HAND, true);

    // Assert
    assertEquals("PlayerUnleashEntityEvent", actualPlayerUnleashEntityEvent.getEventName());
    assertNull(actualPlayerUnleashEntityEvent.getEntityType());
    assertEquals(0, actualPlayerUnleashEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(UnleashReason.PLAYER_UNLEASH, actualPlayerUnleashEntityEvent.getReason());
    assertEquals(EquipmentSlot.HAND, actualPlayerUnleashEntityEvent.getHand());
    assertFalse(actualPlayerUnleashEntityEvent.isAsynchronous());
    assertFalse(actualPlayerUnleashEntityEvent.isCancelled());
    assertTrue(actualPlayerUnleashEntityEvent.isDropLeash());
    assertSame(entity, actualPlayerUnleashEntityEvent.getEntity());
    assertSame(player, actualPlayerUnleashEntityEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerUnleashEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerUnleashEntityEvent#getHand()}
   *   <li>{@link PlayerUnleashEntityEvent#getPlayer()}
   *   <li>{@link PlayerUnleashEntityEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EquipmentSlot PlayerUnleashEntityEvent.getHand()",
    "Player PlayerUnleashEntityEvent.getPlayer()",
    "boolean PlayerUnleashEntityEvent.isCancelled()",
    "void PlayerUnleashEntityEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerUnleashEntityEvent playerUnleashEntityEvent =
        new PlayerUnleashEntityEvent(mock(Entity.class), mock(Player.class));

    // Act
    playerUnleashEntityEvent.setCancelled(true);
    EquipmentSlot actualHand = playerUnleashEntityEvent.getHand();
    playerUnleashEntityEvent.getPlayer();

    // Assert
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertTrue(playerUnleashEntityEvent.isCancelled());
  }
}
