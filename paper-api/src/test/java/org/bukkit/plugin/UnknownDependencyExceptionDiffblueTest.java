package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnknownDependencyExceptionDiffblueTest {
  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new UnknownDependencyException(Collection, String); given ','; when ArrayList() add ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownDependencyException.<init>(Collection, String)"})
  void testNewUnknownDependencyException_givenComma_whenArrayListAddComma() {
    // Arrange
    ArrayList<String> missingDependencies = new ArrayList<>();
    missingDependencies.add(", ");

    // Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException(missingDependencies, "Plugin Name");

    // Assert
    assertEquals(
        "Unknown/missing dependency plugins: [, ]. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getLocalizedMessage());
    assertEquals(
        "Unknown/missing dependency plugins: [, ]. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getMessage());
    assertNull(actualUnknownDependencyException.getCause());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new UnknownDependencyException(Collection, String); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownDependencyException.<init>(Collection, String)"})
  void testNewUnknownDependencyException_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> missingDependencies = new ArrayList<>();
    missingDependencies.add("foo");
    missingDependencies.add(", ");

    // Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException(missingDependencies, "Plugin Name");

    // Assert
    assertEquals(
        "Unknown/missing dependency plugins: [foo, , ]. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getLocalizedMessage());
    assertEquals(
        "Unknown/missing dependency plugins: [foo, , ]. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getMessage());
    assertNull(actualUnknownDependencyException.getCause());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(String)}
   */
  @Test
  @DisplayName(
      "Test new UnknownDependencyException(String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownDependencyException.<init>()",
    "void UnknownDependencyException.<init>(String)",
    "void UnknownDependencyException.<init>(Throwable)",
    "void UnknownDependencyException.<init>(Throwable, String)"
  })
  void testNewUnknownDependencyException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnknownDependencyException.getMessage());
    assertNull(actualUnknownDependencyException.getCause());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(Throwable, String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(Throwable,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new UnknownDependencyException(Throwable, String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownDependencyException.<init>()",
    "void UnknownDependencyException.<init>(String)",
    "void UnknownDependencyException.<init>(Throwable)",
    "void UnknownDependencyException.<init>(Throwable, String)"
  })
  void testNewUnknownDependencyException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException(throwable, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnknownDependencyException.getMessage());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
    assertSame(throwable, actualUnknownDependencyException.getCause());
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new UnknownDependencyException(Throwable); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownDependencyException.<init>()",
    "void UnknownDependencyException.<init>(String)",
    "void UnknownDependencyException.<init>(Throwable)",
    "void UnknownDependencyException.<init>(Throwable, String)"
  })
  void testNewUnknownDependencyException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualUnknownDependencyException.getMessage());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
    assertSame(throwable, actualUnknownDependencyException.getCause());
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException()}
   */
  @Test
  @DisplayName("Test new UnknownDependencyException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownDependencyException.<init>()",
    "void UnknownDependencyException.<init>(String)",
    "void UnknownDependencyException.<init>(Throwable)",
    "void UnknownDependencyException.<init>(Throwable, String)"
  })
  void testNewUnknownDependencyException_thenReturnMessageIsNull() {
    // Arrange and Act
    UnknownDependencyException actualUnknownDependencyException = new UnknownDependencyException();

    // Assert
    assertNull(actualUnknownDependencyException.getMessage());
    assertNull(actualUnknownDependencyException.getCause());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
  }

  /**
   * Test {@link UnknownDependencyException#UnknownDependencyException(Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDependencyException#UnknownDependencyException(Collection,
   * String)}
   */
  @Test
  @DisplayName("Test new UnknownDependencyException(Collection, String); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownDependencyException.<init>(Collection, String)"})
  void testNewUnknownDependencyException_whenArrayList() {
    // Arrange and Act
    UnknownDependencyException actualUnknownDependencyException =
        new UnknownDependencyException(new ArrayList<>(), "Plugin Name");

    // Assert
    assertEquals(
        "Unknown/missing dependency plugins: []. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getLocalizedMessage());
    assertEquals(
        "Unknown/missing dependency plugins: []. Please download and install these plugins to run 'Plugin"
            + " Name'.",
        actualUnknownDependencyException.getMessage());
    assertNull(actualUnknownDependencyException.getCause());
    assertEquals(0, actualUnknownDependencyException.getSuppressed().length);
  }
}
