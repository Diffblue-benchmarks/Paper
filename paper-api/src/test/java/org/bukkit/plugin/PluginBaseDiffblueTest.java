package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginBaseDiffblueTest {
  /**
   * Test {@link PluginBase#equals(Object)}, and {@link PluginBase#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginBase#equals(Object)}
   *   <li>{@link PluginBase#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginBase.equals(Object)", "int PluginBase.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestPlugin testPlugin = new TestPlugin("Plugin Name");
    TestPlugin testPlugin2 = new TestPlugin("Plugin Name");

    // Act and Assert
    assertEquals(testPlugin, testPlugin2);
    assertEquals(testPlugin.hashCode(), testPlugin2.hashCode());
  }

  /**
   * Test {@link PluginBase#equals(Object)}, and {@link PluginBase#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginBase#equals(Object)}
   *   <li>{@link PluginBase#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginBase.equals(Object)", "int PluginBase.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestPlugin testPlugin = new TestPlugin("Plugin Name");

    // Act and Assert
    assertEquals(testPlugin, testPlugin);
    int expectedHashCodeResult = testPlugin.hashCode();
    assertEquals(expectedHashCodeResult, testPlugin.hashCode());
  }

  /**
   * Test {@link PluginBase#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginBase#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginBase.equals(Object)", "int PluginBase.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPlugin testPlugin = new TestPlugin("U");

    // Act and Assert
    assertNotEquals(testPlugin, new TestPlugin("Plugin Name"));
  }

  /**
   * Test {@link PluginBase#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginBase#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginBase.equals(Object)", "int PluginBase.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPlugin("Plugin Name"), null);
  }

  /**
   * Test {@link PluginBase#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginBase#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginBase.equals(Object)", "int PluginBase.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPlugin("Plugin Name"), "Different type to PluginBase");
  }

  /**
   * Test {@link PluginBase#getName()}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return {@code Plugin_Name}.
   * </ul>
   *
   * <p>Method under test: {@link PluginBase#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given TestPlugin(String) with 'Plugin Name'; then return 'Plugin_Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PluginBase.getName()"})
  void testGetName_givenTestPluginWithPluginName_thenReturnPluginName() {
    // Arrange, Act and Assert
    assertEquals("Plugin_Name", new TestPlugin("Plugin Name").getName());
  }

  /**
   * Test {@link PluginBase#namespace()}.
   *
   * <ul>
   *   <li>Given {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return {@code plugin_name}.
   * </ul>
   *
   * <p>Method under test: {@link PluginBase#namespace()}
   */
  @Test
  @DisplayName(
      "Test namespace(); given TestPlugin(String) with 'Plugin Name'; then return 'plugin_name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PluginBase.namespace()"})
  void testNamespace_givenTestPluginWithPluginName_thenReturnPluginName() {
    // Arrange, Act and Assert
    assertEquals("plugin_name", new TestPlugin("Plugin Name").namespace());
  }
}
