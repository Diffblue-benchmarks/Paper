package io.papermc.paper.plugin.entrypoint.dependency;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphDependencyContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphDependencyContext#GraphDependencyContext(MutableGraph)}
   *   <li>{@link GraphDependencyContext#toString()}
   *   <li>{@link GraphDependencyContext#getDependencyGraph()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphDependencyContext.<init>(MutableGraph)",
    "MutableGraph GraphDependencyContext.getDependencyGraph()",
    "String GraphDependencyContext.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    MutableGraph<String> dependencyGraph = mock(MutableGraph.class);

    // Act
    GraphDependencyContext actualGraphDependencyContext =
        new GraphDependencyContext(dependencyGraph);
    actualGraphDependencyContext.toString();

    // Assert
    assertSame(dependencyGraph, actualGraphDependencyContext.getDependencyGraph());
  }

  /**
   * Test {@link GraphDependencyContext#isTransitiveDependency(PluginMeta, PluginMeta)}.
   *
   * <ul>
   *   <li>When {@link PaperPluginMeta} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDependencyContext#isTransitiveDependency(PluginMeta,
   * PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test isTransitiveDependency(PluginMeta, PluginMeta); when PaperPluginMeta (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GraphDependencyContext.isTransitiveDependency(PluginMeta, PluginMeta)"
  })
  void testIsTransitiveDependency_whenPaperPluginMeta_thenReturnFalse() {
    // Arrange
    MutableGraph<String> dependencyGraph = mock(MutableGraph.class);
    when(dependencyGraph.nodes()).thenReturn(new HashSet<>());
    GraphDependencyContext graphDependencyContext = new GraphDependencyContext(dependencyGraph);
    PaperPluginMeta plugin = new PaperPluginMeta();

    // Act
    boolean actualIsTransitiveDependencyResult =
        graphDependencyContext.isTransitiveDependency(plugin, new PaperPluginMeta());

    // Assert
    verify(dependencyGraph).nodes();
    assertFalse(actualIsTransitiveDependencyResult);
  }

  /**
   * Test {@link GraphDependencyContext#hasDependency(String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDependencyContext#hasDependency(String)}
   */
  @Test
  @DisplayName("Test hasDependency(String); given HashSet() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphDependencyContext.hasDependency(String)"})
  void testHasDependency_givenHashSetAdd42_thenReturnTrue() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    stringSet.add("foo");

    MutableGraph<String> dependencyGraph = mock(MutableGraph.class);
    when(dependencyGraph.nodes()).thenReturn(stringSet);

    // Act
    boolean actualHasDependencyResult =
        new GraphDependencyContext(dependencyGraph).hasDependency("42");

    // Assert
    verify(dependencyGraph).nodes();
    assertTrue(actualHasDependencyResult);
  }

  /**
   * Test {@link GraphDependencyContext#hasDependency(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDependencyContext#hasDependency(String)}
   */
  @Test
  @DisplayName("Test hasDependency(String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphDependencyContext.hasDependency(String)"})
  void testHasDependency_thenReturnFalse() {
    // Arrange
    MutableGraph<String> dependencyGraph = mock(MutableGraph.class);
    when(dependencyGraph.nodes()).thenReturn(new HashSet<>());

    // Act
    boolean actualHasDependencyResult =
        new GraphDependencyContext(dependencyGraph).hasDependency("42");

    // Assert
    verify(dependencyGraph).nodes();
    assertFalse(actualHasDependencyResult);
  }
}
