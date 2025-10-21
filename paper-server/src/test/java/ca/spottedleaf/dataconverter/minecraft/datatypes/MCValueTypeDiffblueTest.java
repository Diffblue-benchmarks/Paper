package ca.spottedleaf.dataconverter.minecraft.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class MCValueTypeDiffblueTest {
  /**
   * Test {@link MCValueType#MCValueType(String)}.
   *
   * <p>Method under test: {@link MCValueType#MCValueType(String)}
   */
  @Test
  @DisplayName("Test new MCValueType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MCValueType.<init>(String)"})
  void testNewMCValueType() {
    // Arrange and Act
    MCValueType actualMcValueType = new MCValueType("Name");

    // Assert
    assertEquals("Name", actualMcValueType.name);
    assertTrue(actualMcValueType.converters.isEmpty());
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#BIOME}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given BIOME; when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenBiome_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft:42", MCTypeRegistry.BIOME.convert("42", 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#BIOME}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given BIOME; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenBiome_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MCTypeRegistry.BIOME.convert(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#BIOME}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given BIOME; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenBiome_whenWildcard_object_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.BIOME.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, Long.MAX_VALUE, 1L));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#BIOME}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given BIOME; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenBiome_whenWildcard_object_thenReturnNull3() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.BIOME.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#BLOCK_NAME}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given BLOCK_NAME; when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenBlock_name_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft:42", MCTypeRegistry.BLOCK_NAME.convert("42", 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#ENTITY_NAME}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given ENTITY_NAME; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenEntity_name_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.ENTITY_NAME.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link MCValueType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCValueType#MCValueType(String)} with {@code Name}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MCValueType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given MCValueType(String) with 'Name'; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MCValueType.convert(Object, long, long)"})
  void testConvert_givenMCValueTypeWithName_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new MCValueType("Name").convert(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }
}
