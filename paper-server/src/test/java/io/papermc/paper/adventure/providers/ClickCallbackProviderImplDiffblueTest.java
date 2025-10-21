package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.providers.ClickCallbackProviderImpl.DialogClickManager;
import java.time.Duration;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.event.ClickCallback;
import net.kyori.adventure.text.event.ClickCallback.Options;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.ClickEvent.Action;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClickCallbackProviderImplDiffblueTest {
  /**
   * Test {@link ClickCallbackProviderImpl#create(ClickCallback, Options)}.
   *
   * <ul>
   *   <li>Given ofSeconds one.
   *   <li>Then return action is {@code CUSTOM}.
   * </ul>
   *
   * <p>Method under test: {@link ClickCallbackProviderImpl#create(ClickCallback, Options)}
   */
  @Test
  @DisplayName(
      "Test create(ClickCallback, Options); given ofSeconds one; then return action is 'CUSTOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClickEvent ClickCallbackProviderImpl.create(ClickCallback, Options)"})
  void testCreate_givenOfSecondsOne_thenReturnActionIsCustom() {
    // Arrange
    ClickCallbackProviderImpl clickCallbackProviderImpl = new ClickCallbackProviderImpl();
    ClickCallback<Audience> callback = mock(ClickCallback.class);

    Options options = mock(Options.class);
    when(options.uses()).thenReturn(1);
    when(options.lifetime()).thenReturn(Duration.ofSeconds(1L));

    // Act
    ClickEvent actualCreateResult = clickCallbackProviderImpl.create(callback, options);

    // Assert
    verify(options).lifetime();
    verify(options).uses();
    assertEquals(Action.CUSTOM, actualCreateResult.action());
  }

  /**
   * Test DialogClickManager new {@link DialogClickManager} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DialogClickManager}
   */
  @Test
  @DisplayName("Test DialogClickManager new DialogClickManager (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogClickManager.<init>()"})
  void testDialogClickManagerNewDialogClickManager() {
    // Arrange, Act and Assert
    assertTrue(new DialogClickManager().callbacks.isEmpty());
  }
}
