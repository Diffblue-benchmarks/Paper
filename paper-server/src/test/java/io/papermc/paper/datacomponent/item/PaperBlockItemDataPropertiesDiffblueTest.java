package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperBlockItemDataProperties.BuilderImpl;
import net.minecraft.world.item.component.BlockItemStateProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBlockItemDataPropertiesDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockItemDataProperties BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    BlockItemDataProperties actualBlockItemDataProperties = new BuilderImpl().build();

    // Assert
    assertTrue(actualBlockItemDataProperties instanceof PaperBlockItemDataProperties);
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange and Act
    BlockItemDataProperties actualBlockItemDataProperties = new BuilderImpl().build();

    // Assert
    assertTrue(actualBlockItemDataProperties instanceof PaperBlockItemDataProperties);
    BlockItemStateProperties handle =
        ((PaperBlockItemDataProperties) actualBlockItemDataProperties).getHandle();
    assertTrue(handle.properties().isEmpty());
    assertSame(handle, ((PaperBlockItemDataProperties) actualBlockItemDataProperties).impl());
  }

  /**
   * Test {@link PaperBlockItemDataProperties#getHandle()}.
   *
   * <p>Method under test: {@link PaperBlockItemDataProperties#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockItemStateProperties PaperBlockItemDataProperties.getHandle()"})
  void testGetHandle() {
    // Arrange
    PaperBlockItemDataProperties paperBlockItemDataProperties =
        new PaperBlockItemDataProperties(BlockItemStateProperties.EMPTY);

    // Act
    BlockItemStateProperties actualHandle = paperBlockItemDataProperties.getHandle();

    // Assert
    assertTrue(actualHandle.properties().isEmpty());
    BlockItemStateProperties blockItemStateProperties = BlockItemStateProperties.EMPTY;
    assertSame(blockItemStateProperties, actualHandle);
    assertSame(blockItemStateProperties, paperBlockItemDataProperties.impl());
  }
}
