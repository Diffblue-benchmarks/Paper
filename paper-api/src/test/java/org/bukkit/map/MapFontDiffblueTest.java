package org.bukkit.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.map.MapFont.CharacterSprite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapFontDiffblueTest {
  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new CharacterSprite(4, 1, new boolean[] {true, false, true, false}).get(1, 1));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(new CharacterSprite(4, 1, new boolean[] {true, false, true, false}).get(0, 1));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_thenReturnFalse3() {
    // Arrange, Act and Assert
    assertFalse(new CharacterSprite(4, 1, new boolean[] {true, false, true, false}).get(-1, 1));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_thenReturnFalse4() {
    // Arrange, Act and Assert
    assertFalse(new CharacterSprite(4, 1, new boolean[] {true, false, true, false}).get(1, -1));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CharacterSprite(4, 1, new boolean[] {true, true, true, false}).get(0, 1));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#get(int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#get(int, int)}
   */
  @Test
  @DisplayName("Test CharacterSprite get(int, int); when four; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CharacterSprite.get(int, int)"})
  void testCharacterSpriteGet_whenFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new CharacterSprite(4, 1, new boolean[] {true, false, true, false}).get(0, 4));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#CharacterSprite(int, int, boolean[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#CharacterSprite(int, int, boolean[])}
   */
  @Test
  @DisplayName(
      "Test CharacterSprite new CharacterSprite(int, int, boolean[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CharacterSprite.<init>(int, int, boolean[])"})
  void testCharacterSpriteNewCharacterSprite_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CharacterSprite(1, 1, new boolean[] {true, false, true, false}));
  }

  /**
   * Test CharacterSprite {@link CharacterSprite#CharacterSprite(int, int, boolean[])}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return Height is one.
   * </ul>
   *
   * <p>Method under test: {@link CharacterSprite#CharacterSprite(int, int, boolean[])}
   */
  @Test
  @DisplayName(
      "Test CharacterSprite new CharacterSprite(int, int, boolean[]); when four; then return Height is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CharacterSprite.<init>(int, int, boolean[])"})
  void testCharacterSpriteNewCharacterSprite_whenFour_thenReturnHeightIsOne() {
    // Arrange and Act
    CharacterSprite actualCharacterSprite =
        new CharacterSprite(4, 1, new boolean[] {true, false, true, false});

    // Assert
    assertEquals(1, actualCharacterSprite.getHeight());
    assertEquals(4, actualCharacterSprite.getWidth());
  }

  /**
   * Test {@link MapFont#setChar(char, CharacterSprite)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MapFont#setChar(char, CharacterSprite)}
   */
  @Test
  @DisplayName("Test setChar(char, CharacterSprite); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapFont.setChar(char, CharacterSprite)"})
  void testSetChar_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            MinecraftFont.Font.setChar(
                'A', new CharacterSprite(4, 1, new boolean[] {true, false, true, false})));
  }

  /**
   * Test {@link MapFont#getChar(char)}.
   *
   * <p>Method under test: {@link MapFont#getChar(char)}
   */
  @Test
  @DisplayName("Test getChar(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CharacterSprite MapFont.getChar(char)"})
  void testGetChar() {
    // Arrange and Act
    CharacterSprite actualChar = MinecraftFont.Font.getChar('A');

    // Assert
    assertEquals(5, actualChar.getWidth());
    assertEquals(8, actualChar.getHeight());
  }

  /**
   * Test {@link MapFont#getWidth(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MapFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when empty string; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapFont.getWidth(String)"})
  void testGetWidth_whenEmptyString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MinecraftFont.Font.getWidth(""));
  }

  /**
   * Test {@link MapFont#getWidth(String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link MapFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'Text'; then return twenty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapFont.getWidth(String)"})
  void testGetWidth_whenText_thenReturnTwentyOne() {
    // Arrange, Act and Assert
    assertEquals(21, MinecraftFont.Font.getWidth("Text"));
  }

  /**
   * Test {@link MapFont#isValid(String)}.
   *
   * <p>Method under test: {@link MapFont#isValid(String)}
   */
  @Test
  @DisplayName("Test isValid(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapFont.isValid(String)"})
  void testIsValid() {
    // Arrange, Act and Assert
    assertTrue(MinecraftFont.Font.isValid("Text"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MapFont}
   *   <li>{@link MapFont#getHeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapFont.<init>()", "int MapFont.getHeight()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new MapFont().getHeight());
  }
}
