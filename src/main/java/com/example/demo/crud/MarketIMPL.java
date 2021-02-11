package com.example.demo.crud;

import com.example.demo.entity.Market;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
@Repository
public class MarketIMPL implements CRUD{
    private final EntityManager manager;

    @Autowired
    public MarketIMPL(EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional
    public List<Object> searchAll(){
        Session current = manager.unwrap(Session.class);
        Query<Object> query = current.createQuery("from Market");
        return query.getResultList();

    }

    @Override
    @Transactional
    public Object searchId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        return currentSession.get(Market.class, theId);
    }

    @Override
    @Transactional
    public void saveUpdate(Object market) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(market);
    }

    @Override
    @Transactional
    public void deleteId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        Market market = currentSession.get(Market.class, theId);
        currentSession.delete(market);
    }
}
