package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.inspector.TagInspector;
import org.yaml.snakeyaml.inspector.UnTrustedTagInspector;
import org.yaml.snakeyaml.introspector.PropertyUtils;

class YamlConstructorDiffblueTest {
  /**
   * Test {@link YamlConstructor#YamlConstructor()}.
   *
   * <p>Method under test: {@link YamlConstructor#YamlConstructor()}
   */
  @Test
  @DisplayName("Test new YamlConstructor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlConstructor.<init>()"})
  void testNewYamlConstructor() {
    // Arrange and Act
    YamlConstructor actualYamlConstructor = new YamlConstructor();

    // Assert
    LoaderOptions loadingConfig = actualYamlConstructor.getLoadingConfig();
    assertTrue(loadingConfig.getTagInspector() instanceof UnTrustedTagInspector);
    assertEquals(3145728, loadingConfig.getCodePointLimit());
    assertEquals(50, loadingConfig.getMaxAliasesForCollections());
    assertEquals(50, loadingConfig.getNestingDepthLimit());
    assertFalse(loadingConfig.getAllowRecursiveKeys());
    assertFalse(loadingConfig.isProcessComments());
    assertFalse(loadingConfig.isWrappedToRootException());
    assertFalse(actualYamlConstructor.isEnumCaseSensitive());
    assertFalse(actualYamlConstructor.isExplicitPropertyUtils());
    assertFalse(actualYamlConstructor.isWrappedToRootException());
    PropertyUtils propertyUtils = actualYamlConstructor.getPropertyUtils();
    assertFalse(propertyUtils.isAllowReadOnlyProperties());
    assertFalse(propertyUtils.isSkipMissingProperties());
    assertTrue(loadingConfig.isAllowDuplicateKeys());
    assertTrue(loadingConfig.isEnumCaseSensitive());
    assertTrue(actualYamlConstructor.isAllowDuplicateKeys());
  }

  /**
   * Test {@link YamlConstructor#YamlConstructor(LoaderOptions)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return not EnumCaseSensitive.
   * </ul>
   *
   * <p>Method under test: {@link YamlConstructor#YamlConstructor(LoaderOptions)}
   */
  @Test
  @DisplayName(
      "Test new YamlConstructor(LoaderOptions); given 'true'; then return not EnumCaseSensitive")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlConstructor.<init>(LoaderOptions)"})
  void testNewYamlConstructor_givenTrue_thenReturnNotEnumCaseSensitive() {
    // Arrange
    LoaderOptions loaderOptions = new LoaderOptions();
    loaderOptions.setAllowDuplicateKeys(true);
    loaderOptions.setAllowRecursiveKeys(true);
    loaderOptions.setCodePointLimit(1);
    loaderOptions.setEnumCaseSensitive(true);
    loaderOptions.setMaxAliasesForCollections(3);
    loaderOptions.setNestingDepthLimit(2);
    loaderOptions.setProcessComments(true);
    loaderOptions.setTagInspector(mock(TagInspector.class));
    loaderOptions.setWrappedToRootException(true);

    // Act
    YamlConstructor actualYamlConstructor = new YamlConstructor(loaderOptions);

    // Assert
    assertFalse(actualYamlConstructor.isEnumCaseSensitive());
    assertFalse(actualYamlConstructor.isExplicitPropertyUtils());
    assertFalse(actualYamlConstructor.isWrappedToRootException());
    PropertyUtils propertyUtils = actualYamlConstructor.getPropertyUtils();
    assertFalse(propertyUtils.isAllowReadOnlyProperties());
    assertFalse(propertyUtils.isSkipMissingProperties());
    assertTrue(actualYamlConstructor.isAllowDuplicateKeys());
    assertSame(loaderOptions, actualYamlConstructor.getLoadingConfig());
  }
}
