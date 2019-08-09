package se.lexicon.account.component.test.unit;

import com.so4it.test.builder.entity.EntityMatchers;
import com.so4it.test.category.UnitTest;
import com.so4it.test.domain.TestBuilderExecutor;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(UnitTest.class)
public class ReferenceComponentEntityUnitTest {

    private static final String PACKAGE_NAME = "se.lexicon.reference.component.test.common.entity";

    @Test
    public void testEntityCompliance() {

        TestBuilderExecutor.execute(PACKAGE_NAME, EntityMatchers.getMatchers());
    }
}
