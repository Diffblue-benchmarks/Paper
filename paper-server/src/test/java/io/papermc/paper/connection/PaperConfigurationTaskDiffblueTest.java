package io.papermc.paper.connection;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperConfigurationTaskDiffblueTest {
  /**
   * Test {@link PaperConfigurationTask#type()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PaperConfigurationTask#PaperConfigurationTask(ServerConfigurationPacketListenerImpl)}
   *       with packetListener is {@code null}.
   *   <li>Then return {@link PaperConfigurationTask#TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurationTask#type()}
   */
  @Test
  @DisplayName(
      "Test type(); given PaperConfigurationTask(ServerConfigurationPacketListenerImpl) with packetListener is 'null'; then return TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.server.network.ConfigurationTask.Type PaperConfigurationTask.type()"
  })
  void testType_givenPaperConfigurationTaskWithPacketListenerIsNull_thenReturnType() {
    // Arrange, Act and Assert
    assertSame(PaperConfigurationTask.TYPE, new PaperConfigurationTask(null).type());
  }
}
