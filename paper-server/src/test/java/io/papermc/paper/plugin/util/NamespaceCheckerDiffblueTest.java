package io.papermc.paper.plugin.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamespaceCheckerDiffblueTest {
  /**
   * Test {@link NamespaceChecker#validateNameSpaceForClassloading(String)}.
   *
   * <ul>
   *   <li>Then throw {@link ClassNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceChecker#validateNameSpaceForClassloading(String)}
   */
  @Test
  @DisplayName("Test validateNameSpaceForClassloading(String); then throw ClassNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceChecker.validateNameSpaceForClassloading(String)"})
  void testValidateNameSpaceForClassloading_thenThrowClassNotFoundException()
      throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertThrows(
        ClassNotFoundException.class,
        () -> NamespaceChecker.validateNameSpaceForClassloading("com.destroystokoyo.paper."));
  }

  /**
   * Test {@link NamespaceChecker#validateNameSpaceForClassloading(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceChecker#validateNameSpaceForClassloading(String)}
   */
  @Test
  @DisplayName("Test validateNameSpaceForClassloading(String); when 'Name'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceChecker.validateNameSpaceForClassloading(String)"})
  void testValidateNameSpaceForClassloading_whenName_thenDoesNotThrow()
      throws ClassNotFoundException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> NamespaceChecker.validateNameSpaceForClassloading("Name"));
  }

  /**
   * Test {@link NamespaceChecker#isValidNameSpace(String)}.
   *
   * <ul>
   *   <li>When {@code com.destroystokoyo.paper.}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceChecker#isValidNameSpace(String)}
   */
  @Test
  @DisplayName(
      "Test isValidNameSpace(String); when 'com.destroystokoyo.paper.'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespaceChecker.isValidNameSpace(String)"})
  void testIsValidNameSpace_whenComDestroystokoyoPaper_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(NamespaceChecker.isValidNameSpace("com.destroystokoyo.paper."));
  }

  /**
   * Test {@link NamespaceChecker#isValidNameSpace(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceChecker#isValidNameSpace(String)}
   */
  @Test
  @DisplayName("Test isValidNameSpace(String); when 'Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespaceChecker.isValidNameSpace(String)"})
  void testIsValidNameSpace_whenName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NamespaceChecker.isValidNameSpace("Name"));
  }
}
