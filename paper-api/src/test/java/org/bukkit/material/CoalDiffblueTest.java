package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.CoalType;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoalDiffblueTest {
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
   *   <li>{@link Coal#Coal(Material, byte)}
   *   <li>{@link Coal#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'null ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Coal.<init>(Material)",
    "void Coal.<init>(Material, byte)",
    "java.lang.String Coal.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsNullAcaciaBoat65() {
    // Arrange and Act
    Coal actualCoal = new Coal(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("null ACACIA_BOAT(65)", actualCoal.toString());
    assertEquals(Material.ACACIA_BOAT, actualCoal.getItemType());
    assertEquals('A', actualCoal.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code COAL ACACIA_BOAT(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Coal#Coal(Material)}
   *   <li>{@link Coal#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'COAL ACACIA_BOAT(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Coal.<init>(Material)",
    "void Coal.<init>(Material, byte)",
    "java.lang.String Coal.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsCoalAcaciaBoat0() {
    // Arrange and Act
    Coal actualCoal = new Coal(Material.ACACIA_BOAT);

    // Assert
    assertEquals("COAL ACACIA_BOAT(0)", actualCoal.toString());
    assertEquals((byte) 0, actualCoal.getData());
    assertEquals(Material.ACACIA_BOAT, actualCoal.getItemType());
  }

  /**
   * Test {@link Coal#Coal()}.
   *
   * <p>Method under test: {@link Coal#Coal()}
   */
  @Test
  @DisplayName("Test new Coal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Coal.<init>()"})
  void testNewCoal() {
    // Arrange and Act
    Coal actualCoal = new Coal();

    // Assert
    assertEquals((byte) 0, actualCoal.getData());
    assertEquals(CoalType.COAL, actualCoal.getType());
    assertEquals(Material.LEGACY_COAL, actualCoal.getItemType());
  }

  /**
   * Test {@link Coal#Coal(CoalType)}.
   *
   * <p>Method under test: {@link Coal#Coal(CoalType)}
   */
  @Test
  @DisplayName("Test new Coal(CoalType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Coal.<init>(CoalType)"})
  void testNewCoal2() {
    // Arrange and Act
    Coal actualCoal = new Coal(CoalType.COAL);

    // Assert
    assertEquals((byte) 0, actualCoal.getData());
    assertEquals(CoalType.COAL, actualCoal.getType());
    assertEquals(Material.LEGACY_COAL, actualCoal.getItemType());
  }

  /**
   * Test {@link Coal#getType()}.
   *
   * <p>Method under test: {@link Coal#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CoalType Coal.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(CoalType.COAL, new Coal().getType());
  }

  /**
   * Test {@link Coal#clone()}.
   *
   * <p>Method under test: {@link Coal#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Coal Coal.clone()"})
  void testClone() {
    // Arrange
    Coal coal = new Coal();

    // Act
    Coal actualCloneResult = coal.clone();

    // Assert
    assertEquals(coal, actualCloneResult);
  }
}
