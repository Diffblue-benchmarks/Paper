package io.papermc.paper.plugin.entrypoint.dependency;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.configuration.PluginMeta;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleMetaDependencyTreeDiffblueTest {
  /**
   * Test {@link SimpleMetaDependencyTree#SimpleMetaDependencyTree(MutableGraph)}.
   *
   * <p>Method under test: {@link SimpleMetaDependencyTree#SimpleMetaDependencyTree(MutableGraph)}
   */
  @Test
  @DisplayName("Test new SimpleMetaDependencyTree(MutableGraph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMetaDependencyTree.<init>(MutableGraph)"})
  void testNewSimpleMetaDependencyTree() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);

    // Act
    SimpleMetaDependencyTree actualSimpleMetaDependencyTree = new SimpleMetaDependencyTree(graph);

    // Assert
    assertTrue(actualSimpleMetaDependencyTree.dependencies.isEmpty());
    assertSame(graph, actualSimpleMetaDependencyTree.getGraph());
  }

  /**
   * Test {@link SimpleMetaDependencyTree#SimpleMetaDependencyTree()}.
   *
   * <p>Method under test: {@link SimpleMetaDependencyTree#SimpleMetaDependencyTree()}
   */
  @Test
  @DisplayName("Test new SimpleMetaDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMetaDependencyTree.<init>()"})
  void testNewSimpleMetaDependencyTree2() {
    // Arrange, Act and Assert
    assertTrue(new SimpleMetaDependencyTree().dependencies.isEmpty());
  }

  /**
   * Test {@link SimpleMetaDependencyTree#registerDependencies(String, PluginMeta)}.
   *
   * <ul>
   *   <li>Given {@link MutableGraph} {@link MutableGraph#putEdge(Object, Object)} return {@code
   *       true}.
   *   <li>Then calls {@link MutableGraph#putEdge(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMetaDependencyTree#registerDependencies(String, PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test registerDependencies(String, PluginMeta); given MutableGraph putEdge(Object, Object) return 'true'; then calls putEdge(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMetaDependencyTree.registerDependencies(String, PluginMeta)"})
  void testRegisterDependencies_givenMutableGraphPutEdgeReturnTrue_thenCallsPutEdge() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.putEdge(Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    SimpleMetaDependencyTree simpleMetaDependencyTree = new SimpleMetaDependencyTree(graph);

    ArrayList<String> hardDependencies = new ArrayList<>();
    hardDependencies.add("Meta");

    ArrayList<String> softDependencies = new ArrayList<>();
    softDependencies.add("Meta");

    TestPluginMeta meta = new TestPluginMeta("42");
    meta.setHardDependencies(hardDependencies);
    meta.setSoftDependencies(softDependencies);

    // Act
    simpleMetaDependencyTree.registerDependencies("42", meta);

    // Assert
    verify(graph, atLeast(1)).putEdge("42", "Meta");
  }
}
