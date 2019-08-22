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
import se.lexicon.reference.component.domain.OrderBooks;
import se.lexicon.reference.component.service.OrderBookService;
import se.lexicon.reference.component.test.common.domain.CreateOrderBookRequestTestBuilder;

import java.util.Arrays;

@Category(IntegrationTest.class)
public class ReferenceComponentOrderBookServiceIntegrationTest {


    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule
            (ReferenceComponentServiceIntegrationTestSuite.getExportContext()
                    .getBean(GigaSpace.class));

    @Test
    public void testGetOrderBookService() {
        OrderBookService orderBookService = ReferenceComponentServiceIntegrationTestSuite
                .getImportContext().getBean(OrderBookService.class);
        Assert.assertNotNull(orderBookService);
    }

    @Test
    public void testCreatingOrderBook() {
        OrderBookService orderBookService = ReferenceComponentServiceIntegrationTestSuite
                .getImportContext().getBean(OrderBookService.class);
        OrderBook inserted = orderBookService.createOrderBook(CreateOrderBookRequestTestBuilder.builder()
                .build());
        OrderBook fetched = orderBookService.getOrderBook(inserted.getInstrumentId());
        Assert.assertEquals(inserted.getInstrumentId(), fetched.getInstrumentId());
    }

    @Test
    public void testGetAllOrderBooks() {
        OrderBookService orderBookService = ReferenceComponentServiceIntegrationTestSuite
                .getImportContext().getBean(OrderBookService.class);
        OrderBook inserted0 = orderBookService.createOrderBook(CreateOrderBookRequestTestBuilder.builder().build());
        OrderBook inserted1 = orderBookService.createOrderBook(CreateOrderBookRequestTestBuilder.builder().build());
        OrderBook inserted2 = orderBookService.createOrderBook(CreateOrderBookRequestTestBuilder.builder().build());
        OrderBook inserted3 = orderBookService.createOrderBook(CreateOrderBookRequestTestBuilder.builder().build());
        OrderBooks fetched = orderBookService.getAllOrderBooks();
        Assert.assertEquals(4, fetched.size());
        Assert.assertTrue(fetched.asList().containsAll(Arrays.asList(inserted0, inserted1, inserted2, inserted3)));
    }
}