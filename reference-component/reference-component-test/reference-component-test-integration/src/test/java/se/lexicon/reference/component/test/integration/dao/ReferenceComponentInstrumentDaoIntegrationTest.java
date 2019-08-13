package se.lexicon.reference.component.test.integration.dao;

import com.so4it.test.category.IntegrationTest;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.dao.InstrumentDao;
import se.lexicon.reference.component.entity.InstrumentEntity;
import se.lexicon.reference.component.test.common.entity.InstrumentEntityTestBuilder;

@Category(IntegrationTest.class)
public class ReferenceComponentInstrumentDaoIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentDaoIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentDaoIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));



    @Test
    public void testInsertingOrderBook() {
        InstrumentDao instrumentDao = ReferenceComponentDaoIntegrationTestSuite.getExportContext().getBean(InstrumentDao.class);
        InstrumentEntity instrumentEntity = instrumentDao.insert(InstrumentEntityTestBuilder.builder().build());
        Assert.assertEquals(instrumentEntity, instrumentDao.read(instrumentEntity.getId()));
    }


}
