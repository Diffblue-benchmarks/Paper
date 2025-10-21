package io.papermc.paper.command.brigadier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class APICommandMetaDiffblueTest {
  /**
   * Test {@link APICommandMeta#APICommandMeta(PluginMeta, String)}.
   *
   * <p>Method under test: {@link APICommandMeta#APICommandMeta(PluginMeta, String)}
   */
  @Test
  @DisplayName("Test new APICommandMeta(PluginMeta, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void APICommandMeta.<init>(PluginMeta, String)"})
  void testNewAPICommandMeta() {
    // Arrange
    PaperPluginMeta pluginMeta = new PaperPluginMeta();

    // Act
    APICommandMeta actualApiCommandMeta =
        new APICommandMeta(pluginMeta, "The characteristics of someone or something");

    // Assert
    PluginMeta pluginMetaResult = actualApiCommandMeta.pluginMeta();
    assertTrue(pluginMetaResult instanceof PaperPluginMeta);
    assertEquals("The characteristics of someone or something", actualApiCommandMeta.description());
    assertNull(actualApiCommandMeta.helpCommandNamespace());
    assertTrue(actualApiCommandMeta.aliases().isEmpty());
    assertSame(pluginMeta, pluginMetaResult);
  }

  /**
   * Test {@link APICommandMeta#plugin()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link APICommandMeta#plugin()}
   */
  @Test
  @DisplayName("Test plugin(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.plugin.Plugin APICommandMeta.plugin()"})
  void testPlugin_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new APICommandMeta(null, "The characteristics of someone or something").plugin());
  }

  /**
   * Test {@link APICommandMeta#withAliases(List)}.
   *
   * <p>Method under test: {@link APICommandMeta#withAliases(List)}
   */
  @Test
  @DisplayName("Test withAliases(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"APICommandMeta APICommandMeta.withAliases(List)"})
  void testWithAliases() {
    // Arrange
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    APICommandMeta apiCommandMeta =
        new APICommandMeta(
            pluginMeta,
            "The characteristics of someone or something",
            new ArrayList<>(),
            "Help Command Namespace");

    // Act
    APICommandMeta actualWithAliasesResult = apiCommandMeta.withAliases(new ArrayList<>());

    // Assert
    assertEquals(apiCommandMeta, actualWithAliasesResult);
  }

  /**
   * Test {@link APICommandMeta#withAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then pluginMeta return {@link PaperPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link APICommandMeta#withAliases(List)}
   */
  @Test
  @DisplayName(
      "Test withAliases(List); given '42'; when ArrayList() add '42'; then pluginMeta return PaperPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"APICommandMeta APICommandMeta.withAliases(List)"})
  void testWithAliases_given42_whenArrayListAdd42_thenPluginMetaReturnPaperPluginMeta() {
    // Arrange
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    APICommandMeta apiCommandMeta =
        new APICommandMeta(
            pluginMeta,
            "The characteristics of someone or something",
            new ArrayList<>(),
            "Help Command Namespace");

    ArrayList<String> registeredAliases = new ArrayList<>();
    registeredAliases.add("42");
    registeredAliases.add("foo");

    // Act
    APICommandMeta actualWithAliasesResult = apiCommandMeta.withAliases(registeredAliases);

    // Assert
    PluginMeta pluginMetaResult = actualWithAliasesResult.pluginMeta();
    assertTrue(pluginMetaResult instanceof PaperPluginMeta);
    List<String> authors = pluginMetaResult.getAuthors();
    assertTrue(authors.isEmpty());
    assertEquals(registeredAliases, actualWithAliasesResult.aliases());
    assertSame(authors, pluginMetaResult.getContributors());
    assertSame(authors, pluginMetaResult.getPermissions());
    assertSame(authors, pluginMetaResult.getProvidedPlugins());
  }

  /**
   * Test {@link APICommandMeta#withAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then pluginMeta return {@link PaperPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link APICommandMeta#withAliases(List)}
   */
  @Test
  @DisplayName(
      "Test withAliases(List); given 'foo'; when ArrayList() add 'foo'; then pluginMeta return PaperPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"APICommandMeta APICommandMeta.withAliases(List)"})
  void testWithAliases_givenFoo_whenArrayListAddFoo_thenPluginMetaReturnPaperPluginMeta() {
    // Arrange
    PaperPluginMeta pluginMeta = new PaperPluginMeta();
    APICommandMeta apiCommandMeta =
        new APICommandMeta(
            pluginMeta,
            "The characteristics of someone or something",
            new ArrayList<>(),
            "Help Command Namespace");

    ArrayList<String> registeredAliases = new ArrayList<>();
    registeredAliases.add("foo");

    // Act
    APICommandMeta actualWithAliasesResult = apiCommandMeta.withAliases(registeredAliases);

    // Assert
    PluginMeta pluginMetaResult = actualWithAliasesResult.pluginMeta();
    assertTrue(pluginMetaResult instanceof PaperPluginMeta);
    List<String> authors = pluginMetaResult.getAuthors();
    assertTrue(authors.isEmpty());
    assertEquals(registeredAliases, actualWithAliasesResult.aliases());
    assertSame(authors, pluginMetaResult.getContributors());
    assertSame(authors, pluginMetaResult.getPermissions());
    assertSame(authors, pluginMetaResult.getProvidedPlugins());
  }
}
