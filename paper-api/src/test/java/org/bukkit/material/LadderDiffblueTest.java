package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LadderDiffblueTest {
  /**
   * Test {@link Ladder#Ladder()}.
   *
   * <p>Method under test: {@link Ladder#Ladder()}
   */
  @Test
  @DisplayName("Test new Ladder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.<init>()"})
  void testNewLadder() {
    // Arrange and Act
    Ladder actualLadder = new Ladder();

    // Assert
    assertNull(actualLadder.getAttachedFace());
    assertNull(actualLadder.getFacing());
    assertEquals((byte) 0, actualLadder.getData());
    assertEquals(Material.LEGACY_LADDER, actualLadder.getItemType());
  }

  /**
   * Test {@link Ladder#Ladder(Material, byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#Ladder(Material, byte)}
   */
  @Test
  @DisplayName("Test new Ladder(Material, byte); when 'A'; then return Data is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.<init>(Material)", "void Ladder.<init>(Material, byte)"})
  void testNewLadder_whenA_thenReturnDataIsA() {
    // Arrange and Act
    Ladder actualLadder = new Ladder(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualLadder.getItemType());
    assertEquals('A', actualLadder.getData());
  }

  /**
   * Test {@link Ladder#Ladder(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#Ladder(Material)}
   */
  @Test
  @DisplayName("Test new Ladder(Material); when 'ACACIA_BOAT'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.<init>(Material)", "void Ladder.<init>(Material, byte)"})
  void testNewLadder_whenAcaciaBoat_thenReturnDataIsZero() {
    // Arrange and Act
    Ladder actualLadder = new Ladder(Material.ACACIA_BOAT);

    // Assert
    assertEquals((byte) 0, actualLadder.getData());
    assertEquals(Material.ACACIA_BOAT, actualLadder.getItemType());
  }

  /**
   * Test {@link Ladder#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder(Material)} with type is {@code ACACIA_BOAT} Data is five.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Ladder(Material) with type is 'ACACIA_BOAT' Data is five; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Ladder.getAttachedFace()"})
  void testGetAttachedFace_givenLadderWithTypeIsAcaciaBoatDataIsFive_thenReturnWest() {
    // Arrange
    Ladder ladder = new Ladder(Material.ACACIA_BOAT);
    ladder.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.WEST, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder(Material)} with type is {@code ACACIA_BOAT} Data is four.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Ladder(Material) with type is 'ACACIA_BOAT' Data is four; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Ladder.getAttachedFace()"})
  void testGetAttachedFace_givenLadderWithTypeIsAcaciaBoatDataIsFour_thenReturnEast() {
    // Arrange
    Ladder ladder = new Ladder(Material.ACACIA_BOAT);
    ladder.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.EAST, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Ladder(Material) with type is 'ACACIA_BOAT' Data is three; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Ladder.getAttachedFace()"})
  void testGetAttachedFace_givenLadderWithTypeIsAcaciaBoatDataIsThree_thenReturnNorth() {
    // Arrange
    Ladder ladder = new Ladder(Material.ACACIA_BOAT);
    ladder.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.NORTH, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given Ladder(Material) with type is 'ACACIA_BOAT' Data is two; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Ladder.getAttachedFace()"})
  void testGetAttachedFace_givenLadderWithTypeIsAcaciaBoatDataIsTwo_thenReturnSouth() {
    // Arrange
    Ladder ladder = new Ladder(Material.ACACIA_BOAT);
    ladder.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link Ladder#Ladder()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given Ladder(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Ladder.getAttachedFace()"})
  void testGetAttachedFace_givenLadder_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Ladder().getAttachedFace());
  }

  /**
   * Test {@link Ladder#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Ladder#Ladder()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Ladder() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenLadderDataIsFour() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    ladder.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 4, ladder.getData());
    assertEquals(BlockFace.EAST, ladder.getAttachedFace());
    assertEquals(BlockFace.WEST, ladder.getFacing());
  }

  /**
   * Test {@link Ladder#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Ladder#Ladder()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Ladder() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenLadderDataIsThree() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    ladder.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 3, ladder.getData());
    assertEquals(BlockFace.NORTH, ladder.getAttachedFace());
    assertEquals(BlockFace.SOUTH, ladder.getFacing());
  }

  /**
   * Test {@link Ladder#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Ladder#Ladder()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Ladder() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenLadderDataIsTwo() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    ladder.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 2, ladder.getData());
    assertEquals(BlockFace.NORTH, ladder.getFacing());
    assertEquals(BlockFace.SOUTH, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link Ladder#Ladder()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'UP'; then Ladder() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenUp_thenLadderDataIsZero() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    ladder.setFacingDirection(BlockFace.UP);

    // Assert that nothing has changed
    assertEquals((byte) 0, ladder.getData());
  }

  /**
   * Test {@link Ladder#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Ladder#Ladder()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Ladder#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Ladder() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ladder.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenLadderDataIsFive() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    ladder.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 5, ladder.getData());
    assertEquals(BlockFace.EAST, ladder.getFacing());
    assertEquals(BlockFace.WEST, ladder.getAttachedFace());
  }

  /**
   * Test {@link Ladder#clone()}.
   *
   * <p>Method under test: {@link Ladder#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Ladder Ladder.clone()"})
  void testClone() {
    // Arrange
    Ladder ladder = new Ladder();

    // Act
    Ladder actualCloneResult = ladder.clone();

    // Assert
    assertEquals(ladder, actualCloneResult);
  }
}
