package ca.spottedleaf.dataconverter.minecraft.converters.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.MapType;
import ca.spottedleaf.dataconverter.types.json.JsonListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashSet;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class RenameHelperDiffblueTest {
  /**
   * Test {@link RenameHelper#renameKeys(MapType, Function)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code 42}.
   *   <li>Then calls {@link MapType#getGeneric(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameKeys(MapType, Function)}
   */
  @Test
  @DisplayName(
      "Test renameKeys(MapType, Function); given LinkedHashSet() add '42'; then calls getGeneric(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameKeys(MapType, Function)"})
  void testRenameKeys_givenLinkedHashSetAdd42_thenCallsGetGeneric() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("42");
    stringSet.add(null);

    MapType data = mock(MapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(data.keys()).thenReturn(stringSet);

    // Act
    RenameHelper.renameKeys(data, HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data, atLeast(1)).getGeneric("42");
    verify(data, atLeast(1)).keys();
    verify(data, atLeast(1)).remove("42");
    verify(data, atLeast(1)).setGeneric(eq("42"), isA(Object.class));
  }

  /**
   * Test {@link RenameHelper#renameKeys(MapType, Function)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Keys}.
   *   <li>Then calls {@link MapType#getGeneric(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameKeys(MapType, Function)}
   */
  @Test
  @DisplayName(
      "Test renameKeys(MapType, Function); given LinkedHashSet() add 'Keys'; then calls getGeneric(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameKeys(MapType, Function)"})
  void testRenameKeys_givenLinkedHashSetAddKeys_thenCallsGetGeneric() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Keys");

    MapType data = mock(MapType.class);
    when(data.getGeneric(Mockito.<String>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setGeneric(Mockito.<String>any(), Mockito.<Object>any());
    when(data.keys()).thenReturn(stringSet);

    // Act
    RenameHelper.renameKeys(data, HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data, atLeast(1)).getGeneric("Keys");
    verify(data, atLeast(1)).keys();
    verify(data, atLeast(1)).remove("Keys");
    verify(data, atLeast(1)).setGeneric(eq("Keys"), isA(Object.class));
  }

  /**
   * Test {@link RenameHelper#renameKeys(MapType, Function)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then calls {@link MapType#keys()}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameKeys(MapType, Function)}
   */
  @Test
  @DisplayName(
      "Test renameKeys(MapType, Function); given LinkedHashSet() add 'null'; then calls keys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameKeys(MapType, Function)"})
  void testRenameKeys_givenLinkedHashSetAddNull_thenCallsKeys() {
    // Arrange
    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add(null);

    MapType data = mock(MapType.class);
    when(data.keys()).thenReturn(stringSet);

    // Act
    RenameHelper.renameKeys(data, HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).keys();
  }

  /**
   * Test {@link RenameHelper#renameSingle(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameSingle(MapType, String, String)}
   */
  @Test
  @DisplayName("Test renameSingle(MapType, String, String); when NBTMapType(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenameHelper.renameSingle(MapType, String, String)"})
  void testRenameSingle_whenNBTMapType_thenReturnFalse() {
    // Arrange and Act
    boolean actualRenameSingleResult =
        RenameHelper.renameSingle(new NBTMapType(), "jane.doe@example.org", "To Key");

    // Assert
    assertFalse(actualRenameSingleResult);
  }

  /**
   * Test {@link RenameHelper#renameSingle(MapType, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameSingle(MapType, String, String)}
   */
  @Test
  @DisplayName("Test renameSingle(MapType, String, String); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenameHelper.renameSingle(MapType, String, String)"})
  void testRenameSingle_whenNull_thenReturnFalse() {
    // Arrange and Act
    boolean actualRenameSingleResult =
        RenameHelper.renameSingle(null, "jane.doe@example.org", "To Key");

    // Assert
    assertFalse(actualRenameSingleResult);
  }

  /**
   * Test {@link RenameHelper#renameString(MapType, String, Function)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link MapType} {@link MapType#setString(String, String)} does nothing.
   *   <li>Then calls {@link MapType#getString(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameString(MapType, String, Function)}
   */
  @Test
  @DisplayName(
      "Test renameString(MapType, String, Function); given 'String'; when MapType setString(String, String) does nothing; then calls getString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameString(MapType, String, Function)"})
  void testRenameString_givenString_whenMapTypeSetStringDoesNothing_thenCallsGetString() {
    // Arrange
    MapType data = mock(MapType.class);
    doNothing().when(data).setString(Mockito.<String>any(), Mockito.<String>any());
    when(data.getString(Mockito.<String>any())).thenReturn("String");

    // Act
    RenameHelper.renameString(data, "Key", HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).getString("Key");
    verify(data).setString("Key", "String");
  }

  /**
   * Test {@link RenameHelper#renameListMapItems(MapType, String, String, Function)}.
   *
   * <ul>
   *   <li>Given {@link JsonListType} {@link JsonListType#getMap(int, MapType)} return {@link
   *       NBTMapType#NBTMapType()}.
   *   <li>Then calls {@link JsonListType#getMap(int, MapType)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameListMapItems(MapType, String, String,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test renameListMapItems(MapType, String, String, Function); given JsonListType getMap(int, MapType) return NBTMapType(); then calls getMap(int, MapType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameListMapItems(MapType, String, String, Function)"})
  void testRenameListMapItems_givenJsonListTypeGetMapReturnNBTMapType_thenCallsGetMap() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(new NBTMapType());
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    RenameHelper.renameListMapItems(
        data, "List Path", "Map Path", HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link RenameHelper#renameListMapItems(MapType, String, String, Function)}.
   *
   * <ul>
   *   <li>Given {@link JsonListType} {@link JsonListType#getMap(int, MapType)} return {@code null}.
   *   <li>Then calls {@link JsonListType#getMap(int, MapType)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameListMapItems(MapType, String, String,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test renameListMapItems(MapType, String, String, Function); given JsonListType getMap(int, MapType) return 'null'; then calls getMap(int, MapType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameListMapItems(MapType, String, String, Function)"})
  void testRenameListMapItems_givenJsonListTypeGetMapReturnNull_thenCallsGetMap() {
    // Arrange
    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(null);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    RenameHelper.renameListMapItems(
        data, "List Path", "Map Path", HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link RenameHelper#renameListMapItems(MapType, String, String, Function)}.
   *
   * <ul>
   *   <li>Given {@link MapType} {@link MapType#setString(String, String)} does nothing.
   *   <li>Then calls {@link MapType#getString(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameListMapItems(MapType, String, String,
   * Function)}
   */
  @Test
  @DisplayName(
      "Test renameListMapItems(MapType, String, String, Function); given MapType setString(String, String) does nothing; then calls getString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameListMapItems(MapType, String, String, Function)"})
  void testRenameListMapItems_givenMapTypeSetStringDoesNothing_thenCallsGetString() {
    // Arrange
    MapType mapType = mock(MapType.class);
    doNothing().when(mapType).setString(Mockito.<String>any(), Mockito.<String>any());
    when(mapType.getString(Mockito.<String>any())).thenReturn("String");

    JsonListType jsonListType = mock(JsonListType.class);
    when(jsonListType.getMap(anyInt(), Mockito.<MapType>any())).thenReturn(mapType);
    when(jsonListType.size()).thenReturn(3);

    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(jsonListType);

    // Act
    RenameHelper.renameListMapItems(
        data, "List Path", "Map Path", HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).getListUnchecked("List Path");
    verify(mapType, atLeast(1)).getString("Map Path");
    verify(mapType, atLeast(1)).setString("Map Path", "String");
    verify(jsonListType, atLeast(1)).getMap(anyInt(), isNull());
    verify(jsonListType).size();
  }

  /**
   * Test {@link RenameHelper#renameListMapItems(MapType, String, String, Function)}.
   *
   * <ul>
   *   <li>Given {@link NBTListType#NBTListType()}.
   * </ul>
   *
   * <p>Method under test: {@link RenameHelper#renameListMapItems(MapType, String, String,
   * Function)}
   */
  @Test
  @DisplayName("Test renameListMapItems(MapType, String, String, Function); given NBTListType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenameHelper.renameListMapItems(MapType, String, String, Function)"})
  void testRenameListMapItems_givenNBTListType() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getListUnchecked(Mockito.<String>any())).thenReturn(new NBTListType());

    // Act
    RenameHelper.renameListMapItems(
        data, "List Path", "Map Path", HelperBlockFlatteningV1450::getNewBlockName);

    // Assert
    verify(data).getListUnchecked("List Path");
  }
}
