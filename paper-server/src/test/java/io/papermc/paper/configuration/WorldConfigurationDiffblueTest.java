package io.papermc.paper.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.WorldConfiguration.Entities;
import io.papermc.paper.configuration.WorldConfiguration.Entities.Spawning;
import io.papermc.paper.configuration.WorldConfiguration.Entities.Spawning.DespawnRangePair;
import io.papermc.paper.configuration.WorldConfiguration.Lootables;
import io.papermc.paper.configuration.type.Duration;
import net.minecraft.resources.ResourceLocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldConfigurationDiffblueTest {
  /**
   * Test Entities_Spawning_DespawnRangePair {@link Spawning.DespawnRangePair#createDefault()}.
   *
   * <p>Method under test: {@link Spawning.DespawnRangePair#createDefault()}
   */
  @Test
  @DisplayName("Test Entities_Spawning_DespawnRangePair createDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Spawning.DespawnRangePair Spawning.DespawnRangePair.createDefault()"})
  void testEntities_Spawning_DespawnRangePairCreateDefault() {
    // Arrange and Act
    DespawnRangePair actualCreateDefaultResult = DespawnRangePair.createDefault();

    // Assert
    assertFalse(actualCreateDefaultResult.hard().wasDefinedViaLongSyntax());
    assertFalse(actualCreateDefaultResult.soft().wasDefinedViaLongSyntax());
  }

  /**
   * Test {@link WorldConfiguration#isDefault()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WorldConfiguration#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WorldConfiguration.isDefault()"})
  void testIsDefault_thenReturnFalse() {
    // Arrange
    WorldConfiguration worldConfiguration =
        new WorldConfiguration(null, ResourceLocation.withDefaultNamespace("argument.id.invalid"));

    // Act and Assert
    assertFalse(worldConfiguration.isDefault());
  }

  /**
   * Test {@link WorldConfiguration#isDefault()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WorldConfiguration#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WorldConfiguration.isDefault()"})
  void testIsDefault_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new WorldConfiguration(null, Configurations.WORLD_DEFAULTS_KEY).isDefault());
  }

  /**
   * Test Lootables {@link Lootables#Lootables(WorldConfiguration)}.
   *
   * <p>Method under test: {@link Lootables#Lootables(WorldConfiguration)}
   */
  @Test
  @DisplayName("Test Lootables new Lootables(WorldConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Lootables.<init>(WorldConfiguration)"})
  void testLootablesNewLootables() {
    // Arrange
    WorldConfiguration worldConfiguration =
        new WorldConfiguration(null, ResourceLocation.withDefaultNamespace("argument.id.invalid"));

    // Act
    Lootables actualLootables = worldConfiguration.new Lootables();

    // Assert
    Duration duration = actualLootables.refreshMin;
    assertEquals("12h", duration.value());
    Duration duration2 = actualLootables.refreshMax;
    assertEquals("2d", duration2.value());
    assertEquals(-1, actualLootables.maxRefills);
    assertEquals(172800L, duration2.seconds());
    assertEquals(43200L, duration.seconds());
    assertFalse(actualLootables.restrictPlayerRelootTime.value().isPresent());
    assertFalse(actualLootables.autoReplenish);
    assertTrue(actualLootables.resetSeedOnFill);
    assertTrue(actualLootables.restrictPlayerReloot);
    assertTrue(actualLootables.retainUnlootedShulkerBoxLootTableOnNonPlayerBreak);
  }
}
