package ca.spottedleaf.dataconverter.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.MapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NamespaceUtilDiffblueTest {
  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code 42}.
   *   <li>Then calls {@link MapType#setString(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test enforceForPath(MapType, String); given '42'; when MapType getString(String) return '42'; then calls setString(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_given42_whenMapTypeGetStringReturn42_thenCallsSetString() {
    // Arrange
    MapType data = mock(MapType.class);
    doNothing().when(data).setString(Mockito.<String>any(), Mockito.<String>any());
    when(data.getString(Mockito.<String>any())).thenReturn("42");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
    verify(data).setString("Path", "minecraft:42");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code 42minecraft:foo}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code 42minecraft:foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test enforceForPath(MapType, String); given '42minecraft:foo'; when MapType getString(String) return '42minecraft:foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_given42minecraftFoo_whenMapTypeGetStringReturn42minecraftFoo() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("42minecraft:foo");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code foo}.
   *   <li>Then calls {@link MapType#setString(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test enforceForPath(MapType, String); given 'foo'; when MapType getString(String) return 'foo'; then calls setString(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenFoo_whenMapTypeGetStringReturnFoo_thenCallsSetString() {
    // Arrange
    MapType data = mock(MapType.class);
    doNothing().when(data).setString(Mockito.<String>any(), Mockito.<String>any());
    when(data.getString(Mockito.<String>any())).thenReturn("foo");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
    verify(data).setString("Path", "minecraft:foo");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code java.lang.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName("Test enforceForPath(MapType, String); given 'java.lang.Boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenJavaLangBoolean() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("java.lang.Boolean");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code java.lang.Booleanminecraft:foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName("Test enforceForPath(MapType, String); given 'java.lang.Booleanminecraft:foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenJavaLangBooleanminecraftFoo() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("java.lang.Booleanminecraft:foo");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code minecraft:foo}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code minecraft:foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test enforceForPath(MapType, String); given 'minecraft:foo'; when MapType getString(String) return 'minecraft:foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenMinecraftFoo_whenMapTypeGetStringReturnMinecraftFoo() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("minecraft:foo");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code minecraft:foominecraft:foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName("Test enforceForPath(MapType, String); given 'minecraft:foominecraft:foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenMinecraftFoominecraftFoo() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("minecraft:foominecraft:foo");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#enforceForPath(MapType, String)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link MapType} {@link MapType#getString(String)} return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#enforceForPath(MapType, String)}
   */
  @Test
  @DisplayName(
      "Test enforceForPath(MapType, String); given 'String'; when MapType getString(String) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespaceUtil.enforceForPath(MapType, String)"})
  void testEnforceForPath_givenString_whenMapTypeGetStringReturnString() {
    // Arrange
    MapType data = mock(MapType.class);
    when(data.getString(Mockito.<String>any())).thenReturn("String");

    // Act
    NamespaceUtil.enforceForPath(data, "Path");

    // Assert
    verify(data).getString("Path");
  }

  /**
   * Test {@link NamespaceUtil#correctNamespace(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespace(String)}
   */
  @Test
  @DisplayName("Test correctNamespace(String); when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespace(String)"})
  void testCorrectNamespace_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft:42", NamespaceUtil.correctNamespace("42"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespace(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespace(String)}
   */
  @Test
  @DisplayName("Test correctNamespace(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespace(String)"})
  void testCorrectNamespace_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespace(null));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespace(String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespace(String)}
   */
  @Test
  @DisplayName("Test correctNamespace(String); when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespace(String)"})
  void testCorrectNamespace_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", NamespaceUtil.correctNamespace("Value"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code minecraft:42}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when '42'; then return 'minecraft:42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_when42_thenReturnMinecraft42() {
    // Arrange, Act and Assert
    assertEquals("minecraft:42", NamespaceUtil.correctNamespaceOrNull("42"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code 42minecraft:42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when '42minecraft:42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_when42minecraft42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull("42minecraft:42"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when 'minecraft:42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_whenMinecraft42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull("minecraft:42"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:42minecraft:42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName(
      "Test correctNamespaceOrNull(String); when 'minecraft:42minecraft:42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_whenMinecraft42minecraft42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull("minecraft:42minecraft:42"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull(null));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when 'Value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_whenValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull("Value"));
  }

  /**
   * Test {@link NamespaceUtil#correctNamespaceOrNull(String)}.
   *
   * <ul>
   *   <li>When {@code Valueminecraft:42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamespaceUtil#correctNamespaceOrNull(String)}
   */
  @Test
  @DisplayName("Test correctNamespaceOrNull(String); when 'Valueminecraft:42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamespaceUtil.correctNamespaceOrNull(String)"})
  void testCorrectNamespaceOrNull_whenValueminecraft42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(NamespaceUtil.correctNamespaceOrNull("Valueminecraft:42"));
  }
}
