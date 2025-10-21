package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SkullDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code ACACIA_BOAT(65) facing SELF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Skull#Skull(Material, byte)}
   *   <li>{@link Skull#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'A'; then return toString is 'ACACIA_BOAT(65) facing SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Skull.<init>(Material)",
    "void Skull.<init>(Material, byte)",
    "java.lang.String Skull.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsAcaciaBoat65FacingSelf() {
    // Arrange and Act
    Skull actualSkull = new Skull(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("ACACIA_BOAT(65) facing SELF", actualSkull.toString());
    assertEquals(Material.ACACIA_BOAT, actualSkull.getItemType());
    assertEquals('A', actualSkull.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code ACACIA_BOAT(0) facing SELF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Skull#Skull(Material)}
   *   <li>{@link Skull#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'ACACIA_BOAT(0) facing SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Skull.<init>(Material)",
    "void Skull.<init>(Material, byte)",
    "java.lang.String Skull.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsAcaciaBoat0FacingSelf() {
    // Arrange and Act
    Skull actualSkull = new Skull(Material.ACACIA_BOAT);

    // Assert
    assertEquals("ACACIA_BOAT(0) facing SELF", actualSkull.toString());
    assertEquals((byte) 0, actualSkull.getData());
    assertEquals(Material.ACACIA_BOAT, actualSkull.getItemType());
  }

  /**
   * Test {@link Skull#Skull()}.
   *
   * <p>Method under test: {@link Skull#Skull()}
   */
  @Test
  @DisplayName("Test new Skull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>()"})
  void testNewSkull() {
    // Arrange and Act
    Skull actualSkull = new Skull();

    // Assert
    assertEquals((byte) 0, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.SELF, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#Skull(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Skull#Skull(BlockFace)}
   */
  @Test
  @DisplayName("Test new Skull(BlockFace); when 'EAST'; then return Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>(BlockFace)"})
  void testNewSkull_whenEast_thenReturnDataIsFive() {
    // Arrange and Act
    Skull actualSkull = new Skull(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.EAST, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#Skull(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Skull#Skull(BlockFace)}
   */
  @Test
  @DisplayName("Test new Skull(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>(BlockFace)"})
  void testNewSkull_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    Skull actualSkull = new Skull(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.NORTH, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#Skull(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SELF}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Skull#Skull(BlockFace)}
   */
  @Test
  @DisplayName("Test new Skull(BlockFace); when 'SELF'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>(BlockFace)"})
  void testNewSkull_whenSelf_thenReturnDataIsOne() {
    // Arrange and Act
    Skull actualSkull = new Skull(BlockFace.SELF);

    // Assert
    assertEquals((byte) 1, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.SELF, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#Skull(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Skull#Skull(BlockFace)}
   */
  @Test
  @DisplayName("Test new Skull(BlockFace); when 'SOUTH'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>(BlockFace)"})
  void testNewSkull_whenSouth_thenReturnDataIsThree() {
    // Arrange and Act
    Skull actualSkull = new Skull(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.SOUTH, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#Skull(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Skull#Skull(BlockFace)}
   */
  @Test
  @DisplayName("Test new Skull(BlockFace); when 'WEST'; then return Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.<init>(BlockFace)"})
  void testNewSkull_whenWest_thenReturnDataIsFour() {
    // Arrange and Act
    Skull actualSkull = new Skull(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, actualSkull.getData());
    assertEquals(Material.LEGACY_SKULL, actualSkull.getItemType());
    assertEquals(BlockFace.WEST, actualSkull.getFacing());
  }

  /**
   * Test {@link Skull#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link Skull#Skull()} Data is five.
   * </ul>
   *
   * <p>Method under test: {@link Skull#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then Skull() Data is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenSkullDataIsFive() {
    // Arrange
    Skull skull = new Skull();

    // Act
    skull.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 5, skull.getData());
    assertEquals(BlockFace.EAST, skull.getFacing());
  }

  /**
   * Test {@link Skull#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link Skull#Skull()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link Skull#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then Skull() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenSkullDataIsTwo() {
    // Arrange
    Skull skull = new Skull();

    // Act
    skull.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, skull.getData());
    assertEquals(BlockFace.NORTH, skull.getFacing());
  }

  /**
   * Test {@link Skull#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SELF}.
   *   <li>Then {@link Skull#Skull()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link Skull#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SELF'; then Skull() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSelf_thenSkullDataIsOne() {
    // Arrange
    Skull skull = new Skull();

    // Act
    skull.setFacingDirection(BlockFace.SELF);

    // Assert
    assertEquals((byte) 1, skull.getData());
    assertEquals(BlockFace.SELF, skull.getFacing());
  }

  /**
   * Test {@link Skull#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link Skull#Skull()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link Skull#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then Skull() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenSkullDataIsThree() {
    // Arrange
    Skull skull = new Skull();

    // Act
    skull.setFacingDirection(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 3, skull.getData());
    assertEquals(BlockFace.SOUTH, skull.getFacing());
  }

  /**
   * Test {@link Skull#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link Skull#Skull()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link Skull#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then Skull() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Skull.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenSkullDataIsFour() {
    // Arrange
    Skull skull = new Skull();

    // Act
    skull.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 4, skull.getData());
    assertEquals(BlockFace.WEST, skull.getFacing());
  }

  /**
   * Test {@link Skull#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Skull#Skull(Material)} with type is {@code ACACIA_BOAT} Data is five.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link Skull#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Skull(Material) with type is 'ACACIA_BOAT' Data is five; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Skull.getFacing()"})
  void testGetFacing_givenSkullWithTypeIsAcaciaBoatDataIsFive_thenReturnEast() {
    // Arrange
    Skull skull = new Skull(Material.ACACIA_BOAT);
    skull.setData((byte) 5);

    // Act and Assert
    assertEquals(BlockFace.EAST, skull.getFacing());
  }

  /**
   * Test {@link Skull#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Skull#Skull(Material)} with type is {@code ACACIA_BOAT} Data is four.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link Skull#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Skull(Material) with type is 'ACACIA_BOAT' Data is four; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Skull.getFacing()"})
  void testGetFacing_givenSkullWithTypeIsAcaciaBoatDataIsFour_thenReturnWest() {
    // Arrange
    Skull skull = new Skull(Material.ACACIA_BOAT);
    skull.setData((byte) 4);

    // Act and Assert
    assertEquals(BlockFace.WEST, skull.getFacing());
  }

  /**
   * Test {@link Skull#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Skull#Skull(Material)} with type is {@code ACACIA_BOAT} Data is three.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link Skull#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Skull(Material) with type is 'ACACIA_BOAT' Data is three; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Skull.getFacing()"})
  void testGetFacing_givenSkullWithTypeIsAcaciaBoatDataIsThree_thenReturnSouth() {
    // Arrange
    Skull skull = new Skull(Material.ACACIA_BOAT);
    skull.setData((byte) 3);

    // Act and Assert
    assertEquals(BlockFace.SOUTH, skull.getFacing());
  }

  /**
   * Test {@link Skull#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Skull#Skull(Material)} with type is {@code ACACIA_BOAT} Data is two.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link Skull#getFacing()}
   */
  @Test
  @DisplayName(
      "Test getFacing(); given Skull(Material) with type is 'ACACIA_BOAT' Data is two; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Skull.getFacing()"})
  void testGetFacing_givenSkullWithTypeIsAcaciaBoatDataIsTwo_thenReturnNorth() {
    // Arrange
    Skull skull = new Skull(Material.ACACIA_BOAT);
    skull.setData((byte) 2);

    // Act and Assert
    assertEquals(BlockFace.NORTH, skull.getFacing());
  }

  /**
   * Test {@link Skull#getFacing()}.
   *
   * <ul>
   *   <li>Given {@link Skull#Skull()}.
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link Skull#getFacing()}
   */
  @Test
  @DisplayName("Test getFacing(); given Skull(); then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace Skull.getFacing()"})
  void testGetFacing_givenSkull_thenReturnSelf() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SELF, new Skull().getFacing());
  }

  /**
   * Test {@link Skull#clone()}.
   *
   * <p>Method under test: {@link Skull#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Skull Skull.clone()"})
  void testClone() {
    // Arrange
    Skull skull = new Skull();

    // Act
    Skull actualCloneResult = skull.clone();

    // Assert
    assertEquals(skull, actualCloneResult);
  }
}
