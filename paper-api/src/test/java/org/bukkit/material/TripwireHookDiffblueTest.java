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

class TripwireHookDiffblueTest {
  /**
   * Test {@link TripwireHook#TripwireHook(Material, byte)}.
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook(Material, byte)}
   */
  @Test
  @DisplayName("Test new TripwireHook(Material, byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>(Material, byte)"})
  void testNewTripwireHook() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals(Material.ACACIA_BOAT, actualTripwireHook.getItemType());
    assertEquals('A', actualTripwireHook.getData());
  }

  /**
   * Test {@link TripwireHook#TripwireHook()}.
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook()}
   */
  @Test
  @DisplayName("Test new TripwireHook()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>()"})
  void testNewTripwireHook2() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook();

    // Assert
    assertEquals((byte) 0, actualTripwireHook.getData());
    assertEquals(Material.LEGACY_TRIPWIRE_HOOK, actualTripwireHook.getItemType());
    assertEquals(BlockFace.NORTH, actualTripwireHook.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualTripwireHook.getFacing());
    assertFalse(actualTripwireHook.isActivated());
    assertFalse(actualTripwireHook.isConnected());
    assertFalse(actualTripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#TripwireHook(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook(BlockFace)}
   */
  @Test
  @DisplayName("Test new TripwireHook(BlockFace); when 'EAST'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>(BlockFace)"})
  void testNewTripwireHook_whenEast_thenReturnDataIsThree() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, actualTripwireHook.getData());
    assertEquals(Material.LEGACY_TRIPWIRE_HOOK, actualTripwireHook.getItemType());
    assertEquals(BlockFace.EAST, actualTripwireHook.getFacing());
    assertEquals(BlockFace.WEST, actualTripwireHook.getAttachedFace());
    assertFalse(actualTripwireHook.isActivated());
    assertFalse(actualTripwireHook.isConnected());
    assertFalse(actualTripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#TripwireHook(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook(BlockFace)}
   */
  @Test
  @DisplayName("Test new TripwireHook(BlockFace); when 'NORTH'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>(BlockFace)"})
  void testNewTripwireHook_whenNorth_thenReturnDataIsTwo() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, actualTripwireHook.getData());
    assertEquals(Material.LEGACY_TRIPWIRE_HOOK, actualTripwireHook.getItemType());
    assertEquals(BlockFace.NORTH, actualTripwireHook.getFacing());
    assertEquals(BlockFace.SOUTH, actualTripwireHook.getAttachedFace());
    assertFalse(actualTripwireHook.isActivated());
    assertFalse(actualTripwireHook.isConnected());
    assertFalse(actualTripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#TripwireHook(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook(BlockFace)}
   */
  @Test
  @DisplayName("Test new TripwireHook(BlockFace); when 'SOUTH'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>(BlockFace)"})
  void testNewTripwireHook_whenSouth_thenReturnDataIsZero() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook(BlockFace.SOUTH);

    // Assert
    assertEquals((byte) 0, actualTripwireHook.getData());
    assertEquals(Material.LEGACY_TRIPWIRE_HOOK, actualTripwireHook.getItemType());
    assertEquals(BlockFace.NORTH, actualTripwireHook.getAttachedFace());
    assertEquals(BlockFace.SOUTH, actualTripwireHook.getFacing());
    assertFalse(actualTripwireHook.isActivated());
    assertFalse(actualTripwireHook.isConnected());
    assertFalse(actualTripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#TripwireHook(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#TripwireHook(BlockFace)}
   */
  @Test
  @DisplayName("Test new TripwireHook(BlockFace); when 'WEST'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.<init>(BlockFace)"})
  void testNewTripwireHook_whenWest_thenReturnDataIsOne() {
    // Arrange and Act
    TripwireHook actualTripwireHook = new TripwireHook(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, actualTripwireHook.getData());
    assertEquals(Material.LEGACY_TRIPWIRE_HOOK, actualTripwireHook.getItemType());
    assertEquals(BlockFace.EAST, actualTripwireHook.getAttachedFace());
    assertEquals(BlockFace.WEST, actualTripwireHook.getFacing());
    assertFalse(actualTripwireHook.isActivated());
    assertFalse(actualTripwireHook.isConnected());
    assertFalse(actualTripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#isConnected()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isConnected()}
   */
  @Test
  @DisplayName("Test isConnected(); given TripwireHook(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isConnected()"})
  void testIsConnected_givenTripwireHook_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TripwireHook().isConnected());
  }

  /**
   * Test {@link TripwireHook#isConnected()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isConnected()}
   */
  @Test
  @DisplayName("Test isConnected(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isConnected()"})
  void testIsConnected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TripwireHook(Material.ACACIA_BOAT, (byte) 7).isConnected());
  }

  /**
   * Test {@link TripwireHook#setConnected(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setConnected(boolean)}
   */
  @Test
  @DisplayName("Test setConnected(boolean); when 'false'; then TripwireHook() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setConnected(boolean)"})
  void testSetConnected_whenFalse_thenTripwireHookDataIsZero() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setConnected(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, tripwireHook.getData());
    assertFalse(tripwireHook.isConnected());
  }

  /**
   * Test {@link TripwireHook#setConnected(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is four.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setConnected(boolean)}
   */
  @Test
  @DisplayName("Test setConnected(boolean); when 'true'; then TripwireHook() Data is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setConnected(boolean)"})
  void testSetConnected_whenTrue_thenTripwireHookDataIsFour() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setConnected(true);

    // Assert
    assertEquals((byte) 4, tripwireHook.getData());
    assertTrue(tripwireHook.isConnected());
  }

  /**
   * Test {@link TripwireHook#isActivated()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook(Material, byte)} with type is {@code ACACIA_BOAT}
   *       and data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isActivated()}
   */
  @Test
  @DisplayName(
      "Test isActivated(); given TripwireHook(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isActivated()"})
  void testIsActivated_givenTripwireHookWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TripwireHook(Material.ACACIA_BOAT, (byte) 'X').isActivated());
  }

  /**
   * Test {@link TripwireHook#isActivated()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isActivated()}
   */
  @Test
  @DisplayName("Test isActivated(); given TripwireHook(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isActivated()"})
  void testIsActivated_givenTripwireHook_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TripwireHook().isActivated());
  }

  /**
   * Test {@link TripwireHook#setActivated(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setActivated(boolean)}
   */
  @Test
  @DisplayName("Test setActivated(boolean); when 'false'; then TripwireHook() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setActivated(boolean)"})
  void testSetActivated_whenFalse_thenTripwireHookDataIsZero() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setActivated(false);

    // Assert that nothing has changed
    assertEquals((byte) 0, tripwireHook.getData());
    assertFalse(tripwireHook.isActivated());
    assertFalse(tripwireHook.isPowered());
  }

  /**
   * Test {@link TripwireHook#setActivated(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Activated.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setActivated(boolean)}
   */
  @Test
  @DisplayName("Test setActivated(boolean); when 'true'; then TripwireHook() Activated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setActivated(boolean)"})
  void testSetActivated_whenTrue_thenTripwireHookActivated() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setActivated(true);

    // Assert
    assertTrue(tripwireHook.isActivated());
    assertTrue(tripwireHook.isPowered());
    assertEquals('\b', tripwireHook.getData());
  }

  /**
   * Test {@link TripwireHook#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'EAST'; then TripwireHook() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenEast_thenTripwireHookDataIsThree() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setFacingDirection(BlockFace.EAST);

    // Assert
    assertEquals((byte) 3, tripwireHook.getData());
    assertEquals(BlockFace.EAST, tripwireHook.getFacing());
    assertEquals(BlockFace.WEST, tripwireHook.getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'NORTH'; then TripwireHook() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenNorth_thenTripwireHookDataIsTwo() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setFacingDirection(BlockFace.NORTH);

    // Assert
    assertEquals((byte) 2, tripwireHook.getData());
    assertEquals(BlockFace.NORTH, tripwireHook.getFacing());
    assertEquals(BlockFace.SOUTH, tripwireHook.getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'SOUTH'; then TripwireHook() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenSouth_thenTripwireHookDataIsZero() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setFacingDirection(BlockFace.SOUTH);

    // Assert that nothing has changed
    assertEquals((byte) 0, tripwireHook.getData());
    assertEquals(BlockFace.NORTH, tripwireHook.getAttachedFace());
    assertEquals(BlockFace.SOUTH, tripwireHook.getFacing());
  }

  /**
   * Test {@link TripwireHook#setFacingDirection(BlockFace)}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link TripwireHook#TripwireHook()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#setFacingDirection(BlockFace)}
   */
  @Test
  @DisplayName("Test setFacingDirection(BlockFace); when 'WEST'; then TripwireHook() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TripwireHook.setFacingDirection(BlockFace)"})
  void testSetFacingDirection_whenWest_thenTripwireHookDataIsOne() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    tripwireHook.setFacingDirection(BlockFace.WEST);

    // Assert
    assertEquals((byte) 1, tripwireHook.getData());
    assertEquals(BlockFace.EAST, tripwireHook.getAttachedFace());
    assertEquals(BlockFace.WEST, tripwireHook.getFacing());
  }

  /**
   * Test {@link TripwireHook#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook(BlockFace)} with dir is {@code NORTH}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#getAttachedFace()}
   */
  @Test
  @DisplayName(
      "Test getAttachedFace(); given TripwireHook(BlockFace) with dir is 'NORTH'; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TripwireHook.getAttachedFace()"})
  void testGetAttachedFace_givenTripwireHookWithDirIsNorth_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, new TripwireHook(BlockFace.NORTH).getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#getAttachedFace()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook()}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); given TripwireHook(); then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TripwireHook.getAttachedFace()"})
  void testGetAttachedFace_givenTripwireHook_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, new TripwireHook().getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TripwireHook.getAttachedFace()"})
  void testGetAttachedFace_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.EAST, new TripwireHook(Material.ACACIA_BOAT, (byte) 'A').getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#getAttachedFace()}.
   *
   * <ul>
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#getAttachedFace()}
   */
  @Test
  @DisplayName("Test getAttachedFace(); then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace TripwireHook.getAttachedFace()"})
  void testGetAttachedFace_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(
        BlockFace.WEST, new TripwireHook(Material.ACACIA_BOAT, (byte) 3).getAttachedFace());
  }

  /**
   * Test {@link TripwireHook#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook(Material, byte)} with type is {@code ACACIA_BOAT}
   *       and data is {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isPowered()}
   */
  @Test
  @DisplayName(
      "Test isPowered(); given TripwireHook(Material, byte) with type is 'ACACIA_BOAT' and data is 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isPowered()"})
  void testIsPowered_givenTripwireHookWithTypeIsAcaciaBoatAndDataIsX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TripwireHook(Material.ACACIA_BOAT, (byte) 'X').isPowered());
  }

  /**
   * Test {@link TripwireHook#isPowered()}.
   *
   * <ul>
   *   <li>Given {@link TripwireHook#TripwireHook()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#isPowered()}
   */
  @Test
  @DisplayName("Test isPowered(); given TripwireHook(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TripwireHook.isPowered()"})
  void testIsPowered_givenTripwireHook_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TripwireHook().isPowered());
  }

  /**
   * Test {@link TripwireHook#clone()}.
   *
   * <p>Method under test: {@link TripwireHook#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TripwireHook TripwireHook.clone()"})
  void testClone() {
    // Arrange
    TripwireHook tripwireHook = new TripwireHook();

    // Act
    TripwireHook actualCloneResult = tripwireHook.clone();

    // Assert
    assertEquals(tripwireHook, actualCloneResult);
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(3) facing EAST facing EAST}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(3) facing EAST facing EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnAcaciaBoat3FacingEastFacingEast() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(3) facing EAST facing EAST",
        new TripwireHook(Material.ACACIA_BOAT, (byte) 3).toString());
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(4) facing SOUTH facing SOUTH Connected}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(4) facing SOUTH facing SOUTH Connected'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnAcaciaBoat4FacingSouthFacingSouthConnected() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(4) facing SOUTH facing SOUTH Connected",
        new TripwireHook(Material.ACACIA_BOAT, (byte) 4).toString());
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(65) facing WEST facing WEST}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(65) facing WEST facing WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnAcaciaBoat65FacingWestFacingWest() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(65) facing WEST facing WEST",
        new TripwireHook(Material.ACACIA_BOAT, (byte) 'A').toString());
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ACACIA_BOAT(88) facing SOUTH facing SOUTH Activated}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ACACIA_BOAT(88) facing SOUTH facing SOUTH Activated'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnAcaciaBoat88FacingSouthFacingSouthActivated() {
    // Arrange, Act and Assert
    assertEquals(
        "ACACIA_BOAT(88) facing SOUTH facing SOUTH Activated",
        new TripwireHook(Material.ACACIA_BOAT, (byte) 'X').toString());
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_TRIPWIRE_HOOK(0) facing SOUTH facing SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_TRIPWIRE_HOOK(0) facing SOUTH facing SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnLegacyTripwireHook0FacingSouthFacingSouth() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_TRIPWIRE_HOOK(0) facing SOUTH facing SOUTH", new TripwireHook().toString());
  }

  /**
   * Test {@link TripwireHook#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LEGACY_TRIPWIRE_HOOK(2) facing NORTH facing NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link TripwireHook#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LEGACY_TRIPWIRE_HOOK(2) facing NORTH facing NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TripwireHook.toString()"})
  void testToString_thenReturnLegacyTripwireHook2FacingNorthFacingNorth() {
    // Arrange, Act and Assert
    assertEquals(
        "LEGACY_TRIPWIRE_HOOK(2) facing NORTH facing NORTH",
        new TripwireHook(BlockFace.NORTH).toString());
  }
}
