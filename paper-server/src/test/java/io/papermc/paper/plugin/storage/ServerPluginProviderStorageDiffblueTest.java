package io.papermc.paper.plugin.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.strategy.modern.ModernPluginLoadingStrategy;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerPluginProviderStorageDiffblueTest {
  /**
   * Test new {@link ServerPluginProviderStorage} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ServerPluginProviderStorage}
   */
  @Test
  @DisplayName("Test new ServerPluginProviderStorage (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerPluginProviderStorage.<init>()"})
  void testNewServerPluginProviderStorage() {
    // Arrange and Act
    ServerPluginProviderStorage actualServerPluginProviderStorage =
        new ServerPluginProviderStorage();

    // Assert
    assertTrue(actualServerPluginProviderStorage.strategy instanceof ModernPluginLoadingStrategy);
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        actualServerPluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertTrue(((List<PluginProvider<JavaPlugin>>) registeredProviders).isEmpty());
  }
}
