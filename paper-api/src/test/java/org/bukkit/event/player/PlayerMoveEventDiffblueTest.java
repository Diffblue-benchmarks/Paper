package org.bukkit.event.player;

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

class PlayerMoveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerMoveEvent#PlayerMoveEvent(Player, Location, Location)}
   *   <li>{@link PlayerMoveEvent#setCancelled(boolean)}
   *   <li>{@link PlayerMoveEvent#getHandlerList()}
   *   <li>{@link PlayerMoveEvent#getFrom()}
   *   <li>{@link PlayerMoveEvent#getHandlers()}
   *   <li>{@link PlayerMoveEvent#getTo()}
   *   <li>{@link PlayerMoveEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerMoveEvent.<init>(Player, Location, Location)",
    "Location PlayerMoveEvent.getFrom()",
    "HandlerList PlayerMoveEvent.getHandlerList()",
    "HandlerList PlayerMoveEvent.getHandlers()",
    "Location PlayerMoveEvent.getTo()",
    "boolean PlayerMoveEvent.isCancelled()",
    "void PlayerMoveEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerMoveEvent actualPlayerMoveEvent = new PlayerMoveEvent(player, from, resultTo);
    actualPlayerMoveEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerMoveEvent.getHandlerList();
    Location actualFrom = actualPlayerMoveEvent.getFrom();
    HandlerList actualHandlers = actualPlayerMoveEvent.getHandlers();
    Location actualTo = actualPlayerMoveEvent.getTo();
    boolean actualIsCancelledResult = actualPlayerMoveEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerMoveEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(from, actualFrom);
    assertSame(resultTo, actualTo);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerMoveEvent.getPlayer());
  }

  /**
   * Test {@link PlayerMoveEvent#setFrom(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#setFrom(Location)}
   */
  @Test
  @DisplayName("Test setFrom(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerMoveEvent.setFrom(Location)"})
  void testSetFrom_givenWorld_thenCallsClone() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    Location from2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(from2.clone()).thenReturn(location);
    when(from2.getWorld()).thenReturn(mock(World.class));

    // Act
    playerMoveEvent.setFrom(from2);

    // Assert
    verify(from2).clone();
    verify(from2).getWorld();
  }

  /**
   * Test {@link PlayerMoveEvent#setTo(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#setTo(Location)}
   */
  @Test
  @DisplayName("Test setTo(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerMoveEvent.setTo(Location)"})
  void testSetTo_givenWorld_thenCallsClone() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    Location resultTo2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(resultTo2.clone()).thenReturn(location);
    when(resultTo2.getWorld()).thenReturn(mock(World.class));

    // Act
    playerMoveEvent.setTo(resultTo2);

    // Assert
    verify(resultTo2).clone();
    verify(resultTo2).getWorld();
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedPosition()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName("Test hasChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setWorld(mock(World.class));

    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    resultTo.setWorld(null);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(mock(Player.class), from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is three and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is three and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsThreeAndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is two.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is two and y is three and z is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTwo() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is two and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is two and y is two and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsTwoAndYIsTwoAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName("Test hasChangedPosition(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_thenReturnTrue() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition2() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition3() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertFalse(playerMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName("Test hasChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setWorld(mock(World.class));

    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    resultTo.setWorld(null);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(mock(Player.class), from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is three and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is three and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsThreeAndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is two.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is two and y is three and z is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTwo() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is two and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is two and y is two and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsTwoAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName("Test hasChangedBlock(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_thenReturnTrue() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock2() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasExplicitlyChangedBlock(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is two and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasExplicitlyChangedBlock(); given Location(World, double, double, double) with World and x is two and y is two and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsTwoAndZIsTen() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertFalse(playerMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedOrientation()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d, 10.0f, 10.0f);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedOrientation());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedOrientation()}.
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation2() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setYaw(10.0f);
    Player player = mock(Player.class);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerMoveEvent.hasChangedOrientation());
  }

  /**
   * Test {@link PlayerMoveEvent#hasChangedOrientation()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(player, from, resultTo);

    // Act and Assert
    assertFalse(playerMoveEvent.hasChangedOrientation());
  }
}
