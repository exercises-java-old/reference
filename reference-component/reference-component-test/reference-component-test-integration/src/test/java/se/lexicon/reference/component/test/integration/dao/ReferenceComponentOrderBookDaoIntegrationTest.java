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
import se.lexicon.reference.component.dao.OrderBookDao;
import se.lexicon.reference.component.entity.OrderBookEntity;
import se.lexicon.reference.component.test.common.entity.OrderBookEntityTestBuilder;
import se.lexicon.reference.component.test.integration.service.ReferenceComponentServiceIntegrationTestSuite;


@Category(IntegrationTest.class)
public class ReferenceComponentOrderBookDaoIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentDaoIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));



    @Test
    public void testInsertingOrderBook() {
        OrderBookDao orderBookDao = ReferenceComponentDaoIntegrationTestSuite.getExportContext().getBean(OrderBookDao.class);
        OrderBookEntity orderBookEntity = orderBookDao.insert(OrderBookEntityTestBuilder.builder().build());
        Assert.assertEquals(orderBookEntity,orderBookDao.read(orderBookEntity.getId()));
    }

}

