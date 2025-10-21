package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WoolDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code null ACACIA_BOAT(65)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Wool#Wool(Material, byte)}
   *   <li>{@link Wool#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'null ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Wool.<init>(Material)",
    "void Wool.<init>(Material, byte)",
    "java.lang.String Wool.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsNullAcaciaBoat65() {
    // Arrange and Act
    Wool actualWool = new Wool(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("null ACACIA_BOAT(65)", actualWool.toString());
    assertEquals(Material.ACACIA_BOAT, actualWool.getItemType());
    assertEquals('A', actualWool.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code WHITE ACACIA_BOAT(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Wool#Wool(Material)}
   *   <li>{@link Wool#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'WHITE ACACIA_BOAT(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Wool.<init>(Material)",
    "void Wool.<init>(Material, byte)",
    "java.lang.String Wool.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsWhiteAcaciaBoat0() {
    // Arrange and Act
    Wool actualWool = new Wool(Material.ACACIA_BOAT);

    // Assert
    assertEquals("WHITE ACACIA_BOAT(0)", actualWool.toString());
    assertEquals((byte) 0, actualWool.getData());
    assertEquals(Material.ACACIA_BOAT, actualWool.getItemType());
  }

  /**
   * Test {@link Wool#Wool()}.
   *
   * <p>Method under test: {@link Wool#Wool()}
   */
  @Test
  @DisplayName("Test new Wool()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wool.<init>()"})
  void testNewWool() {
    // Arrange and Act
    Wool actualWool = new Wool();

    // Assert
    assertEquals((byte) 0, actualWool.getData());
    assertEquals(DyeColor.WHITE, actualWool.getColor());
    assertEquals(Material.LEGACY_WOOL, actualWool.getItemType());
  }

  /**
   * Test {@link Wool#Wool(DyeColor)}.
   *
   * <p>Method under test: {@link Wool#Wool(DyeColor)}
   */
  @Test
  @DisplayName("Test new Wool(DyeColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wool.<init>(DyeColor)"})
  void testNewWool2() {
    // Arrange and Act
    Wool actualWool = new Wool(DyeColor.WHITE);

    // Assert
    assertEquals((byte) 0, actualWool.getData());
    assertEquals(DyeColor.WHITE, actualWool.getColor());
    assertEquals(Material.LEGACY_WOOL, actualWool.getItemType());
  }

  /**
   * Test {@link Wool#getColor()}.
   *
   * <ul>
   *   <li>Given {@link Wool#Wool()} Data is {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Wool#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given Wool() Data is 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor Wool.getColor()"})
  void testGetColor_givenWoolDataIsA_thenReturnNull() {
    // Arrange
    Wool wool = new Wool();
    wool.setData((byte) 'A');

    // Act and Assert
    assertNull(wool.getColor());
  }

  /**
   * Test {@link Wool#getColor()}.
   *
   * <ul>
   *   <li>Given {@link Wool#Wool()}.
   *   <li>Then return {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link Wool#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given Wool(); then return 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor Wool.getColor()"})
  void testGetColor_givenWool_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals(DyeColor.WHITE, new Wool().getColor());
  }

  /**
   * Test {@link Wool#clone()}.
   *
   * <p>Method under test: {@link Wool#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Wool Wool.clone()"})
  void testClone() {
    // Arrange
    Wool wool = new Wool();

    // Act
    Wool actualCloneResult = wool.clone();

    // Assert
    assertEquals(wool, actualCloneResult);
  }
}
