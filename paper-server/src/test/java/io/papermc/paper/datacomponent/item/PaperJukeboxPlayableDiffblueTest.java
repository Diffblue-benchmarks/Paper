package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.util.Either;
import net.minecraft.world.item.EitherHolder;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.JukeboxSong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperJukeboxPlayableDiffblueTest {
  /**
   * Test {@link PaperJukeboxPlayable#getHandle()}.
   *
   * <p>Method under test: {@link PaperJukeboxPlayable#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JukeboxPlayable PaperJukeboxPlayable.getHandle()"})
  void testGetHandle() {
    // Arrange
    EitherHolder<JukeboxSong> song = new EitherHolder<>(mock(Either.class));
    JukeboxPlayable impl = new JukeboxPlayable(song);

    // Act
    JukeboxPlayable actualHandle = new PaperJukeboxPlayable(impl).getHandle();

    // Assert
    assertSame(song, actualHandle.song());
    assertSame(impl, actualHandle);
  }
}
