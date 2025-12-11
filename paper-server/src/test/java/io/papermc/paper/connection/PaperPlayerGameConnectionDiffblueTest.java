package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPlayerGameConnectionDiffblueTest {
  /**
   * Test {@link PaperPlayerGameConnection#PaperPlayerGameConnection(ServerGamePacketListenerImpl)}.
   *
   * <p>Method under test: {@link
   * PaperPlayerGameConnection#PaperPlayerGameConnection(ServerGamePacketListenerImpl)}
   */
  @Test
  @DisplayName("Test new PaperPlayerGameConnection(ServerGamePacketListenerImpl)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPlayerGameConnection.<init>(ServerGamePacketListenerImpl)"})
  void testNewPaperPlayerGameConnection() {
    // Arrange and Act
    PaperPlayerGameConnection actualPaperPlayerGameConnection =
        new PaperPlayerGameConnection(mock(ServerGamePacketListenerImpl.class));

    // Assert
    assertNull(actualPaperPlayerGameConnection.getPlayer());
    assertFalse(actualPaperPlayerGameConnection.isTransferred());
    assertFalse(actualPaperPlayerGameConnection.isAwaitingCookies());
  }
}
