package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class YamlConfigurationOptionsDiffblueTest {
  /**
   * Test {@link YamlConfigurationOptions#YamlConfigurationOptions(YamlConfiguration)}.
   *
   * <p>Method under test: {@link
   * YamlConfigurationOptions#YamlConfigurationOptions(YamlConfiguration)}
   */
  @Test
  @DisplayName("Test new YamlConfigurationOptions(YamlConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlConfigurationOptions.<init>(YamlConfiguration)"})
  void testNewYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration configuration = new YamlConfiguration();

    // Act
    YamlConfigurationOptions actualYamlConfigurationOptions =
        new YamlConfigurationOptions(configuration);

    // Assert
    assertEquals('.', actualYamlConfigurationOptions.pathSeparator());
    assertEquals(2, actualYamlConfigurationOptions.indent());
    assertEquals(80, actualYamlConfigurationOptions.width());
    assertFalse(actualYamlConfigurationOptions.copyDefaults());
    List<String> footer = actualYamlConfigurationOptions.getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(actualYamlConfigurationOptions.parseComments());
    assertEquals(Integer.MAX_VALUE, actualYamlConfigurationOptions.codePointLimit());
    assertSame(configuration, actualYamlConfigurationOptions.configuration());
    assertSame(footer, actualYamlConfigurationOptions.getHeader());
  }

  /**
   * Test {@link YamlConfigurationOptions#configuration()}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#configuration()}
   */
  @Test
  @DisplayName("Test configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfiguration YamlConfigurationOptions.configuration()"})
  void testConfiguration() {
    // Arrange
    YamlConfiguration configuration = new YamlConfiguration();

    // Act and Assert
    assertSame(configuration, new YamlConfigurationOptions(configuration).configuration());
  }

  /**
   * Test {@link YamlConfigurationOptions#copyDefaults(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#copyDefaults(boolean)}
   */
  @Test
  @DisplayName("Test copyDefaults(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.copyDefaults(boolean)"})
  void testCopyDefaultsWithBoolean() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualCopyDefaultsResult = yamlConfigurationOptions.copyDefaults(true);

    // Assert
    assertTrue(yamlConfigurationOptions.copyDefaults());
    assertSame(yamlConfigurationOptions, actualCopyDefaultsResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#pathSeparator(char)} with {@code char}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#pathSeparator(char)}
   */
  @Test
  @DisplayName("Test pathSeparator(char) with 'char'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.pathSeparator(char)"})
  void testPathSeparatorWithChar() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualPathSeparatorResult =
        yamlConfigurationOptions.pathSeparator('A');

    // Assert
    assertEquals('A', yamlConfigurationOptions.pathSeparator());
    assertSame(yamlConfigurationOptions, actualPathSeparatorResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setHeader(List)"})
  void testSetHeader_given42_whenArrayListAdd42() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    YamlConfigurationOptions actualSetHeaderResult = yamlConfigurationOptions.setHeader(value);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setHeader(List)"})
  void testSetHeader_givenFoo_whenArrayListAddFoo() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    YamlConfigurationOptions actualSetHeaderResult = yamlConfigurationOptions.setHeader(value);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setHeader(List)"})
  void testSetHeader_whenArrayList() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualSetHeaderResult =
        yamlConfigurationOptions.setHeader(new ArrayList<>());

    // Assert
    assertSame(yamlConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setHeader(List)"})
  void testSetHeader_whenNull() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualSetHeaderResult = yamlConfigurationOptions.setHeader(null);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#header(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#header(String)}
   */
  @Test
  @DisplayName("Test header(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.header(String)"})
  void testHeaderWithString_when42() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualHeaderResult = yamlConfigurationOptions.header("42");

    // Assert
    assertSame(yamlConfigurationOptions, actualHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#header(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#header(String)}
   */
  @Test
  @DisplayName("Test header(String) with 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.header(String)"})
  void testHeaderWithString_whenNull() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualHeaderResult = yamlConfigurationOptions.header(null);

    // Assert
    assertSame(yamlConfigurationOptions, actualHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setFooter(List)"})
  void testSetFooter_given42_whenArrayListAdd42() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    YamlConfigurationOptions actualSetFooterResult = yamlConfigurationOptions.setFooter(value);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setFooter(List)"})
  void testSetFooter_givenFoo_whenArrayListAddFoo() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    YamlConfigurationOptions actualSetFooterResult = yamlConfigurationOptions.setFooter(value);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setFooter(List)"})
  void testSetFooter_whenArrayList() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualSetFooterResult =
        yamlConfigurationOptions.setFooter(new ArrayList<>());

    // Assert
    assertSame(yamlConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.setFooter(List)"})
  void testSetFooter_whenNull() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualSetFooterResult = yamlConfigurationOptions.setFooter(null);

    // Assert
    assertSame(yamlConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#parseComments(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#parseComments(boolean)}
   */
  @Test
  @DisplayName("Test parseComments(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.parseComments(boolean)"})
  void testParseCommentsWithBoolean() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualParseCommentsResult =
        yamlConfigurationOptions.parseComments(true);

    // Assert
    assertSame(yamlConfigurationOptions, actualParseCommentsResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#copyHeader(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#copyHeader(boolean)}
   */
  @Test
  @DisplayName("Test copyHeader(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.copyHeader(boolean)"})
  void testCopyHeaderWithBoolean() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualCopyHeaderResult = yamlConfigurationOptions.copyHeader(true);

    // Assert
    assertSame(yamlConfigurationOptions, actualCopyHeaderResult);
  }

  /**
   * Test {@link YamlConfigurationOptions#indent(int)} with {@code int}.
   *
   * <p>Method under test: {@link YamlConfigurationOptions#indent(int)}
   */
  @Test
  @DisplayName("Test indent(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfigurationOptions.indent(int)"})
  void testIndentWithInt() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualIndentResult = yamlConfigurationOptions.indent(2);

    // Assert
    assertSame(yamlConfigurationOptions, actualIndentResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link YamlConfigurationOptions#codePointLimit(int)}
   *   <li>{@link YamlConfigurationOptions#width(int)}
   *   <li>{@link YamlConfigurationOptions#codePointLimit()}
   *   <li>{@link YamlConfigurationOptions#indent()}
   *   <li>{@link YamlConfigurationOptions#width()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int YamlConfigurationOptions.codePointLimit()",
    "YamlConfigurationOptions YamlConfigurationOptions.codePointLimit(int)",
    "int YamlConfigurationOptions.indent()",
    "int YamlConfigurationOptions.width()",
    "YamlConfigurationOptions YamlConfigurationOptions.width(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    YamlConfigurationOptions yamlConfigurationOptions =
        new YamlConfigurationOptions(new YamlConfiguration());

    // Act
    YamlConfigurationOptions actualCodePointLimitResult =
        yamlConfigurationOptions.codePointLimit(1);
    YamlConfigurationOptions actualWidthResult = yamlConfigurationOptions.width(42);
    int actualCodePointLimitResult2 = yamlConfigurationOptions.codePointLimit();
    int actualIndentResult = yamlConfigurationOptions.indent();

    // Assert
    assertEquals(1, actualCodePointLimitResult2);
    assertEquals(2, actualIndentResult);
    assertEquals(42, yamlConfigurationOptions.width());
    assertSame(yamlConfigurationOptions, actualCodePointLimitResult);
    assertSame(yamlConfigurationOptions, actualWidthResult);
  }
}
