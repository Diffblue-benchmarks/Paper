package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.Entrypoint;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.provider.PluginProvider;
import io.papermc.paper.plugin.storage.ProviderStorage;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuntimePluginEntrypointHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuntimePluginEntrypointHandler#RuntimePluginEntrypointHandler(ProviderStorage)}
   *   <li>{@link RuntimePluginEntrypointHandler#getPluginProviderStorage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuntimePluginEntrypointHandler.<init>(ProviderStorage)",
    "ProviderStorage RuntimePluginEntrypointHandler.getPluginProviderStorage()"
  })
  void testGettersAndSetters() {
    // Arrange
    MultiRuntimePluginProviderStorage multiRuntimePluginProviderStorage =
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());

    // Act
    RuntimePluginEntrypointHandler<ProviderStorage<JavaPlugin>>
        actualRuntimePluginEntrypointHandler =
            new RuntimePluginEntrypointHandler<>(multiRuntimePluginProviderStorage);

    // Assert
    assertSame(
        multiRuntimePluginProviderStorage,
        actualRuntimePluginEntrypointHandler.getPluginProviderStorage());
  }

  /**
   * Test {@link RuntimePluginEntrypointHandler#register(Entrypoint, PluginProvider)}.
   *
   * <ul>
   *   <li>When {@link Entrypoint}.
   *   <li>Then throw {@link InvalidPluginException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimePluginEntrypointHandler#register(Entrypoint,
   * PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test register(Entrypoint, PluginProvider); when Entrypoint; then throw InvalidPluginException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimePluginEntrypointHandler.register(Entrypoint, PluginProvider)"})
  void testRegister_whenEntrypoint_thenThrowInvalidPluginException() {
    // Arrange
    RuntimePluginEntrypointHandler<ProviderStorage<JavaPlugin>> runtimePluginEntrypointHandler =
        new RuntimePluginEntrypointHandler<>(
            new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree()));

    // Act and Assert
    assertThrows(
        InvalidPluginException.class,
        () ->
            runtimePluginEntrypointHandler.register(
                mock(Entrypoint.class), mock(PluginProvider.class)));
  }

  /**
   * Test {@link RuntimePluginEntrypointHandler#enter(Entrypoint)}.
   *
   * <ul>
   *   <li>When {@link Entrypoint}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimePluginEntrypointHandler#enter(Entrypoint)}
   */
  @Test
  @DisplayName("Test enter(Entrypoint); when Entrypoint; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimePluginEntrypointHandler.enter(Entrypoint)"})
  void testEnter_whenEntrypoint_thenThrowIllegalArgumentException() {
    // Arrange
    RuntimePluginEntrypointHandler<ProviderStorage<JavaPlugin>> runtimePluginEntrypointHandler =
        new RuntimePluginEntrypointHandler<>(
            new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> runtimePluginEntrypointHandler.enter(mock(Entrypoint.class)));
  }
}
