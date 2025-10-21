package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.NetherWartsState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NetherWartsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return toString is {@code RIPE ACACIA_BOAT(65)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NetherWarts#NetherWarts(Material, byte)}
   *   <li>{@link NetherWarts#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return toString is 'RIPE ACACIA_BOAT(65)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NetherWarts.<init>(Material)",
    "void NetherWarts.<init>(Material, byte)",
    "java.lang.String NetherWarts.toString()"
  })
  void testGettersAndSetters_whenA_thenReturnToStringIsRipeAcaciaBoat65() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("RIPE ACACIA_BOAT(65)", actualNetherWarts.toString());
    assertEquals(Material.ACACIA_BOAT, actualNetherWarts.getItemType());
    assertEquals('A', actualNetherWarts.getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return toString is {@code SEEDED ACACIA_BOAT(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NetherWarts#NetherWarts(Material)}
   *   <li>{@link NetherWarts#toString()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return toString is 'SEEDED ACACIA_BOAT(0)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NetherWarts.<init>(Material)",
    "void NetherWarts.<init>(Material, byte)",
    "java.lang.String NetherWarts.toString()"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnToStringIsSeededAcaciaBoat0() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(Material.ACACIA_BOAT);

    // Assert
    assertEquals("SEEDED ACACIA_BOAT(0)", actualNetherWarts.toString());
    assertEquals((byte) 0, actualNetherWarts.getData());
    assertEquals(Material.ACACIA_BOAT, actualNetherWarts.getItemType());
  }

  /**
   * Test {@link NetherWarts#NetherWarts()}.
   *
   * <p>Method under test: {@link NetherWarts#NetherWarts()}
   */
  @Test
  @DisplayName("Test new NetherWarts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.<init>()"})
  void testNewNetherWarts() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts();

    // Assert
    assertEquals((byte) 0, actualNetherWarts.getData());
    assertEquals(Material.LEGACY_NETHER_WARTS, actualNetherWarts.getItemType());
    assertEquals(NetherWartsState.SEEDED, actualNetherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#NetherWarts(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code RIPE}.
   *   <li>Then return Data is three.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#NetherWarts(NetherWartsState)}
   */
  @Test
  @DisplayName("Test new NetherWarts(NetherWartsState); when 'RIPE'; then return Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.<init>(NetherWartsState)"})
  void testNewNetherWarts_whenRipe_thenReturnDataIsThree() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(NetherWartsState.RIPE);

    // Assert
    assertEquals((byte) 3, actualNetherWarts.getData());
    assertEquals(Material.LEGACY_NETHER_WARTS, actualNetherWarts.getItemType());
    assertEquals(NetherWartsState.RIPE, actualNetherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#NetherWarts(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code SEEDED}.
   *   <li>Then return Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#NetherWarts(NetherWartsState)}
   */
  @Test
  @DisplayName("Test new NetherWarts(NetherWartsState); when 'SEEDED'; then return Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.<init>(NetherWartsState)"})
  void testNewNetherWarts_whenSeeded_thenReturnDataIsZero() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(NetherWartsState.SEEDED);

    // Assert
    assertEquals((byte) 0, actualNetherWarts.getData());
    assertEquals(Material.LEGACY_NETHER_WARTS, actualNetherWarts.getItemType());
    assertEquals(NetherWartsState.SEEDED, actualNetherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#NetherWarts(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code STAGE_ONE}.
   *   <li>Then return Data is one.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#NetherWarts(NetherWartsState)}
   */
  @Test
  @DisplayName("Test new NetherWarts(NetherWartsState); when 'STAGE_ONE'; then return Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.<init>(NetherWartsState)"})
  void testNewNetherWarts_whenStageOne_thenReturnDataIsOne() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(NetherWartsState.STAGE_ONE);

    // Assert
    assertEquals((byte) 1, actualNetherWarts.getData());
    assertEquals(Material.LEGACY_NETHER_WARTS, actualNetherWarts.getItemType());
    assertEquals(NetherWartsState.STAGE_ONE, actualNetherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#NetherWarts(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code STAGE_TWO}.
   *   <li>Then return Data is two.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#NetherWarts(NetherWartsState)}
   */
  @Test
  @DisplayName("Test new NetherWarts(NetherWartsState); when 'STAGE_TWO'; then return Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.<init>(NetherWartsState)"})
  void testNewNetherWarts_whenStageTwo_thenReturnDataIsTwo() {
    // Arrange and Act
    NetherWarts actualNetherWarts = new NetherWarts(NetherWartsState.STAGE_TWO);

    // Assert
    assertEquals((byte) 2, actualNetherWarts.getData());
    assertEquals(Material.LEGACY_NETHER_WARTS, actualNetherWarts.getItemType());
    assertEquals(NetherWartsState.STAGE_TWO, actualNetherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#getState()}.
   *
   * <ul>
   *   <li>Given {@link NetherWarts#NetherWarts()} Data is {@code A}.
   *   <li>Then return {@code RIPE}.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#getState()}
   */
  @Test
  @DisplayName("Test getState(); given NetherWarts() Data is 'A'; then return 'RIPE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NetherWartsState NetherWarts.getState()"})
  void testGetState_givenNetherWartsDataIsA_thenReturnRipe() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();
    netherWarts.setData((byte) 'A');

    // Act and Assert
    assertEquals(NetherWartsState.RIPE, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#getState()}.
   *
   * <ul>
   *   <li>Given {@link NetherWarts#NetherWarts(Material)} with type is {@code ACACIA_BOAT} Data is
   *       one.
   *   <li>Then return {@code STAGE_ONE}.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#getState()}
   */
  @Test
  @DisplayName(
      "Test getState(); given NetherWarts(Material) with type is 'ACACIA_BOAT' Data is one; then return 'STAGE_ONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NetherWartsState NetherWarts.getState()"})
  void testGetState_givenNetherWartsWithTypeIsAcaciaBoatDataIsOne_thenReturnStageOne() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts(Material.ACACIA_BOAT);
    netherWarts.setData((byte) 1);

    // Act and Assert
    assertEquals(NetherWartsState.STAGE_ONE, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#getState()}.
   *
   * <ul>
   *   <li>Given {@link NetherWarts#NetherWarts(Material)} with type is {@code ACACIA_BOAT} Data is
   *       two.
   *   <li>Then return {@code STAGE_TWO}.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#getState()}
   */
  @Test
  @DisplayName(
      "Test getState(); given NetherWarts(Material) with type is 'ACACIA_BOAT' Data is two; then return 'STAGE_TWO'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NetherWartsState NetherWarts.getState()"})
  void testGetState_givenNetherWartsWithTypeIsAcaciaBoatDataIsTwo_thenReturnStageTwo() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts(Material.ACACIA_BOAT);
    netherWarts.setData((byte) 2);

    // Act and Assert
    assertEquals(NetherWartsState.STAGE_TWO, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#getState()}.
   *
   * <ul>
   *   <li>Given {@link NetherWarts#NetherWarts()}.
   *   <li>Then return {@code SEEDED}.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#getState()}
   */
  @Test
  @DisplayName("Test getState(); given NetherWarts(); then return 'SEEDED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NetherWartsState NetherWarts.getState()"})
  void testGetState_givenNetherWarts_thenReturnSeeded() {
    // Arrange, Act and Assert
    assertEquals(NetherWartsState.SEEDED, new NetherWarts().getState());
  }

  /**
   * Test {@link NetherWarts#setState(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code RIPE}.
   *   <li>Then {@link NetherWarts#NetherWarts()} Data is three.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#setState(NetherWartsState)}
   */
  @Test
  @DisplayName("Test setState(NetherWartsState); when 'RIPE'; then NetherWarts() Data is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.setState(NetherWartsState)"})
  void testSetState_whenRipe_thenNetherWartsDataIsThree() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();

    // Act
    netherWarts.setState(NetherWartsState.RIPE);

    // Assert
    assertEquals((byte) 3, netherWarts.getData());
    assertEquals(NetherWartsState.RIPE, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#setState(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code SEEDED}.
   *   <li>Then {@link NetherWarts#NetherWarts()} Data is zero.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#setState(NetherWartsState)}
   */
  @Test
  @DisplayName("Test setState(NetherWartsState); when 'SEEDED'; then NetherWarts() Data is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.setState(NetherWartsState)"})
  void testSetState_whenSeeded_thenNetherWartsDataIsZero() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();

    // Act
    netherWarts.setState(NetherWartsState.SEEDED);

    // Assert that nothing has changed
    assertEquals((byte) 0, netherWarts.getData());
    assertEquals(NetherWartsState.SEEDED, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#setState(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code STAGE_ONE}.
   *   <li>Then {@link NetherWarts#NetherWarts()} Data is one.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#setState(NetherWartsState)}
   */
  @Test
  @DisplayName("Test setState(NetherWartsState); when 'STAGE_ONE'; then NetherWarts() Data is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.setState(NetherWartsState)"})
  void testSetState_whenStageOne_thenNetherWartsDataIsOne() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();

    // Act
    netherWarts.setState(NetherWartsState.STAGE_ONE);

    // Assert
    assertEquals((byte) 1, netherWarts.getData());
    assertEquals(NetherWartsState.STAGE_ONE, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#setState(NetherWartsState)}.
   *
   * <ul>
   *   <li>When {@code STAGE_TWO}.
   *   <li>Then {@link NetherWarts#NetherWarts()} Data is two.
   * </ul>
   *
   * <p>Method under test: {@link NetherWarts#setState(NetherWartsState)}
   */
  @Test
  @DisplayName("Test setState(NetherWartsState); when 'STAGE_TWO'; then NetherWarts() Data is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NetherWarts.setState(NetherWartsState)"})
  void testSetState_whenStageTwo_thenNetherWartsDataIsTwo() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();

    // Act
    netherWarts.setState(NetherWartsState.STAGE_TWO);

    // Assert
    assertEquals((byte) 2, netherWarts.getData());
    assertEquals(NetherWartsState.STAGE_TWO, netherWarts.getState());
  }

  /**
   * Test {@link NetherWarts#clone()}.
   *
   * <p>Method under test: {@link NetherWarts#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NetherWarts NetherWarts.clone()"})
  void testClone() {
    // Arrange
    NetherWarts netherWarts = new NetherWarts();

    // Act
    NetherWarts actualCloneResult = netherWarts.clone();

    // Assert
    assertEquals(netherWarts, actualCloneResult);
  }
}
