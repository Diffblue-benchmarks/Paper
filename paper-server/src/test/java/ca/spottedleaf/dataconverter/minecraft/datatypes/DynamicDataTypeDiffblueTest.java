package ca.spottedleaf.dataconverter.minecraft.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTTypeUtil;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class DynamicDataTypeDiffblueTest {
  /**
   * Test {@link DynamicDataType#DynamicDataType(String)}.
   *
   * <p>Method under test: {@link DynamicDataType#DynamicDataType(String)}
   */
  @Test
  @DisplayName("Test new DynamicDataType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicDataType.<init>(String)"})
  void testNewDynamicDataType() {
    // Arrange and Act
    DynamicDataType actualDynamicDataType = new DynamicDataType("Name");

    // Assert
    assertEquals("Name", actualDynamicDataType.name);
    assertTrue(actualDynamicDataType.structureConverters.isEmpty());
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link DynamicDataType#DynamicDataType(String)} with {@code Name}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given DynamicDataType(String) with 'Name'; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenDynamicDataTypeWithName_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DynamicDataType("Name").convert(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#PARTICLE}.
   *   <li>When {@code 42}.
   *   <li>Then return {@link NBTMapType}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given PARTICLE; when '42'; then return NBTMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenParticle_when42_thenReturnNBTMapType() {
    // Arrange and Act
    Object actualConvertResult = MCTypeRegistry.PARTICLE.convert("42", 1L, Long.MAX_VALUE);

    // Assert
    assertTrue(actualConvertResult instanceof NBTMapType);
    assertTrue(((NBTMapType) actualConvertResult).getTypeUtil() instanceof NBTTypeUtil);
    assertEquals(1, ((NBTMapType) actualConvertResult).size());
    CompoundTag tag = ((NBTMapType) actualConvertResult).getTag();
    assertEquals(1, tag.size());
    assertFalse(((NBTMapType) actualConvertResult).isEmpty());
    assertFalse(tag.isEmpty());
    assertEquals('\n', tag.getId());
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#PARTICLE}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given PARTICLE; when MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenParticle_whenMax_value_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.PARTICLE.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, 1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#TEXT_COMPONENT}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given TEXT_COMPONENT; when MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenText_component_whenMax_value_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.TEXT_COMPONENT.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, Long.MAX_VALUE, 1L));
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#TEXT_COMPONENT}.
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given TEXT_COMPONENT; when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenText_component_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.TEXT_COMPONENT.convert(
            ConfigurationTransformation.WILDCARD_OBJECT, 1L, -1L));
  }

  /**
   * Test {@link DynamicDataType#convert(Object, long, long)}.
   *
   * <ul>
   *   <li>Given {@link MCTypeRegistry#TEXT_COMPONENT}.
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicDataType#convert(Object, long, long)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, long, long); given TEXT_COMPONENT; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DynamicDataType.convert(Object, long, long)"})
  void testConvert_givenText_component_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        MCTypeRegistry.TEXT_COMPONENT.convert(ConfigurationTransformation.WILDCARD_OBJECT, 1L, 1L));
  }
}
