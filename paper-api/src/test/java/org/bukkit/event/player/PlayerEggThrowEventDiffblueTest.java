package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerEggThrowEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerEggThrowEvent#PlayerEggThrowEvent(Player, Egg, boolean, byte, EntityType)}
   *   <li>{@link PlayerEggThrowEvent#setHatching(boolean)}
   *   <li>{@link PlayerEggThrowEvent#setNumHatches(byte)}
   *   <li>{@link PlayerEggThrowEvent#getHandlerList()}
   *   <li>{@link PlayerEggThrowEvent#getEgg()}
   *   <li>{@link PlayerEggThrowEvent#getHandlers()}
   *   <li>{@link PlayerEggThrowEvent#getHatchingType()}
   *   <li>{@link PlayerEggThrowEvent#getNumHatches()}
   *   <li>{@link PlayerEggThrowEvent#isHatching()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerEggThrowEvent.<init>(Player, Egg, boolean, byte, EntityType)",
    "Egg PlayerEggThrowEvent.getEgg()",
    "HandlerList PlayerEggThrowEvent.getHandlerList()",
    "HandlerList PlayerEggThrowEvent.getHandlers()",
    "EntityType PlayerEggThrowEvent.getHatchingType()",
    "byte PlayerEggThrowEvent.getNumHatches()",
    "boolean PlayerEggThrowEvent.isHatching()",
    "void PlayerEggThrowEvent.setHatching(boolean)",
    "void PlayerEggThrowEvent.setNumHatches(byte)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Egg egg = mock(Egg.class);

    // Act
    PlayerEggThrowEvent actualPlayerEggThrowEvent =
        new PlayerEggThrowEvent(player, egg, true, (byte) 'A', EntityType.ACACIA_BOAT);
    actualPlayerEggThrowEvent.setHatching(true);
    actualPlayerEggThrowEvent.setNumHatches((byte) 'A');
    HandlerList actualHandlerList = actualPlayerEggThrowEvent.getHandlerList();
    Egg actualEgg = actualPlayerEggThrowEvent.getEgg();
    HandlerList actualHandlers = actualPlayerEggThrowEvent.getHandlers();
    EntityType actualHatchingType = actualPlayerEggThrowEvent.getHatchingType();
    byte actualNumHatches = actualPlayerEggThrowEvent.getNumHatches();
    boolean actualIsHatchingResult = actualPlayerEggThrowEvent.isHatching();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EntityType.ACACIA_BOAT, actualHatchingType);
    assertFalse(actualPlayerEggThrowEvent.isAsynchronous());
    assertTrue(actualIsHatchingResult);
    assertEquals('A', actualNumHatches);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(egg, actualEgg);
    assertSame(player, actualPlayerEggThrowEvent.getPlayer());
  }
}
