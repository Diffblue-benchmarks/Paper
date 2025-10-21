package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.block.Block;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SignChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SignChangeEvent#SignChangeEvent(Block, Player, List, Side)}
   *   <li>{@link SignChangeEvent#setCancelled(boolean)}
   *   <li>{@link SignChangeEvent#getHandlerList()}
   *   <li>{@link SignChangeEvent#getHandlers()}
   *   <li>{@link SignChangeEvent#getPlayer()}
   *   <li>{@link SignChangeEvent#getSide()}
   *   <li>{@link SignChangeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SignChangeEvent.<init>(Block, Player, List, Side)",
    "HandlerList SignChangeEvent.getHandlerList()",
    "HandlerList SignChangeEvent.getHandlers()",
    "Player SignChangeEvent.getPlayer()",
    "Side SignChangeEvent.getSide()",
    "boolean SignChangeEvent.isCancelled()",
    "void SignChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    SignChangeEvent actualSignChangeEvent =
        new SignChangeEvent(sign, player, new ArrayList<>(), Side.FRONT);
    actualSignChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSignChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualSignChangeEvent.getHandlers();
    Player actualPlayer = actualSignChangeEvent.getPlayer();
    Side actualSide = actualSignChangeEvent.getSide();
    boolean actualIsCancelledResult = actualSignChangeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSide);
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(player, actualPlayer);
  }

  /**
   * Test {@link SignChangeEvent#SignChangeEvent(Block, Player, String[])}.
   *
   * <p>Method under test: {@link SignChangeEvent#SignChangeEvent(Block, Player, String[])}
   */
  @Test
  @DisplayName("Test new SignChangeEvent(Block, Player, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignChangeEvent.<init>(Block, Player, String[])"})
  void testNewSignChangeEvent() {
    // Arrange
    Block sign = mock(Block.class);
    Player thePlayer = mock(Player.class);
    String[] theLines = new String[] {"The Lines"};

    // Act
    SignChangeEvent actualSignChangeEvent = new SignChangeEvent(sign, thePlayer, theLines);

    // Assert
    assertEquals("SignChangeEvent", actualSignChangeEvent.getEventName());
    assertEquals(0, actualSignChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSignChangeEvent.getSide());
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertFalse(actualSignChangeEvent.isCancelled());
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(thePlayer, actualSignChangeEvent.getPlayer());
    assertArrayEquals(new String[] {"The Lines"}, actualSignChangeEvent.getLines());
  }

  /**
   * Test {@link SignChangeEvent#SignChangeEvent(Block, Player, String[], Side)}.
   *
   * <p>Method under test: {@link SignChangeEvent#SignChangeEvent(Block, Player, String[], Side)}
   */
  @Test
  @DisplayName("Test new SignChangeEvent(Block, Player, String[], Side)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignChangeEvent.<init>(Block, Player, String[], Side)"})
  void testNewSignChangeEvent2() {
    // Arrange
    Block sign = mock(Block.class);
    Player thePlayer = mock(Player.class);
    String[] theLines = new String[] {"The Lines"};

    // Act
    SignChangeEvent actualSignChangeEvent =
        new SignChangeEvent(sign, thePlayer, theLines, Side.FRONT);

    // Assert
    assertEquals("SignChangeEvent", actualSignChangeEvent.getEventName());
    assertEquals(0, actualSignChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSignChangeEvent.getSide());
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertFalse(actualSignChangeEvent.isCancelled());
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(thePlayer, actualSignChangeEvent.getPlayer());
    assertArrayEquals(new String[] {"The Lines"}, actualSignChangeEvent.getLines());
  }

  /**
   * Test {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}.
   *
   * <ul>
   *   <li>Given {@link Component}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Component}.
   * </ul>
   *
   * <p>Method under test: {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}
   */
  @Test
  @DisplayName(
      "Test new SignChangeEvent(Block, Player, List); given Component; when ArrayList() add Component")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignChangeEvent.<init>(Block, Player, List)"})
  void testNewSignChangeEvent_givenComponent_whenArrayListAddComponent() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    ArrayList<Component> adventure$lines = new ArrayList<>();
    adventure$lines.add(mock(Component.class));

    // Act
    SignChangeEvent actualSignChangeEvent = new SignChangeEvent(sign, player, adventure$lines);

    // Assert
    assertEquals("SignChangeEvent", actualSignChangeEvent.getEventName());
    assertEquals(0, actualSignChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSignChangeEvent.getSide());
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertFalse(actualSignChangeEvent.isCancelled());
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(player, actualSignChangeEvent.getPlayer());
  }

  /**
   * Test {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}.
   *
   * <ul>
   *   <li>Given {@link Component}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Component}.
   * </ul>
   *
   * <p>Method under test: {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}
   */
  @Test
  @DisplayName(
      "Test new SignChangeEvent(Block, Player, List); given Component; when ArrayList() add Component")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignChangeEvent.<init>(Block, Player, List)"})
  void testNewSignChangeEvent_givenComponent_whenArrayListAddComponent2() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    ArrayList<Component> adventure$lines = new ArrayList<>();
    adventure$lines.add(mock(Component.class));
    adventure$lines.add(mock(Component.class));

    // Act
    SignChangeEvent actualSignChangeEvent = new SignChangeEvent(sign, player, adventure$lines);

    // Assert
    assertEquals("SignChangeEvent", actualSignChangeEvent.getEventName());
    assertEquals(0, actualSignChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Side.FRONT, actualSignChangeEvent.getSide());
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertFalse(actualSignChangeEvent.isCancelled());
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(player, actualSignChangeEvent.getPlayer());
  }

  /**
   * Test {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SignChangeEvent#SignChangeEvent(Block, Player, List)}
   */
  @Test
  @DisplayName("Test new SignChangeEvent(Block, Player, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SignChangeEvent.<init>(Block, Player, List)"})
  void testNewSignChangeEvent_whenArrayList() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    SignChangeEvent actualSignChangeEvent = new SignChangeEvent(sign, player, new ArrayList<>());

    // Assert
    assertEquals("SignChangeEvent", actualSignChangeEvent.getEventName());
    assertEquals(0, actualSignChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(0, actualSignChangeEvent.getLines().length);
    assertEquals(Side.FRONT, actualSignChangeEvent.getSide());
    assertFalse(actualSignChangeEvent.isAsynchronous());
    assertFalse(actualSignChangeEvent.isCancelled());
    assertSame(sign, actualSignChangeEvent.getBlock());
    assertSame(player, actualSignChangeEvent.getPlayer());
  }

  /**
   * Test {@link SignChangeEvent#lines()}.
   *
   * <p>Method under test: {@link SignChangeEvent#lines()}
   */
  @Test
  @DisplayName("Test lines()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SignChangeEvent.lines()"})
  void testLines() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    SignChangeEvent signChangeEvent = new SignChangeEvent(sign, player, new ArrayList<>());

    // Act and Assert
    assertTrue(signChangeEvent.lines().isEmpty());
  }

  /**
   * Test {@link SignChangeEvent#getLines()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link SignChangeEvent#getLines()}
   */
  @Test
  @DisplayName("Test getLines(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SignChangeEvent.getLines()"})
  void testGetLines_thenReturnArrayLengthIsZero() {
    // Arrange
    Block sign = mock(Block.class);
    Player player = mock(Player.class);

    SignChangeEvent signChangeEvent = new SignChangeEvent(sign, player, new ArrayList<>());

    // Act and Assert
    assertEquals(0, signChangeEvent.getLines().length);
  }

  /**
   * Test {@link SignChangeEvent#getLine(int)}.
   *
   * <ul>
   *   <li>Given {@link Style} {@link Style#color()} return {@link TextColor}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SignChangeEvent#getLine(int)}
   */
  @Test
  @DisplayName("Test getLine(int); given Style color() return TextColor; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SignChangeEvent.getLine(int)"})
  void testGetLine_givenStyleColorReturnTextColor_thenReturnEmptyString()
      throws IndexOutOfBoundsException {
    // Arrange
    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component component = mock(Component.class);
    when(component.children()).thenReturn(new ArrayList<>());
    when(component.style()).thenReturn(style);

    ArrayList<Component> adventure$lines = new ArrayList<>();
    adventure$lines.add(mock(Component.class));
    adventure$lines.add(component);
    SignChangeEvent signChangeEvent =
        new SignChangeEvent(mock(Block.class), mock(Player.class), adventure$lines);

    // Act
    String actualLine = signChangeEvent.getLine(1);

    // Assert
    verify(component).children();
    verify(component).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    assertEquals("", actualLine);
  }
}
