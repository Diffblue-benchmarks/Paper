package com.destroystokyo.paper.loottable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.loottable.PaperLootableInventoryData.LootTableInterface;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Codec;
import java.util.UUID;
import java.util.function.Consumer;
import net.minecraft.Util;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueInput.TypedInputList;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueOutput.TypedOutputList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class PaperLootableInventoryDataDiffblueTest {
  /**
   * Test {@link PaperLootableInventoryData#shouldReplenish(Object, LootTableInterface, Player)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#shouldReplenish(Object,
   * LootTableInterface, Player)}
   */
  @Test
  @DisplayName(
      "Test shouldReplenish(Object, LootTableInterface, Player); given 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaperLootableInventoryData.shouldReplenish(Object, LootTableInterface, Player)"
  })
  void testShouldReplenish_givenFalse_thenReturnFalse() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();

    LootTableInterface<Object> holderInterface = mock(LootTableInterface.class);
    when(holderInterface.hasLootTable(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualShouldReplenishResult =
        paperLootableInventoryData.shouldReplenish(
            ConfigurationTransformation.WILDCARD_OBJECT, holderInterface, null);

    // Assert
    verify(holderInterface).hasLootTable(isA(Object.class));
    assertFalse(actualShouldReplenishResult);
  }

  /**
   * Test {@link PaperLootableInventoryData#shouldReplenish(Object, LootTableInterface, Player)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#shouldReplenish(Object,
   * LootTableInterface, Player)}
   */
  @Test
  @DisplayName(
      "Test shouldReplenish(Object, LootTableInterface, Player); given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaperLootableInventoryData.shouldReplenish(Object, LootTableInterface, Player)"
  })
  void testShouldReplenish_givenTrue_thenReturnTrue() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();

    LootTableInterface<Object> holderInterface = mock(LootTableInterface.class);
    when(holderInterface.hasLootTable(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualShouldReplenishResult =
        paperLootableInventoryData.shouldReplenish(
            ConfigurationTransformation.WILDCARD_OBJECT, holderInterface, null);

    // Assert
    verify(holderInterface).hasLootTable(isA(Object.class));
    assertTrue(actualShouldReplenishResult);
  }

  /**
   * Test {@link PaperLootableInventoryData#loadNbt(ValueInput)}.
   *
   * <ul>
   *   <li>Given {@link ValueInput.TypedInputList} {@link ValueInput.TypedInputList#isEmpty()}
   *       return {@code false}.
   *   <li>Then calls {@link ValueInput.TypedInputList#forEach(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#loadNbt(ValueInput)}
   */
  @Test
  @DisplayName(
      "Test loadNbt(ValueInput); given TypedInputList isEmpty() return 'false'; then calls forEach(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.loadNbt(ValueInput)"})
  void testLoadNbt_givenTypedInputListIsEmptyReturnFalse_thenCallsForEach() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();

    TypedInputList<Object> typedInputList = mock(TypedInputList.class);
    when(typedInputList.isEmpty()).thenReturn(false);
    doNothing().when(typedInputList).forEach(Mockito.<Consumer<Object>>any());

    ValueInput valueInput = mock(ValueInput.class);
    when(valueInput.getIntOr(Mockito.<String>any(), anyInt())).thenReturn(1);
    when(valueInput.getLongOr(Mockito.<String>any(), anyLong())).thenReturn(1L);
    when(valueInput.listOrEmpty(Mockito.<String>any(), Mockito.<Codec<Object>>any()))
        .thenReturn(typedInputList);

    ValueInput input = mock(ValueInput.class);
    when(input.childOrEmpty(Mockito.<String>any())).thenReturn(valueInput);

    // Act
    paperLootableInventoryData.loadNbt(input);

    // Assert
    verify(typedInputList).forEach(isA(Consumer.class));
    verify(input).childOrEmpty("Paper.LootableData");
    verify(valueInput).getIntOr("numRefills", 0);
    verify(valueInput, atLeast(1)).getLongOr(Mockito.<String>any(), eq(-1L));
    verify(valueInput).listOrEmpty(eq("lootedPlayers"), isA(Codec.class));
    verify(typedInputList).isEmpty();
    assertEquals(1L, paperLootableInventoryData.getLastFill());
    assertEquals(1L, paperLootableInventoryData.getNextRefill());
  }

  /**
   * Test {@link PaperLootableInventoryData#loadNbt(ValueInput)}.
   *
   * <ul>
   *   <li>Given {@link ValueInput.TypedInputList} {@link ValueInput.TypedInputList#isEmpty()}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#loadNbt(ValueInput)}
   */
  @Test
  @DisplayName("Test loadNbt(ValueInput); given TypedInputList isEmpty() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.loadNbt(ValueInput)"})
  void testLoadNbt_givenTypedInputListIsEmptyReturnTrue() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();

    TypedInputList<Object> typedInputList = mock(TypedInputList.class);
    when(typedInputList.isEmpty()).thenReturn(true);

    ValueInput valueInput = mock(ValueInput.class);
    when(valueInput.getIntOr(Mockito.<String>any(), anyInt())).thenReturn(1);
    when(valueInput.getLongOr(Mockito.<String>any(), anyLong())).thenReturn(1L);
    when(valueInput.listOrEmpty(Mockito.<String>any(), Mockito.<Codec<Object>>any()))
        .thenReturn(typedInputList);

    ValueInput input = mock(ValueInput.class);
    when(input.childOrEmpty(Mockito.<String>any())).thenReturn(valueInput);

    // Act
    paperLootableInventoryData.loadNbt(input);

    // Assert
    verify(input).childOrEmpty("Paper.LootableData");
    verify(valueInput).getIntOr("numRefills", 0);
    verify(valueInput, atLeast(1)).getLongOr(Mockito.<String>any(), eq(-1L));
    verify(valueInput).listOrEmpty(eq("lootedPlayers"), isA(Codec.class));
    verify(typedInputList).isEmpty();
    assertEquals(1L, paperLootableInventoryData.getLastFill());
    assertEquals(1L, paperLootableInventoryData.getNextRefill());
  }

  /**
   * Test {@link PaperLootableInventoryData#saveNbt(ValueOutput)}.
   *
   * <ul>
   *   <li>Given {@link PaperLootableInventoryData} (default constructor).
   *   <li>Then calls {@link TagValueOutput#discard(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#saveNbt(ValueOutput)}
   */
  @Test
  @DisplayName(
      "Test saveNbt(ValueOutput); given PaperLootableInventoryData (default constructor); then calls discard(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.saveNbt(ValueOutput)"})
  void testSaveNbt_givenPaperLootableInventoryData_thenCallsDiscard() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();

    TagValueOutput tagValueOutput = mock(TagValueOutput.class);
    when(tagValueOutput.isEmpty()).thenReturn(true);

    TagValueOutput output = mock(TagValueOutput.class);
    doNothing().when(output).discard(Mockito.<String>any());
    when(output.child(Mockito.<String>any())).thenReturn(tagValueOutput);

    // Act
    paperLootableInventoryData.saveNbt(output);

    // Assert
    verify(output).child("Paper.LootableData");
    verify(output).discard("Paper.LootableData");
    verify(tagValueOutput).isEmpty();
  }

  /**
   * Test {@link PaperLootableInventoryData#saveNbt(ValueOutput)}.
   *
   * <ul>
   *   <li>Given {@link TagValueOutput} {@link TagValueOutput#isEmpty()} return {@code false}.
   *   <li>Then calls {@link TagValueOutput#list(String, Codec)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#saveNbt(ValueOutput)}
   */
  @Test
  @DisplayName(
      "Test saveNbt(ValueOutput); given TagValueOutput isEmpty() return 'false'; then calls list(String, Codec)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.saveNbt(ValueOutput)"})
  void testSaveNbt_givenTagValueOutputIsEmptyReturnFalse_thenCallsList() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();
    paperLootableInventoryData.setPlayerLootedState(Util.NIL_UUID, true);

    TypedOutputList<Object> typedOutputList = mock(TypedOutputList.class);
    doNothing().when(typedOutputList).add(Mockito.<Object>any());

    TagValueOutput tagValueOutput = mock(TagValueOutput.class);
    when(tagValueOutput.list(Mockito.<String>any(), Mockito.<Codec<Object>>any()))
        .thenReturn(typedOutputList);
    when(tagValueOutput.isEmpty()).thenReturn(false);

    TagValueOutput output = mock(TagValueOutput.class);
    when(output.child(Mockito.<String>any())).thenReturn(tagValueOutput);

    // Act
    paperLootableInventoryData.saveNbt(output);

    // Assert
    verify(output).child("Paper.LootableData");
    verify(tagValueOutput).isEmpty();
    verify(tagValueOutput).list(eq("lootedPlayers"), isA(Codec.class));
    verify(typedOutputList).add(isA(Object.class));
  }

  /**
   * Test {@link PaperLootableInventoryData#saveNbt(ValueOutput)}.
   *
   * <ul>
   *   <li>Given {@link TagValueOutput} {@link TagValueOutput#putLong(String, long)} does nothing.
   *   <li>Then calls {@link TagValueOutput#putLong(String, long)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#saveNbt(ValueOutput)}
   */
  @Test
  @DisplayName(
      "Test saveNbt(ValueOutput); given TagValueOutput putLong(String, long) does nothing; then calls putLong(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.saveNbt(ValueOutput)"})
  void testSaveNbt_givenTagValueOutputPutLongDoesNothing_thenCallsPutLong() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();
    paperLootableInventoryData.setNextRefill(1L);
    paperLootableInventoryData.setPlayerLootedState(Util.NIL_UUID, true);

    TypedOutputList<Object> typedOutputList = mock(TypedOutputList.class);
    doNothing().when(typedOutputList).add(Mockito.<Object>any());

    TagValueOutput tagValueOutput = mock(TagValueOutput.class);
    doNothing().when(tagValueOutput).putLong(Mockito.<String>any(), anyLong());
    when(tagValueOutput.list(Mockito.<String>any(), Mockito.<Codec<Object>>any()))
        .thenReturn(typedOutputList);
    when(tagValueOutput.isEmpty()).thenReturn(true);

    TagValueOutput output = mock(TagValueOutput.class);
    doNothing().when(output).discard(Mockito.<String>any());
    when(output.child(Mockito.<String>any())).thenReturn(tagValueOutput);

    // Act
    paperLootableInventoryData.saveNbt(output);

    // Assert
    verify(output).child("Paper.LootableData");
    verify(output).discard("Paper.LootableData");
    verify(tagValueOutput).isEmpty();
    verify(tagValueOutput).list(eq("lootedPlayers"), isA(Codec.class));
    verify(tagValueOutput).putLong("nextRefill", 1L);
    verify(typedOutputList).add(isA(Object.class));
  }

  /**
   * Test {@link PaperLootableInventoryData#saveNbt(ValueOutput)}.
   *
   * <ul>
   *   <li>Given {@link ValueOutput.TypedOutputList} {@link ValueOutput.TypedOutputList#add(Object)}
   *       does nothing.
   *   <li>Then calls {@link TagValueOutput#discard(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#saveNbt(ValueOutput)}
   */
  @Test
  @DisplayName(
      "Test saveNbt(ValueOutput); given TypedOutputList add(Object) does nothing; then calls discard(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperLootableInventoryData.saveNbt(ValueOutput)"})
  void testSaveNbt_givenTypedOutputListAddDoesNothing_thenCallsDiscard() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();
    paperLootableInventoryData.setPlayerLootedState(Util.NIL_UUID, true);

    TypedOutputList<Object> typedOutputList = mock(TypedOutputList.class);
    doNothing().when(typedOutputList).add(Mockito.<Object>any());

    TagValueOutput tagValueOutput = mock(TagValueOutput.class);
    when(tagValueOutput.list(Mockito.<String>any(), Mockito.<Codec<Object>>any()))
        .thenReturn(typedOutputList);
    when(tagValueOutput.isEmpty()).thenReturn(true);

    TagValueOutput output = mock(TagValueOutput.class);
    doNothing().when(output).discard(Mockito.<String>any());
    when(output.child(Mockito.<String>any())).thenReturn(tagValueOutput);

    // Act
    paperLootableInventoryData.saveNbt(output);

    // Assert
    verify(output).child("Paper.LootableData");
    verify(output).discard("Paper.LootableData");
    verify(tagValueOutput).isEmpty();
    verify(tagValueOutput).list(eq("lootedPlayers"), isA(Codec.class));
    verify(typedOutputList).add(isA(Object.class));
  }

  /**
   * Test {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}.
   *
   * <p>Method under test: {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}
   */
  @Test
  @DisplayName("Test hasPlayerLooted(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperLootableInventoryData.hasPlayerLooted(UUID)"})
  void testHasPlayerLooted() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();
    paperLootableInventoryData.setPlayerLootedState(UUID.randomUUID(), true);

    // Act and Assert
    assertFalse(paperLootableInventoryData.hasPlayerLooted(Util.NIL_UUID));
  }

  /**
   * Test {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}.
   *
   * <ul>
   *   <li>Given {@link PaperLootableInventoryData} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}
   */
  @Test
  @DisplayName(
      "Test hasPlayerLooted(UUID); given PaperLootableInventoryData (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperLootableInventoryData.hasPlayerLooted(UUID)"})
  void testHasPlayerLooted_givenPaperLootableInventoryData_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaperLootableInventoryData().hasPlayerLooted(Util.NIL_UUID));
  }

  /**
   * Test {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#hasPlayerLooted(UUID)}
   */
  @Test
  @DisplayName("Test hasPlayerLooted(UUID); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperLootableInventoryData.hasPlayerLooted(UUID)"})
  void testHasPlayerLooted_thenReturnTrue() {
    // Arrange
    PaperLootableInventoryData paperLootableInventoryData = new PaperLootableInventoryData();
    paperLootableInventoryData.setPlayerLootedState(Util.NIL_UUID, true);

    // Act and Assert
    assertTrue(paperLootableInventoryData.hasPlayerLooted(Util.NIL_UUID));
  }

  /**
   * Test {@link PaperLootableInventoryData#getLastLooted(UUID)}.
   *
   * <ul>
   *   <li>Given {@link PaperLootableInventoryData} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperLootableInventoryData#getLastLooted(UUID)}
   */
  @Test
  @DisplayName(
      "Test getLastLooted(UUID); given PaperLootableInventoryData (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long PaperLootableInventoryData.getLastLooted(UUID)"})
  void testGetLastLooted_givenPaperLootableInventoryData_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PaperLootableInventoryData().getLastLooted(Util.NIL_UUID));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PaperLootableInventoryData}
   *   <li>{@link PaperLootableInventoryData#setNextRefill(long)}
   *   <li>{@link PaperLootableInventoryData#getLastFill()}
   *   <li>{@link PaperLootableInventoryData#getNextRefill()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperLootableInventoryData.<init>()",
    "long PaperLootableInventoryData.getLastFill()",
    "long PaperLootableInventoryData.getNextRefill()",
    "long PaperLootableInventoryData.setNextRefill(long)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PaperLootableInventoryData actualPaperLootableInventoryData = new PaperLootableInventoryData();
    long actualSetNextRefillResult = actualPaperLootableInventoryData.setNextRefill(1L);
    long actualLastFill = actualPaperLootableInventoryData.getLastFill();

    // Assert
    assertEquals(-1L, actualLastFill);
    assertEquals(-1L, actualSetNextRefillResult);
    assertEquals(1L, actualPaperLootableInventoryData.getNextRefill());
  }
}
