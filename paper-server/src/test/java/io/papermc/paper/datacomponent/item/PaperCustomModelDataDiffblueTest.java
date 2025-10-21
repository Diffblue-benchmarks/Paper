package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.CustomModelData.Builder;
import io.papermc.paper.datacomponent.item.PaperCustomModelData.BuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperCustomModelDataDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addColor(Color)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperCustomModelData}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addColor(Color)}
   */
  @Test
  @DisplayName("Test BuilderImpl addColor(Color); then build return PaperCustomModelData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addColor(Color)"})
  void testBuilderImplAddColor_thenBuildReturnPaperCustomModelData()
      throws IllegalArgumentException {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addColor(Color.fromBGR(1, 1, 1));

    // Act
    Builder actualAddColorResult = builderImpl.addColor(Color.fromBGR(1, 1, 1));

    // Assert
    CustomModelData customModelData = actualAddColorResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddColorResult instanceof BuilderImpl);
    List<Integer> colorsResult = ((PaperCustomModelData) customModelData).getHandle().colors();
    assertEquals(2, colorsResult.size());
    List<Integer> colorsResult2 = ((PaperCustomModelData) customModelData2).getHandle().colors();
    assertEquals(2, colorsResult2.size());
    assertEquals(65793, colorsResult.get(1).intValue());
    assertEquals(65793, colorsResult2.get(0).intValue());
    assertEquals(65793, colorsResult2.get(1).intValue());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addColor(Color)}.
   *
   * <ul>
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle colors size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addColor(Color)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addColor(Color); then BuilderImpl (default constructor) build Handle colors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addColor(Color)"})
  void testBuilderImplAddColor_thenBuilderImplBuildHandleColorsSizeIsOne()
      throws IllegalArgumentException {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddColorResult = builderImpl.addColor(Color.fromBGR(1, 1, 1));

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    List<Integer> colorsResult = ((PaperCustomModelData) customModelData).getHandle().colors();
    assertEquals(1, colorsResult.size());
    assertEquals(65793, colorsResult.get(0).intValue());
    assertSame(builderImpl, actualAddColorResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addColors(List)}.
   *
   * <ul>
   *   <li>Then return build Handle colors size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addColors(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addColors(List); then return build Handle colors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addColors(List)"})
  void testBuilderImplAddColors_thenReturnBuildHandleColorsSizeIsOne()
      throws IllegalArgumentException {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<Color> colors = new ArrayList<>();
    colors.add(Color.fromBGR(1, 1, 1));

    // Act
    Builder actualAddColorsResult = builderImpl.addColors(colors);

    // Assert
    CustomModelData customModelData = actualAddColorsResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddColorsResult instanceof BuilderImpl);
    List<Integer> colorsResult = ((PaperCustomModelData) customModelData).getHandle().colors();
    assertEquals(1, colorsResult.size());
    List<Integer> colorsResult2 = ((PaperCustomModelData) customModelData2).getHandle().colors();
    assertEquals(1, colorsResult2.size());
    assertEquals(65793, colorsResult.get(0).intValue());
    assertEquals(65793, colorsResult2.get(0).intValue());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addColors(List)}.
   *
   * <ul>
   *   <li>Then return build Handle colors size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addColors(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addColors(List); then return build Handle colors size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addColors(List)"})
  void testBuilderImplAddColors_thenReturnBuildHandleColorsSizeIsTwo()
      throws IllegalArgumentException {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<Color> colors = new ArrayList<>();
    colors.add(Color.fromBGR(1, 1, 1));
    colors.add(Color.fromBGR(1, 1, 1));

    // Act
    Builder actualAddColorsResult = builderImpl.addColors(colors);

    // Assert
    CustomModelData customModelData = actualAddColorsResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddColorsResult instanceof BuilderImpl);
    List<Integer> colorsResult = ((PaperCustomModelData) customModelData).getHandle().colors();
    assertEquals(2, colorsResult.size());
    List<Integer> colorsResult2 = ((PaperCustomModelData) customModelData2).getHandle().colors();
    assertEquals(2, colorsResult2.size());
    assertEquals(65793, colorsResult.get(1).intValue());
    assertEquals(65793, colorsResult2.get(1).intValue());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addColors(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle colors Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addColors(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addColors(List); when ArrayList(); then BuilderImpl (default constructor) build Handle colors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addColors(List)"})
  void testBuilderImplAddColors_whenArrayList_thenBuilderImplBuildHandleColorsEmpty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddColorsResult = builderImpl.addColors(new ArrayList<>());

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertTrue(((PaperCustomModelData) customModelData).getHandle().colors().isEmpty());
    assertSame(builderImpl, actualAddColorsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFlag(boolean)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor).
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle flags size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFlag(boolean)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFlag(boolean); given BuilderImpl (default constructor); then BuilderImpl (default constructor) build Handle flags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFlag(boolean)"})
  void testBuilderImplAddFlag_givenBuilderImpl_thenBuilderImplBuildHandleFlagsSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddFlagResult = builderImpl.addFlag(true);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    List<Boolean> flagsResult = ((PaperCustomModelData) customModelData).getHandle().flags();
    assertEquals(1, flagsResult.size());
    assertTrue(flagsResult.get(0));
    assertSame(builderImpl, actualAddFlagResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFlag(boolean)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperCustomModelData}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFlag(boolean)}
   */
  @Test
  @DisplayName("Test BuilderImpl addFlag(boolean); then build return PaperCustomModelData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFlag(boolean)"})
  void testBuilderImplAddFlag_thenBuildReturnPaperCustomModelData() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addFlag(true);

    // Act
    Builder actualAddFlagResult = builderImpl.addFlag(true);

    // Assert
    CustomModelData customModelData = actualAddFlagResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddFlagResult instanceof BuilderImpl);
    List<Boolean> flagsResult = ((PaperCustomModelData) customModelData).getHandle().flags();
    assertEquals(2, flagsResult.size());
    List<Boolean> flagsResult2 = ((PaperCustomModelData) customModelData2).getHandle().flags();
    assertEquals(2, flagsResult2.size());
    assertTrue(flagsResult.get(1));
    assertTrue(flagsResult2.get(0));
    assertTrue(flagsResult2.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFlags(List)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle flags is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFlags(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFlags(List); given 'true'; then BuilderImpl (default constructor) build Handle flags is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFlags(List)"})
  void testBuilderImplAddFlags_givenTrue_thenBuilderImplBuildHandleFlagsIsArrayList() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<Boolean> flags = new ArrayList<>();
    flags.add(true);

    // Act
    Builder actualAddFlagsResult = builderImpl.addFlags(flags);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertEquals(flags, ((PaperCustomModelData) customModelData).getHandle().flags());
    assertSame(builderImpl, actualAddFlagsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFlags(List)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperCustomModelData}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFlags(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addFlags(List); then build return PaperCustomModelData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFlags(List)"})
  void testBuilderImplAddFlags_thenBuildReturnPaperCustomModelData() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addFlag(true);

    ArrayList<Boolean> flags = new ArrayList<>();
    flags.add(true);

    // Act
    Builder actualAddFlagsResult = builderImpl.addFlags(flags);

    // Assert
    CustomModelData customModelData = actualAddFlagsResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddFlagsResult instanceof BuilderImpl);
    List<Boolean> flagsResult = ((PaperCustomModelData) customModelData).getHandle().flags();
    assertEquals(2, flagsResult.size());
    List<Boolean> flagsResult2 = ((PaperCustomModelData) customModelData2).getHandle().flags();
    assertEquals(2, flagsResult2.size());
    assertTrue(flagsResult.get(0));
    assertTrue(flagsResult.get(1));
    assertTrue(flagsResult2.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFlags(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle flags Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFlags(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFlags(List); when ArrayList(); then BuilderImpl (default constructor) build Handle flags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFlags(List)"})
  void testBuilderImplAddFlags_whenArrayList_thenBuilderImplBuildHandleFlagsEmpty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddFlagsResult = builderImpl.addFlags(new ArrayList<>());

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertTrue(((PaperCustomModelData) customModelData).getHandle().flags().isEmpty());
    assertSame(builderImpl, actualAddFlagsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFloat(float)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperCustomModelData}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFloat(float)}
   */
  @Test
  @DisplayName("Test BuilderImpl addFloat(float); then build return PaperCustomModelData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFloat(float)"})
  void testBuilderImplAddFloat_thenBuildReturnPaperCustomModelData() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addFloat(10.0f);

    // Act
    Builder actualAddFloatResult = builderImpl.addFloat(10.0f);

    // Assert
    CustomModelData customModelData = actualAddFloatResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddFloatResult instanceof BuilderImpl);
    List<Float> floatsResult = ((PaperCustomModelData) customModelData).getHandle().floats();
    assertEquals(2, floatsResult.size());
    assertEquals(10.0f, floatsResult.get(1).floatValue());
    List<Float> floatsResult2 = ((PaperCustomModelData) customModelData2).getHandle().floats();
    assertEquals(2, floatsResult2.size());
    assertEquals(10.0f, floatsResult2.get(0).floatValue());
    assertEquals(10.0f, floatsResult2.get(1).floatValue());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFloat(float)}.
   *
   * <ul>
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle floats size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFloat(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFloat(float); then BuilderImpl (default constructor) build Handle floats size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFloat(float)"})
  void testBuilderImplAddFloat_thenBuilderImplBuildHandleFloatsSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddFloatResult = builderImpl.addFloat(10.0f);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    List<Float> floatsResult = ((PaperCustomModelData) customModelData).getHandle().floats();
    assertEquals(1, floatsResult.size());
    assertEquals(10.0f, floatsResult.get(0).floatValue());
    assertSame(builderImpl, actualAddFloatResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFloats(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle floats is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFloats(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFloats(List); given ten; then BuilderImpl (default constructor) build Handle floats is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFloats(List)"})
  void testBuilderImplAddFloats_givenTen_thenBuilderImplBuildHandleFloatsIsArrayList() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<Float> floats = new ArrayList<>();
    floats.add(10.0f);

    // Act
    Builder actualAddFloatsResult = builderImpl.addFloats(floats);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertEquals(floats, ((PaperCustomModelData) customModelData).getHandle().floats());
    assertSame(builderImpl, actualAddFloatsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFloats(List)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperCustomModelData}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFloats(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addFloats(List); then build return PaperCustomModelData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFloats(List)"})
  void testBuilderImplAddFloats_thenBuildReturnPaperCustomModelData() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addFloat(10.0f);

    ArrayList<Float> floats = new ArrayList<>();
    floats.add(10.0f);

    // Act
    Builder actualAddFloatsResult = builderImpl.addFloats(floats);

    // Assert
    CustomModelData customModelData = actualAddFloatsResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddFloatsResult instanceof BuilderImpl);
    List<Float> floatsResult = ((PaperCustomModelData) customModelData).getHandle().floats();
    assertEquals(2, floatsResult.size());
    assertEquals(10.0f, floatsResult.get(0).floatValue());
    assertEquals(10.0f, floatsResult.get(1).floatValue());
    List<Float> floatsResult2 = ((PaperCustomModelData) customModelData2).getHandle().floats();
    assertEquals(2, floatsResult2.size());
    assertEquals(10.0f, floatsResult2.get(1).floatValue());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFloats(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle floats Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFloats(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFloats(List); when ArrayList(); then BuilderImpl (default constructor) build Handle floats Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFloats(List)"})
  void testBuilderImplAddFloats_whenArrayList_thenBuilderImplBuildHandleFloatsEmpty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddFloatsResult = builderImpl.addFloats(new ArrayList<>());

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertTrue(((PaperCustomModelData) customModelData).getHandle().floats().isEmpty());
    assertSame(builderImpl, actualAddFloatsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addString(String)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor).
   *   <li>Then return build Handle strings size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addString(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addString(String); given BuilderImpl (default constructor); then return build Handle strings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addString(String)"})
  void testBuilderImplAddString_givenBuilderImpl_thenReturnBuildHandleStringsSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddStringResult = builderImpl.addString("String");

    // Assert
    CustomModelData customModelData = actualAddStringResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddStringResult instanceof BuilderImpl);
    List<String> stringsResult = ((PaperCustomModelData) customModelData).getHandle().strings();
    assertEquals(1, stringsResult.size());
    assertEquals("String", stringsResult.get(0));
    List<String> stringsResult2 = ((PaperCustomModelData) customModelData2).getHandle().strings();
    assertEquals(1, stringsResult2.size());
    assertEquals("String", stringsResult2.get(0));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addString(String)}.
   *
   * <ul>
   *   <li>Then return build Handle strings size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addString(String)}
   */
  @Test
  @DisplayName("Test BuilderImpl addString(String); then return build Handle strings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addString(String)"})
  void testBuilderImplAddString_thenReturnBuildHandleStringsSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addString("String cannot be null");

    // Act
    Builder actualAddStringResult = builderImpl.addString("String");

    // Assert
    CustomModelData customModelData = actualAddStringResult.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    CustomModelData customModelData2 = builderImpl.build();
    assertTrue(customModelData2 instanceof PaperCustomModelData);
    assertTrue(actualAddStringResult instanceof BuilderImpl);
    List<String> stringsResult = ((PaperCustomModelData) customModelData).getHandle().strings();
    assertEquals(2, stringsResult.size());
    assertEquals("String cannot be null", stringsResult.get(0));
    List<String> stringsResult2 = ((PaperCustomModelData) customModelData2).getHandle().strings();
    assertEquals(2, stringsResult2.size());
    assertEquals("String cannot be null", stringsResult2.get(0));
    assertEquals("String", stringsResult.get(1));
    assertEquals("String", stringsResult2.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addStrings(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle strings is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addStrings(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addStrings(List); given 'foo'; then BuilderImpl (default constructor) build Handle strings is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addStrings(List)"})
  void testBuilderImplAddStrings_givenFoo_thenBuilderImplBuildHandleStringsIsArrayList() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act
    Builder actualAddStringsResult = builderImpl.addStrings(strings);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertEquals(strings, ((PaperCustomModelData) customModelData).getHandle().strings());
    assertSame(builderImpl, actualAddStringsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addStrings(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle strings is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addStrings(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addStrings(List); given 'foo'; then BuilderImpl (default constructor) build Handle strings is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addStrings(List)"})
  void testBuilderImplAddStrings_givenFoo_thenBuilderImplBuildHandleStringsIsArrayList2() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");
    strings.add("foo");

    // Act
    Builder actualAddStringsResult = builderImpl.addStrings(strings);

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertEquals(strings, ((PaperCustomModelData) customModelData).getHandle().strings());
    assertSame(builderImpl, actualAddStringsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addStrings(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle strings Empty.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addStrings(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addStrings(List); when ArrayList(); then BuilderImpl (default constructor) build Handle strings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addStrings(List)"})
  void testBuilderImplAddStrings_whenArrayList_thenBuilderImplBuildHandleStringsEmpty() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddStringsResult = builderImpl.addStrings(new ArrayList<>());

    // Assert
    CustomModelData customModelData = builderImpl.build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    assertTrue(((PaperCustomModelData) customModelData).getHandle().strings().isEmpty());
    assertSame(builderImpl, actualAddStringsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomModelData BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    CustomModelData actualCustomModelData = new BuilderImpl().build();

    // Assert
    assertTrue(actualCustomModelData instanceof PaperCustomModelData);
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange, Act and Assert
    CustomModelData customModelData = new BuilderImpl().build();
    assertTrue(customModelData instanceof PaperCustomModelData);
    net.minecraft.world.item.component.CustomModelData handle =
        ((PaperCustomModelData) customModelData).getHandle();
    assertTrue(handle.colors().isEmpty());
    assertTrue(handle.flags().isEmpty());
    assertTrue(handle.floats().isEmpty());
    assertTrue(handle.strings().isEmpty());
    assertSame(handle, ((PaperCustomModelData) customModelData).impl());
  }

  /**
   * Test {@link PaperCustomModelData#getHandle()}.
   *
   * <p>Method under test: {@link PaperCustomModelData#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.CustomModelData PaperCustomModelData.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperCustomModelData paperCustomModelData =
        new PaperCustomModelData(net.minecraft.world.item.component.CustomModelData.EMPTY);

    // Act and Assert
    net.minecraft.world.item.component.CustomModelData customModelData =
        net.minecraft.world.item.component.CustomModelData.EMPTY;
    assertSame(customModelData, paperCustomModelData.getHandle());
    assertSame(customModelData, paperCustomModelData.impl());
  }

  /**
   * Test {@link PaperCustomModelData#floats()}.
   *
   * <ul>
   *   <li>Given {@link PaperCustomModelData#PaperCustomModelData(CustomModelData)} with impl is
   *       {@link net.minecraft.world.item.component.CustomModelData#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperCustomModelData#floats()}
   */
  @Test
  @DisplayName(
      "Test floats(); given PaperCustomModelData(CustomModelData) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperCustomModelData.floats()"})
  void testFloats_givenPaperCustomModelDataWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperCustomModelData(net.minecraft.world.item.component.CustomModelData.EMPTY)
            .floats()
            .isEmpty());
  }

  /**
   * Test {@link PaperCustomModelData#flags()}.
   *
   * <ul>
   *   <li>Given {@link PaperCustomModelData#PaperCustomModelData(CustomModelData)} with impl is
   *       {@link net.minecraft.world.item.component.CustomModelData#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperCustomModelData#flags()}
   */
  @Test
  @DisplayName(
      "Test flags(); given PaperCustomModelData(CustomModelData) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperCustomModelData.flags()"})
  void testFlags_givenPaperCustomModelDataWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperCustomModelData(net.minecraft.world.item.component.CustomModelData.EMPTY)
            .flags()
            .isEmpty());
  }

  /**
   * Test {@link PaperCustomModelData#strings()}.
   *
   * <ul>
   *   <li>Given {@link PaperCustomModelData#PaperCustomModelData(CustomModelData)} with impl is
   *       {@link net.minecraft.world.item.component.CustomModelData#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperCustomModelData#strings()}
   */
  @Test
  @DisplayName(
      "Test strings(); given PaperCustomModelData(CustomModelData) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperCustomModelData.strings()"})
  void testStrings_givenPaperCustomModelDataWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperCustomModelData(net.minecraft.world.item.component.CustomModelData.EMPTY)
            .strings()
            .isEmpty());
  }

  /**
   * Test {@link PaperCustomModelData#colors()}.
   *
   * <ul>
   *   <li>Given {@link PaperCustomModelData#PaperCustomModelData(CustomModelData)} with impl is
   *       {@link net.minecraft.world.item.component.CustomModelData#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperCustomModelData#colors()}
   */
  @Test
  @DisplayName(
      "Test colors(); given PaperCustomModelData(CustomModelData) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperCustomModelData.colors()"})
  void testColors_givenPaperCustomModelDataWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperCustomModelData(net.minecraft.world.item.component.CustomModelData.EMPTY)
            .colors()
            .isEmpty());
  }
}
