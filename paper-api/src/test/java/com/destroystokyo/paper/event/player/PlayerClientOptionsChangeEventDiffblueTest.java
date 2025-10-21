package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.ClientOption.ChatVisibility;
import com.destroystokyo.paper.ClientOption.ParticleVisibility;
import com.destroystokyo.paper.SkinParts;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.inventory.MainHand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerClientOptionsChangeEventDiffblueTest {
  /**
   * Test {@link PlayerClientOptionsChangeEvent#PlayerClientOptionsChangeEvent(Player, Map)}.
   *
   * <ul>
   *   <li>Given {@link ClientOption#LOCALE}.
   *   <li>Then return Locale is {@code Options}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PlayerClientOptionsChangeEvent#PlayerClientOptionsChangeEvent(Player, Map)}
   */
  @Test
  @DisplayName(
      "Test new PlayerClientOptionsChangeEvent(Player, Map); given LOCALE; then return Locale is 'Options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerClientOptionsChangeEvent.<init>(Player, Map)"})
  void testNewPlayerClientOptionsChangeEvent_givenLocale_thenReturnLocaleIsOptions() {
    // Arrange
    Player player = mock(Player.class);

    HashMap<ClientOption<?>, Object> options = new HashMap<>();
    options.put(ClientOption.LOCALE, "Options");
    options.put(ClientOption.VIEW_DISTANCE, 1);
    options.put(ClientOption.CHAT_VISIBILITY, ChatVisibility.FULL);
    options.put(ClientOption.CHAT_COLORS_ENABLED, true);
    options.put(ClientOption.SKIN_PARTS, mock(SkinParts.class));
    options.put(ClientOption.MAIN_HAND, MainHand.LEFT);
    options.put(ClientOption.ALLOW_SERVER_LISTINGS, true);
    options.put(ClientOption.TEXT_FILTERING_ENABLED, true);
    options.put(ClientOption.PARTICLE_VISIBILITY, ParticleVisibility.ALL);

    // Act
    PlayerClientOptionsChangeEvent actualPlayerClientOptionsChangeEvent =
        new PlayerClientOptionsChangeEvent(player, options);

    // Assert
    assertEquals("Options", actualPlayerClientOptionsChangeEvent.getLocale());
    assertEquals(
        "PlayerClientOptionsChangeEvent", actualPlayerClientOptionsChangeEvent.getEventName());
    assertEquals(1, actualPlayerClientOptionsChangeEvent.getViewDistance());
    assertEquals(ChatVisibility.FULL, actualPlayerClientOptionsChangeEvent.getChatVisibility());
    assertEquals(
        ParticleVisibility.ALL, actualPlayerClientOptionsChangeEvent.getParticleVisibility());
    assertEquals(MainHand.LEFT, actualPlayerClientOptionsChangeEvent.getMainHand());
    assertFalse(actualPlayerClientOptionsChangeEvent.isAsynchronous());
    assertTrue(actualPlayerClientOptionsChangeEvent.allowsServerListings());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasChatColorsEnabled());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasChatVisibilityChanged());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasLocaleChanged());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasMainHandChanged());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasParticleVisibilityChanged());
    assertTrue(actualPlayerClientOptionsChangeEvent.hasTextFilteringEnabled());
    assertSame(player, actualPlayerClientOptionsChangeEvent.getPlayer());
  }
}
