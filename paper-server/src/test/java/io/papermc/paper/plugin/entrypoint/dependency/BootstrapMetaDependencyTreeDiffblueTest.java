package io.papermc.paper.plugin.entrypoint.dependency;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.configuration.PluginMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BootstrapMetaDependencyTreeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree(MutableGraph)}
   *   <li>{@link BootstrapMetaDependencyTree#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMetaDependencyTree.<init>(MutableGraph)",
    "String BootstrapMetaDependencyTree.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);

    // Act
    BootstrapMetaDependencyTree actualBootstrapMetaDependencyTree =
        new BootstrapMetaDependencyTree(graph);
    actualBootstrapMetaDependencyTree.toString();

    // Assert
    assertTrue(actualBootstrapMetaDependencyTree.dependencies.isEmpty());
    assertSame(graph, actualBootstrapMetaDependencyTree.getGraph());
  }

  /**
   * Test {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()}.
   *
   * <p>Method under test: {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()}
   */
  @Test
  @DisplayName("Test new BootstrapMetaDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMetaDependencyTree.<init>()"})
  void testNewBootstrapMetaDependencyTree() {
    // Arrange, Act and Assert
    assertTrue(new BootstrapMetaDependencyTree().dependencies.isEmpty());
  }

  /**
   * Test {@link BootstrapMetaDependencyTree#registerDependencies(String, PluginMeta)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMetaDependencyTree#registerDependencies(String,
   * PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test registerDependencies(String, PluginMeta); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMetaDependencyTree.registerDependencies(String, PluginMeta)"})
  void testRegisterDependencies_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new BootstrapMetaDependencyTree().registerDependencies("42", null));
  }

  /**
   * Test {@link BootstrapMetaDependencyTree#unregisterDependencies(String, PluginMeta)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMetaDependencyTree#unregisterDependencies(String,
   * PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test unregisterDependencies(String, PluginMeta); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMetaDependencyTree.unregisterDependencies(String, PluginMeta)"})
  void testUnregisterDependencies_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new BootstrapMetaDependencyTree().unregisterDependencies("42", null));
  }
}
