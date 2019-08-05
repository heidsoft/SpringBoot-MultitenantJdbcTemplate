package com.tenancy.MultitenantJdbcTemplate;

import javax.sql.DataSource;

import com.tenancy.MultitenantJdbcTemplate.MultiTenantSettings.TenantDataSources.DataSourceMap;
import com.tenancy.MultitenantJdbcTemplate.MultiTenantSettings.TenantInterceptorRoutingDataSource.CustomRoutingDataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = "com.tenancy.MultitenantJdbcTemplate")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MultitenantJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantJdbcTemplateApplication.class, args);
	}

	@Bean
    public DataSource dataSource(){
        CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(DataSourceMap.getDataSourceHashMap());
        return customDataSource;
    }

}
