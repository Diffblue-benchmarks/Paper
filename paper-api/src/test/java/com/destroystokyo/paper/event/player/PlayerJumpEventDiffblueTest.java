package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerJumpEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerJumpEvent#PlayerJumpEvent(Player, Location, Location)}
   *   <li>{@link PlayerJumpEvent#setCancelled(boolean)}
   *   <li>{@link PlayerJumpEvent#getHandlerList()}
   *   <li>{@link PlayerJumpEvent#getFrom()}
   *   <li>{@link PlayerJumpEvent#getHandlers()}
   *   <li>{@link PlayerJumpEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerJumpEvent.<init>(Player, Location, Location)",
    "Location PlayerJumpEvent.getFrom()",
    "HandlerList PlayerJumpEvent.getHandlerList()",
    "HandlerList PlayerJumpEvent.getHandlers()",
    "boolean PlayerJumpEvent.isCancelled()",
    "void PlayerJumpEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerJumpEvent actualPlayerJumpEvent = new PlayerJumpEvent(player, from, resultTo);
    actualPlayerJumpEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerJumpEvent.getHandlerList();
    Location actualFrom = actualPlayerJumpEvent.getFrom();
    HandlerList actualHandlers = actualPlayerJumpEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerJumpEvent.isCancelled();

    // Assert
    assertFalse(actualPlayerJumpEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(from, actualFrom);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerJumpEvent.getPlayer());
  }

  /**
   * Test {@link PlayerJumpEvent#setFrom(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJumpEvent#setFrom(Location)}
   */
  @Test
  @DisplayName("Test setFrom(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerJumpEvent.setFrom(Location)"})
  void testSetFrom_givenWorld_thenCallsClone() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerJumpEvent playerJumpEvent = new PlayerJumpEvent(player, from, resultTo);

    Location from2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(from2.clone()).thenReturn(location);
    when(from2.getWorld()).thenReturn(mock(World.class));

    // Act
    playerJumpEvent.setFrom(from2);

    // Assert
    verify(from2).clone();
    verify(from2).getWorld();
  }

  /**
   * Test {@link PlayerJumpEvent#getTo()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerJumpEvent#getTo()}
   */
  @Test
  @DisplayName(
      "Test getTo(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PlayerJumpEvent.getTo()"})
  void testGetTo_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerJumpEvent playerJumpEvent = new PlayerJumpEvent(player, from, resultTo);

    // Act and Assert
    assertEquals(resultTo, playerJumpEvent.getTo());
  }
}
