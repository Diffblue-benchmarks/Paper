package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

class SingularRuntimePluginProviderStorageDiffblueTest {
  /**
   * Test {@link
   * SingularRuntimePluginProviderStorage#SingularRuntimePluginProviderStorage(MetaDependencyTree)}.
   *
   * <p>Method under test: {@link
   * SingularRuntimePluginProviderStorage#SingularRuntimePluginProviderStorage(MetaDependencyTree)}
   */
  @Test
  @DisplayName("Test new SingularRuntimePluginProviderStorage(MetaDependencyTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingularRuntimePluginProviderStorage.<init>(MetaDependencyTree)"})
  void testNewSingularRuntimePluginProviderStorage() {
    // Arrange and Act
    SingularRuntimePluginProviderStorage actualSingularRuntimePluginProviderStorage =
        new SingularRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());

    // Assert
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        actualSingularRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertFalse(actualSingularRuntimePluginProviderStorage.getSingleLoaded().isPresent());
    assertTrue(((List<PluginProvider<JavaPlugin>>) registeredProviders).isEmpty());
  }

  /**
   * Test {@link SingularRuntimePluginProviderStorage#register(PluginProvider)}.
   *
   * <p>Method under test: {@link SingularRuntimePluginProviderStorage#register(PluginProvider)}
   */
  @Test
  @DisplayName("Test register(PluginProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingularRuntimePluginProviderStorage.register(PluginProvider)"})
  void testRegister() {
    // Arrange
    SingularRuntimePluginProviderStorage singularRuntimePluginProviderStorage =
        new SingularRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());
    PluginProvider<JavaPlugin> provider = mock(PluginProvider.class);

    // Act
    singularRuntimePluginProviderStorage.register(provider);

    // Assert
    Iterable<PluginProvider<JavaPlugin>> registeredProviders =
        singularRuntimePluginProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertEquals(1, ((List<PluginProvider<JavaPlugin>>) registeredProviders).size());
    assertSame(provider, ((List<PluginProvider<JavaPlugin>>) registeredProviders).get(0));
  }

  /**
   * Test {@link SingularRuntimePluginProviderStorage#register(PluginProvider)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SingularRuntimePluginProviderStorage#register(PluginProvider)}
   */
  @Test
  @DisplayName("Test register(PluginProvider); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingularRuntimePluginProviderStorage.register(PluginProvider)"})
  void testRegister_thenThrowIllegalStateException() {
    // Arrange
    SingularRuntimePluginProviderStorage singularRuntimePluginProviderStorage =
        new SingularRuntimePluginProviderStorage(new BootstrapMetaDependencyTree());
    singularRuntimePluginProviderStorage.register(null);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> singularRuntimePluginProviderStorage.register(mock(PaperServerPluginProvider.class)));
  }

  /**
   * Test {@link SingularRuntimePluginProviderStorage#throwOnCycle()}.
   *
   * <p>Method under test: {@link SingularRuntimePluginProviderStorage#throwOnCycle()}
   */
  @Test
  @DisplayName("Test throwOnCycle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SingularRuntimePluginProviderStorage.throwOnCycle()"})
  void testThrowOnCycle() {
    // Arrange, Act and Assert
    assertFalse(
        new SingularRuntimePluginProviderStorage(new BootstrapMetaDependencyTree()).throwOnCycle());
  }

  /**
   * Test {@link SingularRuntimePluginProviderStorage#getSingleLoaded()}.
   *
   * <p>Method under test: {@link SingularRuntimePluginProviderStorage#getSingleLoaded()}
   */
  @Test
  @DisplayName("Test getSingleLoaded()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional SingularRuntimePluginProviderStorage.getSingleLoaded()"})
  void testGetSingleLoaded() {
    // Arrange, Act and Assert
    assertFalse(
        new SingularRuntimePluginProviderStorage(new BootstrapMetaDependencyTree())
            .getSingleLoaded()
            .isPresent());
  }

  /**
   * Test {@link SingularRuntimePluginProviderStorage#createDependencyTree()}.
   *
   * <p>Method under test: {@link SingularRuntimePluginProviderStorage#createDependencyTree()}
   */
  @Test
  @DisplayName("Test createDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetaDependencyTree SingularRuntimePluginProviderStorage.createDependencyTree()"
  })
  void testCreateDependencyTree() {
    // Arrange
    BootstrapMetaDependencyTree dependencyTree = new BootstrapMetaDependencyTree();

    // Act
    MetaDependencyTree actualCreateDependencyTreeResult =
        new SingularRuntimePluginProviderStorage(dependencyTree).createDependencyTree();

    // Assert
    assertTrue(actualCreateDependencyTreeResult instanceof BootstrapMetaDependencyTree);
    assertSame(dependencyTree, actualCreateDependencyTreeResult);
  }
}
