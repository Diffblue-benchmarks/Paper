package io.papermc.paper.pluginremap.reflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperReflectionDiffblueTest {
  /**
   * Test {@link PaperReflection#PaperReflection()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PaperReflection}
   */
  @Test
  @DisplayName("Test new PaperReflection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperReflection.<init>()"})
  void testNewPaperReflection() {
    // Arrange, Act and Assert
    assertEquals("Name", new PaperReflection().mapClassName("Name"));
  }

  /**
   * Test {@link PaperReflection#mapClassName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperReflection#mapClassName(String)}
   */
  @Test
  @DisplayName("Test mapClassName(String); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperReflection.mapClassName(String)"})
  void testMapClassName_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", new PaperReflection().mapClassName("Name"));
  }

  /**
   * Test {@link PaperReflection#mapDeclaredMethodName(Class, String, Class[])}.
   *
   * <ul>
   *   <li>When {@link Object}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperReflection#mapDeclaredMethodName(Class, String, Class[])}
   */
  @Test
  @DisplayName(
      "Test mapDeclaredMethodName(Class, String, Class[]); when Object; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperReflection.mapDeclaredMethodName(Class, String, Class[])"})
  void testMapDeclaredMethodName_whenObject_thenReturnName() {
    // Arrange
    PaperReflection paperReflection = new PaperReflection();
    Class<Object> clazz = Object.class;
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertEquals("Name", paperReflection.mapDeclaredMethodName(clazz, "Name", forNameResult));
  }

  /**
   * Test {@link PaperReflection#mapMethodName(Class, String, Class[])}.
   *
   * <ul>
   *   <li>When {@link Object}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperReflection#mapMethodName(Class, String, Class[])}
   */
  @Test
  @DisplayName("Test mapMethodName(Class, String, Class[]); when Object; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperReflection.mapMethodName(Class, String, Class[])"})
  void testMapMethodName_whenObject_thenReturnName() {
    // Arrange
    PaperReflection paperReflection = new PaperReflection();
    Class<Object> clazz = Object.class;
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertEquals("Name", paperReflection.mapMethodName(clazz, "Name", forNameResult));
  }

  /**
   * Test {@link PaperReflection#mapDeclaredFieldName(Class, String)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperReflection#mapDeclaredFieldName(Class, String)}
   */
  @Test
  @DisplayName(
      "Test mapDeclaredFieldName(Class, String); when 'java.lang.Object'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperReflection.mapDeclaredFieldName(Class, String)"})
  void testMapDeclaredFieldName_whenJavaLangObject_thenReturnName() {
    // Arrange
    PaperReflection paperReflection = new PaperReflection();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Name", paperReflection.mapDeclaredFieldName(clazz, "Name"));
  }

  /**
   * Test {@link PaperReflection#mapFieldName(Class, String)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperReflection#mapFieldName(Class, String)}
   */
  @Test
  @DisplayName("Test mapFieldName(Class, String); when 'java.lang.Object'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperReflection.mapFieldName(Class, String)"})
  void testMapFieldName_whenJavaLangObject_thenReturnName() {
    // Arrange
    PaperReflection paperReflection = new PaperReflection();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Name", paperReflection.mapFieldName(clazz, "Name"));
  }
}
