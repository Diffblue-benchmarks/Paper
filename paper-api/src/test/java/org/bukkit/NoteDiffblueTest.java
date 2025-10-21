package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Note.Tone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoteDiffblueTest {
  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return Pitch is {@code 1.4142135}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when 'B'; then return Pitch is '1.4142135'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenB_thenReturnPitchIs14142135() {
    // Arrange and Act
    Note actualNote = new Note(1, Tone.B, true);

    // Assert
    assertEquals(1, actualNote.getOctave());
    assertEquals(1.4142135f, actualNote.getPitch());
    assertEquals((byte) 18, actualNote.getId());
    assertEquals(Tone.C, actualNote.getTone());
    assertFalse(actualNote.isSharped());
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When {@code G}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when 'G'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenG_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Note(2, Tone.G, true));
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Note(int, Tone, boolean); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Note(-1, Tone.F, false));
  }

  /**
   * Test {@link Note#Note(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Octave is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int)}
   */
  @Test
  @DisplayName("Test new Note(int); when one; then return Octave is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int)"})
  void testNewNote_whenOne_thenReturnOctaveIsZero() {
    // Arrange and Act
    Note actualNote = new Note(1);

    // Assert
    assertEquals(0, actualNote.getOctave());
    assertEquals(0.5297315f, actualNote.getPitch());
    assertEquals((byte) 1, actualNote.getId());
    assertEquals(Tone.G, actualNote.getTone());
    assertFalse(actualNote.isSharped());
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Pitch is {@code 1.122462}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when one; then return Pitch is '1.122462'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenOne_thenReturnPitchIs1122462() {
    // Arrange and Act
    Note actualNote = new Note(1, Tone.G, true);

    // Assert
    assertEquals(1, actualNote.getOctave());
    assertEquals(1.122462f, actualNote.getPitch());
    assertEquals((byte) 14, actualNote.getId());
    assertEquals(Tone.G, actualNote.getTone());
    assertTrue(actualNote.isSharped());
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Note(3, Tone.F, false));
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Octave is two.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when two; then return Octave is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenTwo_thenReturnOctaveIsTwo() {
    // Arrange and Act
    Note actualNote = new Note(2, Tone.F, true);

    // Assert
    assertEquals(2, actualNote.getOctave());
    assertEquals(2.0f, actualNote.getPitch());
    assertEquals((byte) 24, actualNote.getId());
    assertEquals(Tone.F, actualNote.getTone());
    assertTrue(actualNote.isSharped());
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Note(2, Tone.F, false));
  }

  /**
   * Test {@link Note#Note(int, Tone, boolean)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Octave is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(int, Tone, boolean)}
   */
  @Test
  @DisplayName("Test new Note(int, Tone, boolean); when zero; then return Octave is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(int, Tone, boolean)"})
  void testNewNote_whenZero_thenReturnOctaveIsZero() {
    // Arrange and Act
    Note actualNote = new Note(0, Tone.F, false);

    // Assert
    assertEquals(0, actualNote.getOctave());
    assertEquals(0.9438743f, actualNote.getPitch());
    assertEquals((byte) 11, actualNote.getId());
    assertEquals(Tone.F, actualNote.getTone());
    assertFalse(actualNote.isSharped());
  }

  /**
   * Test {@link Note#flat(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Pitch is {@code 1.122462}.
   * </ul>
   *
   * <p>Method under test: {@link Note#flat(int, Tone)}
   */
  @Test
  @DisplayName("Test flat(int, Tone); when 'A'; then return Pitch is '1.122462'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flat(int, Tone)"})
  void testFlat_whenA_thenReturnPitchIs1122462() {
    // Arrange and Act
    Note actualFlatResult = Note.flat(1, Tone.A);

    // Assert
    assertEquals(1.122462f, actualFlatResult.getPitch());
    assertEquals((byte) 14, actualFlatResult.getId());
    assertEquals(Tone.G, actualFlatResult.getTone());
    assertTrue(actualFlatResult.isSharped());
  }

  /**
   * Test {@link Note#flat(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return Pitch is {@code 1.3348398}.
   * </ul>
   *
   * <p>Method under test: {@link Note#flat(int, Tone)}
   */
  @Test
  @DisplayName("Test flat(int, Tone); when 'C'; then return Pitch is '1.3348398'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flat(int, Tone)"})
  void testFlat_whenC_thenReturnPitchIs13348398() {
    // Arrange and Act
    Note actualFlatResult = Note.flat(1, Tone.C);

    // Assert
    assertEquals(1.3348398f, actualFlatResult.getPitch());
    assertEquals((byte) 17, actualFlatResult.getId());
    assertEquals(Tone.B, actualFlatResult.getTone());
    assertFalse(actualFlatResult.isSharped());
  }

  /**
   * Test {@link Note#flat(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code G}.
   *   <li>Then return Pitch is one.
   * </ul>
   *
   * <p>Method under test: {@link Note#flat(int, Tone)}
   */
  @Test
  @DisplayName("Test flat(int, Tone); when 'G'; then return Pitch is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flat(int, Tone)"})
  void testFlat_whenG_thenReturnPitchIsOne() {
    // Arrange and Act
    Note actualFlatResult = Note.flat(1, Tone.G);

    // Assert
    assertEquals(1.0f, actualFlatResult.getPitch());
    assertEquals(Tone.F, actualFlatResult.getTone());
    assertTrue(actualFlatResult.isSharped());
    assertEquals('\f', actualFlatResult.getId());
  }

  /**
   * Test {@link Note#flat(int, Tone)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#flat(int, Tone)}
   */
  @Test
  @DisplayName("Test flat(int, Tone); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flat(int, Tone)"})
  void testFlat_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.flat(-1, Tone.G));
  }

  /**
   * Test {@link Note#flat(int, Tone)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#flat(int, Tone)}
   */
  @Test
  @DisplayName("Test flat(int, Tone); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flat(int, Tone)"})
  void testFlat_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.flat(3, Tone.G));
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return Pitch is {@code 1.4142135}.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when 'B'; then return Pitch is '1.4142135'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenB_thenReturnPitchIs14142135() {
    // Arrange and Act
    Note actualSharpResult = Note.sharp(1, Tone.B);

    // Assert
    assertEquals(1.4142135f, actualSharpResult.getPitch());
    assertEquals((byte) 18, actualSharpResult.getId());
    assertEquals(Tone.C, actualSharpResult.getTone());
    assertFalse(actualSharpResult.isSharped());
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code E}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when 'E'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenE_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.sharp(2, Tone.E));
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When {@code G}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when 'G'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenG_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.sharp(2, Tone.G));
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.sharp(-1, Tone.F));
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Octave is one.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when one; then return Octave is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenOne_thenReturnOctaveIsOne() {
    // Arrange and Act
    Note actualSharpResult = Note.sharp(1, Tone.G);

    // Assert
    assertEquals(1, actualSharpResult.getOctave());
    assertEquals(1.122462f, actualSharpResult.getPitch());
    assertEquals((byte) 14, actualSharpResult.getId());
    assertEquals(Tone.G, actualSharpResult.getTone());
    assertTrue(actualSharpResult.isSharped());
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.sharp(3, Tone.F));
  }

  /**
   * Test {@link Note#sharp(int, Tone)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Octave is two.
   * </ul>
   *
   * <p>Method under test: {@link Note#sharp(int, Tone)}
   */
  @Test
  @DisplayName("Test sharp(int, Tone); when two; then return Octave is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharp(int, Tone)"})
  void testSharp_whenTwo_thenReturnOctaveIsTwo() {
    // Arrange and Act
    Note actualSharpResult = Note.sharp(2, Tone.F);

    // Assert
    assertEquals(2, actualSharpResult.getOctave());
    assertEquals(2.0f, actualSharpResult.getPitch());
    assertEquals((byte) 24, actualSharpResult.getId());
    assertEquals(Tone.F, actualSharpResult.getTone());
  }

  /**
   * Test {@link Note#natural(int, Tone)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#natural(int, Tone)}
   */
  @Test
  @DisplayName("Test natural(int, Tone); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.natural(int, Tone)"})
  void testNatural_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.natural(-1, Tone.F));
  }

  /**
   * Test {@link Note#natural(int, Tone)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Octave is one.
   * </ul>
   *
   * <p>Method under test: {@link Note#natural(int, Tone)}
   */
  @Test
  @DisplayName("Test natural(int, Tone); when one; then return Octave is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.natural(int, Tone)"})
  void testNatural_whenOne_thenReturnOctaveIsOne() {
    // Arrange and Act
    Note actualNaturalResult = Note.natural(1, Tone.G);

    // Assert
    assertEquals(1, actualNaturalResult.getOctave());
    assertEquals(1.0594631f, actualNaturalResult.getPitch());
    assertEquals(Tone.G, actualNaturalResult.getTone());
    assertFalse(actualNaturalResult.isSharped());
    assertEquals('\r', actualNaturalResult.getId());
  }

  /**
   * Test {@link Note#natural(int, Tone)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#natural(int, Tone)}
   */
  @Test
  @DisplayName("Test natural(int, Tone); when three; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.natural(int, Tone)"})
  void testNatural_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Note.natural(3, Tone.F));
  }

  /**
   * Test {@link Note#sharped()}.
   *
   * <p>Method under test: {@link Note#sharped()}
   */
  @Test
  @DisplayName("Test sharped()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.sharped()"})
  void testSharped() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act
    Note actualSharpedResult = flatResult.sharped();

    // Assert
    assertEquals(1, actualSharpedResult.getOctave());
    assertEquals(1.0594631f, actualSharpedResult.getPitch());
    assertEquals(Tone.G, actualSharpedResult.getTone());
    assertFalse(actualSharpedResult.isSharped());
    assertEquals('\r', actualSharpedResult.getId());
  }

  /**
   * Test {@link Note#flattened()}.
   *
   * <ul>
   *   <li>Given flat one and {@code G}.
   *   <li>Then return Octave is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#flattened()}
   */
  @Test
  @DisplayName("Test flattened(); given flat one and 'G'; then return Octave is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Note Note.flattened()"})
  void testFlattened_givenFlatOneAndG_thenReturnOctaveIsZero() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act
    Note actualFlattenedResult = flatResult.flattened();

    // Assert
    assertEquals(0, actualFlattenedResult.getOctave());
    assertEquals(0.9438743f, actualFlattenedResult.getPitch());
    assertEquals((byte) 11, actualFlattenedResult.getId());
    assertEquals(Tone.F, actualFlattenedResult.getTone());
    assertFalse(actualFlattenedResult.isSharped());
  }

  /**
   * Test {@link Note#getId()}.
   *
   * <p>Method under test: {@link Note#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Note.getId()"})
  void testGetId() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act and Assert
    assertEquals('\f', flatResult.getId());
  }

  /**
   * Test {@link Note#getOctave()}.
   *
   * <p>Method under test: {@link Note#getOctave()}
   */
  @Test
  @DisplayName("Test getOctave()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Note.getOctave()"})
  void testGetOctave() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act and Assert
    assertEquals(1, flatResult.getOctave());
  }

  /**
   * Test {@link Note#getTone()}.
   *
   * <p>Method under test: {@link Note#getTone()}
   */
  @Test
  @DisplayName("Test getTone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tone Note.getTone()"})
  void testGetTone() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act and Assert
    assertEquals(Tone.F, flatResult.getTone());
  }

  /**
   * Test {@link Note#isSharped()}.
   *
   * <ul>
   *   <li>Given flat one and {@code C}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Note#isSharped()}
   */
  @Test
  @DisplayName("Test isSharped(); given flat one and 'C'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Note.isSharped()"})
  void testIsSharped_givenFlatOneAndC_thenReturnFalse() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.C);

    // Act and Assert
    assertFalse(flatResult.isSharped());
  }

  /**
   * Test {@link Note#isSharped()}.
   *
   * <ul>
   *   <li>Given flat one and {@code G}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Note#isSharped()}
   */
  @Test
  @DisplayName("Test isSharped(); given flat one and 'G'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Note.isSharped()"})
  void testIsSharped_givenFlatOneAndG_thenReturnTrue() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act and Assert
    assertTrue(flatResult.isSharped());
  }

  /**
   * Test {@link Note#getPitch()}.
   *
   * <p>Method under test: {@link Note#getPitch()}
   */
  @Test
  @DisplayName("Test getPitch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Note.getPitch()"})
  void testGetPitch() {
    // Arrange
    Note flatResult = Note.flat(1, Tone.G);

    // Act and Assert
    assertEquals(1.0f, flatResult.getPitch());
  }

  /**
   * Test Tone {@link Tone#getById(byte)}.
   *
   * <p>Method under test: {@link Tone#getById(byte)}
   */
  @Test
  @DisplayName("Test Tone getById(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tone Tone.getById(byte)"})
  void testToneGetById() {
    // Arrange, Act and Assert
    assertNull(Tone.getById((byte) 'A'));
  }

  /**
   * Test Tone {@link Tone#getId()}.
   *
   * <p>Method under test: {@link Tone#getId()}
   */
  @Test
  @DisplayName("Test Tone getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Tone.getId()"})
  void testToneGetId() {
    // Arrange, Act and Assert
    assertEquals((byte) 1, Tone.G.getId());
  }

  /**
   * Test Tone {@link Tone#getId(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@code B}.
   *   <li>When {@code true}.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link Tone#getId(boolean)}
   */
  @Test
  @DisplayName("Test Tone getId(boolean) with 'boolean'; given 'B'; when 'true'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Tone.getId(boolean)"})
  void testToneGetIdWithBoolean_givenB_whenTrue_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals((byte) 5, Tone.B.getId(true));
  }

  /**
   * Test Tone {@link Tone#getId(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@code G}.
   *   <li>When {@code false}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Tone#getId(boolean)}
   */
  @Test
  @DisplayName("Test Tone getId(boolean) with 'boolean'; given 'G'; when 'false'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Tone.getId(boolean)"})
  void testToneGetIdWithBoolean_givenG_whenFalse_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals((byte) 1, Tone.G.getId(false));
  }

  /**
   * Test Tone {@link Tone#getId(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@code G}.
   *   <li>When {@code true}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link Tone#getId(boolean)}
   */
  @Test
  @DisplayName("Test Tone getId(boolean) with 'boolean'; given 'G'; when 'true'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Tone.getId(boolean)"})
  void testToneGetIdWithBoolean_givenG_whenTrue_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals((byte) 2, Tone.G.getId(true));
  }

  /**
   * Test Tone {@link Tone#isSharped(byte)}.
   *
   * <ul>
   *   <li>Given {@code B}.
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Tone#isSharped(byte)}
   */
  @Test
  @DisplayName(
      "Test Tone isSharped(byte); given 'B'; when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tone.isSharped(byte)"})
  void testToneIsSharped_givenB_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Tone.B.isSharped((byte) 'A'));
  }

  /**
   * Test Tone {@link Tone#isSharped(byte)}.
   *
   * <ul>
   *   <li>Given {@code G}.
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Tone#isSharped(byte)}
   */
  @Test
  @DisplayName(
      "Test Tone isSharped(byte); given 'G'; when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tone.isSharped(byte)"})
  void testToneIsSharped_givenG_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Tone.G.isSharped((byte) 'A'));
  }

  /**
   * Test Tone {@link Tone#isSharped(byte)}.
   *
   * <ul>
   *   <li>Given {@code G}.
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Tone#isSharped(byte)}
   */
  @Test
  @DisplayName("Test Tone isSharped(byte); given 'G'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tone.isSharped(byte)"})
  void testToneIsSharped_givenG_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Tone.G.isSharped((byte) 1));
  }

  /**
   * Test Tone {@link Tone#isSharped(byte)}.
   *
   * <ul>
   *   <li>Given {@code G}.
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tone#isSharped(byte)}
   */
  @Test
  @DisplayName("Test Tone isSharped(byte); given 'G'; when two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Tone.isSharped(byte)"})
  void testToneIsSharped_givenG_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Tone.G.isSharped((byte) 2));
  }
}
