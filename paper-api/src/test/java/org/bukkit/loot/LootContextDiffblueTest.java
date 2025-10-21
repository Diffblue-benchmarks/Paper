package org.bukkit.loot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.loot.LootContext.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LootContextDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#killer(HumanEntity)}
   *   <li>{@link Builder#lootedEntity(Entity)}
   *   <li>{@link Builder#lootingModifier(int)}
   *   <li>{@link Builder#luck(float)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LootContext Builder.build()",
    "Builder Builder.killer(HumanEntity)",
    "Builder Builder.lootedEntity(Entity)",
    "Builder Builder.lootingModifier(int)",
    "Builder Builder.luck(float)"
  })
  void testBuilderBuild() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    HumanEntity killer = mock(HumanEntity.class);
    Entity lootedEntity = mock(Entity.class);

    // Act
    LootContext actualLootContext =
        new Builder(location)
            .killer(killer)
            .lootedEntity(lootedEntity)
            .lootingModifier(1)
            .luck(10.0f)
            .build();

    // Assert
    assertEquals(1, actualLootContext.getLootingModifier());
    assertEquals(10.0f, actualLootContext.getLuck());
    assertEquals(location, actualLootContext.getLocation());
    assertSame(lootedEntity, actualLootContext.getLootedEntity());
    assertSame(killer, actualLootContext.getKiller());
  }

  /**
   * Test Builder {@link Builder#Builder(Location)}.
   *
   * <p>Method under test: {@link Builder#Builder(Location)}
   */
  @Test
  @DisplayName("Test Builder new Builder(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(Location)"})
  void testBuilderNewBuilder() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    LootContext lootContext = new Builder(location).build();
    assertNull(lootContext.getLootedEntity());
    assertNull(lootContext.getKiller());
    assertEquals(0.0f, lootContext.getLuck());
    assertEquals(location, lootContext.getLocation());
    assertEquals(LootContext.DEFAULT_LOOT_MODIFIER, lootContext.getLootingModifier());
  }

  /**
   * Test {@link LootContext#getLocation()}.
   *
   * <p>Method under test: {@link LootContext#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location LootContext.getLocation()"})
  void testGetLocation() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertEquals(
        location,
        new Builder(location)
            .killer(mock(HumanEntity.class))
            .lootedEntity(mock(Entity.class))
            .lootingModifier(1)
            .luck(10.0f)
            .build()
            .getLocation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LootContext#getKiller()}
   *   <li>{@link LootContext#getLootedEntity()}
   *   <li>{@link LootContext#getLootingModifier()}
   *   <li>{@link LootContext#getLuck()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HumanEntity LootContext.getKiller()",
    "Entity LootContext.getLootedEntity()",
    "int LootContext.getLootingModifier()",
    "float LootContext.getLuck()"
  })
  void testGettersAndSetters() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    LootContext lootContext =
        new Builder(location)
            .killer(mock(HumanEntity.class))
            .lootedEntity(mock(Entity.class))
            .lootingModifier(1)
            .luck(10.0f)
            .build();

    // Act
    lootContext.getKiller();
    lootContext.getLootedEntity();
    int actualLootingModifier = lootContext.getLootingModifier();

    // Assert
    assertEquals(1, actualLootingModifier);
    assertEquals(10.0f, lootContext.getLuck());
  }
}
