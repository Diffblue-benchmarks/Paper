package io.papermc.paper.plugin.provider.type.spigot;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpigotLoadOrderConfigurationDiffblueTest {
  /**
   * Test {@link SpigotLoadOrderConfiguration#SpigotLoadOrderConfiguration(SpigotPluginProvider,
   * Map)}.
   *
   * <ul>
   *   <li>Then Meta return {@link PluginDescriptionFile}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SpigotLoadOrderConfiguration#SpigotLoadOrderConfiguration(SpigotPluginProvider, Map)}
   */
  @Test
  @DisplayName(
      "Test new SpigotLoadOrderConfiguration(SpigotPluginProvider, Map); then Meta return PluginDescriptionFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpigotLoadOrderConfiguration.<init>(SpigotPluginProvider, Map)"})
  void testNewSpigotLoadOrderConfiguration_thenMetaReturnPluginDescriptionFile() {
    // Arrange
    PluginDescriptionFile description =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");
    SpigotPluginProvider spigotPluginProvider =
        new SpigotPluginProvider(
            MetricsPersister.PROFILING_RESULTS_DIR, null, description, new ArrayList<>());

    // Act
    SpigotLoadOrderConfiguration actualSpigotLoadOrderConfiguration =
        new SpigotLoadOrderConfiguration(spigotPluginProvider, new HashMap<>());

    // Assert
    PluginMeta meta = actualSpigotLoadOrderConfiguration.getMeta();
    assertTrue(meta instanceof PluginDescriptionFile);
    assertTrue(actualSpigotLoadOrderConfiguration.getLoadAfter().isEmpty());
    assertTrue(actualSpigotLoadOrderConfiguration.getLoadBefore().isEmpty());
    assertSame(description, meta);
  }
}
