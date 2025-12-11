package com.mojang.datafixers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.DataFixerBuilder.Result;
import com.mojang.datafixers.schemas.Schema;
import it.unimi.dsi.fastutil.ints.Int2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import java.util.ArrayList;
import net.minecraft.util.datafix.fixes.AbstractArrowPickupFix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataFixerBuilderDiffblueTest {
  /**
   * Test {@link DataFixerBuilder#DataFixerBuilder(int)}.
   *
   * <p>Method under test: {@link DataFixerBuilder#DataFixerBuilder(int)}
   */
  @Test
  @DisplayName("Test new DataFixerBuilder(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.<init>(int)"})
  void testNewDataFixerBuilder() {
    // Arrange, Act and Assert
    DataFixer fixerResult = new DataFixerBuilder(1).build().fixer();
    assertTrue(fixerResult instanceof DataFixerUpper);
    assertTrue(((DataFixerUpper) fixerResult).fixerVersions().isEmpty());
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link DataFixerBuilder#DataFixerBuilder(int)} with dataVersion is one.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test addSchema(Schema) with 'schema'; given DataFixerBuilder(int) with dataVersion is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenDataFixerBuilderWithDataVersionIsOne() {
    // Arrange
    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);

    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addSchema(schema);

    // Assert
    verify(schema).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVersionKey()} return {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test addSchema(Schema) with 'schema'; given Schema getVersionKey() return MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenSchemaGetVersionKeyReturnMin_value() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(Integer.MIN_VALUE);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(-1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema2);
    dataFixerBuilder.addSchema(schema);

    Schema schema3 = mock(Schema.class);
    when(schema3.getVersionKey()).thenReturn(Integer.MIN_VALUE);

    // Act
    dataFixerBuilder.addSchema(schema3);

    // Assert
    verify(schema2).getVersionKey();
    verify(schema).getVersionKey();
    verify(schema3).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVersionKey()} return one.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test addSchema(Schema) with 'schema'; given Schema getVersionKey() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenSchemaGetVersionKeyReturnOne() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addSchema(schema2);

    // Assert
    verify(schema).getVersionKey();
    verify(schema2).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVersionKey()} return one.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test addSchema(Schema) with 'schema'; given Schema getVersionKey() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenSchemaGetVersionKeyReturnOne2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(1);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(-1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema2);
    dataFixerBuilder.addSchema(schema);

    Schema schema3 = mock(Schema.class);
    when(schema3.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addSchema(schema3);

    // Assert
    verify(schema2).getVersionKey();
    verify(schema).getVersionKey();
    verify(schema3).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVersionKey()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test addSchema(Schema) with 'schema'; given Schema getVersionKey() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenSchemaGetVersionKeyReturnZero() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(0);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addSchema(schema2);

    // Assert
    verify(schema).getVersionKey();
    verify(schema2).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getVersionKey()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName("Test addSchema(Schema) with 'schema'; given Schema getVersionKey() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenSchemaGetVersionKeyReturnZero2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(0);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(-1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema2);
    dataFixerBuilder.addSchema(schema);

    Schema schema3 = mock(Schema.class);
    when(schema3.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addSchema(schema3);

    // Assert
    verify(schema2).getVersionKey();
    verify(schema).getVersionKey();
    verify(schema3).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Schema} {@link Schema#getVersionKey()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test addSchema(Schema) with 'schema'; given zero; when Schema getVersionKey() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenZero_whenSchemaGetVersionKeyReturnZero() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(0);

    // Act
    dataFixerBuilder.addSchema(schema2);

    // Assert
    verify(schema).getVersionKey();
    verify(schema2).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addSchema(Schema)} with {@code schema}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Schema} {@link Schema#getVersionKey()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addSchema(Schema)}
   */
  @Test
  @DisplayName(
      "Test addSchema(Schema) with 'schema'; given zero; when Schema getVersionKey() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addSchema(Schema)"})
  void testAddSchemaWithSchema_givenZero_whenSchemaGetVersionKeyReturnZero2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVersionKey()).thenReturn(1);

    Schema schema2 = mock(Schema.class);
    when(schema2.getVersionKey()).thenReturn(-1);

    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    dataFixerBuilder.addSchema(schema2);
    dataFixerBuilder.addSchema(schema);

    Schema schema3 = mock(Schema.class);
    when(schema3.getVersionKey()).thenReturn(0);

    // Act
    dataFixerBuilder.addSchema(schema3);

    // Assert
    verify(schema2).getVersionKey();
    verify(schema).getVersionKey();
    verify(schema3).getVersionKey();
  }

  /**
   * Test {@link DataFixerBuilder#addFixer(DataFix)}.
   *
   * <p>Method under test: {@link DataFixerBuilder#addFixer(DataFix)}
   */
  @Test
  @DisplayName("Test addFixer(DataFix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addFixer(DataFix)"})
  void testAddFixer() {
    // Arrange
    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(-1);

    Schema outputSchema = mock(Schema.class);
    when(outputSchema.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addFixer(new AbstractArrowPickupFix(outputSchema));

    // Assert that nothing has changed
    verify(outputSchema).getVersionKey();
    DataFixer fixerResult = dataFixerBuilder.build().fixer();
    assertTrue(fixerResult instanceof DataFixerUpper);
    assertTrue(((DataFixerUpper) fixerResult).fixerVersions().isEmpty());
  }

  /**
   * Test {@link DataFixerBuilder#addFixer(DataFix)}.
   *
   * <ul>
   *   <li>Then {@link DataFixerBuilder#DataFixerBuilder(int)} with dataVersion is one build fixer
   *       {@link DataFixerUpper}.
   * </ul>
   *
   * <p>Method under test: {@link DataFixerBuilder#addFixer(DataFix)}
   */
  @Test
  @DisplayName(
      "Test addFixer(DataFix); then DataFixerBuilder(int) with dataVersion is one build fixer DataFixerUpper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataFixerBuilder.addFixer(DataFix)"})
  void testAddFixer_thenDataFixerBuilderWithDataVersionIsOneBuildFixerDataFixerUpper() {
    // Arrange
    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);

    Schema outputSchema = mock(Schema.class);
    when(outputSchema.getVersionKey()).thenReturn(1);

    // Act
    dataFixerBuilder.addFixer(new AbstractArrowPickupFix(outputSchema));

    // Assert
    verify(outputSchema, atLeast(1)).getVersionKey();
    DataFixer fixerResult = dataFixerBuilder.build().fixer();
    assertTrue(fixerResult instanceof DataFixerUpper);
    assertEquals(1, ((DataFixerUpper) fixerResult).fixerVersions().size());
  }

  /**
   * Test {@link DataFixerBuilder#build()}.
   *
   * <p>Method under test: {@link DataFixerBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result DataFixerBuilder.build()"})
  void testBuild() {
    // Arrange, Act and Assert
    assertTrue(new DataFixerBuilder(1).build().fixer() instanceof DataFixerUpper);
  }

  /**
   * Test Result {@link Result#fixer()}.
   *
   * <p>Method under test: {@link Result#fixer()}
   */
  @Test
  @DisplayName("Test Result fixer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataFixer Result.fixer()"})
  void testResultFixer() {
    // Arrange
    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    Int2ObjectAVLTreeMap<Schema> schemas = new Int2ObjectAVLTreeMap<>();
    ArrayList<DataFix> globalList = new ArrayList<>();

    DataFixerUpper dataFixerUpper = new DataFixerUpper(schemas, globalList, new IntAVLTreeSet());

    // Act and Assert
    assertSame(dataFixerUpper, dataFixerBuilder.new Result(dataFixerUpper).fixer());
  }

  /**
   * Test Result {@link Result#Result(DataFixerBuilder, DataFixerUpper)}.
   *
   * <p>Method under test: {@link Result#Result(DataFixerBuilder, DataFixerUpper)}
   */
  @Test
  @DisplayName("Test Result new Result(DataFixerBuilder, DataFixerUpper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Result.<init>(DataFixerBuilder, DataFixerUpper)"})
  void testResultNewResult() {
    // Arrange
    DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
    Int2ObjectAVLTreeMap<Schema> schemas = new Int2ObjectAVLTreeMap<>();
    ArrayList<DataFix> globalList = new ArrayList<>();

    DataFixerUpper dataFixerUpper = new DataFixerUpper(schemas, globalList, new IntAVLTreeSet());

    // Act and Assert
    assertSame(dataFixerUpper, dataFixerBuilder.new Result(dataFixerUpper).fixer());
  }
}
