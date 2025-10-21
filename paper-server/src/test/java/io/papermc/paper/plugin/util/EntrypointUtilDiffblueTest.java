package io.papermc.paper.plugin.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.EntrypointHandler;
import io.papermc.paper.plugin.provider.source.ProviderSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class EntrypointUtilDiffblueTest {
  /**
   * Test {@link EntrypointUtil#registerProvidersFromSource(ProviderSource, Object)}.
   *
   * <p>Method under test: {@link EntrypointUtil#registerProvidersFromSource(ProviderSource,
   * Object)}
   */
  @Test
  @DisplayName("Test registerProvidersFromSource(ProviderSource, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntrypointUtil.registerProvidersFromSource(ProviderSource, Object)"})
  void testRegisterProvidersFromSource() throws Exception {
    // Arrange
    ProviderSource<Object, Object> source = mock(ProviderSource.class);
    when(source.prepareContext(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    doNothing()
        .when(source)
        .registerProviders(Mockito.<EntrypointHandler>any(), Mockito.<Object>any());

    // Act
    EntrypointUtil.registerProvidersFromSource(source, ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    verify(source).prepareContext(isA(Object.class));
    verify(source).registerProviders(isA(EntrypointHandler.class), isA(Object.class));
  }
}
