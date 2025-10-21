package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.primitives.UnsignedInteger;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class CopyHelperDiffblueTest {
  /**
   * Test {@link CopyHelper#copy(MapType, String, MapType, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copy(MapType, String, MapType, String)}
   */
  @Test
  @DisplayName(
      "Test copy(MapType, String, MapType, String); when NBTMapType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CopyHelper.copy(MapType, String, MapType, String)"})
  void testCopy_whenNBTMapType_thenReturnFalse() {
    // Arrange
    NBTMapType src = new NBTMapType();

    // Act
    boolean actualCopyResult = CopyHelper.copy(src, "Src Path", new NBTMapType(), "Dst Path");

    // Assert
    assertFalse(actualCopyResult);
  }

  /**
   * Test {@link CopyHelper#move(MapType, String, MapType, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#move(MapType, String, MapType, String)}
   */
  @Test
  @DisplayName(
      "Test move(MapType, String, MapType, String); when NBTMapType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CopyHelper.move(MapType, String, MapType, String)"})
  void testMove_whenNBTMapType_thenReturnFalse() {
    // Arrange
    NBTMapType src = new NBTMapType();

    // Act
    boolean actualMoveResult = CopyHelper.move(src, "Src Path", new NBTMapType(), "Dst Path");

    // Assert
    assertFalse(actualMoveResult);
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when 'A'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenA_thenReturnByteValueIsA() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber((byte) 'A');

    // Assert
    assertEquals('A', actualSanitizeNumberResult.byteValue());
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when bootstrapDuration; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenBootstrapDuration_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CopyHelper.sanitizeNumber(Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenOne_thenReturnIntValueIsOne() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber(1);

    // Assert
    assertEquals(1, actualSanitizeNumberResult.intValue());
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenOne_thenReturnLongValueIsOne() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber(1L);

    // Assert
    assertEquals(1L, actualSanitizeNumberResult.longValue());
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return shortValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when one; then return shortValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenOne_thenReturnShortValueIsOne() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber((short) 1);

    // Assert
    assertEquals((short) 1, actualSanitizeNumberResult.shortValue());
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenTen_thenReturnDoubleValueIsTen() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber(10.0d);

    // Assert
    assertEquals(10.0d, actualSanitizeNumberResult.doubleValue());
  }

  /**
   * Test {@link CopyHelper#sanitizeNumber(Number)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#sanitizeNumber(Number)}
   */
  @Test
  @DisplayName("Test sanitizeNumber(Number); when ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number CopyHelper.sanitizeNumber(Number)"})
  void testSanitizeNumber_whenTen_thenReturnFloatValueIsTen() {
    // Arrange and Act
    Number actualSanitizeNumberResult = CopyHelper.sanitizeNumber(10.0f);

    // Assert
    assertEquals(10.0f, actualSanitizeNumberResult.floatValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", CopyHelper.copyGeneric("42"));
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return byteValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when 'A'; then return byteValue is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenA_thenReturnByteValueIsA() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric((byte) 'A');

    // Assert
    assertEquals('A', ((Byte) actualCopyGenericResult).byteValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) CopyHelper.copyGeneric(false));
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when forty-two; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(42);

    // Assert
    assertEquals(42, ((Integer) actualCopyGenericResult).intValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when forty-two; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenFortyTwo_thenReturnLongValueIsFortyTwo() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(42L);

    // Assert
    assertEquals(42L, ((Long) actualCopyGenericResult).longValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When fromIntBits one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test copyGeneric(Object); when fromIntBits one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenFromIntBitsOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> CopyHelper.copyGeneric(UnsignedInteger.fromIntBits(1)));
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonListType#JsonListType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonListType}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test copyGeneric(Object); when JsonListType(boolean) with compressed is 'true'; then return JsonListType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenJsonListTypeWithCompressedIsTrue_thenReturnJsonListType() {
    // Arrange
    JsonListType jsonListType = new JsonListType(true);

    // Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(jsonListType);

    // Assert
    assertTrue(actualCopyGenericResult instanceof JsonListType);
    assertEquals(jsonListType, actualCopyGenericResult);
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@link JsonMapType}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test copyGeneric(Object); when JsonMapType(boolean) with compressed is 'true'; then return JsonMapType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenJsonMapTypeWithCompressedIsTrue_thenReturnJsonMapType() {
    // Arrange
    JsonMapType jsonMapType = new JsonMapType(true);

    // Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(jsonMapType);

    // Assert
    assertTrue(actualCopyGenericResult instanceof JsonMapType);
    assertEquals(jsonMapType, actualCopyGenericResult);
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CopyHelper.copyGeneric(null));
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return shortValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when one; then return shortValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenOne_thenReturnShortValueIsOne() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric((short) 1);

    // Assert
    assertEquals((short) 1, ((Short) actualCopyGenericResult).shortValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenTen_thenReturnDoubleValueIsTen() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(10.0d);

    // Assert
    assertEquals(10.0d, ((Double) actualCopyGenericResult).doubleValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenTen_thenReturnFloatValueIsTen() {
    // Arrange and Act
    Object actualCopyGenericResult = CopyHelper.copyGeneric(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) actualCopyGenericResult).floatValue());
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName("Test copyGeneric(Object); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) CopyHelper.copyGeneric(true));
  }

  /**
   * Test {@link CopyHelper#copyGeneric(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CopyHelper#copyGeneric(Object)}
   */
  @Test
  @DisplayName(
      "Test copyGeneric(Object); when WILDCARD_OBJECT; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CopyHelper.copyGeneric(Object)"})
  void testCopyGeneric_whenWildcard_object_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> CopyHelper.copyGeneric(ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
