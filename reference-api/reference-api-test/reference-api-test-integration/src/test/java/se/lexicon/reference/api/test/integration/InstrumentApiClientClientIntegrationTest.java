package se.lexicon.reference.api.test.integration;

import com.so4it.api.Reference;
import com.so4it.api.interceptor.request.RequestContextClientInterceptor;
import com.so4it.api.interceptor.request.RequestContextServerInterceptor;
import com.so4it.api.test.common.ApiFrameworkBootstrapTestRule;
import com.so4it.api.test.common.ApiFrameworkCommonTest;
import com.so4it.api.test.common.SatisfiedWhenClientConnected;
import com.so4it.common.bean.BeanContext;
import com.so4it.test.category.IntegrationTest;
import com.so4it.test.common.Assert;
import com.so4it.test.common.probe.Poller;
import com.so4it.test.common.probe.SatisfiedWhenTrueReturned;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.api.client.InstrumentApiClient;
import se.lexicon.reference.api.client.ReferenceApiProvider;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.service.InstrumentService;
import se.lexicon.reference.component.test.common.domain.CreateInstrumentRequestTestBuilder;

/**
 * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
 */
@Category(IntegrationTest.class)
public class InstrumentApiClientClientIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceApiIntegrationTestSuite.SUITE_RULE_CHAIN;


    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceApiIntegrationTestSuite.getComponentRule().getBean(GigaSpace.class));


    private static final BeanContext BEAN_CONTEXT = ApiFrameworkCommonTest.createClientBeanContext(ReferenceApiIntegrationTestSuite.DYNAMIC_CONFIGURATION);


    @ClassRule
    public static ApiFrameworkBootstrapTestRule apiFrameworkBootstrapTestRule = ApiFrameworkBootstrapTestRule.builder()
            .withBeanContext(BEAN_CONTEXT)
            .withDynamicConfiguration(ReferenceApiIntegrationTestSuite.DYNAMIC_CONFIGURATION)
            .withApiRegistryClient(ReferenceApiIntegrationTestSuite.API_REGISTRY)
            .withImports(ReferenceApiProvider.class)
            .withExports()
            .withClientInterceptors(new RequestContextClientInterceptor())
            .withServerInterceptors(new RequestContextServerInterceptor())
            .build();


    @Test
    public void testCreatingInstrument() throws Exception {
        InstrumentApiClient instrumentApiClient = BEAN_CONTEXT.getBean(InstrumentApiClient.class);

        Poller.pollAndCheck(SatisfiedWhenClientConnected.create(instrumentApiClient));

        CreateInstrumentRequest createInstrumentRequest = CreateInstrumentRequestTestBuilder.builder().build();

        instrumentApiClient.createInstrument(createInstrumentRequest);

        InstrumentService instrumentComponentService = ReferenceApiIntegrationTestSuite.getComponentRule().getBean(InstrumentService.class);

        Poller.pollAndCheck(SatisfiedWhenTrueReturned.create(() -> instrumentComponentService.getInstrument(createInstrumentRequest.getName()) != null));

        Instrument fetched = instrumentComponentService.getInstrument(createInstrumentRequest.getName());

        Assert.assertNotNull(fetched.getId());
        Assert.assertEquals(createInstrumentRequest.getName(), fetched.getName());
        Assert.assertEquals(createInstrumentRequest.getCurrency(), fetched.getCurrency());
    }


    @Test
    public void testGetInstrument() throws Exception {
        InstrumentApiClient instrumentApiClient = BEAN_CONTEXT.getBean(InstrumentApiClient.class);
        Poller.pollAndCheck(SatisfiedWhenClientConnected.create(instrumentApiClient));
        InstrumentService instrumentService = ReferenceApiIntegrationTestSuite.getComponentRule().getBean(InstrumentService.class);
        CreateInstrumentRequest createInstrumentRequest = CreateInstrumentRequestTestBuilder.builder().build();
        instrumentService.createInstrument(createInstrumentRequest);
        Instrument instrument = instrumentApiClient.getInstrument(createInstrumentRequest.getName());
        Assert.assertNotNull(instrument.getId());
        Assert.assertEquals(createInstrumentRequest.getCurrency(), instrument.getCurrency());
        Assert.assertEquals(createInstrumentRequest.getName(), instrument.getName());

    }

    /*@Test
    public void testCreatingAccountBalance() throws Exception {
        AccountApiClient accountApiClient = BEAN_CONTEXT.getBean(AccountApiClient.class);
        Poller.pollAndCheck(SatisfiedWhenClientConnected.create(accountApiClient));

        AccountBalance accountBalanceOne = accountApiClient.createAccountBalance(CreateAccountBalanceRequest.builder()
                .withArrangementId("1")
                .withBatchId("aaa")
                .withInsertionTimestamp(Instant.parse("2019-06-27T09:00:00.000Z"))
                .withBalances(Sets.newHashSet(BalanceTestBuilder.builder().build())).build());
        AccountBalance accountBalanceTwo = accountApiClient.createAccountBalance(CreateAccountBalanceRequest.builder()
                .withArrangementId("1")
                .withBatchId("bbb")
                .withInsertionTimestamp(Instant.parse("2019-06-27T10:00:00.000Z"))
                .withBalances(Sets.newHashSet(BalanceTestBuilder.builder().build())).build());
        //Optional<AccountBalance> accountBalanceOptional = accountComponentService.getAccountBalance(accountBalanceOne.getArrangementId());
        //Assert.assertTrue(accountBalanceOptional.isPresent());
        //Assert.assertEquals(Integer.valueOf(2),accountBalanceOptional.getAccountBalance().getSequenceNumber());
    }

    @Test
    public void testCreatingAccountTransaction() throws Exception {
        AccountApiClient accountApiClient = BEAN_CONTEXT.getBean(AccountApiClient.class);
        Poller.pollAndCheck(SatisfiedWhenClientConnected.create(accountApiClient));

        AccountTransaction accountTransaction = accountApiClient.createAccountTransaction(CreateAccountTransactionRequestTestBuilder.builder().build());
    }*/

}