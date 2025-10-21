package org.bukkit.configuration.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.block.spawner.SpawnRule;
import org.bukkit.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigurationSerializationDiffblueTest {
  /**
   * Test {@link ConfigurationSerialization#ConfigurationSerialization(Class)}.
   *
   * <p>Method under test: {@link ConfigurationSerialization#ConfigurationSerialization(Class)}
   */
  @Test
  @DisplayName("Test new ConfigurationSerialization(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigurationSerialization.<init>(Class)"})
  void testNewConfigurationSerialization() {
    // Arrange
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertNull(new ConfigurationSerialization(clazz).getConstructor());
  }

  /**
   * Test {@link ConfigurationSerialization#getMethod(String, boolean)}.
   *
   * <p>Method under test: {@link ConfigurationSerialization#getMethod(String, boolean)}
   */
  @Test
  @DisplayName("Test getMethod(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.reflect.Method ConfigurationSerialization.getMethod(String, boolean)"
  })
  void testGetMethod() {
    // Arrange
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertNull(new ConfigurationSerialization(clazz).getMethod("Name", true));
  }

  /**
   * Test {@link ConfigurationSerialization#getConstructor()}.
   *
   * <p>Method under test: {@link ConfigurationSerialization#getConstructor()}
   */
  @Test
  @DisplayName("Test getConstructor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.reflect.Constructor ConfigurationSerialization.getConstructor()"})
  void testGetConstructor() {
    // Arrange
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertNull(new ConfigurationSerialization(clazz).getConstructor());
  }

  /**
   * Test {@link ConfigurationSerialization#deserialize(Map)}.
   *
   * <ul>
   *   <li>Given {@code SpawnRule}.
   *   <li>Then return {@link SpawnRule}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserialize(Map)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Map); given 'org.bukkit.block.spawner.SpawnRule'; then return SpawnRule")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable ConfigurationSerialization.deserialize(Map)"})
  void testDeserialize_givenOrgBukkitBlockSpawnerSpawnRule_thenReturnSpawnRule() {
    // Arrange
    Class<SpawnRule> clazz = SpawnRule.class;
    ConfigurationSerialization configurationSerialization = new ConfigurationSerialization(clazz);

    // Act
    ConfigurationSerializable actualDeserializeResult =
        configurationSerialization.deserialize(new HashMap<>());

    // Assert
    assertTrue(actualDeserializeResult instanceof SpawnRule);
    assertEquals(0, ((SpawnRule) actualDeserializeResult).getMaxBlockLight());
    assertEquals(0, ((SpawnRule) actualDeserializeResult).getMaxSkyLight());
    assertEquals(0, ((SpawnRule) actualDeserializeResult).getMinBlockLight());
    assertEquals(0, ((SpawnRule) actualDeserializeResult).getMinSkyLight());
  }

  /**
   * Test {@link ConfigurationSerialization#deserialize(Map)}.
   *
   * <ul>
   *   <li>Given {@code BoundingBox}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link BoundingBox}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserialize(Map)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Map); given 'org.bukkit.util.BoundingBox'; when HashMap(); then return BoundingBox")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable ConfigurationSerialization.deserialize(Map)"})
  void testDeserialize_givenOrgBukkitUtilBoundingBox_whenHashMap_thenReturnBoundingBox() {
    // Arrange
    Class<BoundingBox> clazz = BoundingBox.class;
    ConfigurationSerialization configurationSerialization = new ConfigurationSerialization(clazz);

    // Act
    ConfigurationSerializable actualDeserializeResult =
        configurationSerialization.deserialize(new HashMap<>());

    // Assert
    assertTrue(actualDeserializeResult instanceof BoundingBox);
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getCenterX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getCenterY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getCenterZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getHeight());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMaxX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMaxY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMaxZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMinX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMinY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getMinZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getVolume());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getWidthX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeResult).getWidthZ());
  }

  /**
   * Test {@link ConfigurationSerialization#deserialize(Map)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserialize(Map)}
   */
  @Test
  @DisplayName("Test deserialize(Map); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable ConfigurationSerialization.deserialize(Map)"})
  void testDeserialize_thenReturnNull() {
    // Arrange
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;
    ConfigurationSerialization configurationSerialization = new ConfigurationSerialization(clazz);

    // Act and Assert
    assertNull(configurationSerialization.deserialize(new HashMap<>()));
  }

  /**
   * Test {@link ConfigurationSerialization#deserializeObject(Map, Class)} with {@code args}, {@code
   * clazz}.
   *
   * <ul>
   *   <li>Then return {@link BoundingBox}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserializeObject(Map, Class)}
   */
  @Test
  @DisplayName("Test deserializeObject(Map, Class) with 'args', 'clazz'; then return BoundingBox")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigurationSerializable ConfigurationSerialization.deserializeObject(Map, Class)"
  })
  void testDeserializeObjectWithArgsClazz_thenReturnBoundingBox() {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    Class<BoundingBox> clazz = BoundingBox.class;

    // Act
    ConfigurationSerializable actualDeserializeObjectResult =
        ConfigurationSerialization.deserializeObject(args, clazz);

    // Assert
    assertTrue(actualDeserializeObjectResult instanceof BoundingBox);
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getCenterX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getCenterY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getCenterZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getHeight());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMaxX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMaxY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMaxZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMinX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMinY());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getMinZ());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getVolume());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getWidthX());
    assertEquals(0.0d, ((BoundingBox) actualDeserializeObjectResult).getWidthZ());
  }

  /**
   * Test {@link ConfigurationSerialization#deserializeObject(Map, Class)} with {@code args}, {@code
   * clazz}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserializeObject(Map, Class)}
   */
  @Test
  @DisplayName("Test deserializeObject(Map, Class) with 'args', 'clazz'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigurationSerializable ConfigurationSerialization.deserializeObject(Map, Class)"
  })
  void testDeserializeObjectWithArgsClazz_thenReturnNull() {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertNull(ConfigurationSerialization.deserializeObject(args, clazz));
  }

  /**
   * Test {@link ConfigurationSerialization#deserializeObject(Map, Class)} with {@code args}, {@code
   * clazz}.
   *
   * <ul>
   *   <li>Then return {@link SpawnRule}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#deserializeObject(Map, Class)}
   */
  @Test
  @DisplayName("Test deserializeObject(Map, Class) with 'args', 'clazz'; then return SpawnRule")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigurationSerializable ConfigurationSerialization.deserializeObject(Map, Class)"
  })
  void testDeserializeObjectWithArgsClazz_thenReturnSpawnRule() {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    Class<SpawnRule> clazz = SpawnRule.class;

    // Act
    ConfigurationSerializable actualDeserializeObjectResult =
        ConfigurationSerialization.deserializeObject(args, clazz);

    // Assert
    assertTrue(actualDeserializeObjectResult instanceof SpawnRule);
    assertEquals(0, ((SpawnRule) actualDeserializeObjectResult).getMaxBlockLight());
    assertEquals(0, ((SpawnRule) actualDeserializeObjectResult).getMaxSkyLight());
    assertEquals(0, ((SpawnRule) actualDeserializeObjectResult).getMinBlockLight());
    assertEquals(0, ((SpawnRule) actualDeserializeObjectResult).getMinSkyLight());
  }

  /**
   * Test {@link ConfigurationSerialization#getClassByAlias(String)}.
   *
   * <p>Method under test: {@link ConfigurationSerialization#getClassByAlias(String)}
   */
  @Test
  @DisplayName("Test getClassByAlias(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ConfigurationSerialization.getClassByAlias(String)"})
  void testGetClassByAlias() {
    // Arrange and Act
    Class<? extends ConfigurationSerializable> actualClassByAlias =
        ConfigurationSerialization.getClassByAlias("Alias");

    // Assert
    assertNull(actualClassByAlias);
  }

  /**
   * Test {@link ConfigurationSerialization#getAlias(Class)}.
   *
   * <p>Method under test: {@link ConfigurationSerialization#getAlias(Class)}
   */
  @Test
  @DisplayName("Test getAlias(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigurationSerialization.getAlias(Class)"})
  void testGetAlias() {
    // Arrange
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertEquals(
        "org.bukkit.configuration.serialization.ConfigurationSerializable",
        ConfigurationSerialization.getAlias(clazz));
  }

  /**
   * Test {@link ConfigurationSerialization#getAlias(Class)}.
   *
   * <ul>
   *   <li>When {@code SpawnRule}.
   *   <li>Then return {@code SpawnRule}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSerialization#getAlias(Class)}
   */
  @Test
  @DisplayName(
      "Test getAlias(Class); when 'org.bukkit.block.spawner.SpawnRule'; then return 'SpawnRule'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConfigurationSerialization.getAlias(Class)"})
  void testGetAlias_whenOrgBukkitBlockSpawnerSpawnRule_thenReturnSpawnRule() {
    // Arrange
    Class<SpawnRule> clazz = SpawnRule.class;

    // Act and Assert
    assertEquals("SpawnRule", ConfigurationSerialization.getAlias(clazz));
  }
}
