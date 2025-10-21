package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import net.minecraft.server.MinecraftServer;
import org.apache.logging.slf4j.Log4jEventBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.spi.NOPLoggingEventBuilder;

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
        .thenReturn(MinecraftServer.COMPONENT_LOGGER);

    // Act
    ComponentLogger actualLoggerResult = componentLoggerProviderImpl.logger(helper, "Name");

    // Assert
    verify(helper).delegating(isA(Logger.class), isA(Function.class));
    assertTrue(actualLoggerResult.atError() instanceof Log4jEventBuilder);
    assertTrue(actualLoggerResult.atInfo() instanceof Log4jEventBuilder);
    LoggingEventBuilder atDebugResult = actualLoggerResult.atDebug();
    assertTrue(atDebugResult instanceof NOPLoggingEventBuilder);
    assertSame(atDebugResult, actualLoggerResult.atTrace());
  }
}
