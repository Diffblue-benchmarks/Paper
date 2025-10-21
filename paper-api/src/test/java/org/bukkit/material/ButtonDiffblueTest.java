package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ButtonDiffblueTest {
  /**
   * Test {@link Button#Button()}.
   *
   * <p>Method under test: {@link Button#Button()}
   */
  @Test
  @DisplayName("Test new Button()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.<init>()"})
  void testNewButton() {
    // Arrange and Act
    Button actualButton = new Button();

    // Assert
    assertEquals((byte) 0, actualButton.getData());
    assertEquals(Material.LEGACY_STONE_BUTTON, actualButton.getItemType());
    assertEquals(BlockFace.DOWN, actualButton.getFacing());
    assertEquals(BlockFace.UP, actualButton.getAttachedFace());
    assertFalse(actualButton.isPowered());
  }

  /**
   * Test {@link Button#Button(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Button#Button(Material, byte)}
   */
  @Test
  @DisplayName("Test new Button(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.<init>(Material)", "void Button.<init>(Material, byte)"})
  void testNewButton_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Button actualButton = new Button(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualButton.getItemType());
    assertEquals('A', actualButton.getData());
  }

  /**
   * Test {@link Button#Button(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Button#Button(Material)}
   */
  @Test
  @DisplayName("Test new Button(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.<init>(Material)", "void Button.<init>(Material, byte)"})
  void testNewButton_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Button actualButton = new Button(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualButton.getData());
    assertEquals(Material.ACACIA_BOAT, actualButton.getItemType());
  }

  /**
   * Test {@link Button#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Button#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Button.isPowered()"})
  void testIsPowered_givenButtonWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Button(Material.ACACIA_BOAT, (byte) 'X').isPowered());
  }

  /**
   * Test {@link Button#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Button#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Button(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Button.isPowered()"})
  void testIsPowered_givenButton_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Button().isPowered());
  }

  /**
   * Test {@link Button#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Button#Button()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Button#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'false'; then Button() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setPowered(boolean)"})
  void testSetPowered_whenFalse_thenButtonDataIsZero() {
    // Arrange
    Button button = new Button();

    // Act
    button.setPowered(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, button.getData());
    assertFalse(button.isPowered());
  }

  /**
   * Test {@link Button#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Button#Button()} Powered.
   * </ul>
   *
   * <p>Method under test: {@link Button#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'true'; then Button() Powered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setPowered(boolean)"})
  void testSetPowered_whenTrue_thenButtonPowered() {
    // Arrange
    Button button = new Button();

    // Act
    button.setPowered(true);

    // Assert
    assertTrue(button.isPowered());
    assertEquals('\b', button.getData());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButtonWithTypeIsAcaciaBoatAndDataIsA_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Button(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is five; then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButtonWithTypeIsAcaciaBoatAndDataIsFive_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Button(Material.ACACIA_BOAT, (byte) 5).getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       four.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is four; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButtonWithTypeIsAcaciaBoatAndDataIsFour_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Button(Material.ACACIA_BOAT, (byte) 4).getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       seven.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is seven; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButtonWithTypeIsAcaciaBoatAndDataIsSeven_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Button(Material.ACACIA_BOAT, (byte) 7).getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Button(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButtonWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Button(Material.ACACIA_BOAT, (byte) 2).getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button()}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Button(); then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_givenButton_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.UP, new Button().getAttachedFace());
  }

  /**
   * Test {@link Button#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Button#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Button.getAttachedFace()"})
  void testGetAttachedFace_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Button(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then {@link Button#Button()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'DOWN'; then Button() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenDown_thenButtonDataIsZero() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.DOWN);

    // Assert that nothing has changed
    assertEquals((byte) 0, button.getData());
    assertEquals(BlockFace.DOWN, button.getFacing());
    assertEquals(BlockFace.UP, button.getAttachedFace());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Button#Button()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Button() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenButtonDataIsOne() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, button.getData());
    assertEquals(BlockFace.EAST, button.getFacing());
    assertEquals(BlockFace.WEST, button.getAttachedFace());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH_EAST}.
   *   <li>Then {@link Button#Button()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH_EAST'; then Button() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorthEast_thenButtonDataIsZero() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.NORTH_EAST);

    // Assert that nothing has changed
    assertEquals((byte) 0, button.getData());
    assertEquals(BlockFace.DOWN, button.getFacing());
    assertEquals(BlockFace.UP, button.getAttachedFace());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Button#Button()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Button() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenButtonDataIsFour() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, button.getData());
    assertEquals(BlockFace.NORTH, button.getFacing());
    assertEquals(BlockFace.SOUTH, button.getAttachedFace());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Button#Button()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Button() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenButtonDataIsThree() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, button.getData());
    assertEquals(BlockFace.NORTH, button.getAttachedFace());
    assertEquals(BlockFace.SOUTH, button.getFacing());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Button#Button()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Button() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenButtonDataIsFive() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 5, button.getData());
    assertEquals(BlockFace.DOWN, button.getAttachedFace());
    assertEquals(BlockFace.UP, button.getFacing());
  }

  /**
   * Test {@link Button#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Button#Button()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Button#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Button() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Button.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenButtonDataIsTwo() {
    // Arrange
    Button button = new Button();

    // Act
    button.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, button.getData());
    assertEquals(BlockFace.EAST, button.getAttachedFace());
    assertEquals(BlockFace.WEST, button.getFacing());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Given {@link Button#Button()}.
   *   <li>Then return {@code LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Button(); then return 'LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_givenButton_thenReturnLegacyStoneButton0FacingDownNotPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_STONE_BUTTON(0) facing DOWN NOT POWERED", new Button().toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(2) facing WEST NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(2) facing WEST NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat2FacingWestNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(2) facing WEST NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 2).toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(3) facing SOUTH NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(3) facing SOUTH NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat3FacingSouthNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(3) facing SOUTH NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 3).toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) facing NORTH NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(4) facing NORTH NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat4FacingNorthNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(4) facing NORTH NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(5) facing UP NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(5) facing UP NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat5FacingUpNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(5) facing UP NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 5).toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(7) facing null NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(7) facing null NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat7FacingNullNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(7) facing null NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 7).toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) facing EAST NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) facing EAST NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat65FacingEastNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) facing EAST NOT POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link Button#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(88) facing DOWN POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Button#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(88) facing DOWN POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Button.toString()"})
  void testToString_thenReturnAcaciaBoat88FacingDownPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(88) facing DOWN POWERED",
        new Button(Material.ACACIA_BOAT, (byte) 'X').toString());
  }

  /**
   * Test {@link Button#clone()}.
   *
   * <p>Method under test: {@link Button#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Button Button.clone()"})
  void testClone() {
    // Arrange
    Button button = new Button();

    // Act
    Button actualCloneResult = button.clone();

    // Assert
    assertEquals(button, actualCloneResult);
  }
}
