package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.profile.CraftPlayerProfile;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.kyori.adventure.audience.Audience;
import net.minecraft.Util;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperPlayerConfigurationConnectionDiffblueTest {
  @InjectMocks private PaperPlayerConfigurationConnection paperPlayerConfigurationConnection;

  @Mock private ServerConfigurationPacketListenerImpl serverConfigurationPacketListenerImpl;

  /**
   * Test {@link
   * PaperPlayerConfigurationConnection#PaperPlayerConfigurationConnection(ServerConfigurationPacketListenerImpl)}.
   *
   * <p>Method under test: {@link
   * PaperPlayerConfigurationConnection#PaperPlayerConfigurationConnection(ServerConfigurationPacketListenerImpl)}
   */
  @Test
  @DisplayName("Test new PaperPlayerConfigurationConnection(ServerConfigurationPacketListenerImpl)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperPlayerConfigurationConnection.<init>(ServerConfigurationPacketListenerImpl)"
  })
  void testNewPaperPlayerConfigurationConnection() {
    // Arrange and Act
    PaperPlayerConfigurationConnection actualPaperPlayerConfigurationConnection =
        new PaperPlayerConfigurationConnection(serverConfigurationPacketListenerImpl);

    // Assert
    assertNull(actualPaperPlayerConfigurationConnection.channels());
    assertNull(actualPaperPlayerConfigurationConnection.getClientInformation());
    assertFalse(actualPaperPlayerConfigurationConnection.isTransferred());
    assertFalse(actualPaperPlayerConfigurationConnection.isAwaitingCookies());
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#getClientInformation()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#getClientInformation()}
   */
  @Test
  @DisplayName("Test getClientInformation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.server.level.ClientInformation PaperPlayerConfigurationConnection.getClientInformation()"
  })
  void testGetClientInformation() {
    // Arrange, Act and Assert
    assertNull(paperPlayerConfigurationConnection.getClientInformation());
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#removeResourcePacks(UUID, UUID[])} with {@code
   * UUID}, {@code UUID[]}.
   *
   * <ul>
   *   <li>When {@link Util#NIL_UUID}.
   *   <li>Then calls {@link ServerConfigurationPacketListenerImpl#send(Packet)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#removeResourcePacks(UUID,
   * UUID[])}
   */
  @Test
  @DisplayName(
      "Test removeResourcePacks(UUID, UUID[]) with 'UUID', 'UUID[]'; when NIL_UUID; then calls send(Packet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerConfigurationConnection.removeResourcePacks(UUID, UUID[])"})
  void testRemoveResourcePacksWithUuidUuid_whenNil_uuid_thenCallsSend() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    paperPlayerConfigurationConnection.removeResourcePacks(Util.NIL_UUID, Util.NIL_UUID);

    // Assert
    verify(serverConfigurationPacketListenerImpl, atLeast(1)).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#clearResourcePacks()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#clearResourcePacks()}
   */
  @Test
  @DisplayName("Test clearResourcePacks()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerConfigurationConnection.clearResourcePacks()"})
  void testClearResourcePacks() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    paperPlayerConfigurationConnection.clearResourcePacks();

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#closeDialog()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#closeDialog()}
   */
  @Test
  @DisplayName("Test closeDialog()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerConfigurationConnection.closeDialog()"})
  void testCloseDialog() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    paperPlayerConfigurationConnection.closeDialog();

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#getAudience()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#getAudience()}
   */
  @Test
  @DisplayName("Test getAudience()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Audience PaperPlayerConfigurationConnection.getAudience()"})
  void testGetAudience() {
    // Arrange and Act
    Audience actualAudience = paperPlayerConfigurationConnection.getAudience();

    // Assert
    assertSame(paperPlayerConfigurationConnection, actualAudience);
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#getProfile()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#getProfile()}
   */
  @Test
  @DisplayName("Test getProfile(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerProfile PaperPlayerConfigurationConnection.getProfile()"})
  void testGetProfile_thenReturnName() {
    // Arrange
    when(serverConfigurationPacketListenerImpl.getOwner())
        .thenReturn(new GameProfile(Util.NIL_UUID, "Name"));

    // Act
    PlayerProfile actualProfile = paperPlayerConfigurationConnection.getProfile();

    // Assert
    verify(serverConfigurationPacketListenerImpl).getOwner();
    assertTrue(actualProfile instanceof CraftPlayerProfile);
    assertEquals("Name", actualProfile.getName());
    assertEquals("Name", ((CraftPlayerProfile) actualProfile).getGameProfile().getName());
    assertTrue(actualProfile.isComplete());
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#getProfile()}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#getProfile()}
   */
  @Test
  @DisplayName("Test getProfile(); then return Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerProfile PaperPlayerConfigurationConnection.getProfile()"})
  void testGetProfile_thenReturnNameIsEmptyString() {
    // Arrange
    when(serverConfigurationPacketListenerImpl.getOwner())
        .thenReturn(new GameProfile(Util.NIL_UUID, ""));

    // Act
    PlayerProfile actualProfile = paperPlayerConfigurationConnection.getProfile();

    // Assert
    verify(serverConfigurationPacketListenerImpl).getOwner();
    assertTrue(actualProfile instanceof CraftPlayerProfile);
    assertEquals("", actualProfile.getName());
    assertEquals("", ((CraftPlayerProfile) actualProfile).getGameProfile().getName());
    assertFalse(actualProfile.isComplete());
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#clearChat()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#clearChat()}
   */
  @Test
  @DisplayName("Test clearChat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerConfigurationConnection.clearChat()"})
  void testClearChat() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).send(Mockito.<Packet<?>>any());

    // Act
    paperPlayerConfigurationConnection.clearChat();

    // Assert
    verify(serverConfigurationPacketListenerImpl).send(isA(Packet.class));
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#completeReconfiguration()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#completeReconfiguration()}
   */
  @Test
  @DisplayName("Test completeReconfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerConfigurationConnection.completeReconfiguration()"})
  void testCompleteReconfiguration() {
    // Arrange
    doNothing().when(serverConfigurationPacketListenerImpl).returnToWorld();

    // Act
    paperPlayerConfigurationConnection.completeReconfiguration();

    // Assert
    verify(serverConfigurationPacketListenerImpl).returnToWorld();
  }

  /**
   * Test {@link PaperPlayerConfigurationConnection#channels()}.
   *
   * <p>Method under test: {@link PaperPlayerConfigurationConnection#channels()}
   */
  @Test
  @DisplayName("Test channels()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperPlayerConfigurationConnection.channels()"})
  void testChannels() {
    // Arrange, Act and Assert
    assertNull(paperPlayerConfigurationConnection.channels());
  }
}
