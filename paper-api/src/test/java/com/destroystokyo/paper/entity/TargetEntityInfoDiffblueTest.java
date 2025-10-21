package com.destroystokyo.paper.entity;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TargetEntityInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetEntityInfo#TargetEntityInfo(Entity, Vector)}
   *   <li>{@link TargetEntityInfo#getEntity()}
   *   <li>{@link TargetEntityInfo#getHitVector()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TargetEntityInfo.<init>(Entity, Vector)",
    "Entity TargetEntityInfo.getEntity()",
    "Vector TargetEntityInfo.getHitVector()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Vector hitVec = Vector.getRandom();

    // Act
    TargetEntityInfo actualTargetEntityInfo = new TargetEntityInfo(entity, hitVec);
    Entity actualEntity = actualTargetEntityInfo.getEntity();

    // Assert
    assertSame(hitVec, actualTargetEntityInfo.getHitVector());
    assertSame(entity, actualEntity);
  }
}
