package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.DumperOptions.LineBreak;
import org.yaml.snakeyaml.DumperOptions.NonPrintableStyle;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.DumperOptions.Version;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.serializer.AnchorGenerator;

class YamlRepresenterDiffblueTest {
  /**
   * Test {@link YamlRepresenter#YamlRepresenter()}.
   *
   * <p>Method under test: {@link YamlRepresenter#YamlRepresenter()}
   */
  @Test
  @DisplayName("Test new YamlRepresenter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlRepresenter.<init>()"})
  void testNewYamlRepresenter() {
    // Arrange and Act
    YamlRepresenter actualYamlRepresenter = new YamlRepresenter();

    // Assert
    assertNull(actualYamlRepresenter.getTimeZone());
    assertEquals(FlowStyle.AUTO, actualYamlRepresenter.getDefaultFlowStyle());
    assertEquals(ScalarStyle.PLAIN, actualYamlRepresenter.getDefaultScalarStyle());
    PropertyUtils propertyUtils = actualYamlRepresenter.getPropertyUtils();
    assertFalse(propertyUtils.isAllowReadOnlyProperties());
    assertFalse(propertyUtils.isSkipMissingProperties());
    assertFalse(actualYamlRepresenter.isExplicitPropertyUtils());
  }

  /**
   * Test {@link YamlRepresenter#YamlRepresenter(DumperOptions)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return TimeZone is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link YamlRepresenter#YamlRepresenter(DumperOptions)}
   */
  @Test
  @DisplayName(
      "Test new YamlRepresenter(DumperOptions); given 'true'; then return TimeZone is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlRepresenter.<init>(DumperOptions)"})
  void testNewYamlRepresenter_givenTrue_thenReturnTimeZoneIsNull() {
    // Arrange
    DumperOptions options = new DumperOptions();
    options.setAllowReadOnlyProperties(true);
    options.setAllowUnicode(true);
    options.setAnchorGenerator(mock(AnchorGenerator.class));
    options.setCanonical(true);
    options.setDefaultFlowStyle(FlowStyle.FLOW);
    options.setDefaultScalarStyle(ScalarStyle.DOUBLE_QUOTED);
    options.setExplicitEnd(true);
    options.setExplicitStart(true);
    options.setIndent(1);
    options.setIndentWithIndicator(true);
    options.setIndicatorIndent(1);
    options.setLineBreak(LineBreak.WIN);
    options.setMaxSimpleKeyLength(3);
    options.setNonPrintableStyle(NonPrintableStyle.BINARY);
    options.setPrettyFlow(true);
    options.setProcessComments(true);
    options.setSplitLines(true);
    options.setTags(new HashMap<>());
    options.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
    options.setVersion(Version.V1_0);
    options.setWidth(1);

    // Act
    YamlRepresenter actualYamlRepresenter = new YamlRepresenter(options);

    // Assert
    assertNull(actualYamlRepresenter.getTimeZone());
    assertEquals(FlowStyle.FLOW, actualYamlRepresenter.getDefaultFlowStyle());
    assertEquals(ScalarStyle.DOUBLE_QUOTED, actualYamlRepresenter.getDefaultScalarStyle());
    PropertyUtils propertyUtils = actualYamlRepresenter.getPropertyUtils();
    assertFalse(propertyUtils.isAllowReadOnlyProperties());
    assertFalse(propertyUtils.isSkipMissingProperties());
    assertFalse(actualYamlRepresenter.isExplicitPropertyUtils());
  }
}
