package ca.spottedleaf.moonrise.patches.starlight.light;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.starlight.light.SWMRNibbleArray.SaveState;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import net.minecraft.world.level.chunk.DataLayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SWMRNibbleArrayDiffblueTest {
  /**
   * Test {@link SWMRNibbleArray#fromVanilla(DataLayer)}.
   *
   * <ul>
   *   <li>When {@link DataLayer#DataLayer(int)} with size is three.
   *   <li>Then return {@link SWMRNibbleArray#stateUpdating} is two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#fromVanilla(DataLayer)}
   */
  @Test
  @DisplayName(
      "Test fromVanilla(DataLayer); when DataLayer(int) with size is three; then return stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SWMRNibbleArray SWMRNibbleArray.fromVanilla(DataLayer)"})
  void testFromVanilla_whenDataLayerWithSizeIsThree_thenReturnStateUpdatingIsTwo() {
    // Arrange and Act
    SWMRNibbleArray actualFromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Assert
    assertEquals(2, actualFromVanillaResult.stateUpdating);
    assertEquals(2, actualFromVanillaResult.stateVisible);
    assertTrue(actualFromVanillaResult.isInitialisedUpdating());
    assertTrue(actualFromVanillaResult.isInitialisedVisible());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, actualFromVanillaResult.storageUpdating.length);
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, actualFromVanillaResult.storageVisible.length);
  }

  /**
   * Test {@link SWMRNibbleArray#fromVanilla(DataLayer)}.
   *
   * <ul>
   *   <li>When {@link DataLayer#DataLayer(int)} with size is zero.
   *   <li>Then return SaveState {@link SaveState#data} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#fromVanilla(DataLayer)}
   */
  @Test
  @DisplayName(
      "Test fromVanilla(DataLayer); when DataLayer(int) with size is zero; then return SaveState data is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SWMRNibbleArray SWMRNibbleArray.fromVanilla(DataLayer)"})
  void testFromVanilla_whenDataLayerWithSizeIsZero_thenReturnSaveStateDataIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualFromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(0));

    // Assert
    SaveState saveState = actualFromVanillaResult.getSaveState();
    assertNull(saveState.data);
    assertEquals(1, actualFromVanillaResult.stateUpdating);
    assertEquals(1, actualFromVanillaResult.stateVisible);
    assertEquals(1, saveState.state);
    assertTrue(actualFromVanillaResult.isUninitialisedUpdating());
    assertTrue(actualFromVanillaResult.isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#fromVanilla(DataLayer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SaveState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#fromVanilla(DataLayer)}
   */
  @Test
  @DisplayName("Test fromVanilla(DataLayer); when 'null'; then return SaveState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SWMRNibbleArray SWMRNibbleArray.fromVanilla(DataLayer)"})
  void testFromVanilla_whenNull_thenReturnSaveStateIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualFromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Assert
    assertNull(actualFromVanillaResult.getSaveState());
    assertEquals(0, actualFromVanillaResult.stateUpdating);
    assertEquals(0, actualFromVanillaResult.stateVisible);
    assertTrue(actualFromVanillaResult.isNullNibbleUpdating());
    assertTrue(actualFromVanillaResult.isNullNibbleVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray()}
   */
  @Test
  @DisplayName("Test new SWMRNibbleArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>()"})
  void testNewSWMRNibbleArray() {
    // Arrange and Act
    SWMRNibbleArray actualSwmrNibbleArray = new SWMRNibbleArray();

    // Assert
    assertNull(actualSwmrNibbleArray.storageUpdating);
    assertNull(actualSwmrNibbleArray.storageVisible);
    assertEquals(1, actualSwmrNibbleArray.stateUpdating);
    assertEquals(1, actualSwmrNibbleArray.stateVisible);
    assertFalse(actualSwmrNibbleArray.isDirty());
    assertFalse(actualSwmrNibbleArray.isHiddenUpdating());
    assertFalse(actualSwmrNibbleArray.isHiddenVisible());
    assertFalse(actualSwmrNibbleArray.isInitialisedUpdating());
    assertFalse(actualSwmrNibbleArray.isInitialisedVisible());
    assertFalse(actualSwmrNibbleArray.isNullNibbleUpdating());
    assertFalse(actualSwmrNibbleArray.isNullNibbleVisible());
    assertFalse(actualSwmrNibbleArray.updatingDirty);
    assertTrue(actualSwmrNibbleArray.isUninitialisedUpdating());
    assertTrue(actualSwmrNibbleArray.isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[])}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[])"})
  void testNewSWMRNibbleArray_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SWMRNibbleArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], int)"})
  void testNewSWMRNibbleArray_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SWMRNibbleArray("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], boolean); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], boolean)"})
  void testNewSWMRNibbleArray_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new SWMRNibbleArray("AXAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return SaveState {@link SaveState#data} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], boolean); when 'false'; then return SaveState data is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], boolean)"})
  void testNewSWMRNibbleArray_whenFalse_thenReturnSaveStateDataIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualSwmrNibbleArray = new SWMRNibbleArray(null, false);

    // Assert
    SaveState saveState = actualSwmrNibbleArray.getSaveState();
    assertNull(saveState.data);
    assertEquals(1, actualSwmrNibbleArray.stateUpdating);
    assertEquals(1, actualSwmrNibbleArray.stateVisible);
    assertEquals(1, saveState.state);
    assertFalse(actualSwmrNibbleArray.isNullNibbleUpdating());
    assertFalse(actualSwmrNibbleArray.isNullNibbleVisible());
    assertTrue(actualSwmrNibbleArray.isUninitialisedUpdating());
    assertTrue(actualSwmrNibbleArray.isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SaveState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], boolean); when 'null'; then return SaveState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], boolean)"})
  void testNewSWMRNibbleArray_whenNull_thenReturnSaveStateIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualSwmrNibbleArray = new SWMRNibbleArray(null, true);

    // Assert
    assertNull(actualSwmrNibbleArray.getSaveState());
    assertEquals(0, actualSwmrNibbleArray.stateUpdating);
    assertEquals(0, actualSwmrNibbleArray.stateVisible);
    assertFalse(actualSwmrNibbleArray.isUninitialisedUpdating());
    assertFalse(actualSwmrNibbleArray.isUninitialisedVisible());
    assertTrue(actualSwmrNibbleArray.isNullNibbleUpdating());
    assertTrue(actualSwmrNibbleArray.isNullNibbleVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link SWMRNibbleArray#storageUpdating} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[])}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[]); when 'null'; then return storageUpdating is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[])"})
  void testNewSWMRNibbleArray_whenNull_thenReturnStorageUpdatingIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualSwmrNibbleArray = new SWMRNibbleArray(null);

    // Assert
    assertNull(actualSwmrNibbleArray.storageUpdating);
    assertNull(actualSwmrNibbleArray.storageVisible);
    assertEquals(1, actualSwmrNibbleArray.stateUpdating);
    assertEquals(1, actualSwmrNibbleArray.stateVisible);
    assertFalse(actualSwmrNibbleArray.isDirty());
    assertFalse(actualSwmrNibbleArray.isHiddenUpdating());
    assertFalse(actualSwmrNibbleArray.isHiddenVisible());
    assertFalse(actualSwmrNibbleArray.isInitialisedUpdating());
    assertFalse(actualSwmrNibbleArray.isInitialisedVisible());
    assertFalse(actualSwmrNibbleArray.isNullNibbleUpdating());
    assertFalse(actualSwmrNibbleArray.isNullNibbleVisible());
    assertFalse(actualSwmrNibbleArray.updatingDirty);
    assertTrue(actualSwmrNibbleArray.isUninitialisedUpdating());
    assertTrue(actualSwmrNibbleArray.isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link SWMRNibbleArray#storageUpdating} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], int); when one; then return storageUpdating is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], int)"})
  void testNewSWMRNibbleArray_whenOne_thenReturnStorageUpdatingIsNull() {
    // Arrange and Act
    SWMRNibbleArray actualSwmrNibbleArray = new SWMRNibbleArray(null, 1);

    // Assert
    assertNull(actualSwmrNibbleArray.storageUpdating);
    assertNull(actualSwmrNibbleArray.storageVisible);
    assertEquals(1, actualSwmrNibbleArray.stateUpdating);
    assertEquals(1, actualSwmrNibbleArray.stateVisible);
    assertFalse(actualSwmrNibbleArray.isDirty());
    assertFalse(actualSwmrNibbleArray.isHiddenUpdating());
    assertFalse(actualSwmrNibbleArray.isHiddenVisible());
    assertFalse(actualSwmrNibbleArray.isInitialisedUpdating());
    assertFalse(actualSwmrNibbleArray.isInitialisedVisible());
    assertFalse(actualSwmrNibbleArray.isNullNibbleUpdating());
    assertFalse(actualSwmrNibbleArray.isNullNibbleVisible());
    assertFalse(actualSwmrNibbleArray.updatingDirty);
    assertTrue(actualSwmrNibbleArray.isUninitialisedUpdating());
    assertTrue(actualSwmrNibbleArray.isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], int); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], int)"})
  void testNewSWMRNibbleArray_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SWMRNibbleArray(null, 3));
  }

  /**
   * Test {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#SWMRNibbleArray(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test new SWMRNibbleArray(byte[], int); when two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.<init>(byte[], int)"})
  void testNewSWMRNibbleArray_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SWMRNibbleArray(null, 2));
  }

  /**
   * Test SaveState {@link SaveState#SaveState(byte[], int)}.
   *
   * <p>Method under test: {@link SaveState#SaveState(byte[], int)}
   */
  @Test
  @DisplayName("Test SaveState new SaveState(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SaveState.<init>(byte[], int)"})
  void testSaveStateNewSaveState() throws UnsupportedEncodingException {
    // Arrange and Act
    SaveState actualSaveState = new SaveState("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertEquals(1, actualSaveState.state);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSaveState.data);
  }

  /**
   * Test {@link SWMRNibbleArray#toString()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@link DataLayer#DataLayer(int)} with size is three.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given fromVanilla DataLayer(int) with size is three; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SWMRNibbleArray.toString()"})
  void testToString_givenFromVanillaDataLayerWithSizeIsThree_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "State: initialised\n"
            + "Data:\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "3333333333333333\n"
            + "\n",
        SWMRNibbleArray.fromVanilla(new DataLayer(3)).toString());
  }

  /**
   * Test {@link SWMRNibbleArray#toString()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@code null}.
   *   <li>Then return {@code State: null Data: null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toString()}
   */
  @Test
  @DisplayName("Test toString(); given fromVanilla 'null'; then return 'State: null Data: null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SWMRNibbleArray.toString()"})
  void testToString_givenFromVanillaNull_thenReturnStateNullDataNull() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Act and Assert
    assertEquals("State: null\nData:\nnull", fromVanillaResult.toString());
  }

  /**
   * Test {@link SWMRNibbleArray#toString()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code State: uninitialised Data: null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given SWMRNibbleArray(); then return 'State: uninitialised Data: null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SWMRNibbleArray.toString()"})
  void testToString_givenSWMRNibbleArray_thenReturnStateUninitialisedDataNull() {
    // Arrange, Act and Assert
    assertEquals("State: uninitialised\nData:\nnull", new SWMRNibbleArray().toString());
  }

  /**
   * Test {@link SWMRNibbleArray#isAllZero(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isAllZero(byte[])}
   */
  @Test
  @DisplayName("Test isAllZero(byte[]); when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isAllZero(byte[])"})
  void testIsAllZero_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        SWMRNibbleArray.isAllZero(
            new byte[] {
              0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
              'A', 0, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0,
              'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 0
            }));
  }

  /**
   * Test {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}.
   *
   * <ul>
   *   <li>Then fromVanilla {@link DataLayer#DataLayer(int)} with size is three {@link
   *       SWMRNibbleArray#stateUpdating} is two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}
   */
  @Test
  @DisplayName(
      "Test extrudeLower(SWMRNibbleArray); then fromVanilla DataLayer(int) with size is three stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.extrudeLower(SWMRNibbleArray)"})
  void testExtrudeLower_thenFromVanillaDataLayerWithSizeIsThreeStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));
    SWMRNibbleArray other = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.extrudeLower(other);

    // Assert that nothing has changed
    assertEquals(2, other.stateUpdating);
    assertFalse(other.isUninitialisedUpdating());
    assertTrue(other.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, other.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}.
   *
   * <ul>
   *   <li>Then fromVanilla {@link DataLayer#DataLayer(int)} with size is three {@link
   *       SWMRNibbleArray#storageUpdating} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}
   */
  @Test
  @DisplayName(
      "Test extrudeLower(SWMRNibbleArray); then fromVanilla DataLayer(int) with size is three storageUpdating is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.extrudeLower(SWMRNibbleArray)"})
  void testExtrudeLower_thenFromVanillaDataLayerWithSizeIsThreeStorageUpdatingIsNull() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.extrudeLower(new SWMRNibbleArray());

    // Assert
    assertNull(fromVanillaResult.storageUpdating);
    assertEquals(1, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isInitialisedUpdating());
    assertTrue(fromVanillaResult.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}.
   *
   * <ul>
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}
   */
  @Test
  @DisplayName("Test extrudeLower(SWMRNibbleArray); then SWMRNibbleArray() stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.extrudeLower(SWMRNibbleArray)"})
  void testExtrudeLower_thenSWMRNibbleArrayStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.extrudeLower(SWMRNibbleArray.fromVanilla(new DataLayer(3)));

    // Assert
    assertEquals(2, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isInitialisedUpdating());
    assertTrue(swmrNibbleArray.updatingDirty);
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, swmrNibbleArray.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}.
   *
   * <ul>
   *   <li>When fromVanilla {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}
   */
  @Test
  @DisplayName(
      "Test extrudeLower(SWMRNibbleArray); when fromVanilla 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.extrudeLower(SWMRNibbleArray)"})
  void testExtrudeLower_whenFromVanillaNull_thenThrowIllegalArgumentException() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> swmrNibbleArray.extrudeLower(SWMRNibbleArray.fromVanilla(null)));
  }

  /**
   * Test {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}.
   *
   * <ul>
   *   <li>When {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#extrudeLower(SWMRNibbleArray)}
   */
  @Test
  @DisplayName(
      "Test extrudeLower(SWMRNibbleArray); when SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.extrudeLower(SWMRNibbleArray)"})
  void testExtrudeLower_whenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsOne() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();
    SWMRNibbleArray other = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.extrudeLower(other);

    // Assert that nothing has changed
    assertEquals(1, other.stateUpdating);
    assertFalse(other.isInitialisedUpdating());
    assertTrue(other.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setFull()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setFull()}
   */
  @Test
  @DisplayName(
      "Test setFull(); given SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setFull()"})
  void testSetFull_givenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setFull();

    // Assert
    assertEquals(2, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, swmrNibbleArray.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#setFull()}.
   *
   * <ul>
   *   <li>Then fromVanilla {@link DataLayer#DataLayer(int)} with size is three {@link
   *       SWMRNibbleArray#stateUpdating} is two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setFull()}
   */
  @Test
  @DisplayName(
      "Test setFull(); then fromVanilla DataLayer(int) with size is three stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setFull()"})
  void testSetFull_thenFromVanillaDataLayerWithSizeIsThreeStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.setFull();

    // Assert that nothing has changed
    assertEquals(2, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isUninitialisedUpdating());
    assertTrue(fromVanillaResult.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, fromVanillaResult.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#setZero()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setZero()}
   */
  @Test
  @DisplayName(
      "Test setZero(); given SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setZero()"})
  void testSetZero_givenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setZero();

    // Assert
    assertEquals(2, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, swmrNibbleArray.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#setZero()}.
   *
   * <ul>
   *   <li>Then fromVanilla {@link DataLayer#DataLayer(int)} with size is three {@link
   *       SWMRNibbleArray#stateUpdating} is two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setZero()}
   */
  @Test
  @DisplayName(
      "Test setZero(); then fromVanilla DataLayer(int) with size is three stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setZero()"})
  void testSetZero_thenFromVanillaDataLayerWithSizeIsThreeStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.setZero();

    // Assert that nothing has changed
    assertEquals(2, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isUninitialisedUpdating());
    assertTrue(fromVanillaResult.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, fromVanillaResult.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#setNonNull()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@code null}.
   *   <li>Then fromVanilla {@code null} {@link SWMRNibbleArray#stateUpdating} is one.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setNonNull()}
   */
  @Test
  @DisplayName(
      "Test setNonNull(); given fromVanilla 'null'; then fromVanilla 'null' stateUpdating is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setNonNull()"})
  void testSetNonNull_givenFromVanillaNull_thenFromVanillaNullStateUpdatingIsOne() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Act
    fromVanillaResult.setNonNull();

    // Assert
    assertEquals(1, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isNullNibbleUpdating());
    assertTrue(fromVanillaResult.isDirty());
    assertTrue(fromVanillaResult.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setNonNull()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setNonNull()}
   */
  @Test
  @DisplayName(
      "Test setNonNull(); given SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setNonNull()"})
  void testSetNonNull_givenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsOne() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setNonNull();

    // Assert that nothing has changed
    assertEquals(1, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isDirty());
    assertFalse(swmrNibbleArray.isNullNibbleUpdating());
    assertTrue(swmrNibbleArray.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setNull()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#setNull()}
   */
  @Test
  @DisplayName("Test setNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setNull()"})
  void testSetNull() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setNull();

    // Assert
    assertEquals(0, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isDirty());
    assertTrue(swmrNibbleArray.isNullNibbleUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setUninitialised()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#setUninitialised()}
   */
  @Test
  @DisplayName("Test setUninitialised()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setUninitialised()"})
  void testSetUninitialised() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.setUninitialised();

    // Assert
    assertNull(fromVanillaResult.storageUpdating);
    assertEquals(1, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isInitialisedUpdating());
    assertTrue(fromVanillaResult.isDirty());
    assertTrue(fromVanillaResult.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setUninitialised()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setUninitialised()}
   */
  @Test
  @DisplayName(
      "Test setUninitialised(); given SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setUninitialised()"})
  void testSetUninitialised_givenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsOne() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setUninitialised();

    // Assert that nothing has changed
    assertEquals(1, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isDirty());
    assertFalse(swmrNibbleArray.isInitialisedUpdating());
    assertTrue(swmrNibbleArray.isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setHidden()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setHidden()}
   */
  @Test
  @DisplayName(
      "Test setHidden(); given SWMRNibbleArray(); then SWMRNibbleArray() stateUpdating is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setHidden()"})
  void testSetHidden_givenSWMRNibbleArray_thenSWMRNibbleArrayStateUpdatingIsZero() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.setHidden();

    // Assert
    assertEquals(0, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isHiddenUpdating());
    assertFalse(swmrNibbleArray.isInitialisedUpdating());
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isNullNibbleUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#setHidden()}.
   *
   * <ul>
   *   <li>Then fromVanilla {@link DataLayer#DataLayer(int)} with size is three {@link
   *       SWMRNibbleArray#stateUpdating} is three.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#setHidden()}
   */
  @Test
  @DisplayName(
      "Test setHidden(); then fromVanilla DataLayer(int) with size is three stateUpdating is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.setHidden()"})
  void testSetHidden_thenFromVanillaDataLayerWithSizeIsThreeStateUpdatingIsThree() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.setHidden();

    // Assert
    assertEquals(3, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isInitialisedUpdating());
    assertFalse(fromVanillaResult.isNullNibbleUpdating());
    assertFalse(fromVanillaResult.isUninitialisedUpdating());
    assertTrue(fromVanillaResult.isHiddenUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isDirty()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#isDirty()}
   */
  @Test
  @DisplayName("Test isDirty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isDirty()"})
  void testIsDirty() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isDirty());
  }

  /**
   * Test {@link SWMRNibbleArray#isNullNibbleUpdating()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isNullNibbleUpdating()}
   */
  @Test
  @DisplayName("Test isNullNibbleUpdating(); given fromVanilla 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isNullNibbleUpdating()"})
  void testIsNullNibbleUpdating_givenFromVanillaNull_thenReturnTrue() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Act and Assert
    assertTrue(fromVanillaResult.isNullNibbleUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isNullNibbleUpdating()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isNullNibbleUpdating()}
   */
  @Test
  @DisplayName("Test isNullNibbleUpdating(); given SWMRNibbleArray(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isNullNibbleUpdating()"})
  void testIsNullNibbleUpdating_givenSWMRNibbleArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isNullNibbleUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isNullNibbleVisible()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isNullNibbleVisible()}
   */
  @Test
  @DisplayName("Test isNullNibbleVisible(); given fromVanilla 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isNullNibbleVisible()"})
  void testIsNullNibbleVisible_givenFromVanillaNull_thenReturnTrue() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Act and Assert
    assertTrue(fromVanillaResult.isNullNibbleVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isNullNibbleVisible()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isNullNibbleVisible()}
   */
  @Test
  @DisplayName("Test isNullNibbleVisible(); given SWMRNibbleArray(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isNullNibbleVisible()"})
  void testIsNullNibbleVisible_givenSWMRNibbleArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isNullNibbleVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isUninitialisedUpdating()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isUninitialisedUpdating()}
   */
  @Test
  @DisplayName("Test isUninitialisedUpdating(); given SWMRNibbleArray(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isUninitialisedUpdating()"})
  void testIsUninitialisedUpdating_givenSWMRNibbleArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SWMRNibbleArray().isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isUninitialisedUpdating()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isUninitialisedUpdating()}
   */
  @Test
  @DisplayName("Test isUninitialisedUpdating(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isUninitialisedUpdating()"})
  void testIsUninitialisedUpdating_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SWMRNibbleArray.fromVanilla(new DataLayer(3)).isUninitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isUninitialisedVisible()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isUninitialisedVisible()}
   */
  @Test
  @DisplayName("Test isUninitialisedVisible(); given SWMRNibbleArray(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isUninitialisedVisible()"})
  void testIsUninitialisedVisible_givenSWMRNibbleArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SWMRNibbleArray().isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isUninitialisedVisible()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isUninitialisedVisible()}
   */
  @Test
  @DisplayName("Test isUninitialisedVisible(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isUninitialisedVisible()"})
  void testIsUninitialisedVisible_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(SWMRNibbleArray.fromVanilla(new DataLayer(3)).isUninitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isInitialisedUpdating()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isInitialisedUpdating()}
   */
  @Test
  @DisplayName("Test isInitialisedUpdating(); given SWMRNibbleArray(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isInitialisedUpdating()"})
  void testIsInitialisedUpdating_givenSWMRNibbleArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isInitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isInitialisedUpdating()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isInitialisedUpdating()}
   */
  @Test
  @DisplayName("Test isInitialisedUpdating(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isInitialisedUpdating()"})
  void testIsInitialisedUpdating_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SWMRNibbleArray.fromVanilla(new DataLayer(3)).isInitialisedUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isInitialisedVisible()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@link DataLayer#DataLayer(int)} with size is three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isInitialisedVisible()}
   */
  @Test
  @DisplayName(
      "Test isInitialisedVisible(); given fromVanilla DataLayer(int) with size is three; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isInitialisedVisible()"})
  void testIsInitialisedVisible_givenFromVanillaDataLayerWithSizeIsThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(SWMRNibbleArray.fromVanilla(new DataLayer(3)).isInitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isInitialisedVisible()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#isInitialisedVisible()}
   */
  @Test
  @DisplayName("Test isInitialisedVisible(); given SWMRNibbleArray(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isInitialisedVisible()"})
  void testIsInitialisedVisible_givenSWMRNibbleArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isInitialisedVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#isHiddenUpdating()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#isHiddenUpdating()}
   */
  @Test
  @DisplayName("Test isHiddenUpdating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isHiddenUpdating()"})
  void testIsHiddenUpdating() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isHiddenUpdating());
  }

  /**
   * Test {@link SWMRNibbleArray#isHiddenVisible()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#isHiddenVisible()}
   */
  @Test
  @DisplayName("Test isHiddenVisible()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.isHiddenVisible()"})
  void testIsHiddenVisible() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().isHiddenVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#swapUpdatingAndMarkDirty()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#swapUpdatingAndMarkDirty()}
   */
  @Test
  @DisplayName("Test swapUpdatingAndMarkDirty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.swapUpdatingAndMarkDirty()"})
  void testSwapUpdatingAndMarkDirty() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(new DataLayer(3));

    // Act
    fromVanillaResult.swapUpdatingAndMarkDirty();

    // Assert that nothing has changed
    assertEquals(2, fromVanillaResult.stateUpdating);
    assertFalse(fromVanillaResult.isUninitialisedUpdating());
    assertTrue(fromVanillaResult.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, fromVanillaResult.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#swapUpdatingAndMarkDirty()}.
   *
   * <ul>
   *   <li>Then {@link SWMRNibbleArray#SWMRNibbleArray()} {@link SWMRNibbleArray#stateUpdating} is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#swapUpdatingAndMarkDirty()}
   */
  @Test
  @DisplayName("Test swapUpdatingAndMarkDirty(); then SWMRNibbleArray() stateUpdating is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SWMRNibbleArray.swapUpdatingAndMarkDirty()"})
  void testSwapUpdatingAndMarkDirty_thenSWMRNibbleArrayStateUpdatingIsTwo() {
    // Arrange
    SWMRNibbleArray swmrNibbleArray = new SWMRNibbleArray();

    // Act
    swmrNibbleArray.swapUpdatingAndMarkDirty();

    // Assert
    assertEquals(2, swmrNibbleArray.stateUpdating);
    assertFalse(swmrNibbleArray.isUninitialisedUpdating());
    assertTrue(swmrNibbleArray.isInitialisedUpdating());
    assertEquals(SWMRNibbleArray.ARRAY_SIZE, swmrNibbleArray.storageUpdating.length);
  }

  /**
   * Test {@link SWMRNibbleArray#updateVisible()}.
   *
   * <p>Method under test: {@link SWMRNibbleArray#updateVisible()}
   */
  @Test
  @DisplayName("Test updateVisible()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SWMRNibbleArray.updateVisible()"})
  void testUpdateVisible() {
    // Arrange, Act and Assert
    assertFalse(new SWMRNibbleArray().updateVisible());
  }

  /**
   * Test {@link SWMRNibbleArray#toVanillaNibble()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@link DataLayer#DataLayer(int)} with size is three.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toVanillaNibble()}
   */
  @Test
  @DisplayName("Test toVanillaNibble(); given fromVanilla DataLayer(int) with size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer SWMRNibbleArray.toVanillaNibble()"})
  void testToVanillaNibble_givenFromVanillaDataLayerWithSizeIsThree() {
    // Arrange, Act and Assert
    assertEquals(
        SWMRNibbleArray.ARRAY_SIZE,
        SWMRNibbleArray.fromVanilla(new DataLayer(3)).toVanillaNibble().getData().length);
  }

  /**
   * Test {@link SWMRNibbleArray#toVanillaNibble()}.
   *
   * <ul>
   *   <li>Given fromVanilla {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toVanillaNibble()}
   */
  @Test
  @DisplayName("Test toVanillaNibble(); given fromVanilla 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer SWMRNibbleArray.toVanillaNibble()"})
  void testToVanillaNibble_givenFromVanillaNull_thenReturnNull() {
    // Arrange
    SWMRNibbleArray fromVanillaResult = SWMRNibbleArray.fromVanilla(null);

    // Act and Assert
    assertNull(fromVanillaResult.toVanillaNibble());
  }

  /**
   * Test {@link SWMRNibbleArray#toVanillaNibble()}.
   *
   * <ul>
   *   <li>Given {@link SWMRNibbleArray#SWMRNibbleArray()}.
   *   <li>Then return array length is {@link SWMRNibbleArray#ARRAY_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link SWMRNibbleArray#toVanillaNibble()}
   */
  @Test
  @DisplayName(
      "Test toVanillaNibble(); given SWMRNibbleArray(); then return array length is ARRAY_SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataLayer SWMRNibbleArray.toVanillaNibble()"})
  void testToVanillaNibble_givenSWMRNibbleArray_thenReturnArrayLengthIsArray_size() {
    // Arrange, Act and Assert
    assertEquals(
        SWMRNibbleArray.ARRAY_SIZE, new SWMRNibbleArray().toVanillaNibble().getData().length);
  }
}
