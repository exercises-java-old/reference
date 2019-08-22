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
import se.lexicon.reference.component.domain.Instruments;
import se.lexicon.reference.component.service.InstrumentService;
import se.lexicon.reference.component.test.common.domain.CreateInstrumentRequestTestBuilder;

import java.util.Arrays;

@Category(IntegrationTest.class)
public class ReferenceComponentInstrumentServiceIntegrationTest {


    @ClassRule
    public static final RuleChain SUITE_RULE_CHAIN = ReferenceComponentServiceIntegrationTestSuite.SUITE_RULE_CHAIN;

    @Rule
    public ClearGigaSpaceTestRule clearGigaSpaceTestRule = new ClearGigaSpaceTestRule
            (ReferenceComponentServiceIntegrationTestSuite.getExportContext().getBean(GigaSpace.class));

    @Test
    public void testGetInstrumentService() {
        InstrumentService instrumentService = ReferenceComponentServiceIntegrationTestSuite.getImportContext()
                .getBean(InstrumentService.class);
        Assert.assertNotNull(instrumentService);
    }

    @Test
    public void testCreatingInstrument() {
        InstrumentService instrumentService = ReferenceComponentServiceIntegrationTestSuite
                .getImportContext().getBean(InstrumentService.class);
        Instrument inserted = instrumentService.createInstrument(CreateInstrumentRequestTestBuilder
                .builder().build());
        Instrument fetched = instrumentService.getInstrument(inserted.getName());
        Assert.assertEquals(inserted.getName(), fetched.getName());
    }

    @Test
    public void testGetAllInstruments() {
        InstrumentService instrumentService = ReferenceComponentServiceIntegrationTestSuite
                .getImportContext().getBean(InstrumentService.class);
        Instrument inserted1 = instrumentService.createInstrument(CreateInstrumentRequestTestBuilder.builder()
                .withName("name1").build());
        Instrument inserted2 = instrumentService.createInstrument(CreateInstrumentRequestTestBuilder.builder()
                .withName("name2").build());
        Instruments fetched = instrumentService.getAllInstruments();
        Assert.assertTrue(fetched.asList().containsAll(Arrays.asList(inserted1, inserted2)));
        Assert.assertEquals(2, fetched.size());
    }
}