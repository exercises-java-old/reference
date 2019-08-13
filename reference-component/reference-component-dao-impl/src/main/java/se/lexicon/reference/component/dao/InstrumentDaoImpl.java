package se.lexicon.reference.component.dao;
import com.so4it.component.dao.gs.AbstractSpaceDao;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.entity.InstrumentEntity;

public class InstrumentDaoImpl extends AbstractSpaceDao<InstrumentEntity, String> implements InstrumentDao {


    public InstrumentDaoImpl(GigaSpace gigaSpace) {
        super(gigaSpace);
    }
}