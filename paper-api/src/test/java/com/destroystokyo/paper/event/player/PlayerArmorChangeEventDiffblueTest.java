package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent.SlotType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerArmorChangeEventDiffblueTest {
  /**
   * Test SlotType {@link SlotType#getByMaterial(Material)}.
   *
   * <p>Method under test: {@link SlotType#getByMaterial(Material)}
   */
  @Test
  @DisplayName("Test SlotType getByMaterial(Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SlotType SlotType.getByMaterial(Material)"})
  void testSlotTypeGetByMaterial() {
    // Arrange, Act and Assert
    assertNull(SlotType.getByMaterial(Material.ACACIA_BOAT));
  }

  /**
   * Test SlotType {@link SlotType#getTypes()}.
   *
   * <p>Method under test: {@link SlotType#getTypes()}
   */
  @Test
  @DisplayName("Test SlotType getTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SlotType.getTypes()"})
  void testSlotTypeGetTypes() {
    // Arrange and Act
    Set<Material> actualTypes = SlotType.valueOf("HEAD").getTypes();

    // Assert
    assertEquals(15, actualTypes.size());
    assertTrue(actualTypes.contains(Material.CHAINMAIL_HELMET));
    assertTrue(actualTypes.contains(Material.CREEPER_HEAD));
    assertTrue(actualTypes.contains(Material.DIAMOND_HELMET));
    assertTrue(actualTypes.contains(Material.DRAGON_HEAD));
    assertTrue(actualTypes.contains(Material.GOLDEN_HELMET));
    assertTrue(actualTypes.contains(Material.LEATHER_HELMET));
    assertTrue(actualTypes.contains(Material.NETHERITE_HELMET));
    assertTrue(actualTypes.contains(Material.PIGLIN_HEAD));
    assertTrue(actualTypes.contains(Material.TURTLE_HELMET));
    assertTrue(actualTypes.contains(Material.WITHER_SKELETON_SKULL));
    assertTrue(actualTypes.contains(Material.ZOMBIE_HEAD));
  }

  /**
   * Test SlotType {@link SlotType#isEquipable(Material)}.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SlotType#isEquipable(Material)}
   */
  @Test
  @DisplayName("Test SlotType isEquipable(Material); when 'ACACIA_BOAT'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SlotType.isEquipable(Material)"})
  void testSlotTypeIsEquipable_whenAcaciaBoat_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SlotType.isEquipable(Material.ACACIA_BOAT));
  }
}
