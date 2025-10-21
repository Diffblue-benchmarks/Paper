package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.dependency.MetaDependencyTree;
import io.papermc.paper.plugin.provider.PluginProvider;
import io.papermc.paper.plugin.provider.type.paper.PaperPluginParent;
import io.papermc.paper.plugin.provider.type.paper.PaperPluginParent.PaperServerPluginProvider;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiRuntimePluginProviderStorageDiffblueTest {
  /**
   * Test {@link
   * MultiRuntimePluginProviderStorage#MultiRuntimePluginProviderStorage(MetaDependencyTree)}.
   *
   * <p>Method under test: {@link
   * MultiRuntimePluginProviderStorage#MultiRuntimePluginProviderStorage(MetaDependencyTree)}
   */
  @Test
  @DisplayName("Test new MultiRuntimePluginProviderStorage(MetaDependencyTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiRuntimePluginProviderStorage.<init>(MetaDependencyTree)"})
  void testNewMultiRuntimePluginProviderStorage() {
    // Arrange and Act
    MultiRuntimePluginProviderStorage actualMultiRuntimePluginProviderStorage =
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());

    // Assert
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        actualMultiRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertTrue(actualMultiRuntimePluginProviderStorage.getLoaded().isEmpty());
    assertTrue(((List<PluginProvider<JavaPlugin>>) registeredProviders).isEmpty());
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}
   */
  @Test
  @DisplayName("Test register(PluginProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiRuntimePluginProviderStorage.register(PluginProvider)"})
  void testRegister() {
    // Arrange
    MultiRuntimePluginProviderStorage multiRuntimePluginProviderStorage =
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());
    PluginProvider<JavaPlugin> provider = mock(PluginProvider.class);

    // Act
    multiRuntimePluginProviderStorage.register(provider);

    // Assert
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        multiRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertEquals(1, ((List<PluginProvider<JavaPlugin>>) registeredProviders).size());
    assertSame(provider, ((List<PluginProvider<JavaPlugin>>) registeredProviders).get(0));
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}
   */
  @Test
  @DisplayName("Test register(PluginProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiRuntimePluginProviderStorage.register(PluginProvider)"})
  void testRegister2() {
    // Arrange
    MultiRuntimePluginProviderStorage multiRuntimePluginProviderStorage =
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());

    // Act
    multiRuntimePluginProviderStorage.register(mock(PaperServerPluginProvider.class));

    // Assert that nothing has changed
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        multiRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertTrue(((List<PluginProvider<JavaPlugin>>) registeredProviders).isEmpty());
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#register(PluginProvider)}
   */
  @Test
  @DisplayName("Test register(PluginProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiRuntimePluginProviderStorage.register(PluginProvider)"})
  void testRegister3() {
    // Arrange
    BootstrapMetaDependencyTree dependencyTree =
        new BootstrapMetaDependencyTree(mock(MutableGraph.class));
    MultiRuntimePluginProviderStorage multiRuntimePluginProviderStorage =
        new MultiRuntimePluginProviderStorage(dependencyTree);
    PluginProvider<JavaPlugin> provider = mock(PluginProvider.class);

    // Act
    multiRuntimePluginProviderStorage.register(provider);

    // Assert
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        multiRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertEquals(1, ((List<PluginProvider<JavaPlugin>>) registeredProviders).size());
    assertSame(provider, ((List<PluginProvider<JavaPlugin>>) registeredProviders).get(0));
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#throwOnCycle()}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#throwOnCycle()}
   */
  @Test
  @DisplayName("Test throwOnCycle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiRuntimePluginProviderStorage.throwOnCycle()"})
  void testThrowOnCycle() {
    // Arrange, Act and Assert
    assertFalse(
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree()).throwOnCycle());
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#getLoaded()}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#getLoaded()}
   */
  @Test
  @DisplayName("Test getLoaded()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MultiRuntimePluginProviderStorage.getLoaded()"})
  void testGetLoaded() {
    // Arrange, Act and Assert
    assertTrue(
        new MultiRuntimePluginProviderStorage(new BootstrapMetaDependencyTree())
            .getLoaded()
            .isEmpty());
  }

  /**
   * Test {@link MultiRuntimePluginProviderStorage#createDependencyTree()}.
   *
   * <p>Method under test: {@link MultiRuntimePluginProviderStorage#createDependencyTree()}
   */
  @Test
  @DisplayName("Test createDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetaDependencyTree MultiRuntimePluginProviderStorage.createDependencyTree()"})
  void testCreateDependencyTree() {
    // Arrange
    BootstrapMetaDependencyTree dependencyTree = new BootstrapMetaDependencyTree();

    // Act
    MetaDependencyTree actualCreateDependencyTreeResult =
        new MultiRuntimePluginProviderStorage(dependencyTree).createDependencyTree();

    // Assert
    assertTrue(actualCreateDependencyTreeResult instanceof BootstrapMetaDependencyTree);
    assertSame(dependencyTree, actualCreateDependencyTreeResult);
  }
}
