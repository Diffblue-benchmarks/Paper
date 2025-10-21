package ca.spottedleaf.moonrise.patches.chunk_system.level.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChunkEntitySlicesDiffblueTest {
  /**
   * Test {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}.
   *
   * <ul>
   *   <li>Given {@link ListTag#ListTag()} add {@link ByteTag#ONE}.
   *   <li>When {@link CompoundTag#CompoundTag()}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test copyEntities(CompoundTag, CompoundTag); given ListTag() add ONE; when CompoundTag(); then CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkEntitySlices.copyEntities(CompoundTag, CompoundTag)"})
  void testCopyEntities_givenListTagAddOne_whenCompoundTag_thenCompoundTagSizeIsOne() {
    // Arrange
    ListTag listTag = new ListTag();
    listTag.add(ByteTag.ONE);

    CompoundTag from = mock(CompoundTag.class);
    when(from.getListOrEmpty(Mockito.<String>any())).thenReturn(listTag);
    CompoundTag into = new CompoundTag();

    // Act
    ChunkEntitySlices.copyEntities(from, into);

    // Assert
    verify(from).getListOrEmpty("Entities");
    assertEquals(1, into.size());
    assertFalse(into.isEmpty());
  }

  /**
   * Test {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test copyEntities(CompoundTag, CompoundTag); given 'null'; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkEntitySlices.copyEntities(CompoundTag, CompoundTag)"})
  void testCopyEntities_givenNull_thenCompoundTagSizeIsZero() {
    // Arrange
    CompoundTag from = mock(CompoundTag.class);
    when(from.getListOrEmpty(Mockito.<String>any())).thenReturn(null);
    CompoundTag into = new CompoundTag();

    // Act
    ChunkEntitySlices.copyEntities(from, into);

    // Assert that nothing has changed
    verify(from).getListOrEmpty("Entities");
    assertEquals(0, into.size());
    assertTrue(into.isEmpty());
  }

  /**
   * Test {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}.
   *
   * <ul>
   *   <li>Given {@link ByteTag#ONE}.
   *   <li>When {@link CompoundTag} {@link CompoundTag#put(String, Tag)} return {@link ByteTag#ONE}.
   *   <li>Then calls {@link CompoundTag#put(String, Tag)}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkEntitySlices#copyEntities(CompoundTag, CompoundTag)}
   */
  @Test
  @DisplayName(
      "Test copyEntities(CompoundTag, CompoundTag); given ONE; when CompoundTag put(String, Tag) return ONE; then calls put(String, Tag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkEntitySlices.copyEntities(CompoundTag, CompoundTag)"})
  void testCopyEntities_givenOne_whenCompoundTagPutReturnOne_thenCallsPut() {
    // Arrange
    ListTag listTag = new ListTag();
    listTag.add(ByteTag.ONE);

    CompoundTag from = mock(CompoundTag.class);
    when(from.getListOrEmpty(Mockito.<String>any())).thenReturn(listTag);

    CompoundTag into = mock(CompoundTag.class);
    when(into.getListOrEmpty(Mockito.<String>any())).thenReturn(new ListTag());
    when(into.put(Mockito.<String>any(), Mockito.<net.minecraft.nbt.Tag>any()))
        .thenReturn(ByteTag.ONE);

    // Act
    ChunkEntitySlices.copyEntities(from, into);

    // Assert
    verify(from).getListOrEmpty("Entities");
    verify(into).getListOrEmpty("Entities");
    verify(into).put(eq("Entities"), isA(net.minecraft.nbt.Tag.class));
  }
}
