package se.lexicon.reference.component.dao;

import com.so4it.component.dao.gs.AbstractSpaceDao;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.entity.CreateOrderBookRequestEntity;

public class CreateOrderBookRequestDaoImpl extends AbstractSpaceDao<CreateOrderBookRequestEntity,String>implements CreateOrderBookRequestDao {
    public CreateOrderBookRequestDaoImpl(GigaSpace gigaSpace) {
        super(gigaSpace);
    }
}
