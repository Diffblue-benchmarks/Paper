package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamespacedTagDiffblueTest {
  /**
   * Test {@link NamespacedTag#NamespacedTag(String, String)}.
   *
   * <ul>
   *   <li>When {@code l}.
   *   <li>Then return Key is {@code l}.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#NamespacedTag(String, String)}
   */
  @Test
  @DisplayName("Test new NamespacedTag(String, String); when 'l'; then return Key is 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespacedTag.<init>(String, String)"})
  void testNewNamespacedTag_whenL_thenReturnKeyIsL() {
    // Arrange and Act
    NamespacedTag actualNamespacedTag = new NamespacedTag("l", "l");

    // Assert
    assertEquals("l", actualNamespacedTag.getKey());
    assertEquals("l", actualNamespacedTag.getNamespace());
  }

  /**
   * Test {@link NamespacedTag#NamespacedTag(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return {@code key}.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#NamespacedTag(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test new NamespacedTag(Plugin, String); when TestPlugin(String) with 'Plugin Name'; then return 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamespacedTag.<init>(Plugin, String)"})
  void testNewNamespacedTag_whenTestPluginWithPluginName_thenReturnKey() {
    // Arrange and Act
    NamespacedTag actualNamespacedTag = new NamespacedTag(new TestPlugin("Plugin Name"), "Key");

    // Assert
    assertEquals("key", actualNamespacedTag.getKey());
    assertEquals("plugin_name", actualNamespacedTag.getNamespace());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamespacedTag#toString()}
   *   <li>{@link NamespacedTag#getKey()}
   *   <li>{@link NamespacedTag#getNamespace()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NamespacedTag.getKey()",
    "String NamespacedTag.getNamespace()",
    "String NamespacedTag.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    NamespacedTag randomKeyResult = NamespacedTag.randomKey();

    // Act
    randomKeyResult.toString();
    randomKeyResult.getKey();

    // Assert
    assertEquals(NamespacedTag.BUKKIT, randomKeyResult.getNamespace());
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}, and {@link NamespacedTag#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamespacedTag#equals(Object)}
   *   <li>{@link NamespacedTag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NamespacedTag minecraftResult = NamespacedTag.minecraft(NamespacedTag.BUKKIT);
    NamespacedTag minecraftResult2 = NamespacedTag.minecraft(NamespacedTag.BUKKIT);

    // Act and Assert
    assertEquals(minecraftResult, minecraftResult2);
    assertEquals(minecraftResult.hashCode(), minecraftResult2.hashCode());
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}, and {@link NamespacedTag#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamespacedTag#equals(Object)}
   *   <li>{@link NamespacedTag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NamespacedTag randomKeyResult = NamespacedTag.randomKey();

    // Act and Assert
    assertEquals(randomKeyResult, randomKeyResult);
    int expectedHashCodeResult = randomKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, randomKeyResult.hashCode());
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NamespacedTag randomKeyResult = NamespacedTag.randomKey();

    // Act and Assert
    assertNotEquals(randomKeyResult, NamespacedTag.randomKey());
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NamespacedTag minecraftResult = NamespacedTag.minecraft(NamespacedTag.BUKKIT);

    // Act and Assert
    assertNotEquals(minecraftResult, NamespacedTag.randomKey());
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NamespacedTag.randomKey(), null);
  }

  /**
   * Test {@link NamespacedTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamespacedTag.equals(Object)", "int NamespacedTag.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NamespacedTag.randomKey(), "Different type to NamespacedTag");
  }

  /**
   * Test {@link NamespacedTag#randomKey()}.
   *
   * <p>Method under test: {@link NamespacedTag#randomKey()}
   */
  @Test
  @DisplayName("Test randomKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedTag NamespacedTag.randomKey()"})
  void testRandomKey() {
    // Arrange, Act and Assert
    assertEquals(NamespacedTag.BUKKIT, NamespacedTag.randomKey().getNamespace());
  }

  /**
   * Test {@link NamespacedTag#minecraft(String)}.
   *
   * <ul>
   *   <li>When {@code l}.
   *   <li>Then return Key is {@code l}.
   * </ul>
   *
   * <p>Method under test: {@link NamespacedTag#minecraft(String)}
   */
  @Test
  @DisplayName("Test minecraft(String); when 'l'; then return Key is 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedTag NamespacedTag.minecraft(String)"})
  void testMinecraft_whenL_thenReturnKeyIsL() {
    // Arrange and Act
    NamespacedTag actualMinecraftResult = NamespacedTag.minecraft("l");

    // Assert
    assertEquals("l", actualMinecraftResult.getKey());
    assertEquals(NamespacedTag.MINECRAFT, actualMinecraftResult.getNamespace());
  }
}
