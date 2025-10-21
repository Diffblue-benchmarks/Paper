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
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerInteractAtEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerInteractAtEntityEvent#PlayerInteractAtEntityEvent(Player, Entity, Vector,
   *       EquipmentSlot)}
   *   <li>{@link PlayerInteractAtEntityEvent#getHandlerList()}
   *   <li>{@link PlayerInteractAtEntityEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerInteractAtEntityEvent.<init>(Player, Entity, Vector, EquipmentSlot)",
    "HandlerList PlayerInteractAtEntityEvent.getHandlerList()",
    "HandlerList PlayerInteractAtEntityEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity clickedEntity = mock(Entity.class);

    // Act
    PlayerInteractAtEntityEvent actualPlayerInteractAtEntityEvent =
        new PlayerInteractAtEntityEvent(
            player, clickedEntity, Vector.getRandom(), EquipmentSlot.HAND);
    HandlerList actualHandlerList = actualPlayerInteractAtEntityEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerInteractAtEntityEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractAtEntityEvent.getHand());
    assertFalse(actualPlayerInteractAtEntityEvent.isAsynchronous());
    assertFalse(actualPlayerInteractAtEntityEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(clickedEntity, actualPlayerInteractAtEntityEvent.getRightClicked());
    assertSame(player, actualPlayerInteractAtEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractAtEntityEvent#PlayerInteractAtEntityEvent(Player, Entity, Vector)}.
   *
   * <p>Method under test: {@link PlayerInteractAtEntityEvent#PlayerInteractAtEntityEvent(Player,
   * Entity, Vector)}
   */
  @Test
  @DisplayName("Test new PlayerInteractAtEntityEvent(Player, Entity, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerInteractAtEntityEvent.<init>(Player, Entity, Vector)"})
  void testNewPlayerInteractAtEntityEvent() {
    // Arrange
    Player player = mock(Player.class);
    Entity clickedEntity = mock(Entity.class);
    Vector position = Vector.getRandom();

    // Act
    PlayerInteractAtEntityEvent actualPlayerInteractAtEntityEvent =
        new PlayerInteractAtEntityEvent(player, clickedEntity, position);

    // Assert
    assertEquals("PlayerInteractAtEntityEvent", actualPlayerInteractAtEntityEvent.getEventName());
    assertEquals(
        0, actualPlayerInteractAtEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerInteractAtEntityEvent.getHand());
    assertFalse(actualPlayerInteractAtEntityEvent.isAsynchronous());
    assertFalse(actualPlayerInteractAtEntityEvent.isCancelled());
    assertEquals(position, actualPlayerInteractAtEntityEvent.getClickedPosition());
    assertSame(clickedEntity, actualPlayerInteractAtEntityEvent.getRightClicked());
    assertSame(player, actualPlayerInteractAtEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerInteractAtEntityEvent#getClickedPosition()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractAtEntityEvent#getClickedPosition()}
   */
  @Test
  @DisplayName("Test getClickedPosition(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerInteractAtEntityEvent.getClickedPosition()"})
  void testGetClickedPosition_thenReturnBlockVector() {
    // Arrange
    Player player = mock(Player.class);
    Entity clickedEntity = mock(Entity.class);
    BlockVector position = new BlockVector(2.0d, 3.0d, 10.0d);

    PlayerInteractAtEntityEvent playerInteractAtEntityEvent =
        new PlayerInteractAtEntityEvent(player, clickedEntity, position);

    // Act
    Vector actualClickedPosition = playerInteractAtEntityEvent.getClickedPosition();

    // Assert
    assertTrue(actualClickedPosition instanceof BlockVector);
    assertEquals(position, actualClickedPosition);
  }

  /**
   * Test {@link PlayerInteractAtEntityEvent#getClickedPosition()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link PlayerInteractAtEntityEvent#getClickedPosition()}
   */
  @Test
  @DisplayName("Test getClickedPosition(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerInteractAtEntityEvent.getClickedPosition()"})
  void testGetClickedPosition_thenReturnRandom() {
    // Arrange
    Vector position = Vector.getRandom();
    PlayerInteractAtEntityEvent playerInteractAtEntityEvent =
        new PlayerInteractAtEntityEvent(mock(Player.class), mock(Entity.class), position);

    // Act and Assert
    assertEquals(position, playerInteractAtEntityEvent.getClickedPosition());
  }
}
