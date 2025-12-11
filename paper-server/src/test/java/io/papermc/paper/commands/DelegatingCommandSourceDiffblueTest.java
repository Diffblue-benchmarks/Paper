package io.papermc.paper.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.commands.CommandSource;
import net.minecraft.gametest.framework.GameTestServer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DelegatingCommandSourceDiffblueTest {
  /**
   * Test {@link DelegatingCommandSource#sendSystemMessage(Component)}.
   *
   * <ul>
   *   <li>Then calls {@link GameTestServer#sendSystemMessage(Component)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#sendSystemMessage(Component)}
   */
  @Test
  @DisplayName("Test sendSystemMessage(Component); then calls sendSystemMessage(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatingCommandSource.sendSystemMessage(Component)"})
  void testSendSystemMessage_thenCallsSendSystemMessage() {
    // Arrange
    GameTestServer delegate = mock(GameTestServer.class);
    doNothing().when(delegate).sendSystemMessage(Mockito.<Component>any());

    // Act
    new DelegatingCommandSource(delegate).sendSystemMessage(mock(MutableComponent.class));

    // Assert
    verify(delegate).sendSystemMessage(isA(Component.class));
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsSuccess()}.
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsSuccess()}
   */
  @Test
  @DisplayName("Test acceptsSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsSuccess()"})
  void testAcceptsSuccess() {
    // Arrange, Act and Assert
    assertFalse(
        new DelegatingCommandSource(new DelegatingCommandSource(CommandSource.NULL))
            .acceptsSuccess());
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsSuccess()}.
   *
   * <ul>
   *   <li>Given {@link GameTestServer} {@link GameTestServer#acceptsSuccess()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsSuccess()}
   */
  @Test
  @DisplayName(
      "Test acceptsSuccess(); given GameTestServer acceptsSuccess() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsSuccess()"})
  void testAcceptsSuccess_givenGameTestServerAcceptsSuccessReturnTrue_thenReturnTrue() {
    // Arrange
    GameTestServer delegate = mock(GameTestServer.class);
    when(delegate.acceptsSuccess()).thenReturn(true);

    // Act
    boolean actualAcceptsSuccessResult = new DelegatingCommandSource(delegate).acceptsSuccess();

    // Assert
    verify(delegate).acceptsSuccess();
    assertTrue(actualAcceptsSuccessResult);
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsSuccess()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsSuccess()}
   */
  @Test
  @DisplayName("Test acceptsSuccess(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsSuccess()"})
  void testAcceptsSuccess_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DelegatingCommandSource(CommandSource.NULL).acceptsSuccess());
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsFailure()}.
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsFailure()}
   */
  @Test
  @DisplayName("Test acceptsFailure()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsFailure()"})
  void testAcceptsFailure() {
    // Arrange, Act and Assert
    assertFalse(
        new DelegatingCommandSource(new DelegatingCommandSource(CommandSource.NULL))
            .acceptsFailure());
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsFailure()}.
   *
   * <ul>
   *   <li>Given {@link GameTestServer} {@link GameTestServer#acceptsFailure()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsFailure()}
   */
  @Test
  @DisplayName(
      "Test acceptsFailure(); given GameTestServer acceptsFailure() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsFailure()"})
  void testAcceptsFailure_givenGameTestServerAcceptsFailureReturnTrue_thenReturnTrue() {
    // Arrange
    GameTestServer delegate = mock(GameTestServer.class);
    when(delegate.acceptsFailure()).thenReturn(true);

    // Act
    boolean actualAcceptsFailureResult = new DelegatingCommandSource(delegate).acceptsFailure();

    // Assert
    verify(delegate).acceptsFailure();
    assertTrue(actualAcceptsFailureResult);
  }

  /**
   * Test {@link DelegatingCommandSource#acceptsFailure()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#acceptsFailure()}
   */
  @Test
  @DisplayName("Test acceptsFailure(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.acceptsFailure()"})
  void testAcceptsFailure_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DelegatingCommandSource(CommandSource.NULL).acceptsFailure());
  }

  /**
   * Test {@link DelegatingCommandSource#shouldInformAdmins()}.
   *
   * <p>Method under test: {@link DelegatingCommandSource#shouldInformAdmins()}
   */
  @Test
  @DisplayName("Test shouldInformAdmins()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.shouldInformAdmins()"})
  void testShouldInformAdmins() {
    // Arrange, Act and Assert
    assertFalse(
        new DelegatingCommandSource(new DelegatingCommandSource(CommandSource.NULL))
            .shouldInformAdmins());
  }

  /**
   * Test {@link DelegatingCommandSource#shouldInformAdmins()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#shouldInformAdmins()}
   */
  @Test
  @DisplayName("Test shouldInformAdmins(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.shouldInformAdmins()"})
  void testShouldInformAdmins_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DelegatingCommandSource(CommandSource.NULL).shouldInformAdmins());
  }

  /**
   * Test {@link DelegatingCommandSource#shouldInformAdmins()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingCommandSource#shouldInformAdmins()}
   */
  @Test
  @DisplayName("Test shouldInformAdmins(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegatingCommandSource.shouldInformAdmins()"})
  void testShouldInformAdmins_thenReturnTrue() {
    // Arrange
    GameTestServer delegate = mock(GameTestServer.class);
    when(delegate.shouldInformAdmins()).thenReturn(true);

    // Act
    boolean actualShouldInformAdminsResult =
        new DelegatingCommandSource(delegate).shouldInformAdmins();

    // Assert
    verify(delegate).shouldInformAdmins();
    assertTrue(actualShouldInformAdminsResult);
  }
}
