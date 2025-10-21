package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.MemoryConfigurationOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileConfigurationOptionsDiffblueTest {
  /**
   * Test {@link FileConfigurationOptions#FileConfigurationOptions(MemoryConfiguration)}.
   *
   * <p>Method under test: {@link
   * FileConfigurationOptions#FileConfigurationOptions(MemoryConfiguration)}
   */
  @Test
  @DisplayName("Test new FileConfigurationOptions(MemoryConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileConfigurationOptions.<init>(MemoryConfiguration)"})
  void testNewFileConfigurationOptions() {
    // Arrange and Act
    FileConfigurationOptions actualFileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Assert
    assertEquals('.', actualFileConfigurationOptions.pathSeparator());
    assertFalse(actualFileConfigurationOptions.copyDefaults());
    List<String> footer = actualFileConfigurationOptions.getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(actualFileConfigurationOptions.parseComments());
    assertSame(footer, actualFileConfigurationOptions.getHeader());
  }

  /**
   * Test {@link FileConfigurationOptions#configuration()}.
   *
   * <p>Method under test: {@link FileConfigurationOptions#configuration()}
   */
  @Test
  @DisplayName("Test configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.bukkit.configuration.file.FileConfiguration FileConfigurationOptions.configuration()"
  })
  void testConfiguration() {
    // Arrange
    YamlConfiguration configuration = new YamlConfiguration();

    // Act and Assert
    assertSame(configuration, new FileConfigurationOptions(configuration).configuration());
  }

  /**
   * Test {@link FileConfigurationOptions#copyDefaults(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link FileConfigurationOptions#copyDefaults(boolean)}
   */
  @Test
  @DisplayName("Test copyDefaults(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.copyDefaults(boolean)"})
  void testCopyDefaultsWithBoolean() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualCopyDefaultsResult = fileConfigurationOptions.copyDefaults(true);

    // Assert
    assertTrue(fileConfigurationOptions.copyDefaults());
    assertSame(fileConfigurationOptions, actualCopyDefaultsResult);
  }

  /**
   * Test {@link FileConfigurationOptions#pathSeparator(char)} with {@code char}.
   *
   * <p>Method under test: {@link FileConfigurationOptions#pathSeparator(char)}
   */
  @Test
  @DisplayName("Test pathSeparator(char) with 'char'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.pathSeparator(char)"})
  void testPathSeparatorWithChar() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualPathSeparatorResult =
        fileConfigurationOptions.pathSeparator('A');

    // Assert
    assertEquals('A', fileConfigurationOptions.pathSeparator());
    assertSame(fileConfigurationOptions, actualPathSeparatorResult);
  }

  /**
   * Test {@link FileConfigurationOptions#header(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#header(String)}
   */
  @Test
  @DisplayName("Test header(String) with 'String'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.header(String)"})
  void testHeaderWithString_when42() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualHeaderResult = fileConfigurationOptions.header("42");

    // Assert
    assertSame(fileConfigurationOptions, actualHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#header(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#header(String)}
   */
  @Test
  @DisplayName("Test header(String) with 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.header(String)"})
  void testHeaderWithString_whenNull() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualHeaderResult = fileConfigurationOptions.header(null);

    // Assert
    assertSame(fileConfigurationOptions, actualHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#header()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#header()}
   */
  @Test
  @DisplayName("Test header(); given ArrayList() add 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileConfigurationOptions.header()"})
  void testHeader_givenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());
    fileConfigurationOptions.setHeader(value);

    // Act and Assert
    assertEquals("foo\n", fileConfigurationOptions.header());
  }

  /**
   * Test {@link FileConfigurationOptions#header()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return lf.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#header()}
   */
  @Test
  @DisplayName("Test header(); given ArrayList() add 'null'; then return lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileConfigurationOptions.header()"})
  void testHeader_givenArrayListAddNull_thenReturnLf() {
    // Arrange
    ArrayList<String> value = new ArrayList<>();
    value.add(null);

    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());
    fileConfigurationOptions.setHeader(value);

    // Act and Assert
    assertEquals("\n", fileConfigurationOptions.header());
  }

  /**
   * Test {@link FileConfigurationOptions#header()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#header()}
   */
  @Test
  @DisplayName("Test header(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileConfigurationOptions.header()"})
  void testHeader_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FileConfigurationOptions(new MemoryConfiguration()).header());
  }

  /**
   * Test {@link FileConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setHeader(List)"})
  void testSetHeader_given42_whenArrayListAdd42() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    FileConfigurationOptions actualSetHeaderResult = fileConfigurationOptions.setHeader(value);

    // Assert
    assertSame(fileConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setHeader(List)"})
  void testSetHeader_givenFoo_whenArrayListAddFoo() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    FileConfigurationOptions actualSetHeaderResult = fileConfigurationOptions.setHeader(value);

    // Assert
    assertSame(fileConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setHeader(List)"})
  void testSetHeader_whenArrayList() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualSetHeaderResult =
        fileConfigurationOptions.setHeader(new ArrayList<>());

    // Assert
    assertSame(fileConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setHeader(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setHeader(List)}
   */
  @Test
  @DisplayName("Test setHeader(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setHeader(List)"})
  void testSetHeader_whenNull() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualSetHeaderResult = fileConfigurationOptions.setHeader(null);

    // Assert
    assertSame(fileConfigurationOptions, actualSetHeaderResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setFooter(List)"})
  void testSetFooter_given42_whenArrayListAdd42() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    FileConfigurationOptions actualSetFooterResult = fileConfigurationOptions.setFooter(value);

    // Assert
    assertSame(fileConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setFooter(List)"})
  void testSetFooter_givenFoo_whenArrayListAddFoo() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    FileConfigurationOptions actualSetFooterResult = fileConfigurationOptions.setFooter(value);

    // Assert
    assertSame(fileConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setFooter(List)"})
  void testSetFooter_whenArrayList() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualSetFooterResult =
        fileConfigurationOptions.setFooter(new ArrayList<>());

    // Assert
    assertSame(fileConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link FileConfigurationOptions#setFooter(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileConfigurationOptions#setFooter(List)}
   */
  @Test
  @DisplayName("Test setFooter(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfigurationOptions.setFooter(List)"})
  void testSetFooter_whenNull() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualSetFooterResult = fileConfigurationOptions.setFooter(null);

    // Assert
    assertSame(fileConfigurationOptions, actualSetFooterResult);
  }

  /**
   * Test {@link FileConfigurationOptions#copyHeader()}.
   *
   * <p>Method under test: {@link FileConfigurationOptions#copyHeader()}
   */
  @Test
  @DisplayName("Test copyHeader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileConfigurationOptions.copyHeader()"})
  void testCopyHeader() {
    // Arrange, Act and Assert
    assertTrue(new FileConfigurationOptions(new MemoryConfiguration()).copyHeader());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileConfigurationOptions#copyHeader(boolean)}
   *   <li>{@link FileConfigurationOptions#parseComments(boolean)}
   *   <li>{@link FileConfigurationOptions#getFooter()}
   *   <li>{@link FileConfigurationOptions#getHeader()}
   *   <li>{@link FileConfigurationOptions#parseComments()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FileConfigurationOptions FileConfigurationOptions.copyHeader(boolean)",
    "List FileConfigurationOptions.getFooter()",
    "List FileConfigurationOptions.getHeader()",
    "boolean FileConfigurationOptions.parseComments()",
    "MemoryConfigurationOptions FileConfigurationOptions.parseComments(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    FileConfigurationOptions fileConfigurationOptions =
        new FileConfigurationOptions(new MemoryConfiguration());

    // Act
    FileConfigurationOptions actualCopyHeaderResult = fileConfigurationOptions.copyHeader(true);
    MemoryConfigurationOptions actualParseCommentsResult =
        fileConfigurationOptions.parseComments(true);
    List<String> actualFooter = fileConfigurationOptions.getFooter();
    List<String> actualHeader = fileConfigurationOptions.getHeader();
    boolean actualParseCommentsResult2 = fileConfigurationOptions.parseComments();

    // Assert
    assertTrue(actualFooter.isEmpty());
    assertTrue(actualParseCommentsResult2);
    assertSame(fileConfigurationOptions, actualCopyHeaderResult);
    assertSame(fileConfigurationOptions, actualParseCommentsResult);
    assertSame(actualFooter, actualHeader);
  }
}
