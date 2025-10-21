package com.destroystokyo.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.event.server.GS4QueryEvent.QueryResponse;
import com.destroystokyo.paper.event.server.GS4QueryEvent.QueryResponse.Builder;
import com.destroystokyo.paper.event.server.GS4QueryEvent.QueryResponse.PluginInformation;
import com.destroystokyo.paper.event.server.GS4QueryEvent.QueryType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GS4QueryEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GS4QueryEvent#GS4QueryEvent(QueryType, InetAddress, QueryResponse)}
   *   <li>{@link GS4QueryEvent#getHandlerList()}
   *   <li>{@link GS4QueryEvent#getHandlers()}
   *   <li>{@link GS4QueryEvent#getQuerierAddress()}
   *   <li>{@link GS4QueryEvent#getQueryType()}
   *   <li>{@link GS4QueryEvent#getResponse()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GS4QueryEvent.<init>(QueryType, InetAddress, QueryResponse)",
    "HandlerList GS4QueryEvent.getHandlerList()",
    "HandlerList GS4QueryEvent.getHandlers()",
    "InetAddress GS4QueryEvent.getQuerierAddress()",
    "QueryType GS4QueryEvent.getQueryType()",
    "QueryResponse GS4QueryEvent.getResponse()"
  })
  void testGettersAndSetters() {
    // Arrange
    QueryResponse response =
        QueryResponse.builder()
            .currentPlayers(1)
            .gameVersion("1.0.2")
            .hostname("localhost")
            .map("Map")
            .maxPlayers(3)
            .motd("Motd")
            .port(8080)
            .serverVersion("1.0.2")
            .build();

    // Act
    GS4QueryEvent actualGs4QueryEvent = new GS4QueryEvent(QueryType.BASIC, null, response);
    HandlerList actualHandlerList = actualGs4QueryEvent.getHandlerList();
    HandlerList actualHandlers = actualGs4QueryEvent.getHandlers();
    InetAddress actualQuerierAddress = actualGs4QueryEvent.getQuerierAddress();
    QueryType actualQueryType = actualGs4QueryEvent.getQueryType();
    QueryResponse actualResponse = actualGs4QueryEvent.getResponse();

    // Assert
    assertNull(actualQuerierAddress);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(QueryType.BASIC, actualQueryType);
    assertTrue(actualGs4QueryEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(response, actualResponse);
  }

  /**
   * Test QueryResponse getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueryResponse#getCurrentPlayers()}
   *   <li>{@link QueryResponse#getGameVersion()}
   *   <li>{@link QueryResponse#getHostname()}
   *   <li>{@link QueryResponse#getMap()}
   *   <li>{@link QueryResponse#getMaxPlayers()}
   *   <li>{@link QueryResponse#getMotd()}
   *   <li>{@link QueryResponse#getPlayers()}
   *   <li>{@link QueryResponse#getPlugins()}
   *   <li>{@link QueryResponse#getPort()}
   *   <li>{@link QueryResponse#getServerVersion()}
   *   <li>{@link QueryResponse#toBuilder()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueryResponse getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int QueryResponse.getCurrentPlayers()",
    "String QueryResponse.getGameVersion()",
    "String QueryResponse.getHostname()",
    "String QueryResponse.getMap()",
    "int QueryResponse.getMaxPlayers()",
    "String QueryResponse.getMotd()",
    "Collection QueryResponse.getPlayers()",
    "Collection QueryResponse.getPlugins()",
    "int QueryResponse.getPort()",
    "String QueryResponse.getServerVersion()",
    "Builder QueryResponse.toBuilder()"
  })
  void testQueryResponseGettersAndSetters() {
    // Arrange
    QueryResponse queryResponse =
        QueryResponse.builder()
            .currentPlayers(1)
            .gameVersion("1.0.2")
            .hostname("localhost")
            .map("Map")
            .maxPlayers(3)
            .motd("Motd")
            .port(8080)
            .serverVersion("1.0.2")
            .build();

    // Act
    int actualCurrentPlayers = queryResponse.getCurrentPlayers();
    String actualGameVersion = queryResponse.getGameVersion();
    String actualHostname = queryResponse.getHostname();
    String actualMap = queryResponse.getMap();
    int actualMaxPlayers = queryResponse.getMaxPlayers();
    String actualMotd = queryResponse.getMotd();
    Collection<String> actualPlayers = queryResponse.getPlayers();
    Collection<PluginInformation> actualPlugins = queryResponse.getPlugins();
    int actualPort = queryResponse.getPort();
    String actualServerVersion = queryResponse.getServerVersion();
    queryResponse.toBuilder();

    // Assert
    assertTrue(actualPlayers instanceof List);
    assertEquals("1.0.2", actualGameVersion);
    assertEquals("1.0.2", actualServerVersion);
    assertEquals("Map", actualMap);
    assertEquals("Motd", actualMotd);
    assertEquals("localhost", actualHostname);
    assertEquals(1, actualCurrentPlayers);
    assertEquals(3, actualMaxPlayers);
    assertEquals(8080, actualPort);
    assertSame(actualPlayers, actualPlugins);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueryResponse Builder.build()"})
  void testQueryResponse_BuilderBuild() {
    // Arrange and Act
    QueryResponse actualQueryResponse =
        QueryResponse.builder()
            .currentPlayers(1)
            .gameVersion("1.0.2")
            .hostname("localhost")
            .map("Map")
            .maxPlayers(3)
            .motd("Motd")
            .port(8080)
            .serverVersion("1.0.2")
            .build();

    // Assert
    Collection<String> players = actualQueryResponse.getPlayers();
    assertTrue(players instanceof List);
    assertEquals("1.0.2", actualQueryResponse.getGameVersion());
    assertEquals("1.0.2", actualQueryResponse.getServerVersion());
    assertEquals("Map", actualQueryResponse.getMap());
    assertEquals("Motd", actualQueryResponse.getMotd());
    assertEquals("localhost", actualQueryResponse.getHostname());
    assertEquals(1, actualQueryResponse.getCurrentPlayers());
    assertEquals(3, actualQueryResponse.getMaxPlayers());
    assertEquals(8080, actualQueryResponse.getPort());
    assertSame(players, actualQueryResponse.getPlugins());
  }

  /**
   * Test QueryResponse_Builder {@link Builder#clearPlayers()}.
   *
   * <p>Method under test: {@link Builder#clearPlayers()}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder clearPlayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.clearPlayers()"})
  void testQueryResponse_BuilderClearPlayers() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualClearPlayersResult = builderResult.clearPlayers();

    // Assert
    assertSame(builderResult, actualClearPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#clearPlugins()}.
   *
   * <p>Method under test: {@link Builder#clearPlugins()}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder clearPlugins()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.clearPlugins()"})
  void testQueryResponse_BuilderClearPlugins() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualClearPluginsResult = builderResult.clearPlugins();

    // Assert
    assertSame(builderResult, actualClearPluginsResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#currentPlayers(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#currentPlayers(int)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder currentPlayers(int); when one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.currentPlayers(int)"})
  void testQueryResponse_BuilderCurrentPlayers_whenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualCurrentPlayersResult = builderResult.currentPlayers(1);

    // Assert
    assertSame(builderResult, actualCurrentPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#gameVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#gameVersion(String)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder gameVersion(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gameVersion(String)"})
  void testQueryResponse_BuilderGameVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualGameVersionResult = builderResult.gameVersion("1.0.2");

    // Assert
    assertSame(builderResult, actualGameVersionResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#hostname(String)}.
   *
   * <ul>
   *   <li>When {@code localhost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#hostname(String)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder hostname(String); when 'localhost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hostname(String)"})
  void testQueryResponse_BuilderHostname_whenLocalhost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualHostnameResult = builderResult.hostname("localhost");

    // Assert
    assertSame(builderResult, actualHostnameResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#map(String)}.
   *
   * <ul>
   *   <li>When {@code Map}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#map(String)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder map(String); when 'Map'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.map(String)"})
  void testQueryResponse_BuilderMap_whenMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualMapResult = builderResult.map("Map");

    // Assert
    assertSame(builderResult, actualMapResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#maxPlayers(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#maxPlayers(int)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder maxPlayers(int); when three; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.maxPlayers(int)"})
  void testQueryResponse_BuilderMaxPlayers_whenThree_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualMaxPlayersResult = builderResult.maxPlayers(3);

    // Assert
    assertSame(builderResult, actualMaxPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#motd(String)}.
   *
   * <ul>
   *   <li>When {@code Motd}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#motd(String)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder motd(String); when 'Motd'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.motd(String)"})
  void testQueryResponse_BuilderMotd_whenMotd_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualMotdResult = builderResult.motd("Motd");

    // Assert
    assertSame(builderResult, actualMotdResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#players(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#players(Collection)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder players(Collection) with 'Collection'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.players(Collection)"})
  void testQueryResponse_BuilderPlayersWithCollection_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    ArrayList<String> players = new ArrayList<>();
    players.add("foo");
    players.add("players");

    // Act
    Builder actualPlayersResult = builderResult.players(players);

    // Assert
    assertSame(builderResult, actualPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#players(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code players}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#players(Collection)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder players(Collection) with 'Collection'; given 'players'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.players(Collection)"})
  void testQueryResponse_BuilderPlayersWithCollection_givenPlayers() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    ArrayList<String> players = new ArrayList<>();
    players.add("players");

    // Act
    Builder actualPlayersResult = builderResult.players(players);

    // Assert
    assertSame(builderResult, actualPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#players(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#players(Collection)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder players(Collection) with 'Collection'; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.players(Collection)"})
  void testQueryResponse_BuilderPlayersWithCollection_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualPlayersResult = builderResult.players(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#players(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code Players}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#players(String[])}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder players(String[]) with 'String[]'; when 'Players'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.players(String[])"})
  void testQueryResponse_BuilderPlayersWithString_whenPlayers_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualPlayersResult = builderResult.players("Players");

    // Assert
    assertSame(builderResult, actualPlayersResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#plugins(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link Builder#plugins(Collection)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder plugins(Collection) with 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plugins(Collection)"})
  void testQueryResponse_BuilderPluginsWithCollection() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    ArrayList<PluginInformation> plugins = new ArrayList<>();
    plugins.add(PluginInformation.of("plugins", "1.0.2"));

    // Act
    Builder actualPluginsResult = builderResult.plugins(plugins);

    // Assert
    assertSame(builderResult, actualPluginsResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#plugins(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link Builder#plugins(Collection)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder plugins(Collection) with 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plugins(Collection)"})
  void testQueryResponse_BuilderPluginsWithCollection2() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    ArrayList<PluginInformation> plugins = new ArrayList<>();
    plugins.add(PluginInformation.of("plugins", "1.0.2"));
    plugins.add(PluginInformation.of("plugins", "1.0.2"));

    // Act
    Builder actualPluginsResult = builderResult.plugins(plugins);

    // Assert
    assertSame(builderResult, actualPluginsResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#plugins(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plugins(Collection)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder plugins(Collection) with 'Collection'; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plugins(Collection)"})
  void testQueryResponse_BuilderPluginsWithCollection_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualPluginsResult = builderResult.plugins(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPluginsResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#plugins(PluginInformation[])} with {@code
   * PluginInformation[]}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plugins(PluginInformation[])}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder plugins(PluginInformation[]) with 'PluginInformation[]'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plugins(PluginInformation[])"})
  void testQueryResponse_BuilderPluginsWithPluginInformation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualPluginsResult = builderResult.plugins(PluginInformation.of("Name", "1.0.2"));

    // Assert
    assertSame(builderResult, actualPluginsResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#port(int)}.
   *
   * <ul>
   *   <li>When {@code 8080}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#port(int)}
   */
  @Test
  @DisplayName("Test QueryResponse_Builder port(int); when '8080'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.port(int)"})
  void testQueryResponse_BuilderPort_when8080_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualPortResult = builderResult.port(8080);

    // Assert
    assertSame(builderResult, actualPortResult);
  }

  /**
   * Test QueryResponse_Builder {@link Builder#serverVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#serverVersion(String)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_Builder serverVersion(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.serverVersion(String)"})
  void testQueryResponse_BuilderServerVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = QueryResponse.builder();

    // Act
    Builder actualServerVersionResult = builderResult.serverVersion("1.0.2");

    // Assert
    assertSame(builderResult, actualServerVersionResult);
  }

  /**
   * Test QueryResponse_PluginInformation getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginInformation#setName(String)}
   *   <li>{@link PluginInformation#setVersion(String)}
   *   <li>{@link PluginInformation#getName()}
   *   <li>{@link PluginInformation#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueryResponse_PluginInformation getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PluginInformation.getName()",
    "String PluginInformation.getVersion()",
    "void PluginInformation.setName(String)",
    "void PluginInformation.setVersion(String)"
  })
  void testQueryResponse_PluginInformationGettersAndSetters() {
    // Arrange
    PluginInformation ofResult = PluginInformation.of("Name", "1.0.2");

    // Act
    ofResult.setName("Name");
    ofResult.setVersion("1.0.2");
    String actualName = ofResult.getName();

    // Assert
    assertEquals("1.0.2", ofResult.getVersion());
    assertEquals("Name", actualName);
  }

  /**
   * Test QueryResponse_PluginInformation {@link PluginInformation#PluginInformation(String,
   * String)}.
   *
   * <ul>
   *   <li>Then return Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInformation#PluginInformation(String, String)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_PluginInformation new PluginInformation(String, String); then return Version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginInformation.<init>(String, String)"})
  void testQueryResponse_PluginInformationNewPluginInformation_thenReturnVersionIs102() {
    // Arrange and Act
    PluginInformation actualPluginInformation = new PluginInformation("Name", "1.0.2");

    // Assert
    assertEquals("1.0.2", actualPluginInformation.getVersion());
    assertEquals("Name", actualPluginInformation.getName());
  }

  /**
   * Test QueryResponse_PluginInformation {@link PluginInformation#of(String, String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PluginInformation#of(String, String)}
   */
  @Test
  @DisplayName(
      "Test QueryResponse_PluginInformation of(String, String); when '1.0.2'; then return Version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PluginInformation PluginInformation.of(String, String)"})
  void testQueryResponse_PluginInformationOf_when102_thenReturnVersionIs102() {
    // Arrange and Act
    PluginInformation actualOfResult = PluginInformation.of("Name", "1.0.2");

    // Assert
    assertEquals("1.0.2", actualOfResult.getVersion());
    assertEquals("Name", actualOfResult.getName());
  }

  /**
   * Test {@link GS4QueryEvent#setResponse(QueryResponse)}.
   *
   * <p>Method under test: {@link GS4QueryEvent#setResponse(QueryResponse)}
   */
  @Test
  @DisplayName("Test setResponse(QueryResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GS4QueryEvent.setResponse(QueryResponse)"})
  void testSetResponse() {
    // Arrange
    QueryResponse response =
        QueryResponse.builder()
            .currentPlayers(1)
            .gameVersion("1.0.2")
            .hostname("localhost")
            .map("Map")
            .maxPlayers(3)
            .motd("Motd")
            .port(8080)
            .serverVersion("1.0.2")
            .build();
    GS4QueryEvent gs4QueryEvent = new GS4QueryEvent(QueryType.BASIC, null, response);
    QueryResponse response2 = mock(QueryResponse.class);

    // Act
    gs4QueryEvent.setResponse(response2);

    // Assert
    assertSame(response2, gs4QueryEvent.getResponse());
  }
}
