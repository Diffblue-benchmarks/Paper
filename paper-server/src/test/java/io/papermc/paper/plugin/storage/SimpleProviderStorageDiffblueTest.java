package io.papermc.paper.plugin.storage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.entrypoint.dependency.SimpleMetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.strategy.PluginGraphCycleException;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleProviderStorageDiffblueTest {
  /**
   * Test {@link SimpleProviderStorage#createDependencyTree()}.
   *
   * <p>Method under test: {@link SimpleProviderStorage#createDependencyTree()}
   */
  @Test
  @DisplayName("Test createDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.entrypoint.dependency.MetaDependencyTree SimpleProviderStorage.createDependencyTree()"
  })
  void testCreateDependencyTree() {
    // Arrange, Act and Assert
    assertTrue(
        new ServerPluginProviderStorage().createDependencyTree()
            instanceof SimpleMetaDependencyTree);
  }

  /**
   * Test {@link SimpleProviderStorage#getRegisteredProviders()}.
   *
   * <p>Method under test: {@link SimpleProviderStorage#getRegisteredProviders()}
   */
  @Test
  @DisplayName("Test getRegisteredProviders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SimpleProviderStorage.getRegisteredProviders()"})
  void testGetRegisteredProviders() {
    // Arrange and Act
    Iterable<PluginProvider<PluginBootstrap>> actualRegisteredProviders =
        new BootstrapProviderStorage().getRegisteredProviders();
    Iterator<PluginProvider<PluginBootstrap>> actualIteratorResult =
        actualRegisteredProviders.iterator();

    // Assert
    assertTrue(actualRegisteredProviders instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<PluginProvider<PluginBootstrap>>) actualRegisteredProviders).isEmpty());
  }

  /**
   * Test {@link SimpleProviderStorage#handleCycle(PluginGraphCycleException)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Cycles}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProviderStorage#handleCycle(PluginGraphCycleException)}
   */
  @Test
  @DisplayName(
      "Test handleCycle(PluginGraphCycleException); given ArrayList() add 'Cycles'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleProviderStorage.handleCycle(PluginGraphCycleException)"})
  void testHandleCycle_givenArrayListAddCycles_thenThrowIllegalStateException() {
    // Arrange
    BootstrapProviderStorage bootstrapProviderStorage = new BootstrapProviderStorage();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Cycles");

    ArrayList<List<String>> cycles = new ArrayList<>();
    cycles.add(stringList);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bootstrapProviderStorage.handleCycle(new PluginGraphCycleException(cycles)));
  }

  /**
   * Test {@link SimpleProviderStorage#handleCycle(PluginGraphCycleException)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleProviderStorage#handleCycle(PluginGraphCycleException)}
   */
  @Test
  @DisplayName("Test handleCycle(PluginGraphCycleException); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleProviderStorage.handleCycle(PluginGraphCycleException)"})
  void testHandleCycle_thenThrowIllegalStateException() {
    // Arrange
    BootstrapProviderStorage bootstrapProviderStorage = new BootstrapProviderStorage();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bootstrapProviderStorage.handleCycle(new PluginGraphCycleException(new ArrayList<>())));
  }

  /**
   * Test {@link SimpleProviderStorage#throwOnCycle()}.
   *
   * <p>Method under test: {@link SimpleProviderStorage#throwOnCycle()}
   */
  @Test
  @DisplayName("Test throwOnCycle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleProviderStorage.throwOnCycle()"})
  void testThrowOnCycle() {
    // Arrange, Act and Assert
    assertTrue(new BootstrapProviderStorage().throwOnCycle());
  }
}
