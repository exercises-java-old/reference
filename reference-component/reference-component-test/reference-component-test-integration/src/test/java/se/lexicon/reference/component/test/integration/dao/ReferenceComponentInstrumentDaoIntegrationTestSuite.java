package se.lexicon.reference.component.test.integration.dao;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import se.lexicon.reference.component.dao.OrderBookDao;
import se.lexicon.reference.component.entity.OrderBookEntity;
import se.lexicon.reference.component.test.common.entity.OrderBookEntityTestBuilder;

public class ReferenceComponentInstrumentDaoIntegrationTestSuite {


    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentInstrumentDaoIntegrationTestSuite.SUITE_RULE_CHAIN;


    //@Rule
    //public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));

    @Test
    public void testInsertingOrderBook() {
        OrderBookDao orderBookDao = ReferenceComponentOrderBookDaoIntegrationTestSuite.getExportContext().getBean(OrderBookDao.class);
        OrderBookEntity orderBookEntity = orderBookDao.insert(OrderBookEntityTestBuilder.builder().build());
        Assert.assertEquals(orderBookEntity, orderBookDao.read(orderBookEntity.getId()));
    }

}
