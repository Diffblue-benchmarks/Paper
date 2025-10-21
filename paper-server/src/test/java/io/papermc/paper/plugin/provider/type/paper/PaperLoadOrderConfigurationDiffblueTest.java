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

class PaperLoadOrderConfigurationDiffblueTest {
  /**
   * Test {@link PaperLoadOrderConfiguration#PaperLoadOrderConfiguration(PaperPluginMeta)}.
   *
   * <ul>
   *   <li>Then Meta return {@link PaperPluginMeta}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperLoadOrderConfiguration#PaperLoadOrderConfiguration(PaperPluginMeta)}
   */
  @Test
  @DisplayName(
      "Test new PaperLoadOrderConfiguration(PaperPluginMeta); then Meta return PaperPluginMeta")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLoadOrderConfiguration.<init>(PaperPluginMeta)"})
  void testNewPaperLoadOrderConfiguration_thenMetaReturnPaperPluginMeta() {
    // Arrange
    PaperPluginMeta meta = new PaperPluginMeta();

    // Act
    PaperLoadOrderConfiguration actualPaperLoadOrderConfiguration =
        new PaperLoadOrderConfiguration(meta);

    // Assert
    PluginMeta meta2 = actualPaperLoadOrderConfiguration.getMeta();
    assertTrue(meta2 instanceof PaperPluginMeta);
    List<String> loadAfter = actualPaperLoadOrderConfiguration.getLoadAfter();
    assertTrue(loadAfter.isEmpty());
    assertSame(meta, meta2);
    assertSame(loadAfter, actualPaperLoadOrderConfiguration.getLoadBefore());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperLoadOrderConfiguration#getLoadAfter()}
   *   <li>{@link PaperLoadOrderConfiguration#getLoadBefore()}
   *   <li>{@link PaperLoadOrderConfiguration#getMeta()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PaperLoadOrderConfiguration.getLoadAfter()",
    "List PaperLoadOrderConfiguration.getLoadBefore()",
    "PluginMeta PaperLoadOrderConfiguration.getMeta()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperPluginMeta meta = new PaperPluginMeta();
    PaperLoadOrderConfiguration paperLoadOrderConfiguration = new PaperLoadOrderConfiguration(meta);

    // Act
    List<String> actualLoadAfter = paperLoadOrderConfiguration.getLoadAfter();
    List<String> actualLoadBefore = paperLoadOrderConfiguration.getLoadBefore();
    PluginMeta actualMeta = paperLoadOrderConfiguration.getMeta();

    // Assert
    assertTrue(actualLoadAfter.isEmpty());
    assertSame(meta, actualMeta);
    assertSame(actualLoadAfter, actualLoadBefore);
  }
}
