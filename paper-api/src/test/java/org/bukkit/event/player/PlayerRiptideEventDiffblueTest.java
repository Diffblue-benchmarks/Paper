package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerRiptideEventDiffblueTest {
  /**
   * Test {@link PlayerRiptideEvent#PlayerRiptideEvent(Player, ItemStack)}.
   *
   * <ul>
   *   <li>When {@link ItemStack}.
   *   <li>Then return EventName is {@code PlayerRiptideEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRiptideEvent#PlayerRiptideEvent(Player, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRiptideEvent(Player, ItemStack); when ItemStack; then return EventName is 'PlayerRiptideEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRiptideEvent.<init>(Player, ItemStack)"})
  void testNewPlayerRiptideEvent_whenItemStack_thenReturnEventNameIsPlayerRiptideEvent() {
    // Arrange
    Player player = mock(Player.class);
    ItemStack item = mock(ItemStack.class);

    // Act
    PlayerRiptideEvent actualPlayerRiptideEvent = new PlayerRiptideEvent(player, item);

    // Assert
    assertEquals("PlayerRiptideEvent", actualPlayerRiptideEvent.getEventName());
    Vector velocity = actualPlayerRiptideEvent.getVelocity();
    assertEquals(0, velocity.getBlockX());
    assertEquals(0, velocity.getBlockY());
    assertEquals(0, velocity.getBlockZ());
    assertEquals(0, actualPlayerRiptideEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(0.0d, velocity.getX());
    assertEquals(0.0d, velocity.getY());
    assertEquals(0.0d, velocity.getZ());
    assertEquals(0.0d, velocity.length());
    assertFalse(actualPlayerRiptideEvent.isAsynchronous());
    assertFalse(actualPlayerRiptideEvent.isCancelled());
    assertTrue(velocity.isZero());
    assertSame(player, actualPlayerRiptideEvent.getPlayer());
    assertSame(item, actualPlayerRiptideEvent.getItem());
  }

  /**
   * Test {@link PlayerRiptideEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Then return BlockX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRiptideEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); then return BlockX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PlayerRiptideEvent.getVelocity()"})
  void testGetVelocity_thenReturnBlockXIsZero() {
    // Arrange
    PlayerRiptideEvent playerRiptideEvent =
        new PlayerRiptideEvent(mock(Player.class), mock(ItemStack.class));

    // Act
    Vector actualVelocity = playerRiptideEvent.getVelocity();

    // Assert
    assertEquals(0, actualVelocity.getBlockX());
    assertEquals(0, actualVelocity.getBlockY());
    assertEquals(0, actualVelocity.getBlockZ());
    assertEquals(0.0d, actualVelocity.getX());
    assertEquals(0.0d, actualVelocity.getY());
    assertEquals(0.0d, actualVelocity.getZ());
    assertEquals(0.0d, actualVelocity.length());
    assertTrue(actualVelocity.isZero());
  }
}
