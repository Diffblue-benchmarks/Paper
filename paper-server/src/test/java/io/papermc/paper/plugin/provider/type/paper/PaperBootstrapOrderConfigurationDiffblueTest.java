package io.papermc.paper.plugin.provider.type.paper;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBootstrapOrderConfigurationDiffblueTest {
  /**
   * Test {@link
   * PaperBootstrapOrderConfiguration#PaperBootstrapOrderConfiguration(PaperPluginMeta)}.
   *
   * <ul>
   *   <li>Then Meta return {@link PaperPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperBootstrapOrderConfiguration#PaperBootstrapOrderConfiguration(PaperPluginMeta)}
   */
  @Test
  @DisplayName(
      "Test new PaperBootstrapOrderConfiguration(PaperPluginMeta); then Meta return PaperPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperBootstrapOrderConfiguration.<init>(PaperPluginMeta)"})
  void testNewPaperBootstrapOrderConfiguration_thenMetaReturnPaperPluginMeta() {
    // Arrange
    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();

    // Act
    PaperBootstrapOrderConfiguration actualPaperBootstrapOrderConfiguration =
        new PaperBootstrapOrderConfiguration(paperPluginMeta);

    // Assert
    PluginMeta meta = actualPaperBootstrapOrderConfiguration.getMeta();
    assertTrue(meta instanceof PaperPluginMeta);
    assertTrue(actualPaperBootstrapOrderConfiguration.getLoadAfter().isEmpty());
    assertTrue(actualPaperBootstrapOrderConfiguration.getLoadBefore().isEmpty());
    assertSame(paperPluginMeta, meta);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperBootstrapOrderConfiguration#getLoadAfter()}
   *   <li>{@link PaperBootstrapOrderConfiguration#getLoadBefore()}
   *   <li>{@link PaperBootstrapOrderConfiguration#getMeta()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PaperBootstrapOrderConfiguration.getLoadAfter()",
    "List PaperBootstrapOrderConfiguration.getLoadBefore()",
    "PluginMeta PaperBootstrapOrderConfiguration.getMeta()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();
    PaperBootstrapOrderConfiguration paperBootstrapOrderConfiguration =
        new PaperBootstrapOrderConfiguration(paperPluginMeta);

    // Act
    List<String> actualLoadAfter = paperBootstrapOrderConfiguration.getLoadAfter();
    List<String> actualLoadBefore = paperBootstrapOrderConfiguration.getLoadBefore();
    PluginMeta actualMeta = paperBootstrapOrderConfiguration.getMeta();

    // Assert
    assertTrue(actualLoadAfter.isEmpty());
    assertTrue(actualLoadBefore.isEmpty());
    assertSame(paperPluginMeta, actualMeta);
  }
}
