package se.lexicon.reference.component.test.integration.service;

import com.so4it.test.category.IntegrationTest;
import com.so4it.test.common.Assert;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.service.OrderBookService;
import se.lexicon.reference.component.test.common.domain.OrderBookTestBuilder;

@Category(IntegrationTest.class)
public class ReferenceComponentOrderBookServiceIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));

    @Test
    public void testGetOrderBookService() {
        OrderBookService orderBookService = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(OrderBookService.class);
        Assert.assertNotNull(orderBookService);
    }

    @Test
    public void testCreatingOrderBook() {
        OrderBookService orderBookService = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(OrderBookService.class);
        OrderBook inserted = orderBookService.createOrderBook(OrderBookTestBuilder.builder().build());
        OrderBook fetched = orderBookService.getOrderbook(inserted.getId());
        Assert.assertEquals(inserted.getName(), fetched.getName());

    }
}
