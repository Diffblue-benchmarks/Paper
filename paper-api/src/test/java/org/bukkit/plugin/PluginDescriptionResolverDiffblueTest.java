package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

class PluginDescriptionResolverDiffblueTest {
  /**
   * Test new {@link PluginDescriptionResolver} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PluginDescriptionResolver}
   */
  @Test
  @DisplayName("Test new PluginDescriptionResolver (default constructor)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionResolver.<init>()"})
  void testNewPluginDescriptionResolver() {
    // Arrange, Act and Assert
    Tag resolveResult = new PluginDescriptionResolver().resolve(NodeId.scalar, "42", true);
    assertEquals("int", resolveResult.getClassName());
    assertEquals("tag:yaml.org,2002:int", resolveResult.getValue());
    assertEquals("tag:yaml.org,2002:int", resolveResult.toString());
    assertFalse(resolveResult.isSecondary());
  }
}
