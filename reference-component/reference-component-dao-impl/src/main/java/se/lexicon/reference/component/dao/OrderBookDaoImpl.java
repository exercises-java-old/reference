package se.lexicon.reference.component.dao;

import com.so4it.component.dao.gs.AbstractSpaceDao;
import org.openspaces.core.GigaSpace;
import se.lexicon.reference.component.entity.OrderBookEntity;

public class OrderBookDaoImpl extends AbstractSpaceDao<OrderBookEntity ,String> implements OrderBookDao {


    public OrderBookDaoImpl(GigaSpace gigaSpace) {
        super(gigaSpace);
    }
}