package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CropsDiffblueTest {
  /**
   * Test {@link Crops#Crops(Material, byte)}.
   *
   * <p>Method under test: {@link Crops#Crops(Material, byte)}
   */
  @Test
  @DisplayName("Test new Crops(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crops.<init>(Material, byte)", "java.lang.String Crops.toString()"})
  void testNewCrops() {
    // Arrange and Act
    Crops actualCrops = new Crops(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualCrops.getItemType());
    assertEquals('A', actualCrops.getData());
  }

  /**
   * Test {@link Crops#Crops()}.
   *
   * <p>Method under test: {@link Crops#Crops()}
   */
  @Test
  @DisplayName("Test new Crops()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crops.<init>()"})
  void testNewCrops2() {
    // Arrange and Act
    Crops actualCrops = new Crops();

    // Assert
    assertEquals((byte) 0, actualCrops.getData());
    assertEquals(CropState.SEEDED, actualCrops.getState());
    assertEquals(Material.LEGACY_CROPS, actualCrops.getItemType());
  }

  /**
   * Test {@link Crops#Crops(CropState)}.
   *
   * <p>Method under test: {@link Crops#Crops(CropState)}
   */
  @Test
  @DisplayName("Test new Crops(CropState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crops.<init>(CropState)"})
  void testNewCrops3() {
    // Arrange and Act
    Crops actualCrops = new Crops(CropState.SEEDED);

    // Assert
    assertEquals((byte) 0, actualCrops.getData());
    assertEquals(CropState.SEEDED, actualCrops.getState());
    assertEquals(Material.LEGACY_CROPS, actualCrops.getItemType());
  }

  /**
   * Test {@link Crops#Crops(Material)}.
   *
   * <p>Method under test: {@link Crops#Crops(Material)}
   */
  @Test
  @DisplayName("Test new Crops(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crops.<init>(Material)"})
  void testNewCrops4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Crops(Material.ACACIA_BOAT));
  }

  /**
   * Test {@link Crops#Crops(Material, CropState)}.
   *
   * <p>Method under test: {@link Crops#Crops(Material, CropState)}
   */
  @Test
  @DisplayName("Test new Crops(Material, CropState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crops.<init>(Material, CropState)"})
  void testNewCrops5() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new Crops(Material.ACACIA_BOAT, CropState.SEEDED));
  }

  /**
   * Test {@link Crops#getState()}.
   *
   * <p>Method under test: {@link Crops#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CropState Crops.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertEquals(CropState.SEEDED, new Crops().getState());
  }

  /**
   * Test {@link Crops#clone()}.
   *
   * <p>Method under test: {@link Crops#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Crops Crops.clone()"})
  void testClone() {
    // Arrange
    Crops crops = new Crops();

    // Act
    Crops actualCloneResult = crops.clone();

    // Assert
    assertEquals(crops, actualCloneResult);
  }
}
