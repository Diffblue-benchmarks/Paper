package io.papermc.paper.pluginremap.reflect;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.craftbukkit.util.LimitedClassRemapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.SimpleRemapper;
import org.objectweb.asm.tree.ClassNode;

class ReflectionRemapperDiffblueTest {
  /**
   * Test {@link ReflectionRemapper#visitor(ClassVisitor)}.
   *
   * <p>Method under test: {@link ReflectionRemapper#visitor(ClassVisitor)}
   */
  @Test
  @DisplayName("Test visitor(ClassVisitor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassVisitor ReflectionRemapper.visitor(ClassVisitor)"})
  void testVisitor() {
    // Arrange
    ClassNode classVisitor = new ClassNode();
    ClassRemapper classVisitor2 =
        new ClassRemapper(classVisitor, new SimpleRemapper("Old Name", "New Name"));
    LimitedClassRemapper parent =
        new LimitedClassRemapper(classVisitor2, new SimpleRemapper("Old Name", "New Name"));

    // Act and Assert
    assertSame(
        parent,
        ReflectionRemapper.visitor(parent)
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate());
  }

  /**
   * Test {@link ReflectionRemapper#visitor(ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link SimpleRemapper#SimpleRemapper(String, String)} with oldName is {@code null}
   *       and newName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectionRemapper#visitor(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test visitor(ClassVisitor); when SimpleRemapper(String, String) with oldName is 'null' and newName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassVisitor ReflectionRemapper.visitor(ClassVisitor)"})
  void testVisitor_whenSimpleRemapperWithOldNameIsNullAndNewNameIsNull() {
    // Arrange
    ClassNode classVisitor = new ClassNode();
    ClassRemapper classVisitor2 =
        new ClassRemapper(classVisitor, new SimpleRemapper("null", "null"));
    LimitedClassRemapper classVisitor3 =
        new LimitedClassRemapper(classVisitor2, new SimpleRemapper("null", "null"));
    ClassRemapper classVisitor4 =
        new ClassRemapper(classVisitor3, new SimpleRemapper("Old Name", "New Name"));
    LimitedClassRemapper parent =
        new LimitedClassRemapper(classVisitor4, new SimpleRemapper("Old Name", "New Name"));

    // Act and Assert
    assertSame(
        parent,
        ReflectionRemapper.visitor(parent)
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate()
            .getDelegate());
  }
}
