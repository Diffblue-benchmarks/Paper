package org.bukkit.plugin.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JavaPluginDiffblueTest {
  /**
   * Test {@link JavaPlugin#getPlugin(Class)}.
   *
   * <ul>
   *   <li>When {@code JavaPlugin}.
   * </ul>
   *
   * <p>Method under test: {@link JavaPlugin#getPlugin(Class)}
   */
  @Test
  @DisplayName("Test getPlugin(Class); when 'org.bukkit.plugin.java.JavaPlugin'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JavaPlugin JavaPlugin.getPlugin(Class)"})
  void testGetPlugin_whenOrgBukkitPluginJavaJavaPlugin() {
    // Arrange
    Class<JavaPlugin> clazz = JavaPlugin.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JavaPlugin.getPlugin(clazz));
  }

  /**
   * Test {@link JavaPlugin#getProvidingPlugin(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JavaPlugin#getProvidingPlugin(Class)}
   */
  @Test
  @DisplayName(
      "Test getProvidingPlugin(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JavaPlugin JavaPlugin.getProvidingPlugin(Class)"})
  void testGetProvidingPlugin_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JavaPlugin.getProvidingPlugin(clazz));
  }
}
