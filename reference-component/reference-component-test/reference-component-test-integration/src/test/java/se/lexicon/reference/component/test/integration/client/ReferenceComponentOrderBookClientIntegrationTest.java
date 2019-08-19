package se.lexicon.reference.component.test.integration.client;

import com.so4it.test.category.IntegrationTest;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.client.OrderBookClient;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.entity.OrderBookEntity;
import se.lexicon.reference.component.test.common.domain.CreateOrderBookRequestTestBuilder;
import se.lexicon.reference.component.test.integration.service.ReferenceComponentServiceIntegrationTestSuite;

@Category(IntegrationTest.class)
<<<<<<< HEAD:reference-component/reference-component-test/reference-component-test-integration/src/test/java/se/lexicon/reference/component/test/integration/client/ReferenceComponentOrderBookClientIntegrationTest.java
public class ReferenceComponentOrderBookClientIntegrationTest {
=======
public class ReferenceComponentClientIntegrationIntegrationTest {


>>>>>>> get-all-instruments:reference-component/reference-component-test/reference-component-test-integration/src/test/java/se/lexicon/reference/component/test/integration/client/ReferenceComponentClientIntegrationIntegrationTest.java
    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));

    @Test
    public void testGetOrderBookClient() {
        OrderBookClient orderBookClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(OrderBookClient.class);
        Assert.assertNotNull(orderBookClient);
    }

    @Test
    public void testCreatingOrderBook() {
        OrderBookClient orderBookClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(OrderBookClient.class);
        orderBookClient.createOrderBook(CreateOrderBookRequestTestBuilder.builder().build());
        Assert.assertEquals(1, ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class).count(OrderBookEntity.templateBuilder().build()));
    }

    @Test
    public void getOrderBook() {
        OrderBookClient orderBookClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(OrderBookClient.class);
        CreateOrderBookRequest inserted = CreateOrderBookRequestTestBuilder.builder().build();
        orderBookClient.createOrderBook(inserted);
        OrderBook fetched = orderBookClient.getOrderBook(inserted.getInstrumentId());
        Assert.assertEquals(inserted.getInstrumentId(), fetched.getInstrumentId());
    }
}