package se.lexicon.reference.component.test.integration.service;

import com.so4it.test.category.IntegrationTest;
import com.so4it.test.gs.rule.ClearGigaSpaceTestRule;
import junitx.framework.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.RuleChain;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.service.InstrumentService;
import se.lexicon.reference.component.test.common.domain.InstrumentTestBuilder;

@Category(IntegrationTest.class)
public class ReferenceComponentInstrumentServiceIntegrationTest {

    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule(ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));


    @Test
    public void testGetInstrumentService() {
        InstrumentService instrumentService = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(InstrumentService.class);
        Assert.assertNotNull(instrumentService);
    }


    @Test
    public void testCreateingInstument() {
        InstrumentService instrumentService = ReferenceComponentServiceIntegrationTestSuite.getImportContext().getBean(InstrumentService.class);
        Instrument inserted = instrumentService.createInstrument(InstrumentTestBuilder.builder().build());
        Instrument fetched = instrumentService.getInstrument(inserted.getId());
        Assert.assertEquals(inserted.getName(), fetched.getName());
    }
}