package io.papermc.paper.plugin.entrypoint.dependency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.graph.MutableGraph;
import io.papermc.paper.plugin.TestJavaPluginProvider;
import io.papermc.paper.plugin.TestPluginMeta;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.PluginProvider;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import io.papermc.paper.plugin.provider.type.paper.PaperPluginParent;
import io.papermc.paper.plugin.provider.type.paper.PaperPluginParent.PaperBootstrapProvider;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetaDependencyTreeDiffblueTest {
  /**
   * Test {@link MetaDependencyTree#add(PluginMeta)} with {@code configuration}.
   *
   * <p>Method under test: {@link MetaDependencyTree#add(PluginMeta)}
   */
  @Test
  @DisplayName("Test add(PluginMeta) with 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.add(PluginMeta)"})
  void testAddWithConfiguration() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenReturn(true);
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree =
        new BootstrapMetaDependencyTree(graph);

    // Act
    bootstrapMetaDependencyTree.add(new PaperPluginMeta());

    // Assert
    verify(graph).addNode(null);
    Set<String> stringSet = bootstrapMetaDependencyTree.dependencies;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains(null));
  }

  /**
   * Test {@link MetaDependencyTree#add(PluginMeta)} with {@code configuration}.
   *
   * <ul>
   *   <li>Then {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()} {@link
   *       MetaDependencyTree#dependencies} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#add(PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test add(PluginMeta) with 'configuration'; then BootstrapMetaDependencyTree() dependencies size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.add(PluginMeta)"})
  void testAddWithConfiguration_thenBootstrapMetaDependencyTreeDependenciesSizeIsOne() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();

    PaperPluginMeta configuration = new PaperPluginMeta();
    configuration.setName("Name");

    // Act
    bootstrapMetaDependencyTree.add(configuration);

    // Assert
    Set<String> stringSet = bootstrapMetaDependencyTree.dependencies;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("Name"));
  }

  /**
   * Test {@link MetaDependencyTree#add(PluginProvider)} with {@code provider}.
   *
   * <p>Method under test: {@link MetaDependencyTree#add(PluginProvider)}
   */
  @Test
  @DisplayName("Test add(PluginProvider) with 'provider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.add(PluginProvider)"})
  void testAddWithProvider() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.addNode(Mockito.<String>any())).thenReturn(true);
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree =
        new BootstrapMetaDependencyTree(graph);

    PaperBootstrapProvider provider = mock(PaperBootstrapProvider.class);
    when(provider.getMeta()).thenReturn(new PaperPluginMeta());

    // Act
    bootstrapMetaDependencyTree.add(provider);

    // Assert
    verify(graph).addNode(null);
    verify(provider).getMeta();
    Set<String> stringSet = bootstrapMetaDependencyTree.dependencies;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains(null));
  }

  /**
   * Test {@link MetaDependencyTree#add(PluginProvider)} with {@code provider}.
   *
   * <ul>
   *   <li>Then {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()} {@link
   *       MetaDependencyTree#dependencies} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#add(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test add(PluginProvider) with 'provider'; then BootstrapMetaDependencyTree() dependencies size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.add(PluginProvider)"})
  void testAddWithProvider_thenBootstrapMetaDependencyTreeDependenciesSizeIsOne() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();

    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();
    paperPluginMeta.setName("Name");

    PaperBootstrapProvider provider = mock(PaperBootstrapProvider.class);
    when(provider.getMeta()).thenReturn(paperPluginMeta);

    // Act
    bootstrapMetaDependencyTree.add(provider);

    // Assert
    verify(provider).getMeta();
    Set<String> stringSet = bootstrapMetaDependencyTree.dependencies;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("Name"));
  }

  /**
   * Test {@link MetaDependencyTree#remove(PluginMeta)} with {@code configuration}.
   *
   * <ul>
   *   <li>When {@link PaperPluginMeta} (default constructor).
   *   <li>Then calls {@link MutableGraph#removeNode(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#remove(PluginMeta)}
   */
  @Test
  @DisplayName(
      "Test remove(PluginMeta) with 'configuration'; when PaperPluginMeta (default constructor); then calls removeNode(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.remove(PluginMeta)"})
  void testRemoveWithConfiguration_whenPaperPluginMeta_thenCallsRemoveNode() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.removeNode(Mockito.<String>any())).thenReturn(true);
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree =
        new BootstrapMetaDependencyTree(graph);

    // Act
    bootstrapMetaDependencyTree.remove(new PaperPluginMeta());

    // Assert
    verify(graph).removeNode(null);
  }

  /**
   * Test {@link MetaDependencyTree#remove(PluginProvider)} with {@code provider}.
   *
   * <ul>
   *   <li>Given {@link MutableGraph} {@link MutableGraph#removeNode(Object)} return {@code true}.
   *   <li>Then calls {@link MutableGraph#removeNode(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#remove(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test remove(PluginProvider) with 'provider'; given MutableGraph removeNode(Object) return 'true'; then calls removeNode(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.remove(PluginProvider)"})
  void testRemoveWithProvider_givenMutableGraphRemoveNodeReturnTrue_thenCallsRemoveNode() {
    // Arrange
    MutableGraph<String> graph = mock(MutableGraph.class);
    when(graph.removeNode(Mockito.<String>any())).thenReturn(true);
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree =
        new BootstrapMetaDependencyTree(graph);

    PaperBootstrapProvider provider = mock(PaperBootstrapProvider.class);
    when(provider.getMeta()).thenReturn(new PaperPluginMeta());

    // Act
    bootstrapMetaDependencyTree.remove(provider);

    // Assert
    verify(graph).removeNode(null);
    verify(provider).getMeta();
  }

  /**
   * Test {@link MetaDependencyTree#remove(PluginProvider)} with {@code provider}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor) Name is {@code Name}.
   *   <li>Then calls {@link PaperPluginParent.PaperBootstrapProvider#getMeta()}.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#remove(PluginProvider)}
   */
  @Test
  @DisplayName(
      "Test remove(PluginProvider) with 'provider'; given PaperPluginMeta (default constructor) Name is 'Name'; then calls getMeta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.remove(PluginProvider)"})
  void testRemoveWithProvider_givenPaperPluginMetaNameIsName_thenCallsGetMeta() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();

    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();
    paperPluginMeta.setName("Name");

    PaperBootstrapProvider provider = mock(PaperBootstrapProvider.class);
    when(provider.getMeta()).thenReturn(paperPluginMeta);

    // Act
    bootstrapMetaDependencyTree.remove(provider);

    // Assert
    verify(provider).getMeta();
  }

  /**
   * Test {@link MetaDependencyTree#isTransitiveDependency(PluginMeta, PluginMeta)}.
   *
   * <p>Method under test: {@link MetaDependencyTree#isTransitiveDependency(PluginMeta, PluginMeta)}
   */
  @Test
  @DisplayName("Test isTransitiveDependency(PluginMeta, PluginMeta)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetaDependencyTree.isTransitiveDependency(PluginMeta, PluginMeta)"})
  void testIsTransitiveDependency() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();
    PaperPluginMeta plugin = new PaperPluginMeta();

    // Act and Assert
    assertFalse(bootstrapMetaDependencyTree.isTransitiveDependency(plugin, new PaperPluginMeta()));
  }

  /**
   * Test {@link MetaDependencyTree#hasDependency(String)}.
   *
   * <ul>
   *   <li>Given {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#hasDependency(String)}
   */
  @Test
  @DisplayName(
      "Test hasDependency(String); given BootstrapMetaDependencyTree(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetaDependencyTree.hasDependency(String)"})
  void testHasDependency_givenBootstrapMetaDependencyTree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BootstrapMetaDependencyTree().hasDependency("42"));
  }

  /**
   * Test {@link MetaDependencyTree#hasDependency(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#hasDependency(String)}
   */
  @Test
  @DisplayName("Test hasDependency(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MetaDependencyTree.hasDependency(String)"})
  void testHasDependency_thenReturnTrue() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();
    bootstrapMetaDependencyTree.addDirectDependency("42");

    // Act and Assert
    assertTrue(bootstrapMetaDependencyTree.hasDependency("42"));
  }

  /**
   * Test {@link MetaDependencyTree#addDirectDependency(String)}.
   *
   * <p>Method under test: {@link MetaDependencyTree#addDirectDependency(String)}
   */
  @Test
  @DisplayName("Test addDirectDependency(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetaDependencyTree.addDirectDependency(String)"})
  void testAddDirectDependency() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();

    // Act
    bootstrapMetaDependencyTree.addDirectDependency("Dependency");

    // Assert
    Set<String> stringSet = bootstrapMetaDependencyTree.dependencies;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("Dependency"));
  }

  /**
   * Test {@link MetaDependencyTree#toString()}.
   *
   * <p>Method under test: {@link MetaDependencyTree#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetaDependencyTree.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SimpleDependencyTree{graph=isDirected: true, allowsSelfLoops: false, nodes: [], edges: []}",
        new SimpleMetaDependencyTree().toString());
  }

  /**
   * Test {@link MetaDependencyTree#toString()}.
   *
   * <p>Method under test: {@link MetaDependencyTree#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetaDependencyTree.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "BootstrapDependencyTree{graph=isDirected: true, allowsSelfLoops: false, nodes: [], edges: []}",
        new BootstrapMetaDependencyTree().toString());
  }

  /**
   * Test {@link MetaDependencyTree#toString()}.
   *
   * <p>Method under test: {@link MetaDependencyTree#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetaDependencyTree.toString()"})
  void testToString3() {
    // Arrange
    SimpleMetaDependencyTree simpleMetaDependencyTree = new SimpleMetaDependencyTree();
    simpleMetaDependencyTree.add(new TestJavaPluginProvider(new TestPluginMeta("42")));

    // Act and Assert
    assertEquals(
        "SimpleDependencyTree{graph=isDirected: true, allowsSelfLoops: false, nodes: [42], edges: []}",
        simpleMetaDependencyTree.toString());
  }

  /**
   * Test {@link MetaDependencyTree#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link MetaDependencyTree#toString()}
   */
  @Test
  @DisplayName("Test toString(); given ArrayList() add 'foo'; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MetaDependencyTree.toString()"})
  void testToString_givenArrayListAddFoo_thenReturnAString() {
    // Arrange
    ArrayList<String> hardDependencies = new ArrayList<>();
    hardDependencies.add("foo");

    TestPluginMeta testPluginConfiguration = new TestPluginMeta("42");
    testPluginConfiguration.setHardDependencies(hardDependencies);
    TestJavaPluginProvider provider = new TestJavaPluginProvider(testPluginConfiguration);

    SimpleMetaDependencyTree simpleMetaDependencyTree = new SimpleMetaDependencyTree();
    simpleMetaDependencyTree.add(provider);

    // Act and Assert
    assertEquals(
        "SimpleDependencyTree{graph=isDirected: true, allowsSelfLoops: false, nodes: [42, foo], edges: [<42"
            + " -> foo>]}",
        simpleMetaDependencyTree.toString());
  }

  /**
   * Test {@link MetaDependencyTree#getGraph()}.
   *
   * <p>Method under test: {@link MetaDependencyTree#getGraph()}
   */
  @Test
  @DisplayName("Test getGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MutableGraph MetaDependencyTree.getGraph()"})
  void testGetGraph() {
    // Arrange
    BootstrapMetaDependencyTree bootstrapMetaDependencyTree = new BootstrapMetaDependencyTree();

    // Act
    MutableGraph<String> actualGraph = bootstrapMetaDependencyTree.getGraph();

    // Assert
    assertSame(bootstrapMetaDependencyTree.graph, actualGraph);
  }
}
