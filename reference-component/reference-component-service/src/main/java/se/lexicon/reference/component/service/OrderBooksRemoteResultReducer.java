package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.RemoteResultReducer;
import com.so4it.gs.rpc.exception.ResultReducerException;
import com.so4it.gs.rpc.remoting.RemoteResult;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.domain.OrderBooks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderBooksRemoteResultReducer implements RemoteResultReducer<OrderBooks> {


    @Override
    public OrderBooks reduce(List<RemoteResult<OrderBooks>> list) throws ResultReducerException {
        Set<OrderBook> orderBookSet = new HashSet<>();
        list.forEach( rr -> orderBookSet.addAll( rr.getResult().asSet()));
        return OrderBooks.valueOf(orderBookSet);
    }
}