package com.destroystokyo.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.event.block.AnvilDamagedEvent.DamageState;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnvilDamagedEventDiffblueTest {
  /**
   * Test DamageState {@link DamageState#getMaterial()}.
   *
   * <p>Method under test: {@link DamageState#getMaterial()}
   */
  @Test
  @DisplayName("Test DamageState getMaterial()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material DamageState.getMaterial()"})
  void testDamageStateGetMaterial() {
    // Arrange, Act and Assert
    assertEquals(Material.ANVIL, DamageState.valueOf("FULL").getMaterial());
  }

  /**
   * Test DamageState {@link DamageState#getState(BlockData)} with {@code blockData}.
   *
   * <ul>
   *   <li>Given {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(BlockData)}
   */
  @Test
  @DisplayName("Test DamageState getState(BlockData) with 'blockData'; given 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(BlockData)"})
  void testDamageStateGetStateWithBlockData_givenAcaciaBoat() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.ACACIA_BOAT);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DamageState.getState(blockData));
    verify(blockData).getMaterial();
  }

  /**
   * Test DamageState {@link DamageState#getState(BlockData)} with {@code blockData}.
   *
   * <ul>
   *   <li>Given {@code AIR}.
   *   <li>When {@link BlockData} {@link BlockData#getMaterial()} return {@code AIR}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(BlockData)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(BlockData) with 'blockData'; given 'AIR'; when BlockData getMaterial() return 'AIR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(BlockData)"})
  void testDamageStateGetStateWithBlockData_givenAir_whenBlockDataGetMaterialReturnAir() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    // Act
    DamageState actualState = DamageState.getState(blockData);

    // Assert
    verify(blockData).getMaterial();
    assertEquals(DamageState.BROKEN, actualState);
  }

  /**
   * Test DamageState {@link DamageState#getState(BlockData)} with {@code blockData}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(BlockData)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(BlockData) with 'blockData'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(BlockData)"})
  void testDamageStateGetStateWithBlockData_givenIllegalArgumentException() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DamageState.getState(blockData));
    verify(blockData).getMaterial();
  }

  /**
   * Test DamageState {@link DamageState#getState(BlockData)} with {@code blockData}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(BlockData)}
   */
  @Test
  @DisplayName("Test DamageState getState(BlockData) with 'blockData'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(BlockData)"})
  void testDamageStateGetStateWithBlockData_givenNull() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(null);

    // Act
    DamageState actualState = DamageState.getState(blockData);

    // Assert
    verify(blockData).getMaterial();
    assertEquals(DamageState.BROKEN, actualState);
  }

  /**
   * Test DamageState {@link DamageState#getState(BlockData)} with {@code blockData}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code BROKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(BlockData)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(BlockData) with 'blockData'; when 'null'; then return 'BROKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(BlockData)"})
  void testDamageStateGetStateWithBlockData_whenNull_thenReturnBroken() {
    // Arrange, Act and Assert
    assertEquals(DamageState.BROKEN, DamageState.getState((BlockData) null));
  }

  /**
   * Test DamageState {@link DamageState#getState(Material)} with {@code material}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(Material)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(Material) with 'material'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(Material)"})
  void testDamageStateGetStateWithMaterial_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DamageState.getState(Material.ACACIA_BOAT));
  }

  /**
   * Test DamageState {@link DamageState#getState(Material)} with {@code material}.
   *
   * <ul>
   *   <li>When {@code AIR}.
   *   <li>Then return {@code BROKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(Material)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(Material) with 'material'; when 'AIR'; then return 'BROKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(Material)"})
  void testDamageStateGetStateWithMaterial_whenAir_thenReturnBroken() {
    // Arrange, Act and Assert
    assertEquals(DamageState.BROKEN, DamageState.getState(Material.AIR));
  }

  /**
   * Test DamageState {@link DamageState#getState(Material)} with {@code material}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code BROKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DamageState#getState(Material)}
   */
  @Test
  @DisplayName(
      "Test DamageState getState(Material) with 'material'; when 'null'; then return 'BROKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageState DamageState.getState(Material)"})
  void testDamageStateGetStateWithMaterial_whenNull_thenReturnBroken() {
    // Arrange, Act and Assert
    assertEquals(DamageState.BROKEN, DamageState.getState((Material) null));
  }

  /**
   * Test {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}.
   *
   * <ul>
   *   <li>Given {@code AIR}.
   *   <li>When {@link BlockData} {@link BlockData#getMaterial()} return {@code AIR}.
   * </ul>
   *
   * <p>Method under test: {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}
   */
  @Test
  @DisplayName(
      "Test new AnvilDamagedEvent(InventoryView, BlockData); given 'AIR'; when BlockData getMaterial() return 'AIR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.<init>(InventoryView, BlockData)"})
  void testNewAnvilDamagedEvent_givenAir_whenBlockDataGetMaterialReturnAir() {
    // Arrange
    InventoryView inventory = mock(InventoryView.class);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    // Act
    AnvilDamagedEvent actualAnvilDamagedEvent = new AnvilDamagedEvent(inventory, blockData);

    // Assert
    verify(blockData).getMaterial();
    assertEquals("AnvilDamagedEvent", actualAnvilDamagedEvent.getEventName());
    assertNull(actualAnvilDamagedEvent.getInventory());
    assertEquals(0, actualAnvilDamagedEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(DamageState.BROKEN, actualAnvilDamagedEvent.getDamageState());
    assertFalse(actualAnvilDamagedEvent.isCancelled());
    assertFalse(actualAnvilDamagedEvent.isAsynchronous());
    assertTrue(actualAnvilDamagedEvent.isBreaking());
    assertSame(inventory, actualAnvilDamagedEvent.getView());
  }

  /**
   * Test {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BlockData} {@link BlockData#getMaterial()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}
   */
  @Test
  @DisplayName(
      "Test new AnvilDamagedEvent(InventoryView, BlockData); given 'null'; when BlockData getMaterial() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.<init>(InventoryView, BlockData)"})
  void testNewAnvilDamagedEvent_givenNull_whenBlockDataGetMaterialReturnNull() {
    // Arrange
    InventoryView inventory = mock(InventoryView.class);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(null);

    // Act
    AnvilDamagedEvent actualAnvilDamagedEvent = new AnvilDamagedEvent(inventory, blockData);

    // Assert
    verify(blockData).getMaterial();
    assertEquals("AnvilDamagedEvent", actualAnvilDamagedEvent.getEventName());
    assertNull(actualAnvilDamagedEvent.getInventory());
    assertEquals(0, actualAnvilDamagedEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(DamageState.BROKEN, actualAnvilDamagedEvent.getDamageState());
    assertFalse(actualAnvilDamagedEvent.isCancelled());
    assertFalse(actualAnvilDamagedEvent.isAsynchronous());
    assertTrue(actualAnvilDamagedEvent.isBreaking());
    assertSame(inventory, actualAnvilDamagedEvent.getView());
  }

  /**
   * Test {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EventName is {@code AnvilDamagedEvent}.
   * </ul>
   *
   * <p>Method under test: {@link AnvilDamagedEvent#AnvilDamagedEvent(InventoryView, BlockData)}
   */
  @Test
  @DisplayName(
      "Test new AnvilDamagedEvent(InventoryView, BlockData); when 'null'; then return EventName is 'AnvilDamagedEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.<init>(InventoryView, BlockData)"})
  void testNewAnvilDamagedEvent_whenNull_thenReturnEventNameIsAnvilDamagedEvent() {
    // Arrange
    InventoryView inventory = mock(InventoryView.class);

    // Act
    AnvilDamagedEvent actualAnvilDamagedEvent = new AnvilDamagedEvent(inventory, null);

    // Assert
    assertEquals("AnvilDamagedEvent", actualAnvilDamagedEvent.getEventName());
    assertNull(actualAnvilDamagedEvent.getInventory());
    assertEquals(0, actualAnvilDamagedEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(DamageState.BROKEN, actualAnvilDamagedEvent.getDamageState());
    assertFalse(actualAnvilDamagedEvent.isCancelled());
    assertFalse(actualAnvilDamagedEvent.isAsynchronous());
    assertTrue(actualAnvilDamagedEvent.isBreaking());
    assertSame(inventory, actualAnvilDamagedEvent.getView());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnvilDamagedEvent#setCancelled(boolean)}
   *   <li>{@link AnvilDamagedEvent#setDamageState(DamageState)}
   *   <li>{@link AnvilDamagedEvent#getHandlerList()}
   *   <li>{@link AnvilDamagedEvent#getDamageState()}
   *   <li>{@link AnvilDamagedEvent#getHandlers()}
   *   <li>{@link AnvilDamagedEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DamageState AnvilDamagedEvent.getDamageState()",
    "HandlerList AnvilDamagedEvent.getHandlerList()",
    "HandlerList AnvilDamagedEvent.getHandlers()",
    "boolean AnvilDamagedEvent.isCancelled()",
    "void AnvilDamagedEvent.setCancelled(boolean)",
    "void AnvilDamagedEvent.setDamageState(DamageState)"
  })
  void testGettersAndSetters() {
    // Arrange
    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), mock(BlockData.class));

    // Act
    anvilDamagedEvent.setCancelled(true);
    anvilDamagedEvent.setDamageState(DamageState.FULL);
    HandlerList actualHandlerList = anvilDamagedEvent.getHandlerList();
    DamageState actualDamageState = anvilDamagedEvent.getDamageState();
    HandlerList actualHandlers = anvilDamagedEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(DamageState.FULL, actualDamageState);
    assertTrue(anvilDamagedEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link AnvilDamagedEvent#isBreaking()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AnvilDamagedEvent#isBreaking()}
   */
  @Test
  @DisplayName("Test isBreaking(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AnvilDamagedEvent.isBreaking()"})
  void testIsBreaking_thenReturnFalse() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    anvilDamagedEvent.setDamageState(DamageState.FULL);

    // Act
    boolean actualIsBreakingResult = anvilDamagedEvent.isBreaking();

    // Assert
    verify(blockData).getMaterial();
    assertFalse(actualIsBreakingResult);
  }

  /**
   * Test {@link AnvilDamagedEvent#isBreaking()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AnvilDamagedEvent#isBreaking()}
   */
  @Test
  @DisplayName("Test isBreaking(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AnvilDamagedEvent.isBreaking()"})
  void testIsBreaking_thenReturnTrue() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);
    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), blockData);

    // Act
    boolean actualIsBreakingResult = anvilDamagedEvent.isBreaking();

    // Assert
    verify(blockData).getMaterial();
    assertTrue(actualIsBreakingResult);
  }

  /**
   * Test {@link AnvilDamagedEvent#setBreaking(boolean)}.
   *
   * <p>Method under test: {@link AnvilDamagedEvent#setBreaking(boolean)}
   */
  @Test
  @DisplayName("Test setBreaking(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.setBreaking(boolean)"})
  void testSetBreaking() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);
    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), blockData);

    // Act
    anvilDamagedEvent.setBreaking(true);

    // Assert that nothing has changed
    verify(blockData).getMaterial();
    assertEquals(DamageState.BROKEN, anvilDamagedEvent.getDamageState());
    assertTrue(anvilDamagedEvent.isBreaking());
  }

  /**
   * Test {@link AnvilDamagedEvent#setBreaking(boolean)}.
   *
   * <p>Method under test: {@link AnvilDamagedEvent#setBreaking(boolean)}
   */
  @Test
  @DisplayName("Test setBreaking(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.setBreaking(boolean)"})
  void testSetBreaking2() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    anvilDamagedEvent.setDamageState(DamageState.BROKEN);

    // Act
    anvilDamagedEvent.setBreaking(false);

    // Assert
    verify(blockData).getMaterial();
    assertEquals(DamageState.DAMAGED, anvilDamagedEvent.getDamageState());
    assertFalse(anvilDamagedEvent.isBreaking());
  }

  /**
   * Test {@link AnvilDamagedEvent#setBreaking(boolean)}.
   *
   * <p>Method under test: {@link AnvilDamagedEvent#setBreaking(boolean)}
   */
  @Test
  @DisplayName("Test setBreaking(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AnvilDamagedEvent.setBreaking(boolean)"})
  void testSetBreaking3() {
    // Arrange
    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent anvilDamagedEvent =
        new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    anvilDamagedEvent.setDamageState(DamageState.FULL);

    // Act
    anvilDamagedEvent.setBreaking(false);

    // Assert that nothing has changed
    verify(blockData).getMaterial();
    assertEquals(DamageState.FULL, anvilDamagedEvent.getDamageState());
    assertFalse(anvilDamagedEvent.isBreaking());
  }
}
