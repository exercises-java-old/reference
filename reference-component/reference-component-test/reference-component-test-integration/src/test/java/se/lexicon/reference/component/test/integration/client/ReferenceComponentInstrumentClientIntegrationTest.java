package se.lexicon.reference.component.test.integration.client;

import com.so4it.test.category.IntegrationTest;
import com.so4it.test.common.Assert;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.client.InstrumentClient;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.entity.InstrumentEntity;
import se.lexicon.reference.component.test.common.domain.CreateInstrumentRequestTestBuilder;
import se.lexicon.reference.component.test.integration.service.ReferenceComponentServiceIntegrationTestSuite;

@Category(IntegrationTest.class)
public class ReferenceComponentInstrumentClientIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));

    @Test
    public void testGetInstrumentClient() {
        InstrumentClient instrumentClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(InstrumentClient.class);
        Assert.assertNotNull(instrumentClient);
    }

    @Test
    public void testCreatingInstrument() {
        InstrumentClient instrumentClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(InstrumentClient.class);
        instrumentClient.createInstrument(CreateInstrumentRequestTestBuilder.builder().build());
        Assert.assertEquals(1, ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class).count(InstrumentEntity.templateBuilder().build()));
    }

    @Test
    public void getInstrument() {
        InstrumentClient instrumentClient = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(InstrumentClient.class);
        CreateInstrumentRequest inserted = CreateInstrumentRequestTestBuilder.builder().build();
        instrumentClient.createInstrument(inserted);
        Instrument fetched = instrumentClient.getInstrument(inserted.getName());
        Assert.assertEquals(inserted.getName(), fetched.getName());
    }
}
