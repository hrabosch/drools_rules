package com.example.demo.configuration;

import com.example.demo.model.OrderRequest;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import java.util.List;
import java.util.Map;

public class PpcomAgendaFilter implements AgendaFilter {

    private OrderRequest orderRequest;

    public PpcomAgendaFilter(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    @Override
    public boolean accept(Match match) {
        Map<String, Object> metadata = match.getRule().getMetaData();
        List<String> productTypes = orderRequest.getProductTypes();
        // No filters on request OR no filter on rule -> run rule
        if (productTypes == null || productTypes.isEmpty()) {
            return true;
        }

        if (productTypes.contains(metadata.get("Product"))
                || metadata.get("Product") == null) {
            return true;
        }

        return false;
    }
}
