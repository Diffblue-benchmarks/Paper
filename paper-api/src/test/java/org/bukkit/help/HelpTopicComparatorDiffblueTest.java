package org.bukkit.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.help.HelpTopicComparator.TopicNameComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpTopicComparatorDiffblueTest {
  /**
   * Test TopicNameComparator {@link TopicNameComparator#compare(String, String)} with {@code lhs},
   * {@code rhs}.
   *
   * <ul>
   *   <li>When {@code Lhs}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TopicNameComparator#compare(String, String)}
   */
  @Test
  @DisplayName(
      "Test TopicNameComparator compare(String, String) with 'lhs', 'rhs'; when 'Lhs'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TopicNameComparator.compare(String, String)"})
  void testTopicNameComparatorCompareWithLhsRhs_whenLhs_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, HelpTopicComparator.topicNameComparatorInstance().compare("Lhs", "/"));
  }

  /**
   * Test TopicNameComparator {@link TopicNameComparator#compare(String, String)} with {@code lhs},
   * {@code rhs}.
   *
   * <ul>
   *   <li>When {@code Lhs}.
   *   <li>Then return minus six.
   * </ul>
   *
   * <p>Method under test: {@link TopicNameComparator#compare(String, String)}
   */
  @Test
  @DisplayName(
      "Test TopicNameComparator compare(String, String) with 'lhs', 'rhs'; when 'Lhs'; then return minus six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TopicNameComparator.compare(String, String)"})
  void testTopicNameComparatorCompareWithLhsRhs_whenLhs_thenReturnMinusSix() {
    // Arrange, Act and Assert
    assertEquals(-6, HelpTopicComparator.topicNameComparatorInstance().compare("Lhs", "Rhs"));
  }

  /**
   * Test TopicNameComparator {@link TopicNameComparator#compare(String, String)} with {@code lhs},
   * {@code rhs}.
   *
   * <ul>
   *   <li>When {@code Rhs}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TopicNameComparator#compare(String, String)}
   */
  @Test
  @DisplayName(
      "Test TopicNameComparator compare(String, String) with 'lhs', 'rhs'; when 'Rhs'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TopicNameComparator.compare(String, String)"})
  void testTopicNameComparatorCompareWithLhsRhs_whenRhs_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, HelpTopicComparator.topicNameComparatorInstance().compare("/", "Rhs"));
  }

  /**
   * Test TopicNameComparator {@link TopicNameComparator#compare(String, String)} with {@code lhs},
   * {@code rhs}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TopicNameComparator#compare(String, String)}
   */
  @Test
  @DisplayName(
      "Test TopicNameComparator compare(String, String) with 'lhs', 'rhs'; when '/'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TopicNameComparator.compare(String, String)"})
  void testTopicNameComparatorCompareWithLhsRhs_whenSlash_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, HelpTopicComparator.topicNameComparatorInstance().compare("/", "/"));
  }

  /**
   * Test {@link HelpTopicComparator#topicNameComparatorInstance()}.
   *
   * <ul>
   *   <li>Then return compare {@code Lhs} and {@code Rhs} is minus six.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#topicNameComparatorInstance()}
   */
  @Test
  @DisplayName(
      "Test topicNameComparatorInstance(); then return compare 'Lhs' and 'Rhs' is minus six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicNameComparator HelpTopicComparator.topicNameComparatorInstance()"})
  void testTopicNameComparatorInstance_thenReturnCompareLhsAndRhsIsMinusSix() {
    // Arrange, Act and Assert
    assertEquals(-6, HelpTopicComparator.topicNameComparatorInstance().compare("Lhs", "Rhs"));
  }

  /**
   * Test {@link HelpTopicComparator#topicNameComparatorInstance()}.
   *
   * <ul>
   *   <li>Then return compare {@code Lhs} and {@code /} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#topicNameComparatorInstance()}
   */
  @Test
  @DisplayName("Test topicNameComparatorInstance(); then return compare 'Lhs' and '/' is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicNameComparator HelpTopicComparator.topicNameComparatorInstance()"})
  void testTopicNameComparatorInstance_thenReturnCompareLhsAndSlashIsMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, HelpTopicComparator.topicNameComparatorInstance().compare("Lhs", "/"));
  }

  /**
   * Test {@link HelpTopicComparator#topicNameComparatorInstance()}.
   *
   * <ul>
   *   <li>Then return compare {@code /} and {@code Rhs} is one.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#topicNameComparatorInstance()}
   */
  @Test
  @DisplayName("Test topicNameComparatorInstance(); then return compare '/' and 'Rhs' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicNameComparator HelpTopicComparator.topicNameComparatorInstance()"})
  void testTopicNameComparatorInstance_thenReturnCompareSlashAndRhsIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, HelpTopicComparator.topicNameComparatorInstance().compare("/", "Rhs"));
  }

  /**
   * Test {@link HelpTopicComparator#topicNameComparatorInstance()}.
   *
   * <ul>
   *   <li>Then return compare {@code /} and {@code /} is zero.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#topicNameComparatorInstance()}
   */
  @Test
  @DisplayName("Test topicNameComparatorInstance(); then return compare '/' and '/' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicNameComparator HelpTopicComparator.topicNameComparatorInstance()"})
  void testTopicNameComparatorInstance_thenReturnCompareSlashAndSlashIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, HelpTopicComparator.topicNameComparatorInstance().compare("/", "/"));
  }

  /**
   * Test {@link HelpTopicComparator#helpTopicComparatorInstance()}.
   *
   * <p>Method under test: {@link HelpTopicComparator#helpTopicComparatorInstance()}
   */
  @Test
  @DisplayName("Test helpTopicComparatorInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpTopicComparator HelpTopicComparator.helpTopicComparatorInstance()"})
  void testHelpTopicComparatorInstance() {
    // Arrange and Act
    HelpTopicComparator actualHelpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    GenericCommandHelpTopic lhs = new GenericCommandHelpTopic(new HelpCommand());

    // Assert
    assertEquals(
        0,
        actualHelpTopicComparatorInstanceResult.compare(
            lhs, new GenericCommandHelpTopic(new HelpCommand())));
  }

  /**
   * Test {@link HelpTopicComparator#helpTopicComparatorInstance()}.
   *
   * <p>Method under test: {@link HelpTopicComparator#helpTopicComparatorInstance()}
   */
  @Test
  @DisplayName("Test helpTopicComparatorInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpTopicComparator HelpTopicComparator.helpTopicComparatorInstance()"})
  void testHelpTopicComparatorInstance2() {
    // Arrange and Act
    HelpTopicComparator actualHelpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    IndexHelpTopic lhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Assert
    assertEquals(
        -1,
        actualHelpTopicComparatorInstanceResult.compare(
            lhs, new GenericCommandHelpTopic(new HelpCommand())));
  }

  /**
   * Test {@link HelpTopicComparator#helpTopicComparatorInstance()}.
   *
   * <p>Method under test: {@link HelpTopicComparator#helpTopicComparatorInstance()}
   */
  @Test
  @DisplayName("Test helpTopicComparatorInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpTopicComparator HelpTopicComparator.helpTopicComparatorInstance()"})
  void testHelpTopicComparatorInstance3() {
    // Arrange and Act
    HelpTopicComparator actualHelpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    GenericCommandHelpTopic lhs = new GenericCommandHelpTopic(new HelpCommand());
    IndexHelpTopic rhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Assert
    assertEquals(1, actualHelpTopicComparatorInstanceResult.compare(lhs, rhs));
  }

  /**
   * Test {@link HelpTopicComparator#helpTopicComparatorInstance()}.
   *
   * <p>Method under test: {@link HelpTopicComparator#helpTopicComparatorInstance()}
   */
  @Test
  @DisplayName("Test helpTopicComparatorInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HelpTopicComparator HelpTopicComparator.helpTopicComparatorInstance()"})
  void testHelpTopicComparatorInstance4() {
    // Arrange and Act
    HelpTopicComparator actualHelpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    IndexHelpTopic lhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());
    IndexHelpTopic rhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Assert
    assertEquals(0, actualHelpTopicComparatorInstanceResult.compare(lhs, rhs));
  }

  /**
   * Test {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)} with {@code lhs}, {@code rhs}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)}
   */
  @Test
  @DisplayName("Test compare(HelpTopic, HelpTopic) with 'lhs', 'rhs'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpTopicComparator.compare(HelpTopic, HelpTopic)"})
  void testCompareWithLhsRhs_thenReturnMinusOne() {
    // Arrange
    HelpTopicComparator helpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    IndexHelpTopic lhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Act and Assert
    assertEquals(
        -1,
        helpTopicComparatorInstanceResult.compare(
            lhs, new GenericCommandHelpTopic(new HelpCommand())));
  }

  /**
   * Test {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)} with {@code lhs}, {@code rhs}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)}
   */
  @Test
  @DisplayName("Test compare(HelpTopic, HelpTopic) with 'lhs', 'rhs'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpTopicComparator.compare(HelpTopic, HelpTopic)"})
  void testCompareWithLhsRhs_thenReturnOne() {
    // Arrange
    HelpTopicComparator helpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    GenericCommandHelpTopic lhs = new GenericCommandHelpTopic(new HelpCommand());
    IndexHelpTopic rhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Act and Assert
    assertEquals(1, helpTopicComparatorInstanceResult.compare(lhs, rhs));
  }

  /**
   * Test {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)} with {@code lhs}, {@code rhs}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)}
   */
  @Test
  @DisplayName("Test compare(HelpTopic, HelpTopic) with 'lhs', 'rhs'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpTopicComparator.compare(HelpTopic, HelpTopic)"})
  void testCompareWithLhsRhs_thenReturnZero() {
    // Arrange
    HelpTopicComparator helpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    GenericCommandHelpTopic lhs = new GenericCommandHelpTopic(new HelpCommand());

    // Act and Assert
    assertEquals(
        0,
        helpTopicComparatorInstanceResult.compare(
            lhs, new GenericCommandHelpTopic(new HelpCommand())));
  }

  /**
   * Test {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)} with {@code lhs}, {@code rhs}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopicComparator#compare(HelpTopic, HelpTopic)}
   */
  @Test
  @DisplayName("Test compare(HelpTopic, HelpTopic) with 'lhs', 'rhs'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpTopicComparator.compare(HelpTopic, HelpTopic)"})
  void testCompareWithLhsRhs_thenReturnZero2() {
    // Arrange
    HelpTopicComparator helpTopicComparatorInstanceResult =
        HelpTopicComparator.helpTopicComparatorInstance();
    IndexHelpTopic lhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());
    IndexHelpTopic rhs = new IndexHelpTopic("Name", "/", "/", new ArrayList<>());

    // Act and Assert
    assertEquals(0, helpTopicComparatorInstanceResult.compare(lhs, rhs));
  }
}
