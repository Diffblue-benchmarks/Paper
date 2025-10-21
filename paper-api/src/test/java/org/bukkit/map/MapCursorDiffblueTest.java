package org.bukkit.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.map.MapCursor.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapCursorDiffblueTest {
  /**
   * Test {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, String)}.
   *
   * <ul>
   *   <li>When {@link MapPalette#TRANSPARENT}.
   *   <li>Then return {@code Caption}.
   * </ul>
   *
   * <p>Method under test: {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new MapCursor(byte, byte, byte, Type, boolean, String); when TRANSPARENT; then return 'Caption'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursor.<init>(byte, byte, byte, Type, boolean, String)"})
  void testNewMapCursor_whenTransparent_thenReturnCaption() {
    // Arrange and Act
    MapCursor actualMapCursor =
        new MapCursor(
            (byte) 'A', (byte) 'A', MapPalette.TRANSPARENT, mock(Type.class), true, "Caption");

    // Assert
    assertEquals("Caption", actualMapCursor.getCaption());
    Component captionResult = actualMapCursor.caption();
    assertNull(captionResult.insertion());
    assertNull(captionResult.font());
    assertNull(captionResult.color());
    Map<TextDecoration, State> decorationsResult = captionResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(captionResult.hasStyling());
    Component actualCompactResult = captionResult.compact();
    assertEquals(captionResult, actualCompactResult);
  }

  /**
   * Test {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, String)}.
   *
   * <ul>
   *   <li>When {@link MapPalette#TRANSPARENT}.
   *   <li>Then return Caption is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new MapCursor(byte, byte, byte, Type, boolean, String); when TRANSPARENT; then return Caption is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursor.<init>(byte, byte, byte, Type, boolean, String)"})
  void testNewMapCursor_whenTransparent_thenReturnCaptionIsNull() {
    // Arrange
    Type type = mock(Type.class);

    // Act
    MapCursor actualMapCursor =
        new MapCursor((byte) 'A', (byte) 'A', MapPalette.TRANSPARENT, type, true, (String) null);

    // Assert
    assertNull(actualMapCursor.getCaption());
    assertNull(actualMapCursor.caption());
    assertTrue(actualMapCursor.isVisible());
    assertEquals(MapPalette.TRANSPARENT, actualMapCursor.getDirection());
    assertEquals(MapPalette.TRANSPARENT, actualMapCursor.getRawType());
    assertEquals('A', actualMapCursor.getX());
    assertEquals('A', actualMapCursor.getY());
    assertSame(type, actualMapCursor.getType());
  }

  /**
   * Test {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, Component)}.
   *
   * <ul>
   *   <li>When {@link MapPalette#TRANSPARENT}.
   *   <li>Then return Visible.
   * </ul>
   *
   * <p>Method under test: {@link MapCursor#MapCursor(byte, byte, byte, Type, boolean, Component)}
   */
  @Test
  @DisplayName(
      "Test new MapCursor(byte, byte, byte, Type, boolean, Component); when TRANSPARENT; then return Visible")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursor.<init>(byte, byte, byte, Type, boolean, Component)"})
  void testNewMapCursor_whenTransparent_thenReturnVisible() {
    // Arrange
    Type type = mock(Type.class);
    Component caption = mock(Component.class);

    // Act
    MapCursor actualMapCursor =
        new MapCursor((byte) 'A', (byte) 'A', MapPalette.TRANSPARENT, type, true, caption);

    // Assert
    assertTrue(actualMapCursor.isVisible());
    assertEquals(MapPalette.TRANSPARENT, actualMapCursor.getDirection());
    assertEquals(MapPalette.TRANSPARENT, actualMapCursor.getRawType());
    assertEquals('A', actualMapCursor.getX());
    assertEquals('A', actualMapCursor.getY());
    assertSame(caption, actualMapCursor.caption());
    assertSame(type, actualMapCursor.getType());
  }

  /**
   * Test {@link MapCursor#getCaption()}.
   *
   * <ul>
   *   <li>Given {@link Style} {@link Style#color()} return {@link TextColor}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MapCursor#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); given Style color() return TextColor; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapCursor.getCaption()"})
  void testGetCaption_givenStyleColorReturnTextColor_thenReturnEmptyString() {
    // Arrange
    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component caption = mock(Component.class);
    when(caption.children()).thenReturn(new ArrayList<>());
    when(caption.style()).thenReturn(style);

    MapCursor mapCursor = new MapCursor((byte) 'A', (byte) 'A', (byte) 15, mock(Type.class), true);
    mapCursor.caption(caption);

    // Act
    String actualCaption = mapCursor.getCaption();

    // Assert
    verify(caption).children();
    verify(caption).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    assertEquals("", actualCaption);
  }

  /**
   * Test {@link MapCursor#getCaption()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapCursor#getCaption()}
   */
  @Test
  @DisplayName("Test getCaption(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapCursor.getCaption()"})
  void testGetCaption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new MapCursor((byte) 'A', (byte) 'A', (byte) 15, mock(Type.class), true).getCaption());
  }

  /**
   * Test {@link MapCursor#setCaption(String)}.
   *
   * <p>Method under test: {@link MapCursor#setCaption(String)}
   */
  @Test
  @DisplayName("Test setCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursor.setCaption(String)"})
  void testSetCaption() {
    // Arrange
    MapCursor mapCursor = new MapCursor((byte) 'A', (byte) 'A', (byte) 15, mock(Type.class), true);

    // Act
    mapCursor.setCaption("Caption");

    // Assert
    assertEquals("Caption", mapCursor.getCaption());
    Component captionResult = mapCursor.caption();
    assertNull(captionResult.insertion());
    assertNull(captionResult.font());
    assertNull(captionResult.color());
    Map<TextDecoration, State> decorationsResult = captionResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(captionResult.hasStyling());
    Component actualCompactResult = captionResult.compact();
    assertEquals(captionResult, actualCompactResult);
  }

  /**
   * Test {@link MapCursor#setCaption(String)}.
   *
   * <p>Method under test: {@link MapCursor#setCaption(String)}
   */
  @Test
  @DisplayName("Test setCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursor.setCaption(String)"})
  void testSetCaption2() {
    // Arrange
    MapCursor mapCursor = new MapCursor((byte) 'A', (byte) 'A', (byte) 15, mock(Type.class), true);

    // Act
    mapCursor.setCaption(null);

    // Assert that nothing has changed
    assertNull(mapCursor.getCaption());
  }
}
