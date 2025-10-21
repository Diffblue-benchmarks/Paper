package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleAttachableMaterialDataDiffblueTest {
  /**
   * Test {@link SimpleAttachableMaterialData#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       minus nine.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAttachableMaterialData#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is minus nine; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace SimpleAttachableMaterialData.getFacing()"})
  void testGetFacing_givenButtonWithTypeIsAcaciaBoatAndDataIsMinusNine_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Button(Material.ACACIA_BOAT, (byte) -9).getFacing());
  }

  /**
   * Test {@link SimpleAttachableMaterialData#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button()}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAttachableMaterialData#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Button(); then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace SimpleAttachableMaterialData.getFacing()"})
  void testGetFacing_givenButton_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Button().getFacing());
  }

  /**
   * Test {@link SimpleAttachableMaterialData#toString()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button()}.
   *   <li>Then return {@code LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAttachableMaterialData#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Button(); then return 'LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleAttachableMaterialData.toString()"})
  void testToString_givenButton_thenReturnLegacyStoneButton0FacingDownNotPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED", new Button().toString());
  }

  /**
   * Test {@link SimpleAttachableMaterialData#toString()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder()}.
   *   <li>Then return {@code LEGACY_LADDER(0) facing null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleAttachableMaterialData#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Ladder(); then return 'LEGACY_LADDER(0) facing null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleAttachableMaterialData.toString()"})
  void testToString_givenLadder_thenReturnLegacyLadder0FacingNull() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_LADDER(0) facing null", new Ladder().toString());
  }

  /**
   * Test {@link SimpleAttachableMaterialData#clone()}.
   *
   * <p>Method under test: {@link SimpleAttachableMaterialData#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleAttachableMaterialData SimpleAttachableMaterialData.clone()"})
  void testClone() {
    // Arrange
    Button button = new Button();

    // Act
    Button actualCloneResult = button.clone();

    // Assert
    assertTrue(actualCloneResult instanceof Button);
    assertEquals(button, actualCloneResult);
  }
}
