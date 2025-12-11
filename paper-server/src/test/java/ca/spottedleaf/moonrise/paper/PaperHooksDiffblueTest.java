package ca.spottedleaf.moonrise.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DSL.TypeReference;
import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.fixes.References;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaperHooksDiffblueTest {
  /**
   * Test {@link PaperHooks#allowAsyncTicketUpdates()}.
   *
   * <p>Method under test: {@link PaperHooks#allowAsyncTicketUpdates()}
   */
  @Test
  @DisplayName("Test allowAsyncTicketUpdates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperHooks.allowAsyncTicketUpdates()"})
  void testAllowAsyncTicketUpdates() {
    // Arrange, Act and Assert
    assertTrue(new PaperHooks().allowAsyncTicketUpdates());
  }

  /**
   * Test {@link PaperHooks#configFixMC224294()}.
   *
   * <p>Method under test: {@link PaperHooks#configFixMC224294()}
   */
  @Test
  @DisplayName("Test configFixMC224294()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperHooks.configFixMC224294()"})
  void testConfigFixMC224294() {
    // Arrange, Act and Assert
    assertTrue(new PaperHooks().configFixMC224294());
  }

  /**
   * Test {@link PaperHooks#configFixMC159283()}.
   *
   * <p>Method under test: {@link PaperHooks#configFixMC159283()}
   */
  @Test
  @DisplayName("Test configFixMC159283()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperHooks.configFixMC159283()"})
  void testConfigFixMC159283() {
    // Arrange, Act and Assert
    assertTrue(new PaperHooks().configFixMC159283());
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Dynamic} {@link Dynamic#getValue()} return {@link
   *       CompoundTag#CompoundTag()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); given Dynamic getValue() return CompoundTag(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_givenDynamicGetValueReturnCompoundTag_thenReturnSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    TypeReference type = mock(TypeReference.class);

    Dynamic<Object> dynamic = mock(Dynamic.class);
    when(dynamic.getValue()).thenReturn(new CompoundTag());

    DataFixer dataFixer = mock(DataFixer.class);
    when(dataFixer.update(
            Mockito.<TypeReference>any(), Mockito.<Dynamic<Object>>any(), anyInt(), anyInt()))
        .thenReturn(dynamic);

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(type, dataFixer, new CompoundTag(), 1, 1);

    // Assert
    verify(dataFixer).update(isA(TypeReference.class), isA(Dynamic.class), eq(1), eq(1));
    verify(dynamic).getValue();
    assertEquals(0, actualConvertNBTResult.size());
    assertTrue(actualConvertNBTResult.isEmpty());
    assertEquals('\n', actualConvertNBTResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertNBTResult.getType());
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Dynamic} {@link Dynamic#getValue()} return {@link
   *       CompoundTag#CompoundTag()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); given Dynamic getValue() return CompoundTag(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_givenDynamicGetValueReturnCompoundTag_thenReturnSizeIsZero2() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    TypeReference type = mock(TypeReference.class);

    Dynamic<Object> dynamic = mock(Dynamic.class);
    when(dynamic.getValue()).thenReturn(new CompoundTag());

    DataFixer dataFixer = mock(DataFixer.class);
    when(dataFixer.update(
            Mockito.<TypeReference>any(), Mockito.<Dynamic<Object>>any(), anyInt(), anyInt()))
        .thenReturn(dynamic);

    // Act
    CompoundTag actualConvertNBTResult = paperHooks.convertNBT(type, dataFixer, null, 1, 1);

    // Assert
    verify(dataFixer).update(isA(TypeReference.class), isA(Dynamic.class), eq(1), eq(1));
    verify(dynamic).getValue();
    assertEquals(0, actualConvertNBTResult.size());
    assertTrue(actualConvertNBTResult.isEmpty());
    assertEquals('\n', actualConvertNBTResult.getId());
    assertSame(CompoundTag.TYPE, actualConvertNBTResult.getType());
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#CHUNK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when CHUNK; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenChunk_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.CHUNK, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#ENTITY_CHUNK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ENTITY_CHUNK; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenEntity_chunk_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.ENTITY_CHUNK, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#ENTITY}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ENTITY; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenEntity_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.ENTITY, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#ENTITY_TREE}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ENTITY_TREE; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenEntity_tree_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.ENTITY_TREE, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#ITEM_STACK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ITEM_STACK; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenItem_stack_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.ITEM_STACK, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#ITEM_STACK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ITEM_STACK; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenItem_stack_thenCompoundTagSizeIsZero2() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.ITEM_STACK, dataFixer, nbt, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertEquals(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When ninety-nine.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when ninety-nine; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenNinetyNine_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.STRUCTURE, dataFixer, nbt, 1, 99);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#PLAYER}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when PLAYER; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenPlayer_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.PLAYER, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#PLAYER}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when PLAYER; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenPlayer_thenCompoundTagSizeIsZero2() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.PLAYER, dataFixer, nbt, Integer.MAX_VALUE, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#PLAYER}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when PLAYER; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenPlayer_thenCompoundTagSizeIsZero3() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.PLAYER, dataFixer, nbt, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#POI_CHUNK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when POI_CHUNK; then CompoundTag() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenPoi_chunk_thenCompoundTagSizeIsOne() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.POI_CHUNK, dataFixer, nbt, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(1, nbt.size());
    assertEquals(1, actualConvertNBTResult.size());
    assertFalse(nbt.isEmpty());
    assertFalse(actualConvertNBTResult.isEmpty());
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#POI_CHUNK}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when POI_CHUNK; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenPoi_chunk_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.POI_CHUNK, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#STRUCTURE}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when STRUCTURE; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenStructure_thenCompoundTagSizeIsZero() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.STRUCTURE, dataFixer, nbt, 1, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#STRUCTURE}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when STRUCTURE; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenStructure_thenCompoundTagSizeIsZero2() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.STRUCTURE, dataFixer, nbt, Integer.MAX_VALUE, 1);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <ul>
   *   <li>When {@link References#STRUCTURE}.
   *   <li>Then {@link CompoundTag#CompoundTag()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int); when STRUCTURE; then CompoundTag() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT_whenStructure_thenCompoundTagSizeIsZero3() {
    // Arrange
    PaperHooks paperHooks = new PaperHooks();
    DataFixer dataFixer = mock(DataFixer.class);
    CompoundTag nbt = new CompoundTag();

    // Act
    CompoundTag actualConvertNBTResult =
        paperHooks.convertNBT(References.STRUCTURE, dataFixer, nbt, 1, Integer.MAX_VALUE);

    // Assert
    assertEquals(0, nbt.size());
    assertTrue(nbt.isEmpty());
    assertSame(nbt, actualConvertNBTResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PaperHooks}
   *   <li>{@link PaperHooks#getBrand()}
   *   <li>{@link PaperHooks#hasCurrentlyLoadingChunk()}
   *   <li>{@link PaperHooks#hasMainChunkLoadHook()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperHooks.<init>()",
    "void PaperHooks.chunkFullStatusComplete(net.minecraft.world.level.chunk.LevelChunk, net.minecraft.world.level.chunk.ProtoChunk)",
    "void PaperHooks.chunkSyncSave(net.minecraft.server.level.ServerLevel, net.minecraft.world.level.chunk.ChunkAccess, net.minecraft.world.level.chunk.storage.SerializableChunkData)",
    "void PaperHooks.chunkUnloadFromWorld(net.minecraft.world.level.chunk.LevelChunk)",
    "void PaperHooks.entityMove(net.minecraft.world.entity.Entity, long, long)",
    "String PaperHooks.getBrand()",
    "boolean PaperHooks.hasCurrentlyLoadingChunk()",
    "boolean PaperHooks.hasMainChunkLoadHook()",
    "void PaperHooks.mainChunkLoad(net.minecraft.world.level.chunk.ChunkAccess, net.minecraft.world.level.chunk.storage.SerializableChunkData)",
    "void PaperHooks.onChunkHolderTicketChange(net.minecraft.server.level.ServerLevel, net.minecraft.server.level.ChunkHolder, int, int)",
    "void PaperHooks.onChunkUnWatch(net.minecraft.server.level.ServerLevel, net.minecraft.world.level.ChunkPos, net.minecraft.server.level.ServerPlayer)",
    "void PaperHooks.onChunkWatch(net.minecraft.server.level.ServerLevel, net.minecraft.world.level.chunk.LevelChunk, net.minecraft.server.level.ServerPlayer)",
    "void PaperHooks.setCurrentlyLoading(net.minecraft.server.level.GenerationChunkHolder, net.minecraft.world.level.chunk.LevelChunk)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PaperHooks actualPaperHooks = new PaperHooks();
    String actualBrand = actualPaperHooks.getBrand();
    boolean actualHasCurrentlyLoadingChunkResult = actualPaperHooks.hasCurrentlyLoadingChunk();

    // Assert
    assertEquals("Paper", actualBrand);
    assertFalse(actualHasCurrentlyLoadingChunkResult);
    assertFalse(actualPaperHooks.hasMainChunkLoadHook());
  }
}
