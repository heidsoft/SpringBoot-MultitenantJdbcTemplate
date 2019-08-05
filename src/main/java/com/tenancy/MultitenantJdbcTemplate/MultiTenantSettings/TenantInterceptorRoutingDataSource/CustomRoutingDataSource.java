package com.tenancy.MultitenantJdbcTemplate.MultiTenantSettings.TenantInterceptorRoutingDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        System.out.println("THE URL IS ----> "+attr);
        
        if(attr!=null) {
            String tenantId = attr.getRequest().getParameter("tenantId");       // find parameter from request
            return tenantId;
        }else{
            return "tenantId1";             // default data source
        }
    }
}

