package com.destroystokyo.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.network.StatusClient;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import net.kyori.adventure.text.Component;
import org.bukkit.util.CachedServerIcon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperServerListPingEventDiffblueTest {
  /**
   * Test {@link PaperServerListPingEvent#PaperServerListPingEvent(StatusClient, Component, int,
   * int, String, int, CachedServerIcon)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return ServerIcon is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#PaperServerListPingEvent(StatusClient,
   * Component, int, int, String, int, CachedServerIcon)}
   */
  @Test
  @DisplayName(
      "Test new PaperServerListPingEvent(StatusClient, Component, int, int, String, int, CachedServerIcon); given 'true'; then return ServerIcon is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperServerListPingEvent.<init>(StatusClient, Component, int, int, String, int, CachedServerIcon)"
  })
  void testNewPaperServerListPingEvent_givenTrue_thenReturnServerIconIsNull() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Component motd = mock(Component.class);

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    // Act
    PaperServerListPingEvent actualPaperServerListPingEvent =
        new PaperServerListPingEvent(client, motd, 10, 3, "1.0.2", 1, favicon);

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals("", actualPaperServerListPingEvent.getHostname());
    assertEquals("1.0.2", actualPaperServerListPingEvent.getVersion());
    assertEquals("PaperServerListPingEvent", actualPaperServerListPingEvent.getEventName());
    assertNull(actualPaperServerListPingEvent.getAddress());
    assertNull(actualPaperServerListPingEvent.getServerIcon());
    assertEquals(1, actualPaperServerListPingEvent.getProtocolVersion());
    assertEquals(10, actualPaperServerListPingEvent.getNumPlayers());
    assertEquals(3, actualPaperServerListPingEvent.getMaxPlayers());
    assertFalse(actualPaperServerListPingEvent.isCancelled());
    assertTrue(actualPaperServerListPingEvent.getListedPlayers().isEmpty());
    assertTrue(actualPaperServerListPingEvent.getPlayerSample().isEmpty());
    assertTrue(actualPaperServerListPingEvent.isAsynchronous());
    assertSame(client, actualPaperServerListPingEvent.getClient());
    assertSame(motd, actualPaperServerListPingEvent.motd());
  }

  /**
   * Test {@link PaperServerListPingEvent#PaperServerListPingEvent(StatusClient, Component, int,
   * int, String, int, CachedServerIcon)}.
   *
   * <ul>
   *   <li>Then return ServerIcon is {@link CachedServerIcon}.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#PaperServerListPingEvent(StatusClient,
   * Component, int, int, String, int, CachedServerIcon)}
   */
  @Test
  @DisplayName(
      "Test new PaperServerListPingEvent(StatusClient, Component, int, int, String, int, CachedServerIcon); then return ServerIcon is CachedServerIcon")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperServerListPingEvent.<init>(StatusClient, Component, int, int, String, int, CachedServerIcon)"
  })
  void testNewPaperServerListPingEvent_thenReturnServerIconIsCachedServerIcon() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Component motd = mock(Component.class);

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(false);

    // Act
    PaperServerListPingEvent actualPaperServerListPingEvent =
        new PaperServerListPingEvent(client, motd, 10, 3, "1.0.2", 1, favicon);

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals("", actualPaperServerListPingEvent.getHostname());
    assertEquals("1.0.2", actualPaperServerListPingEvent.getVersion());
    assertEquals("PaperServerListPingEvent", actualPaperServerListPingEvent.getEventName());
    assertNull(actualPaperServerListPingEvent.getAddress());
    assertEquals(1, actualPaperServerListPingEvent.getProtocolVersion());
    assertEquals(10, actualPaperServerListPingEvent.getNumPlayers());
    assertEquals(3, actualPaperServerListPingEvent.getMaxPlayers());
    assertFalse(actualPaperServerListPingEvent.isCancelled());
    assertTrue(actualPaperServerListPingEvent.getListedPlayers().isEmpty());
    assertTrue(actualPaperServerListPingEvent.getPlayerSample().isEmpty());
    assertTrue(actualPaperServerListPingEvent.isAsynchronous());
    assertSame(client, actualPaperServerListPingEvent.getClient());
    assertSame(motd, actualPaperServerListPingEvent.motd());
    assertSame(favicon, actualPaperServerListPingEvent.getServerIcon());
  }

  /**
   * Test {@link PaperServerListPingEvent#getNumPlayers()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#getNumPlayers()}
   */
  @Test
  @DisplayName("Test getNumPlayers(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperServerListPingEvent.getNumPlayers()"})
  void testGetNumPlayers_thenReturnMinusOne() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);
    paperServerListPingEvent.setHidePlayers(true);

    // Act
    int actualNumPlayers = paperServerListPingEvent.getNumPlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(-1, actualNumPlayers);
  }

  /**
   * Test {@link PaperServerListPingEvent#getNumPlayers()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#getNumPlayers()}
   */
  @Test
  @DisplayName("Test getNumPlayers(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperServerListPingEvent.getNumPlayers()"})
  void testGetNumPlayers_thenReturnTen() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    // Act
    int actualNumPlayers = paperServerListPingEvent.getNumPlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(10, actualNumPlayers);
  }

  /**
   * Test {@link PaperServerListPingEvent#setNumPlayers(int)}.
   *
   * <p>Method under test: {@link PaperServerListPingEvent#setNumPlayers(int)}
   */
  @Test
  @DisplayName("Test setNumPlayers(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperServerListPingEvent.setNumPlayers(int)"})
  void testSetNumPlayers() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    // Act
    paperServerListPingEvent.setNumPlayers(10);

    // Assert that nothing has changed
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(10, paperServerListPingEvent.getNumPlayers());
  }

  /**
   * Test {@link PaperServerListPingEvent#setNumPlayers(int)}.
   *
   * <p>Method under test: {@link PaperServerListPingEvent#setNumPlayers(int)}
   */
  @Test
  @DisplayName("Test setNumPlayers(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperServerListPingEvent.setNumPlayers(int)"})
  void testSetNumPlayers2() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 1, 3, "1.0.2", 1, favicon);

    // Act
    paperServerListPingEvent.setNumPlayers(10);

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(10, paperServerListPingEvent.getNumPlayers());
  }

  /**
   * Test {@link PaperServerListPingEvent#getMaxPlayers()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#getMaxPlayers()}
   */
  @Test
  @DisplayName("Test getMaxPlayers(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperServerListPingEvent.getMaxPlayers()"})
  void testGetMaxPlayers_thenReturnMinusOne() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);
    paperServerListPingEvent.setHidePlayers(true);

    // Act
    int actualMaxPlayers = paperServerListPingEvent.getMaxPlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(-1, actualMaxPlayers);
  }

  /**
   * Test {@link PaperServerListPingEvent#getMaxPlayers()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#getMaxPlayers()}
   */
  @Test
  @DisplayName("Test getMaxPlayers(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperServerListPingEvent.getMaxPlayers()"})
  void testGetMaxPlayers_thenReturnThree() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    // Act
    int actualMaxPlayers = paperServerListPingEvent.getMaxPlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertEquals(3, actualMaxPlayers);
  }

  /**
   * Test {@link PaperServerListPingEvent#shouldHidePlayers()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#shouldHidePlayers()}
   */
  @Test
  @DisplayName("Test shouldHidePlayers(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperServerListPingEvent.shouldHidePlayers()"})
  void testShouldHidePlayers_thenReturnFalse() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    // Act
    boolean actualShouldHidePlayersResult = paperServerListPingEvent.shouldHidePlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertFalse(actualShouldHidePlayersResult);
  }

  /**
   * Test {@link PaperServerListPingEvent#shouldHidePlayers()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#shouldHidePlayers()}
   */
  @Test
  @DisplayName("Test shouldHidePlayers(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperServerListPingEvent.shouldHidePlayers()"})
  void testShouldHidePlayers_thenReturnTrue() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);
    paperServerListPingEvent.setHidePlayers(true);

    // Act
    boolean actualShouldHidePlayersResult = paperServerListPingEvent.shouldHidePlayers();

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    assertTrue(actualShouldHidePlayersResult);
  }

  /**
   * Test {@link PaperServerListPingEvent#setServerIcon(CachedServerIcon)}.
   *
   * <p>Method under test: {@link PaperServerListPingEvent#setServerIcon(CachedServerIcon)}
   */
  @Test
  @DisplayName("Test setServerIcon(CachedServerIcon)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperServerListPingEvent.setServerIcon(CachedServerIcon)"})
  void testSetServerIcon() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    CachedServerIcon icon = mock(CachedServerIcon.class);
    when(icon.isEmpty()).thenReturn(false);

    // Act
    paperServerListPingEvent.setServerIcon(icon);

    // Assert
    verify(client).getAddress();
    verify(favicon).isEmpty();
    verify(icon).isEmpty();
    assertSame(icon, paperServerListPingEvent.getServerIcon());
  }

  /**
   * Test {@link PaperServerListPingEvent#setServerIcon(CachedServerIcon)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link CachedServerIcon} {@link CachedServerIcon#isEmpty()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperServerListPingEvent#setServerIcon(CachedServerIcon)}
   */
  @Test
  @DisplayName(
      "Test setServerIcon(CachedServerIcon); given 'true'; when CachedServerIcon isEmpty() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperServerListPingEvent.setServerIcon(CachedServerIcon)"})
  void testSetServerIcon_givenTrue_whenCachedServerIconIsEmptyReturnTrue() {
    // Arrange
    StatusClient client = mock(StatusClient.class);
    when(client.getAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));

    CachedServerIcon favicon = mock(CachedServerIcon.class);
    when(favicon.isEmpty()).thenReturn(true);

    PaperServerListPingEvent paperServerListPingEvent =
        new PaperServerListPingEvent(client, mock(Component.class), 10, 3, "1.0.2", 1, favicon);

    CachedServerIcon icon = mock(CachedServerIcon.class);
    when(icon.isEmpty()).thenReturn(true);

    // Act
    paperServerListPingEvent.setServerIcon(icon);

    // Assert that nothing has changed
    verify(client).getAddress();
    verify(favicon).isEmpty();
    verify(icon).isEmpty();
  }
}
