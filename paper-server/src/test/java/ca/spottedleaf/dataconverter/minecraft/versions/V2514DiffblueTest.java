package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonMapType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class V2514DiffblueTest {
  /**
   * Test {@link V2514#createUUIDArray(long, long)}.
   *
   * <p>Method under test: {@link V2514#createUUIDArray(long, long)}
   */
  @Test
  @DisplayName("Test createUUIDArray(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDArray(long, long)"})
  void testCreateUUIDArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {0, 1, 0, 1}, V2514.createUUIDArray(1L, 1L));
  }

  /**
   * Test {@link V2514#createUUIDFromString(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromString(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test createUUIDFromString(MapType, String); when JsonMapType(boolean) with compressed is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromString(MapType, String)"})
  void testCreateUUIDFromString_whenJsonMapTypeWithCompressedIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(V2514.createUUIDFromString(new JsonMapType(true), "Path"));
  }

  /**
   * Test {@link V2514#createUUIDFromString(MapType, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromString(MapType, String)}
   */
  @Test
  @DisplayName("Test createUUIDFromString(MapType, String); when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromString(MapType, String)"})
  void testCreateUUIDFromString_whenNBTMapType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(V2514.createUUIDFromString(new NBTMapType(), "Path"));
  }

  /**
   * Test {@link V2514#createUUIDFromString(MapType, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromString(MapType, String)}
   */
  @Test
  @DisplayName("Test createUUIDFromString(MapType, String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromString(MapType, String)"})
  void testCreateUUIDFromString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(V2514.createUUIDFromString(null, "Path"));
  }

  /**
   * Test {@link V2514#createUUIDFromLongs(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromLongs(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test createUUIDFromLongs(MapType, String, String); when JsonMapType(boolean) with compressed is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromLongs(MapType, String, String)"})
  void testCreateUUIDFromLongs_whenJsonMapTypeWithCompressedIsTrue_thenReturnNull() {
    // Arrange and Act
    int[] actualCreateUUIDFromLongsResult =
        V2514.createUUIDFromLongs(new JsonMapType(true), "Most", "Least");

    // Assert
    assertNull(actualCreateUUIDFromLongsResult);
  }

  /**
   * Test {@link V2514#createUUIDFromLongs(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromLongs(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test createUUIDFromLongs(MapType, String, String); when NBTMapType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromLongs(MapType, String, String)"})
  void testCreateUUIDFromLongs_whenNBTMapType_thenReturnNull() {
    // Arrange and Act
    int[] actualCreateUUIDFromLongsResult =
        V2514.createUUIDFromLongs(new NBTMapType(), "Most", "Least");

    // Assert
    assertNull(actualCreateUUIDFromLongsResult);
  }

  /**
   * Test {@link V2514#createUUIDFromLongs(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#createUUIDFromLongs(MapType, String, String)}
   */
  @Test
  @DisplayName("Test createUUIDFromLongs(MapType, String, String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V2514.createUUIDFromLongs(MapType, String, String)"})
  void testCreateUUIDFromLongs_whenNull_thenReturnNull() {
    // Arrange and Act
    int[] actualCreateUUIDFromLongsResult = V2514.createUUIDFromLongs(null, "Most", "Least");

    // Assert
    assertNull(actualCreateUUIDFromLongsResult);
  }

  /**
   * Test {@link V2514#replaceUUIDString(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDString(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDString(MapType, String, String); given 'String'; when MapType getString(String) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDString(MapType, String, String)"})
  void testReplaceUUIDString_givenString_whenMapTypeGetStringReturnString() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("String");

    // Act
    V2514.replaceUUIDString(data, "Old Path", "New Path");

    // Assert
    verify(data).getString("Old Path");
  }

  /**
   * Test {@link V2514#replaceUUIDString(MapType, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDString(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDString(MapType, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDString(MapType, String, String)"})
  void testReplaceUUIDString_thenThrowIllegalArgumentException() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> V2514.replaceUUIDString(data, "Old Path", "New Path"));
    verify(data).getString("Old Path");
  }

  /**
   * Test {@link V2514#replaceUUIDString(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDString(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDString(MapType, String, String); when JsonMapType(boolean) with compressed is 'true'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDString(MapType, String, String)"})
  void testReplaceUUIDString_whenJsonMapTypeWithCompressedIsTrue_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> V2514.replaceUUIDString(new JsonMapType(true), "Old Path", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDString(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDString(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDString(MapType, String, String); when NBTMapType(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDString(MapType, String, String)"})
  void testReplaceUUIDString_whenNBTMapType_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDString(new NBTMapType(), "Old Path", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDString(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDString(MapType, String, String)}
   */
  @Test
  @DisplayName("Test replaceUUIDString(MapType, String, String); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDString(MapType, String, String)"})
  void testReplaceUUIDString_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDString(null, "Old Path", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName("Test replaceUUIDMLTag(MapType, String, String); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_givenIllegalArgumentException() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getLong(Mockito.<String>any())).thenReturn(1L);

    MapType data = mock(MapType.class);
    doThrow(new IllegalArgumentException()).when(data).remove(Mockito.<String>any());
    when(data.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> V2514.replaceUUIDMLTag(data, "Old Path", "New Path"));
    verify(data).getMap("Old Path");
    verify(data).remove("Old Path");
    verify(jsonMapType, atLeast(1)).getLong(Mockito.<String>any());
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType} {@link JsonMapType#getLong(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); given JsonMapType getLong(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_givenJsonMapTypeGetLongThrowIllegalArgumentException() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getLong(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> V2514.replaceUUIDMLTag(data, "Old Path", "New Path"));
    verify(data).getMap("Old Path");
    verify(jsonMapType).getLong("M");
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); given JsonMapType(boolean) with compressed is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_givenJsonMapTypeWithCompressedIsTrue() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new JsonMapType(true));

    // Act
    V2514.replaceUUIDMLTag(data, "Old Path", "New Path");

    // Assert
    verify(data).getMap("Old Path");
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link NBTMapType#NBTMapType()}.
   *   <li>When {@link MapType} {@link MapType#getMap(String)} return {@link
   *       NBTMapType#NBTMapType()}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); given NBTMapType(); when MapType getMap(String) return NBTMapType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_givenNBTMapType_whenMapTypeGetMapReturnNBTMapType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getMap(Mockito.<String>any())).thenReturn(new NBTMapType());

    // Act
    V2514.replaceUUIDMLTag(data, "Old Path", "New Path");

    // Assert
    verify(data).getMap("Old Path");
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); when JsonMapType(boolean) with compressed is 'true'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_whenJsonMapTypeWithCompressedIsTrue_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDMLTag(new JsonMapType(true), "Old Path", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link MapType} {@link MapType#remove(String)} does nothing.
   *   <li>Then calls {@link MapType#setInts(String, int[])}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); when MapType remove(String) does nothing; then calls setInts(String, int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_whenMapTypeRemoveDoesNothing_thenCallsSetInts() {
    // Arrange
    JsonMapType jsonMapType = mock(JsonMapType.class);
    when(jsonMapType.getLong(Mockito.<String>any())).thenReturn(1L);

    MapType data = mock(MapType.class);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setInts(Mockito.<String>any(), Mockito.<int[]>any());
    when(data.getMap(Mockito.<String>any())).thenReturn(jsonMapType);

    // Act
    V2514.replaceUUIDMLTag(data, "Old Path", "New Path");

    // Assert
    verify(data).getMap("Old Path");
    verify(data).remove("Old Path");
    verify(data).setInts(eq("New Path"), isA(int[].class));
    verify(jsonMapType, atLeast(1)).getLong(Mockito.<String>any());
  }

  /**
   * Test {@link V2514#replaceUUIDMLTag(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDMLTag(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDMLTag(MapType, String, String); when NBTMapType(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDMLTag(MapType, String, String)"})
  void testReplaceUUIDMLTag_whenNBTMapType_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDMLTag(new NBTMapType(), "Old Path", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link MapType} {@link MapType#remove(String)} does nothing.
   *   <li>Then calls {@link MapType#setInts(String, int[])}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); given one; when MapType remove(String) does nothing; then calls setInts(String, int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_givenOne_whenMapTypeRemoveDoesNothing_thenCallsSetInts() {
    // Arrange
    MapType data = mock(MapType.class);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setInts(Mockito.<String>any(), Mockito.<int[]>any());
    when(data.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    V2514.replaceUUIDLeastMost(data, "Prefix", "New Path");

    // Assert
    verify(data, atLeast(1)).getLong(Mockito.<String>any());
    verify(data, atLeast(1)).remove(Mockito.<String>any());
    verify(data).setInts(eq("New Path"), isA(int[].class));
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link JsonMapType#JsonMapType(boolean)} with compressed is {@code true}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); when JsonMapType(boolean) with compressed is 'true'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_whenJsonMapTypeWithCompressedIsTrue_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> V2514.replaceUUIDLeastMost(new JsonMapType(true), "Prefix", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link MapType} {@link MapType#getLong(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); when MapType getLong(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_whenMapTypeGetLongThrowIllegalArgumentException() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getLong(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> V2514.replaceUUIDLeastMost(data, "Prefix", "New Path"));
    verify(data).getLong("PrefixMost");
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link MapType} {@link MapType#remove(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); when MapType remove(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_whenMapTypeRemoveThrowIllegalArgumentException() {
    // Arrange
    MapType data = mock(MapType.class);
    doThrow(new IllegalArgumentException()).when(data).remove(Mockito.<String>any());
    when(data.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> V2514.replaceUUIDLeastMost(data, "Prefix", "New Path"));
    verify(data, atLeast(1)).getLong(Mockito.<String>any());
    verify(data).remove("PrefixMost");
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); when NBTMapType(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_whenNBTMapType_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDLeastMost(new NBTMapType(), "Prefix", "New Path"));
  }

  /**
   * Test {@link V2514#replaceUUIDLeastMost(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link V2514#replaceUUIDLeastMost(MapType, String, String)}
   */
  @Test
  @DisplayName(
      "Test replaceUUIDLeastMost(MapType, String, String); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V2514.replaceUUIDLeastMost(MapType, String, String)"})
  void testReplaceUUIDLeastMost_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> V2514.replaceUUIDLeastMost(null, "Prefix", "New Path"));
  }
}
