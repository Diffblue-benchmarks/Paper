package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MaterialDataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaterialData#MaterialData(Material, byte)}
   *   <li>{@link MaterialData#setData(byte)}
   *   <li>{@link MaterialData#toString()}
   *   <li>{@link MaterialData#getData()}
   *   <li>{@link MaterialData#getItemType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MaterialData.<init>(Material)",
    "void MaterialData.<init>(Material, byte)",
    "byte MaterialData.getData()",
    "Material MaterialData.getItemType()",
    "void MaterialData.setData(byte)",
    "String MaterialData.toString()"
  })
  void testGettersAndSetters_whenA() {
    // Arrange and Act
    MaterialData actualMaterialData = new MaterialData(Material.ACACIA_BOAT, (byte) 'A');
    actualMaterialData.setData((byte) 'A');
    String actualToStringResult = actualMaterialData.toString();
    byte actualData = actualMaterialData.getData();

    // Assert
    assertEquals("ACACIA_BOAT(65)", actualToStringResult);
    assertEquals(Material.ACACIA_BOAT, actualMaterialData.getItemType());
    assertEquals('A', actualData);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaterialData#MaterialData(Material)}
   *   <li>{@link MaterialData#setData(byte)}
   *   <li>{@link MaterialData#toString()}
   *   <li>{@link MaterialData#getData()}
   *   <li>{@link MaterialData#getItemType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MaterialData.<init>(Material)",
    "void MaterialData.<init>(Material, byte)",
    "byte MaterialData.getData()",
    "Material MaterialData.getItemType()",
    "void MaterialData.setData(byte)",
    "String MaterialData.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat() {
    // Arrange and Act
    MaterialData actualMaterialData = new MaterialData(Material.ACACIA_BOAT);
    actualMaterialData.setData((byte) 'A');
    String actualToStringResult = actualMaterialData.toString();
    byte actualData = actualMaterialData.getData();

    // Assert
    assertEquals("ACACIA_BOAT(65)", actualToStringResult);
    assertEquals(Material.ACACIA_BOAT, actualMaterialData.getItemType());
    assertEquals('A', actualData);
  }

  /**
   * Test {@link MaterialData#equals(Object)}, and {@link MaterialData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaterialData#equals(Object)}
   *   <li>{@link MaterialData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MaterialData materialData = new MaterialData(Material.ACACIA_BOAT);
    MaterialData materialData2 = new MaterialData(Material.ACACIA_BOAT);

    // Act and Assert
    assertEquals(materialData, materialData2);
    assertEquals(materialData.hashCode(), materialData2.hashCode());
  }

  /**
   * Test {@link MaterialData#equals(Object)}, and {@link MaterialData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaterialData#equals(Object)}
   *   <li>{@link MaterialData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MaterialData materialData = new MaterialData(Material.ACACIA_BOAT);

    // Act and Assert
    assertEquals(materialData, materialData);
    int expectedHashCodeResult = materialData.hashCode();
    assertEquals(expectedHashCodeResult, materialData.hashCode());
  }

  /**
   * Test {@link MaterialData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaterialData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MaterialData materialData = new MaterialData(null);

    // Act and Assert
    assertNotEquals(materialData, new MaterialData(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link MaterialData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaterialData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Banner banner = new Banner(Material.ACACIA_BOAT, (byte) 'A');

    // Act and Assert
    assertNotEquals(banner, new MaterialData(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link MaterialData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaterialData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MaterialData materialData = new MaterialData(Material.ACACIA_BOAT);

    Banner banner = mock(Banner.class);
    when(banner.getData()).thenReturn((byte) 'A');
    when(banner.getItemType()).thenReturn(Material.ACACIA_BOAT);

    // Act and Assert
    assertNotEquals(materialData, banner);
  }

  /**
   * Test {@link MaterialData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaterialData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MaterialData(Material.ACACIA_BOAT), null);
  }

  /**
   * Test {@link MaterialData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaterialData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MaterialData.equals(Object)", "int MaterialData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MaterialData(Material.ACACIA_BOAT), "Different type to MaterialData");
  }

  /**
   * Test {@link MaterialData#clone()}.
   *
   * <p>Method under test: {@link MaterialData#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MaterialData MaterialData.clone()"})
  void testClone() {
    // Arrange
    MaterialData materialData = new MaterialData(Material.ACACIA_BOAT);

    // Act
    MaterialData actualCloneResult = materialData.clone();

    // Assert
    assertEquals(materialData, actualCloneResult);
  }
}
