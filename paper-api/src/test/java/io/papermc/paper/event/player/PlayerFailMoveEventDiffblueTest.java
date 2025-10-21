package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.player.PlayerFailMoveEvent.FailReason;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerFailMoveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerFailMoveEvent#PlayerFailMoveEvent(Player, FailReason, boolean, boolean,
   *       Location, Location)}
   *   <li>{@link PlayerFailMoveEvent#setAllowed(boolean)}
   *   <li>{@link PlayerFailMoveEvent#setLogWarning(boolean)}
   *   <li>{@link PlayerFailMoveEvent#getHandlerList()}
   *   <li>{@link PlayerFailMoveEvent#getFailReason()}
   *   <li>{@link PlayerFailMoveEvent#getHandlers()}
   *   <li>{@link PlayerFailMoveEvent#getLogWarning()}
   *   <li>{@link PlayerFailMoveEvent#isAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerFailMoveEvent.<init>(Player, FailReason, boolean, boolean, Location, Location)",
    "FailReason PlayerFailMoveEvent.getFailReason()",
    "HandlerList PlayerFailMoveEvent.getHandlerList()",
    "HandlerList PlayerFailMoveEvent.getHandlers()",
    "boolean PlayerFailMoveEvent.getLogWarning()",
    "boolean PlayerFailMoveEvent.isAllowed()",
    "void PlayerFailMoveEvent.setAllowed(boolean)",
    "void PlayerFailMoveEvent.setLogWarning(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerFailMoveEvent actualPlayerFailMoveEvent =
        new PlayerFailMoveEvent(
            player, FailReason.MOVED_INTO_UNLOADED_CHUNK, true, true, from, resultTo);
    actualPlayerFailMoveEvent.setAllowed(true);
    actualPlayerFailMoveEvent.setLogWarning(true);
    HandlerList actualHandlerList = actualPlayerFailMoveEvent.getHandlerList();
    FailReason actualFailReason = actualPlayerFailMoveEvent.getFailReason();
    HandlerList actualHandlers = actualPlayerFailMoveEvent.getHandlers();
    boolean actualLogWarning = actualPlayerFailMoveEvent.getLogWarning();
    boolean actualIsAllowedResult = actualPlayerFailMoveEvent.isAllowed();

    // Assert
    assertEquals(FailReason.MOVED_INTO_UNLOADED_CHUNK, actualFailReason);
    assertFalse(actualPlayerFailMoveEvent.isAsynchronous());
    assertTrue(actualLogWarning);
    assertTrue(actualIsAllowedResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerFailMoveEvent.getPlayer());
  }

  /**
   * Test {@link PlayerFailMoveEvent#getFrom()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerFailMoveEvent#getFrom()}
   */
  @Test
  @DisplayName(
      "Test getFrom(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PlayerFailMoveEvent.getFrom()"})
  void testGetFrom_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(
        from,
        new PlayerFailMoveEvent(
                player, FailReason.MOVED_INTO_UNLOADED_CHUNK, true, true, from, resultTo)
            .getFrom());
  }

  /**
   * Test {@link PlayerFailMoveEvent#getTo()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerFailMoveEvent#getTo()}
   */
  @Test
  @DisplayName(
      "Test getTo(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PlayerFailMoveEvent.getTo()"})
  void testGetTo_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(
        resultTo,
        new PlayerFailMoveEvent(
                player, FailReason.MOVED_INTO_UNLOADED_CHUNK, true, true, from, resultTo)
            .getTo());
  }
}
