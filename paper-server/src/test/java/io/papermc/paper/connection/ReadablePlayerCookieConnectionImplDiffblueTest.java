package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import net.minecraft.network.protocol.cookie.ServerboundCookieResponsePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReadablePlayerCookieConnectionImplDiffblueTest {
  @InjectMocks private PaperPlayerConfigurationConnection paperPlayerConfigurationConnection;

  @Mock private ServerConfigurationPacketListenerImpl serverConfigurationPacketListenerImpl;

  /**
   * Test {@link ReadablePlayerCookieConnectionImpl#canStoreCookie()}.
   *
   * <p>Method under test: {@link ReadablePlayerCookieConnectionImpl#canStoreCookie()}
   */
  @Test
  @DisplayName("Test canStoreCookie()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReadablePlayerCookieConnectionImpl.canStoreCookie()"})
  void testCanStoreCookie() {
    // Arrange, Act and Assert
    assertTrue(paperPlayerConfigurationConnection.canStoreCookie());
  }

  /**
   * Test {@link
   * ReadablePlayerCookieConnectionImpl#handleCookieResponse(ServerboundCookieResponsePacket)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReadablePlayerCookieConnectionImpl#handleCookieResponse(ServerboundCookieResponsePacket)}
   */
  @Test
  @DisplayName("Test handleCookieResponse(ServerboundCookieResponsePacket); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadablePlayerCookieConnectionImpl.handleCookieResponse(ServerboundCookieResponsePacket)"
  })
  void testHandleCookieResponse_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    ServerboundCookieResponsePacket packet =
        new ServerboundCookieResponsePacket(
            ResourceLocation.withDefaultNamespace("argument.id.invalid"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(paperPlayerConfigurationConnection.handleCookieResponse(packet));
  }

  /**
   * Test {@link ReadablePlayerCookieConnectionImpl#isAwaitingCookies()}.
   *
   * <p>Method under test: {@link ReadablePlayerCookieConnectionImpl#isAwaitingCookies()}
   */
  @Test
  @DisplayName("Test isAwaitingCookies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReadablePlayerCookieConnectionImpl.isAwaitingCookies()"})
  void testIsAwaitingCookies() {
    // Arrange, Act and Assert
    assertFalse(paperPlayerConfigurationConnection.isAwaitingCookies());
  }
}
