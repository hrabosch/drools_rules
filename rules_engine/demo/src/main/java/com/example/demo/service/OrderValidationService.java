package com.example.demo.service;

import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.model.OrderRequest;

@Service
public class OrderValidationService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private AccountService accountService;

    public Boolean isOrderEliable(OrderRequest orderRequest) {
        Order order = new Order();
        order.setAccount(accountService.getAccountDetails(orderRequest.getAccountUid()));
        order.setEliable(true);
        order.setQuantity(orderRequest.getQuantity());
        order.setSymbol(orderRequest.getSymbol());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("order", order);
        kieSession.insert(order);
        kieSession.fireAllRules(new AgendaFilter() {

            @Override
            public boolean accept(Match match) {
                Map<String, Object> metadata = match.getRule().getMetaData();
                if (orderRequest.getProductTypes().contains(metadata.get("Product"))
                        || metadata.get("Product") == null) {
                    return true;
                }
                return false;
            }

        });
        kieSession.dispose();
        return order.getEliable();
    }

}
