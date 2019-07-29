package com.tren.huantai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationProperties extends SpringBootServletInitializer implements WebServerFactoryCustomizer <ConfigurableWebServerFactory>{
    @Value("${auto_create.table}")
    private String isCreateTable;
    @Value("${my.show_sql}")
    private boolean isShowSql;
    @Value("${server_port}")
    private int server_port;
    public String getIsCreateTable() {
        return isCreateTable;
    }

    public void setIsCreateTable(String isCreateTable) {
        this.isCreateTable = isCreateTable;
    }

    public boolean isShowSql() {
        return isShowSql;
    }

    public void setShowSql(boolean showSql) {
        isShowSql = showSql;
    }
    public ApplicationProperties() {

    }

    public int getServer_port() {
        return server_port;
    }

    public void setServer_port(int server_port) {
        this.server_port = server_port;
    }



    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(this.server_port);
    }
}
