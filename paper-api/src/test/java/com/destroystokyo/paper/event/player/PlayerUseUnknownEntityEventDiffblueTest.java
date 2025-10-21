package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerUseUnknownEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerUseUnknownEntityEvent#PlayerUseUnknownEntityEvent(Player, int, boolean,
   *       EquipmentSlot, Vector)}
   *   <li>{@link PlayerUseUnknownEntityEvent#getHandlerList()}
   *   <li>{@link PlayerUseUnknownEntityEvent#getEntityId()}
   *   <li>{@link PlayerUseUnknownEntityEvent#getHand()}
   *   <li>{@link PlayerUseUnknownEntityEvent#getHandlers()}
   *   <li>{@link PlayerUseUnknownEntityEvent#isAttack()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerUseUnknownEntityEvent.<init>(Player, int, boolean, EquipmentSlot, Vector)",
    "int PlayerUseUnknownEntityEvent.getEntityId()",
    "EquipmentSlot PlayerUseUnknownEntityEvent.getHand()",
    "HandlerList PlayerUseUnknownEntityEvent.getHandlerList()",
    "HandlerList PlayerUseUnknownEntityEvent.getHandlers()",
    "boolean PlayerUseUnknownEntityEvent.isAttack()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerUseUnknownEntityEvent actualPlayerUseUnknownEntityEvent =
        new PlayerUseUnknownEntityEvent(player, 1, true, EquipmentSlot.HAND, Vector.getRandom());
    HandlerList actualHandlerList = actualPlayerUseUnknownEntityEvent.getHandlerList();
    int actualEntityId = actualPlayerUseUnknownEntityEvent.getEntityId();
    EquipmentSlot actualHand = actualPlayerUseUnknownEntityEvent.getHand();
    HandlerList actualHandlers = actualPlayerUseUnknownEntityEvent.getHandlers();
    boolean actualIsAttackResult = actualPlayerUseUnknownEntityEvent.isAttack();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualEntityId);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualPlayerUseUnknownEntityEvent.isAsynchronous());
    assertTrue(actualIsAttackResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerUseUnknownEntityEvent.getPlayer());
  }

  /**
   * Test {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}
   */
  @Test
  @DisplayName("Test getClickedRelativePosition(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerUseUnknownEntityEvent.getClickedRelativePosition()"})
  void testGetClickedRelativePosition_thenReturnBlockVector() {
    // Arrange
    Player player = mock(Player.class);
    BlockVector clickedPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    Vector actualClickedRelativePosition =
        new PlayerUseUnknownEntityEvent(player, 1, true, EquipmentSlot.HAND, clickedPosition)
            .getClickedRelativePosition();

    // Assert
    assertTrue(actualClickedRelativePosition instanceof BlockVector);
    assertEquals(clickedPosition, actualClickedRelativePosition);
  }

  /**
   * Test {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}
   */
  @Test
  @DisplayName("Test getClickedRelativePosition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerUseUnknownEntityEvent.getClickedRelativePosition()"})
  void testGetClickedRelativePosition_thenReturnNull() {
    // Arrange
    PlayerUseUnknownEntityEvent playerUseUnknownEntityEvent =
        new PlayerUseUnknownEntityEvent(mock(Player.class), 1, true, EquipmentSlot.HAND, null);

    // Act and Assert
    assertNull(playerUseUnknownEntityEvent.getClickedRelativePosition());
  }

  /**
   * Test {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link PlayerUseUnknownEntityEvent#getClickedRelativePosition()}
   */
  @Test
  @DisplayName("Test getClickedRelativePosition(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerUseUnknownEntityEvent.getClickedRelativePosition()"})
  void testGetClickedRelativePosition_thenReturnRandom() {
    // Arrange
    Vector clickedPosition = Vector.getRandom();

    // Act and Assert
    assertEquals(
        clickedPosition,
        new PlayerUseUnknownEntityEvent(
                mock(Player.class), 1, true, EquipmentSlot.HAND, clickedPosition)
            .getClickedRelativePosition());
  }
}
