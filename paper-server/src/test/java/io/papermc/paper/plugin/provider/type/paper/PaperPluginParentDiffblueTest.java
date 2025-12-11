package io.papermc.paper.plugin.provider.type.paper;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.type.paper.PaperPluginParent.PaperBootstrapProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperPluginParentDiffblueTest {
  @Mock private PaperPluginParent paperPluginParent;

  /**
   * Test PaperBootstrapProvider {@link PaperBootstrapProvider#file()}.
   *
   * <p>Method under test: {@link PaperBootstrapProvider#file()}
   */
  @Test
  @DisplayName("Test PaperBootstrapProvider file()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.jar.JarFile PaperBootstrapProvider.file()"})
  void testPaperBootstrapProviderFile() {
    // Arrange, Act and Assert
    assertNull(paperPluginParent.new PaperBootstrapProvider().file());
  }

  /**
   * Test PaperBootstrapProvider {@link PaperBootstrapProvider#getLogger()}.
   *
   * <p>Method under test: {@link PaperBootstrapProvider#getLogger()}
   */
  @Test
  @DisplayName("Test PaperBootstrapProvider getLogger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.kyori.adventure.text.logger.slf4j.ComponentLogger PaperBootstrapProvider.getLogger()"
  })
  void testPaperBootstrapProviderGetLogger() {
    // Arrange, Act and Assert
    assertNull(paperPluginParent.new PaperBootstrapProvider().getLogger());
  }

  /**
   * Test PaperBootstrapProvider {@link PaperBootstrapProvider#getMeta()}.
   *
   * <p>Method under test: {@link PaperBootstrapProvider#getMeta()}
   */
  @Test
  @DisplayName("Test PaperBootstrapProvider getMeta()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.provider.configuration.PaperPluginMeta PaperBootstrapProvider.getMeta()"
  })
  void testPaperBootstrapProviderGetMeta() {
    // Arrange, Act and Assert
    assertNull(paperPluginParent.new PaperBootstrapProvider().getMeta());
  }

  /**
   * Test PaperBootstrapProvider {@link PaperBootstrapProvider#getSource()}.
   *
   * <p>Method under test: {@link PaperBootstrapProvider#getSource()}
   */
  @Test
  @DisplayName("Test PaperBootstrapProvider getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.nio.file.Path PaperBootstrapProvider.getSource()"})
  void testPaperBootstrapProviderGetSource() {
    // Arrange, Act and Assert
    assertNull(paperPluginParent.new PaperBootstrapProvider().getSource());
  }
}
