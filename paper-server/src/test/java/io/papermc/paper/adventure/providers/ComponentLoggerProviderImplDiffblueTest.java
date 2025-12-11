package io.papermc.paper.adventure.providers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.kyori.adventure.text.logger.slf4j.ComponentLoggerProvider;
import net.kyori.adventure.text.logger.slf4j.ComponentLoggerProvider.LoggerHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

class ComponentLoggerProviderImplDiffblueTest {
  /**
   * Test {@link ComponentLoggerProviderImpl#logger(LoggerHelper, String)}.
   *
   * <p>Method under test: {@link ComponentLoggerProviderImpl#logger(LoggerHelper, String)}
   */
  @Test
  @DisplayName("Test logger(LoggerHelper, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComponentLogger ComponentLoggerProviderImpl.logger(LoggerHelper, String)"})
  void testLogger() {
    // Arrange
    ComponentLoggerProviderImpl componentLoggerProviderImpl = new ComponentLoggerProviderImpl();

    LoggerHelper helper = mock(LoggerHelper.class);
    when(helper.delegating(Mockito.<Logger>any(), Mockito.<Function<Component, String>>any()))
        .thenReturn(mock(ComponentLogger.class));

    // Act
    componentLoggerProviderImpl.logger(helper, "Name");

    // Assert
    verify(helper).delegating(isA(Logger.class), isA(Function.class));
  }
}
