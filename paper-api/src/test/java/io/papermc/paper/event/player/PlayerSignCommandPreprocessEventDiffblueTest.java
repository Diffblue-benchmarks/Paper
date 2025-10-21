package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerSignCommandPreprocessEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerSignCommandPreprocessEvent#PlayerSignCommandPreprocessEvent(Player, String,
   *       Set, Sign, Side)}
   *   <li>{@link PlayerSignCommandPreprocessEvent#getSide()}
   *   <li>{@link PlayerSignCommandPreprocessEvent#getSign()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerSignCommandPreprocessEvent.<init>(Player, String, Set, Sign, Side)",
    "Side PlayerSignCommandPreprocessEvent.getSide()",
    "Sign PlayerSignCommandPreprocessEvent.getSign()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    HashSet<Player> recipients = new HashSet<>();
    Sign sign = mock(Sign.class);

    // Act
    PlayerSignCommandPreprocessEvent actualPlayerSignCommandPreprocessEvent =
        new PlayerSignCommandPreprocessEvent(
            player, "Not all who wander are lost", recipients, sign, Side.FRONT);
    Side actualSide = actualPlayerSignCommandPreprocessEvent.getSide();
    Sign actualSign = actualPlayerSignCommandPreprocessEvent.getSign();

    // Assert
    assertEquals(
        "Not all who wander are lost", actualPlayerSignCommandPreprocessEvent.getMessage());
    assertEquals(Side.FRONT, actualSide);
    assertFalse(actualPlayerSignCommandPreprocessEvent.isAsynchronous());
    assertFalse(actualPlayerSignCommandPreprocessEvent.isCancelled());
    Set<Player> recipients2 = actualPlayerSignCommandPreprocessEvent.getRecipients();
    assertTrue(recipients2.isEmpty());
    assertSame(recipients, recipients2);
    assertSame(sign, actualSign);
    assertSame(player, actualPlayerSignCommandPreprocessEvent.getPlayer());
  }
}
