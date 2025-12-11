package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.level.saveddata.maps.MapId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperMapIdDiffblueTest {
  /**
   * Test {@link PaperMapId#getHandle()}.
   *
   * <p>Method under test: {@link PaperMapId#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapId PaperMapId.getHandle()"})
  void testGetHandle() {
    // Arrange
    MapId impl = new MapId(1);

    // Act
    MapId actualHandle = new PaperMapId(impl).getHandle();

    // Assert
    assertEquals(1, actualHandle.id());
    assertSame(impl, actualHandle);
  }

  /**
   * Test {@link PaperMapId#id()}.
   *
   * <ul>
   *   <li>Given {@link MapId#MapId(int)} with id is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperMapId#id()}
   */
  @Test
  @DisplayName("Test id(); given MapId(int) with id is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperMapId.id()"})
  void testId_givenMapIdWithIdIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new PaperMapId(new MapId(1)).id());
  }
}
