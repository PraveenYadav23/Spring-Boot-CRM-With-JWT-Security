package com.praveen.cms.api.dao.Impl;

import com.praveen.cms.api.bo.AddCustomerBo;
import com.praveen.cms.api.dao.CustomerDao;
import com.praveen.cms.api.entity.Customer;
import com.praveen.cms.api.repository.CustomerRepository;
//import org.hibernate.search.engine.search.query.SearchResult;
//import org.hibernate.search.mapper.orm.Search;
//import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
//import org.hibernate.search.mapper.orm.scope.SearchScope;
//import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer getCustomerByEmailDao(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Long checkIfEmailAlreadyExist(String email) {
        return customerRepository.countByEmail(email);
    }

//    @Override
//    public List<Customer> searchCustomerDao(String name) {
//        SearchSession searchSession = Search.session( entityManager );
//
//        MassIndexer indexer = searchSession.massIndexer( Customer.class )
//                .threadsToLoadObjects( 7 );
//
//        try {
//            indexer.startAndWait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        SearchScope<Customer> scope = searchSession.scope( Customer.class );
//
//        SearchResult<Customer> result = searchSession.search( scope )
//                .where( scope.predicate().match()
//                        .fields( "firstName","lastName", "orderList.productList.productName" )
//                        .matching( name )
//                        .toPredicate()
//                )
//                .fetch( 20 );
//
//        long totalHitCount = result.getTotalHitCount();
//        List<Customer> hits = result.getHits();
//
//
//        return hits;
//    }

}
