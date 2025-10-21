package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LeverDiffblueTest {
  /**
   * Test {@link Lever#Lever()}.
   *
   * <p>Method under test: {@link Lever#Lever()}
   */
  @Test
  @DisplayName("Test new Lever()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.<init>()"})
  void testNewLever() {
    // Arrange and Act
    Lever actualLever = new Lever();

    // Assert
    assertEquals((byte) 0, actualLever.getData());
    assertEquals(Material.LEGACY_LEVER, actualLever.getItemType());
    assertEquals(BlockFace.DOWN, actualLever.getFacing());
    assertEquals(BlockFace.UP, actualLever.getAttachedFace());
    assertFalse(actualLever.isPowered());
  }

  /**
   * Test {@link Lever#Lever(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#Lever(Material, byte)}
   */
  @Test
  @DisplayName("Test new Lever(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.<init>(Material)", "void Lever.<init>(Material, byte)"})
  void testNewLever_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Lever actualLever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualLever.getItemType());
    assertEquals('A', actualLever.getData());
  }

  /**
   * Test {@link Lever#Lever(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#Lever(Material)}
   */
  @Test
  @DisplayName("Test new Lever(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.<init>(Material)", "void Lever.<init>(Material, byte)"})
  void testNewLever_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Lever actualLever = new Lever(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualLever.getData());
    assertEquals(Material.ACACIA_BOAT, actualLever.getItemType());
  }

  /**
   * Test {@link Lever#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Lever.isPowered()"})
  void testIsPowered_givenLeverWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Lever(Material.ACACIA_BOAT, (byte) 'X').isPowered());
  }

  /**
   * Test {@link Lever#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given Lever(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Lever.isPowered()"})
  void testIsPowered_givenLever_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Lever().isPowered());
  }

  /**
   * Test {@link Lever#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link Lever#Lever()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'false'; then Lever() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setPowered(boolean)"})
  void testSetPowered_whenFalse_thenLeverDataIsZero() {
    // Arrange
    Lever lever = new Lever();

    // Act
    lever.setPowered(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, lever.getData());
    assertFalse(lever.isPowered());
  }

  /**
   * Test {@link Lever#setPowered(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Lever#Lever()} Powered.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setPowered(boolean)}
   */
  @Test
  @DisplayName("Test setPowered(boolean); when 'true'; then Lever() Powered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setPowered(boolean)"})
  void testSetPowered_whenTrue_thenLeverPowered() {
    // Arrange
    Lever lever = new Lever();

    // Act
    lever.setPowered(true);

    // Assert
    assertTrue(lever.isPowered());
    assertEquals('\b', lever.getData());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLeverWithTypeIsAcaciaBoatAndDataIsA_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, new Lever(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is five; then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLeverWithTypeIsAcaciaBoatAndDataIsFive_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, new Lever(Material.ACACIA_BOAT, (byte) 5).getAttachedFace());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       four.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is four; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLeverWithTypeIsAcaciaBoatAndDataIsFour_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new Lever(Material.ACACIA_BOAT, (byte) 4).getAttachedFace());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       three.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is three; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLeverWithTypeIsAcaciaBoatAndDataIsThree_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new Lever(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       two.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Lever(Material, byte) with type is 'ACACIA_BOAT' and data is two; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLeverWithTypeIsAcaciaBoatAndDataIsTwo_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, new Lever(Material.ACACIA_BOAT, (byte) 2).getAttachedFace());
  }

  /**
   * Test {@link Lever#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Lever(); then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Lever.getAttachedFace()"})
  void testGetAttachedFace_givenLever_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.UP, new Lever().getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>When {@code EAST}.
   *   <li>Then {@link Lever#Lever()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Lever(); when 'EAST'; then Lever() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenLever_whenEast_thenLeverDataIsZero() {
    // Arrange
    Lever lever = new Lever();

    // Act
    lever.setFacingDirection(BlockFace.EAST);

    // Assert that nothing has changed
    assertEquals((byte) 0, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getFacing());
    assertEquals(BlockFace.UP, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Lever#Lever()} Data is seven.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Lever(); when 'NORTH'; then Lever() Data is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenLever_whenNorth_thenLeverDataIsSeven() {
    // Arrange
    Lever lever = new Lever();

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 7, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getFacing());
    assertEquals(BlockFace.UP, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>When {@code UP}.
   *   <li>Then {@link Lever#Lever()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); given Lever(); when 'UP'; then Lever() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_givenLever_whenUp_thenLeverDataIsZero() {
    // Arrange
    Lever lever = new Lever();

    // Act
    lever.setFacingDirection(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getFacing());
    assertEquals(BlockFace.UP, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A' Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsADataIsFour() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, lever.getData());
    assertEquals(BlockFace.NORTH, lever.getFacing());
    assertEquals(BlockFace.SOUTH, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A' Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsADataIsThree() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Act
    lever.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, lever.getData());
    assertEquals(BlockFace.NORTH, lever.getAttachedFace());
    assertEquals(BlockFace.SOUTH, lever.getFacing());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is five Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsFiveDataIsFive() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 5);

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 5, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getAttachedFace());
    assertEquals(BlockFace.UP, lever.getFacing());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five Data is six.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is five Data is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsFiveDataIsSix() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 5);

    // Act
    lever.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 6, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getAttachedFace());
    assertEquals(BlockFace.UP, lever.getFacing());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       five Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is five Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsFiveDataIsZero() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 5);

    // Act
    lever.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 0, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getFacing());
    assertEquals(BlockFace.UP, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       four Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is four Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsFourDataIsFour() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 4);

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert that nothing has changed
    assertEquals((byte) 4, lever.getData());
    assertEquals(BlockFace.NORTH, lever.getFacing());
    assertEquals(BlockFace.SOUTH, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       three Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is three Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsThreeDataIsFour() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 3);

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, lever.getData());
    assertEquals(BlockFace.NORTH, lever.getFacing());
    assertEquals(BlockFace.SOUTH, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is two
   *       Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is two Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_thenLeverWithTypeIsAcaciaBoatAndDataIsTwoDataIsFour() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 2);

    // Act
    lever.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 4, lever.getData());
    assertEquals(BlockFace.NORTH, lever.getFacing());
    assertEquals(BlockFace.SOUTH, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'EAST'; then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A' Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenLeverWithTypeIsAcaciaBoatAndDataIsADataIsOne() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Act
    lever.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 1, lever.getData());
    assertEquals(BlockFace.EAST, lever.getFacing());
    assertEquals(BlockFace.WEST, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'UP'; then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A' Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenLeverWithTypeIsAcaciaBoatAndDataIsADataIsZero() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Act
    lever.setFacingDirection(BlockFace.UP);

    // Assert
    assertEquals((byte) 0, lever.getData());
    assertEquals(BlockFace.DOWN, lever.getFacing());
    assertEquals(BlockFace.UP, lever.getAttachedFace());
  }

  /**
   * Test {@link Lever#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Lever#Lever(Material, byte)} with type is {@code ACACIA_BOAT} and data is
   *       {@code A} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Lever#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName(
      "Test setFacingDirection(BlockFace); when 'WEST'; then Lever(Material, byte) with type is 'ACACIA_BOAT' and data is 'A' Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lever.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenLeverWithTypeIsAcaciaBoatAndDataIsADataIsTwo() {
    // Arrange
    Lever lever = new Lever(Material.ACACIA_BOAT, (byte) 'A');

    // Act
    lever.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 2, lever.getData());
    assertEquals(BlockFace.EAST, lever.getAttachedFace());
    assertEquals(BlockFace.WEST, lever.getFacing());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Given {@link Lever#Lever()}.
   *   <li>Then return {@code LEGACY_LEVER(0) facing DOWN facing DOWN NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Lever(); then return 'LEGACY_LEVER(0) facing DOWN facing DOWN NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_givenLever_thenReturnLegacyLever0FacingDownFacingDownNotPowered() {
    // Arrange, Act and Assert
    assertEquals("LEGACY_LEVER(0) facing DOWN facing DOWN NOT POWERED", new Lever().toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(2) facing WEST facing WEST NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(2) facing WEST facing WEST NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat2FacingWestFacingWestNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(2) facing WEST facing WEST NOT POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 2).toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(3) facing SOUTH facing SOUTH NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'ACACIA_BOAT(3) facing SOUTH facing SOUTH NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat3FacingSouthFacingSouthNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(3) facing SOUTH facing SOUTH NOT POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 3).toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) facing NORTH facing NORTH NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'ACACIA_BOAT(4) facing NORTH facing NORTH NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat4FacingNorthFacingNorthNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(4) facing NORTH facing NORTH NOT POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(5) facing UP facing UP NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(5) facing UP facing UP NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat5FacingUpFacingUpNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(5) facing UP facing UP NOT POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 5).toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) facing EAST facing EAST NOT POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) facing EAST facing EAST NOT POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat65FacingEastFacingEastNotPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) facing EAST facing EAST NOT POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link Lever#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(88) facing DOWN facing DOWN POWERED}.
   * </ul>
   *
   * <p>Method under test: {@link Lever#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(88) facing DOWN facing DOWN POWERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Lever.toString()"})
  void testToString_thenReturnAcaciaBoat88FacingDownFacingDownPowered() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(88) facing DOWN facing DOWN POWERED",
        new Lever(Material.ACACIA_BOAT, (byte) 'X').toString());
  }

  /**
   * Test {@link Lever#clone()}.
   *
   * <p>Method under test: {@link Lever#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Lever Lever.clone()"})
  void testClone() {
    // Arrange
    Lever lever = new Lever();

    // Act
    Lever actualCloneResult = lever.clone();

    // Assert
    assertEquals(lever, actualCloneResult);
  }
}
