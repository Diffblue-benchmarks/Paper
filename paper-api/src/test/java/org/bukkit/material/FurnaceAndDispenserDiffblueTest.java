package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FurnaceAndDispenserDiffblueTest {
  /**
   * Test {@link FurnaceAndDispenser#FurnaceAndDispenser(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceAndDispenser#FurnaceAndDispenser(Material, byte)}
   */
  @Test
  @DisplayName("Test new FurnaceAndDispenser(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FurnaceAndDispenser.<init>(Material)",
    "void FurnaceAndDispenser.<init>(Material, byte)"
  })
  void testNewFurnaceAndDispenser_whenA_thenReturnDataIsA() {
    // Arrange and Act
    FurnaceAndDispenser actualFurnaceAndDispenser =
        new FurnaceAndDispenser(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualFurnaceAndDispenser.getItemType());
    assertEquals('A', actualFurnaceAndDispenser.getData());
  }

  /**
   * Test {@link FurnaceAndDispenser#FurnaceAndDispenser(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link FurnaceAndDispenser#FurnaceAndDispenser(Material)}
   */
  @Test
  @DisplayName(
      "Test new FurnaceAndDispenser(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FurnaceAndDispenser.<init>(Material)",
    "void FurnaceAndDispenser.<init>(Material, byte)"
  })
  void testNewFurnaceAndDispenser_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    FurnaceAndDispenser actualFurnaceAndDispenser = new FurnaceAndDispenser(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualFurnaceAndDispenser.getData());
    assertEquals(Material.ACACIA_BOAT, actualFurnaceAndDispenser.getItemType());
  }

  /**
   * Test {@link FurnaceAndDispenser#clone()}.
   *
   * <p>Method under test: {@link FurnaceAndDispenser#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FurnaceAndDispenser FurnaceAndDispenser.clone()"})
  void testClone() {
    // Arrange
    FurnaceAndDispenser furnaceAndDispenser = new FurnaceAndDispenser(Material.ACACIA_BOAT);

    // Act
    FurnaceAndDispenser actualCloneResult = furnaceAndDispenser.clone();

    // Assert
    assertEquals(furnaceAndDispenser, actualCloneResult);
  }
}
