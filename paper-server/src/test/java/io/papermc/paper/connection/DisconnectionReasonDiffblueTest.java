package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.DisconnectionReason.GameEntry;
import java.util.Optional;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerKickEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisconnectionReasonDiffblueTest {
  /**
   * Test GameEntry {@link GameEntry#game()}.
   *
   * <p>Method under test: {@link GameEntry#game()}
   */
  @Test
  @DisplayName("Test GameEntry game()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional GameEntry.game()"})
  void testGameEntryGame() {
    // Arrange and Act
    Optional<Cause> actualGameResult = new GameEntry(Cause.PLUGIN).game();

    // Assert
    assertEquals(Cause.PLUGIN, actualGameResult.get());
    assertTrue(actualGameResult.isPresent());
  }

  /**
   * Test {@link DisconnectionReason#game(Cause)} with {@code Cause}.
   *
   * <p>Method under test: {@link DisconnectionReason#game(Cause)}
   */
  @Test
  @DisplayName("Test game(Cause) with 'Cause'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DisconnectionReason DisconnectionReason.game(Cause)"})
  void testGameWithCause() {
    // Arrange and Act
    DisconnectionReason actualGameResult = DisconnectionReason.game(Cause.PLUGIN);
    Optional<Cause> actualGameResult2 = actualGameResult.game();

    // Assert
    assertTrue(actualGameResult instanceof GameEntry);
    assertEquals(Cause.PLUGIN, ((GameEntry) actualGameResult).gameQuitEvent());
    assertEquals(Cause.PLUGIN, actualGameResult2.get());
    assertTrue(actualGameResult2.isPresent());
  }
}
