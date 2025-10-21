package io.papermc.paper.command.brigadier.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class BukkitBrigForwardingMapDiffblueTest {
  /**
   * Test {@link BukkitBrigForwardingMap#getDispatcher()}.
   *
   * <p>Method under test: {@link BukkitBrigForwardingMap#getDispatcher()}
   */
  @Test
  @DisplayName("Test getDispatcher()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.mojang.brigadier.CommandDispatcher BukkitBrigForwardingMap.getDispatcher()"
  })
  void testGetDispatcher() {
    // Arrange, Act and Assert
    RootCommandNode<CommandSourceStack> root =
        new BukkitBrigForwardingMap().getDispatcher().getRoot();
    Collection<String> examples = root.getExamples();
    assertTrue(examples instanceof List);
    assertEquals("", root.getName());
    assertEquals("", root.getUsageText());
    assertNull(root.getCommand());
    assertNull(root.getRedirect());
    assertNull(root.clientNode);
    assertNull(root.unwrappedCached);
    assertNull(root.wrappedCached);
    assertNull(root.apiCommandMeta);
    assertFalse(root.isFork());
    assertTrue(examples.isEmpty());
  }

  /**
   * Test {@link BukkitBrigForwardingMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitBrigForwardingMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BukkitBrigForwardingMap.containsKey(Object)"})
  void testContainsKey_whenWildcard_object_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new BukkitBrigForwardingMap().containsKey(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link BukkitBrigForwardingMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitBrigForwardingMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when WILDCARD_OBJECT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BukkitBrigForwardingMap.containsValue(Object)"})
  void testContainsValue_whenWildcard_object_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new BukkitBrigForwardingMap().containsValue(ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link BukkitBrigForwardingMap#remove(Object)} with {@code key}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitBrigForwardingMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'key'; when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.command.Command BukkitBrigForwardingMap.remove(Object)"})
  void testRemoveWithKey_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new BukkitBrigForwardingMap().remove(ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
