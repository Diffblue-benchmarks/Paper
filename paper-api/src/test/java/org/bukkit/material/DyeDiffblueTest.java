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

class DyeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code null DYE(65)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dye#Dye(Material, byte)}
   *   <li>{@link Dye#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'null DYE(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Dye.<init>(Material)",
    "void Dye.<init>(Material, byte)",
    "java.lang.String Dye.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsNullDye65() {
    // Arrange and Act
    Dye actualDye = new Dye(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("null DYE(65)", actualDye.toString());
    assertEquals(Material.ACACIA_BOAT, actualDye.getItemType());
    assertEquals('A', actualDye.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code BLACK DYE(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dye#Dye(Material)}
   *   <li>{@link Dye#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'BLACK DYE(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Dye.<init>(Material)",
    "void Dye.<init>(Material, byte)",
    "java.lang.String Dye.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsBlackDye0() {
    // Arrange and Act
    Dye actualDye = new Dye(Material.ACACIA_BOAT);

    // Assert
    assertEquals("BLACK DYE(0)", actualDye.toString());
    assertEquals((byte) 0, actualDye.getData());
    assertEquals(Material.ACACIA_BOAT, actualDye.getItemType());
  }

  /**
   * Test {@link Dye#Dye()}.
   *
   * <p>Method under test: {@link Dye#Dye()}
   */
  @Test
  @DisplayName("Test new Dye()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dye.<init>()"})
  void testNewDye() {
    // Arrange and Act
    Dye actualDye = new Dye();

    // Assert
    assertEquals((byte) 0, actualDye.getData());
    assertEquals(DyeColor.BLACK, actualDye.getColor());
    assertEquals(Material.LEGACY_INK_SACK, actualDye.getItemType());
  }

  /**
   * Test {@link Dye#Dye(DyeColor)}.
   *
   * <p>Method under test: {@link Dye#Dye(DyeColor)}
   */
  @Test
  @DisplayName("Test new Dye(DyeColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dye.<init>(DyeColor)"})
  void testNewDye2() {
    // Arrange and Act
    Dye actualDye = new Dye(DyeColor.WHITE);

    // Assert
    assertEquals((byte) 15, actualDye.getData());
    assertEquals(DyeColor.WHITE, actualDye.getColor());
    assertEquals(Material.LEGACY_INK_SACK, actualDye.getItemType());
  }

  /**
   * Test {@link Dye#getColor()}.
   *
   * <ul>
   *   <li>Given {@link Dye#Dye()} Data is {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dye#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given Dye() Data is 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor Dye.getColor()"})
  void testGetColor_givenDyeDataIsA_thenReturnNull() {
    // Arrange
    Dye dye = new Dye();
    dye.setData((byte) 'A');

    // Act and Assert
    assertNull(dye.getColor());
  }

  /**
   * Test {@link Dye#getColor()}.
   *
   * <ul>
   *   <li>Given {@link Dye#Dye()}.
   *   <li>Then return {@code BLACK}.
   * </ul>
   *
   * <p>Method under test: {@link Dye#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given Dye(); then return 'BLACK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor Dye.getColor()"})
  void testGetColor_givenDye_thenReturnBlack() {
    // Arrange, Act and Assert
    assertEquals(DyeColor.BLACK, new Dye().getColor());
  }

  /**
   * Test {@link Dye#setColor(DyeColor)}.
   *
   * <p>Method under test: {@link Dye#setColor(DyeColor)}
   */
  @Test
  @DisplayName("Test setColor(DyeColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dye.setColor(DyeColor)"})
  void testSetColor() {
    // Arrange
    Dye dye = new Dye();

    // Act
    dye.setColor(DyeColor.WHITE);

    // Assert
    assertEquals((byte) 15, dye.getData());
    assertEquals(DyeColor.WHITE, dye.getColor());
  }

  /**
   * Test {@link Dye#clone()}.
   *
   * <p>Method under test: {@link Dye#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dye Dye.clone()"})
  void testClone() {
    // Arrange
    Dye dye = new Dye();

    // Act
    Dye actualCloneResult = dye.clone();

    // Assert
    assertEquals(dye, actualCloneResult);
  }
}
