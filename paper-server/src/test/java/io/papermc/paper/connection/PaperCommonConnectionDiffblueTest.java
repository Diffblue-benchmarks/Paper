package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.ClientOption;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
import net.minecraft.util.CommonLinks;
import org.bukkit.NamespacedKey;
import org.bukkit.ServerLinks;
import org.bukkit.ServerLinks.Type;
import org.bukkit.craftbukkit.CraftServerLinks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperCommonConnectionDiffblueTest {
  @InjectMocks private PaperPlayerConfigurationConnection paperPlayerConfigurationConnection;

  @Mock private ServerConfigurationPacketListenerImpl serverConfigurationPacketListenerImpl;

  /**
   * Test {@link PaperCommonConnection#sendReportDetails(Map)}.
   *
   * <ul>
   *   <li>Then calls {@link ServerConfigurationPacketListenerImpl#send(Packet)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#sendReportDetails(Map)}
   */
  @Test
  @DisplayName("Test sendReportDetails(Map); then calls send(Packet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.sendReportDetails(Map)"})
  void testSendReportDetails_thenCallsSend() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());
    PaperPlayerConfigurationConnection paperPlayerConfigurationConnection =
        new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl);

    // Act
    paperPlayerConfigurationConnection.sendReportDetails(new HashMap<>());

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperCommonConnection#sendLinks(ServerLinks)}.
   *
   * <ul>
   *   <li>Given {@code COMMUNITY_GUIDELINES}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#sendLinks(ServerLinks)}
   */
  @Test
  @DisplayName("Test sendLinks(ServerLinks); given 'COMMUNITY_GUIDELINES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.sendLinks(ServerLinks)"})
  void testSendLinks_givenCommunityGuidelines() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    CraftServerLinks links = new CraftServerLinks(net.minecraft.server.ServerLinks.EMPTY);
    links.addLink(Type.COMMUNITY_GUIDELINES, CommonLinks.ACCESSIBILITY_HELP);
    links.addLink(Type.REPORT_BUG, CommonLinks.ACCESSIBILITY_HELP);

    // Act
    paperPlayerConfigurationConnection.sendLinks(links);

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperCommonConnection#sendLinks(ServerLinks)}.
   *
   * <ul>
   *   <li>Given {@code REPORT_BUG}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#sendLinks(ServerLinks)}
   */
  @Test
  @DisplayName("Test sendLinks(ServerLinks); given 'REPORT_BUG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.sendLinks(ServerLinks)"})
  void testSendLinks_givenReportBug() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    CraftServerLinks links = new CraftServerLinks(net.minecraft.server.ServerLinks.EMPTY);
    links.addLink(Type.REPORT_BUG, CommonLinks.ACCESSIBILITY_HELP);

    // Act
    paperPlayerConfigurationConnection.sendLinks(links);

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperCommonConnection#sendLinks(ServerLinks)}.
   *
   * <ul>
   *   <li>When {@link CraftServerLinks#CraftServerLinks(ServerLinks)} with serverLinks is {@link
   *       net.minecraft.server.ServerLinks#EMPTY}.
   *   <li>Then calls {@link ServerConfigurationPacketListenerImpl#send(Packet)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#sendLinks(ServerLinks)}
   */
  @Test
  @DisplayName(
      "Test sendLinks(ServerLinks); when CraftServerLinks(ServerLinks) with serverLinks is EMPTY; then calls send(Packet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.sendLinks(ServerLinks)"})
  void testSendLinks_whenCraftServerLinksWithServerLinksIsEmpty_thenCallsSend() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    paperPlayerConfigurationConnection.sendLinks(
        new CraftServerLinks(net.minecraft.server.ServerLinks.EMPTY));

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperCommonConnection#transfer(String, int)}.
   *
   * <ul>
   *   <li>Then calls {@link ServerConfigurationPacketListenerImpl#send(Packet)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#transfer(String, int)}
   */
  @Test
  @DisplayName("Test transfer(String, int); then calls send(Packet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.transfer(String, int)"})
  void testTransfer_thenCallsSend() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl)
        .transfer("localhost", 8080);

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperCommonConnection#getClientOption(ClientOption)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#getClientOption(ClientOption)}
   */
  @Test
  @DisplayName("Test getClientOption(ClientOption); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object PaperCommonConnection.getClientOption(ClientOption)"})
  void testGetClientOption_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> paperPlayerConfigurationConnection.getClientOption(mock(ClientOption.class)));
  }

  /**
   * Test {@link PaperCommonConnection#isTransferred()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#isTransferred()}
   */
  @Test
  @DisplayName("Test isTransferred(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperCommonConnection.isTransferred()"})
  void testIsTransferred_thenReturnFalse() {
    // Arrange
    when(serverConfigurationPacketListenerImpl.isTransferred()).thenReturn(false);

    // Act
    boolean actualIsTransferredResult =
        new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl)
            .isTransferred();

    // Assert
    verify(serverConfigurationPacketListenerImpl).isTransferred();
    assertFalse(actualIsTransferredResult);
  }

  /**
   * Test {@link PaperCommonConnection#isTransferred()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#isTransferred()}
   */
  @Test
  @DisplayName("Test isTransferred(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperCommonConnection.isTransferred()"})
  void testIsTransferred_thenReturnTrue() {
    // Arrange
    when(serverConfigurationPacketListenerImpl.isTransferred()).thenReturn(true);

    // Act
    boolean actualIsTransferredResult =
        new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl)
            .isTransferred();

    // Assert
    verify(serverConfigurationPacketListenerImpl).isTransferred();
    assertTrue(actualIsTransferredResult);
  }

  /**
   * Test {@link PaperCommonConnection#storeCookie(NamespacedKey, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link ServerConfigurationPacketListenerImpl#send(Packet)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperCommonConnection#storeCookie(NamespacedKey, byte[])}
   */
  @Test
  @DisplayName("Test storeCookie(NamespacedKey, byte[]); then calls send(Packet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperCommonConnection.storeCookie(NamespacedKey, byte[])"})
  void testStoreCookie_thenCallsSend() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());
    PaperPlayerConfigurationConnection paperPlayerConfigurationConnection =
        new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl);

    // Act
    paperPlayerConfigurationConnection.storeCookie(
        NamespacedKey.randomKey(), new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }
}
