package com.destroystokyo.paper.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import java.util.UUID;
import net.minecraft.Util;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VelocityProxyDiffblueTest {
  /**
   * Test {@link VelocityProxy#readSignerUuidOrElse(FriendlyByteBuf, UUID)}.
   *
   * <ul>
   *   <li>Then return toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link VelocityProxy#readSignerUuidOrElse(FriendlyByteBuf, UUID)}
   */
  @Test
  @DisplayName(
      "Test readSignerUuidOrElse(FriendlyByteBuf, UUID); then return toString is '00000000-0000-0001-0000-000000000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID VelocityProxy.readSignerUuidOrElse(FriendlyByteBuf, UUID)"})
  void testReadSignerUuidOrElse_thenReturnToStringIs00000000000000010000000000000001() {
    // Arrange
    ByteBuf source = mock(ByteBuf.class);
    when(source.readLong()).thenReturn(1L);
    when(source.readBoolean()).thenReturn(true);
    RegistryFriendlyByteBuf source2 =
        new RegistryFriendlyByteBuf(source, mock(RegistryAccess.class));

    // Act
    UUID actualReadSignerUuidOrElseResult =
        VelocityProxy.readSignerUuidOrElse(new FriendlyByteBuf(source2), Util.NIL_UUID);

    // Assert
    verify(source).readBoolean();
    verify(source, atLeast(1)).readLong();
    assertEquals(
        "00000000-0000-0001-0000-000000000001", actualReadSignerUuidOrElseResult.toString());
  }
}
