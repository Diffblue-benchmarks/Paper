package org.bukkit.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpawnEggDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnEgg#SpawnEgg(Material, byte)}
   *   <li>{@link SpawnEgg#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpawnEgg.<init>(Material, byte)",
    "java.lang.String SpawnEgg.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SpawnEgg actualSpawnEgg = new SpawnEgg(Material.ACACIA_BOAT, (byte) 'A');

    // Assert
    assertEquals("SPAWN EGG{BAT}", actualSpawnEgg.toString());
    assertEquals(Material.ACACIA_BOAT, actualSpawnEgg.getItemType());
    assertEquals('A', actualSpawnEgg.getData());
  }

  /**
   * Test {@link SpawnEgg#SpawnEgg()}.
   *
   * <p>Method under test: {@link SpawnEgg#SpawnEgg()}
   */
  @Test
  @DisplayName("Test new SpawnEgg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnEgg.<init>()"})
  void testNewSpawnEgg() {
    // Arrange and Act
    SpawnEgg actualSpawnEgg = new SpawnEgg();

    // Assert
    assertNull(actualSpawnEgg.getSpawnedType());
    assertEquals((byte) 0, actualSpawnEgg.getData());
    assertEquals(Material.LEGACY_MONSTER_EGG, actualSpawnEgg.getItemType());
  }

  /**
   * Test {@link SpawnEgg#SpawnEgg(byte)}.
   *
   * <p>Method under test: {@link SpawnEgg#SpawnEgg(byte)}
   */
  @Test
  @DisplayName("Test new SpawnEgg(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnEgg.<init>(byte)"})
  void testNewSpawnEgg2() {
    // Arrange and Act
    SpawnEgg actualSpawnEgg = new SpawnEgg((byte) 'A');

    // Assert
    assertEquals(Material.LEGACY_MONSTER_EGG, actualSpawnEgg.getItemType());
    assertEquals(EntityType.BAT, actualSpawnEgg.getSpawnedType());
    assertEquals('A', actualSpawnEgg.getData());
  }

  /**
   * Test {@link SpawnEgg#SpawnEgg(EntityType)}.
   *
   * <p>Method under test: {@link SpawnEgg#SpawnEgg(EntityType)}
   */
  @Test
  @DisplayName("Test new SpawnEgg(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnEgg.<init>(EntityType)"})
  void testNewSpawnEgg3() {
    // Arrange and Act
    SpawnEgg actualSpawnEgg = new SpawnEgg(EntityType.ACACIA_BOAT);

    // Assert
    assertNull(actualSpawnEgg.getSpawnedType());
    assertEquals((byte) -1, actualSpawnEgg.getData());
    assertEquals(Material.LEGACY_MONSTER_EGG, actualSpawnEgg.getItemType());
  }

  /**
   * Test {@link SpawnEgg#getSpawnedType()}.
   *
   * <p>Method under test: {@link SpawnEgg#getSpawnedType()}
   */
  @Test
  @DisplayName("Test getSpawnedType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType SpawnEgg.getSpawnedType()"})
  void testGetSpawnedType() {
    // Arrange, Act and Assert
    assertNull(new SpawnEgg().getSpawnedType());
  }

  /**
   * Test {@link SpawnEgg#setSpawnedType(EntityType)}.
   *
   * <p>Method under test: {@link SpawnEgg#setSpawnedType(EntityType)}
   */
  @Test
  @DisplayName("Test setSpawnedType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnEgg.setSpawnedType(EntityType)"})
  void testSetSpawnedType() {
    // Arrange
    SpawnEgg spawnEgg = new SpawnEgg();

    // Act
    spawnEgg.setSpawnedType(EntityType.ACACIA_BOAT);

    // Assert
    assertEquals((byte) -1, spawnEgg.getData());
  }

  /**
   * Test {@link SpawnEgg#clone()}.
   *
   * <p>Method under test: {@link SpawnEgg#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SpawnEgg SpawnEgg.clone()"})
  void testClone() {
    // Arrange
    SpawnEgg spawnEgg = new SpawnEgg();

    // Act
    SpawnEgg actualCloneResult = spawnEgg.clone();

    // Assert
    assertEquals(spawnEgg, actualCloneResult);
  }
}
