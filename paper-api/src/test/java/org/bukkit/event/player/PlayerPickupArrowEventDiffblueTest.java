package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPickupArrowEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPickupArrowEvent#PlayerPickupArrowEvent(Player, Item, AbstractArrow)}
   *   <li>{@link PlayerPickupArrowEvent#getArrow()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPickupArrowEvent.<init>(Player, Item, AbstractArrow)",
    "AbstractArrow PlayerPickupArrowEvent.getArrow()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Item item = mock(Item.class);
    AbstractArrow arrow = mock(AbstractArrow.class);

    // Act
    PlayerPickupArrowEvent actualPlayerPickupArrowEvent =
        new PlayerPickupArrowEvent(player, item, arrow);
    AbstractArrow actualArrow = actualPlayerPickupArrowEvent.getArrow();

    // Assert
    assertEquals(0, actualPlayerPickupArrowEvent.getRemaining());
    assertFalse(actualPlayerPickupArrowEvent.isAsynchronous());
    assertFalse(actualPlayerPickupArrowEvent.isCancelled());
    assertTrue(actualPlayerPickupArrowEvent.getFlyAtPlayer());
    assertSame(arrow, actualArrow);
    assertSame(item, actualPlayerPickupArrowEvent.getItem());
    assertSame(player, actualPlayerPickupArrowEvent.getPlayer());
  }
}
