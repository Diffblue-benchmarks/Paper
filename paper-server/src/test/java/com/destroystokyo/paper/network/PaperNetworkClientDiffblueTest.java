package com.destroystokyo.paper.network;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperNetworkClientDiffblueTest {
  /**
   * Test {@link PaperNetworkClient#prepareVirtualHost(String, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return HostName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperNetworkClient#prepareVirtualHost(String, int)}
   */
  @Test
  @DisplayName(
      "Test prepareVirtualHost(String, int); when empty string; then return HostName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InetSocketAddress PaperNetworkClient.prepareVirtualHost(String, int)"})
  void testPrepareVirtualHost_whenEmptyString_thenReturnHostNameIsEmptyString() {
    // Arrange and Act
    InetSocketAddress actualPrepareVirtualHostResult =
        PaperNetworkClient.prepareVirtualHost("", 8080);

    // Assert
    assertEquals("", actualPrepareVirtualHostResult.getHostName());
    assertEquals("", actualPrepareVirtualHostResult.getHostString());
    assertNull(actualPrepareVirtualHostResult.getAddress());
    assertEquals(8080, actualPrepareVirtualHostResult.getPort());
    assertTrue(actualPrepareVirtualHostResult.isUnresolved());
  }

  /**
   * Test {@link PaperNetworkClient#prepareVirtualHost(String, int)}.
   *
   * <ul>
   *   <li>When {@code localhost}.
   *   <li>Then return HostName is {@code localhost}.
   * </ul>
   *
   * <p>Method under test: {@link PaperNetworkClient#prepareVirtualHost(String, int)}
   */
  @Test
  @DisplayName(
      "Test prepareVirtualHost(String, int); when 'localhost'; then return HostName is 'localhost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InetSocketAddress PaperNetworkClient.prepareVirtualHost(String, int)"})
  void testPrepareVirtualHost_whenLocalhost_thenReturnHostNameIsLocalhost() {
    // Arrange and Act
    InetSocketAddress actualPrepareVirtualHostResult =
        PaperNetworkClient.prepareVirtualHost("localhost", 8080);

    // Assert
    assertEquals("localhost", actualPrepareVirtualHostResult.getHostName());
    assertEquals("localhost", actualPrepareVirtualHostResult.getHostString());
    assertNull(actualPrepareVirtualHostResult.getAddress());
    assertEquals(8080, actualPrepareVirtualHostResult.getPort());
    assertTrue(actualPrepareVirtualHostResult.isUnresolved());
  }
}
