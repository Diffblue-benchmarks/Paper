package org.bukkit.block.spawner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.block.spawner.SpawnerEntry.Equipment;
import org.bukkit.entity.EntitySnapshot;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.loot.LootTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpawnerEntryDiffblueTest {
  /**
   * Test Equipment getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Equipment#getDropChances()}
   *   <li>{@link Equipment#getEquipmentLootTable()}
   * </ul>
   */
  @Test
  @DisplayName("Test Equipment getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map Equipment.getDropChances()",
    "LootTable Equipment.getEquipmentLootTable()"
  })
  void testEquipmentGettersAndSetters() {
    // Arrange
    LootTable equipmentLootTable = mock(LootTable.class);
    HashMap<EquipmentSlot, Float> dropChances = new HashMap<>();

    Equipment equipment = new Equipment(equipmentLootTable, dropChances);

    // Act
    Map<EquipmentSlot, Float> actualDropChances = equipment.getDropChances();
    equipment.getEquipmentLootTable();

    // Assert
    assertTrue(actualDropChances.isEmpty());
    assertSame(dropChances, actualDropChances);
  }

  /**
   * Test Equipment {@link Equipment#Equipment(LootTable, Map)}.
   *
   * <ul>
   *   <li>When {@link LootTable}.
   *   <li>Then return DropChances Empty.
   * </ul>
   *
   * <p>Method under test: {@link Equipment#Equipment(LootTable, Map)}
   */
  @Test
  @DisplayName(
      "Test Equipment new Equipment(LootTable, Map); when LootTable; then return DropChances Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Equipment.<init>(LootTable, Map)"})
  void testEquipmentNewEquipment_whenLootTable_thenReturnDropChancesEmpty() {
    // Arrange
    LootTable equipmentLootTable = mock(LootTable.class);

    // Act
    Equipment actualEquipment = new Equipment(equipmentLootTable, new HashMap<>());

    // Assert
    assertTrue(actualEquipment.getDropChances().isEmpty());
    assertSame(equipmentLootTable, actualEquipment.getEquipmentLootTable());
  }

  /**
   * Test Equipment {@link Equipment#setEquipmentLootTable(LootTable)}.
   *
   * <p>Method under test: {@link Equipment#setEquipmentLootTable(LootTable)}
   */
  @Test
  @DisplayName("Test Equipment setEquipmentLootTable(LootTable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Equipment.setEquipmentLootTable(LootTable)"})
  void testEquipmentSetEquipmentLootTable() {
    // Arrange
    LootTable equipmentLootTable = mock(LootTable.class);
    Equipment equipment = new Equipment(equipmentLootTable, new HashMap<>());
    LootTable table = mock(LootTable.class);

    // Act
    equipment.setEquipmentLootTable(table);

    // Assert
    assertSame(table, equipment.getEquipmentLootTable());
  }

  /**
   * Test {@link SpawnerEntry#SpawnerEntry(EntitySnapshot, int, SpawnRule)}.
   *
   * <ul>
   *   <li>When {@link EntitySnapshot}.
   *   <li>Then return Equipment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpawnerEntry#SpawnerEntry(EntitySnapshot, int, SpawnRule)}
   */
  @Test
  @DisplayName(
      "Test new SpawnerEntry(EntitySnapshot, int, SpawnRule); when EntitySnapshot; then return Equipment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnerEntry.<init>(EntitySnapshot, int, SpawnRule)"})
  void testNewSpawnerEntry_whenEntitySnapshot_thenReturnEquipmentIsNull() {
    // Arrange
    EntitySnapshot snapshot = mock(EntitySnapshot.class);
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act
    SpawnerEntry actualSpawnerEntry = new SpawnerEntry(snapshot, 1, spawnRule);

    // Assert
    assertNull(actualSpawnerEntry.getEquipment());
    assertEquals(1, actualSpawnerEntry.getSpawnWeight());
    assertEquals(spawnRule, actualSpawnerEntry.getSpawnRule());
    assertSame(snapshot, actualSpawnerEntry.getSnapshot());
  }

  /**
   * Test {@link SpawnerEntry#SpawnerEntry(EntitySnapshot, int, SpawnRule, Equipment)}.
   *
   * <ul>
   *   <li>When {@link EntitySnapshot}.
   *   <li>Then return SpawnWeight is one.
   * </ul>
   *
   * <p>Method under test: {@link SpawnerEntry#SpawnerEntry(EntitySnapshot, int, SpawnRule,
   * Equipment)}
   */
  @Test
  @DisplayName(
      "Test new SpawnerEntry(EntitySnapshot, int, SpawnRule, Equipment); when EntitySnapshot; then return SpawnWeight is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnerEntry.<init>(EntitySnapshot, int, SpawnRule, Equipment)"})
  void testNewSpawnerEntry_whenEntitySnapshot_thenReturnSpawnWeightIsOne() {
    // Arrange
    EntitySnapshot snapshot = mock(EntitySnapshot.class);
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);
    LootTable equipmentLootTable = mock(LootTable.class);
    Equipment equipment = new Equipment(equipmentLootTable, new HashMap<>());

    // Act
    SpawnerEntry actualSpawnerEntry = new SpawnerEntry(snapshot, 1, spawnRule, equipment);

    // Assert
    assertEquals(1, actualSpawnerEntry.getSpawnWeight());
    Equipment equipment2 = actualSpawnerEntry.getEquipment();
    assertTrue(equipment2.getDropChances().isEmpty());
    assertEquals(spawnRule, actualSpawnerEntry.getSpawnRule());
    assertSame(equipment, equipment2);
    assertSame(snapshot, actualSpawnerEntry.getSnapshot());
  }

  /**
   * Test {@link SpawnerEntry#setSnapshot(EntitySnapshot)}.
   *
   * <p>Method under test: {@link SpawnerEntry#setSnapshot(EntitySnapshot)}
   */
  @Test
  @DisplayName("Test setSnapshot(EntitySnapshot)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnerEntry.setSnapshot(EntitySnapshot)"})
  void testSetSnapshot() {
    // Arrange
    EntitySnapshot snapshot = mock(EntitySnapshot.class);
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    SpawnerEntry spawnerEntry = new SpawnerEntry(snapshot, 1, spawnRule);
    EntitySnapshot snapshot2 = mock(EntitySnapshot.class);

    // Act
    spawnerEntry.setSnapshot(snapshot2);

    // Assert
    assertSame(snapshot2, spawnerEntry.getSnapshot());
  }

  /**
   * Test {@link SpawnerEntry#getSpawnRule()}.
   *
   * <p>Method under test: {@link SpawnerEntry#getSpawnRule()}
   */
  @Test
  @DisplayName("Test getSpawnRule()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SpawnRule SpawnerEntry.getSpawnRule()"})
  void testGetSpawnRule() {
    // Arrange
    EntitySnapshot snapshot = mock(EntitySnapshot.class);
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act and Assert
    assertEquals(spawnRule, new SpawnerEntry(snapshot, 1, spawnRule).getSpawnRule());
  }

  /**
   * Test {@link SpawnerEntry#getSpawnRule()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpawnerEntry#getSpawnRule()}
   */
  @Test
  @DisplayName("Test getSpawnRule(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SpawnRule SpawnerEntry.getSpawnRule()"})
  void testGetSpawnRule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SpawnerEntry(mock(EntitySnapshot.class), 1, null).getSpawnRule());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnerEntry#setEquipment(Equipment)}
   *   <li>{@link SpawnerEntry#setSpawnRule(SpawnRule)}
   *   <li>{@link SpawnerEntry#setSpawnWeight(int)}
   *   <li>{@link SpawnerEntry#getEquipment()}
   *   <li>{@link SpawnerEntry#getSnapshot()}
   *   <li>{@link SpawnerEntry#getSpawnWeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Equipment SpawnerEntry.getEquipment()",
    "EntitySnapshot SpawnerEntry.getSnapshot()",
    "int SpawnerEntry.getSpawnWeight()",
    "void SpawnerEntry.setEquipment(Equipment)",
    "void SpawnerEntry.setSpawnRule(SpawnRule)",
    "void SpawnerEntry.setSpawnWeight(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    EntitySnapshot snapshot = mock(EntitySnapshot.class);
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    SpawnerEntry spawnerEntry = new SpawnerEntry(snapshot, 1, spawnRule);
    LootTable equipmentLootTable = mock(LootTable.class);
    Equipment equipment = new Equipment(equipmentLootTable, new HashMap<>());

    // Act
    spawnerEntry.setEquipment(equipment);
    SpawnRule spawnRule2 = new SpawnRule(1, 3, 1, 3);
    spawnerEntry.setSpawnRule(spawnRule2);
    spawnerEntry.setSpawnWeight(3);
    Equipment actualEquipment = spawnerEntry.getEquipment();
    spawnerEntry.getSnapshot();

    // Assert
    assertEquals(3, spawnerEntry.getSpawnWeight());
    assertSame(equipment, actualEquipment);
  }
}
