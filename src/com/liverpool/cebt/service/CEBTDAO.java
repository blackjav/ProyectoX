package com.liverpool.cebt.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Super clase para el manejo de la persistencia para operaciones específicas de la aplicación SITD
 */
public class CEBTDAO {
    public static final String SQL_MAPPING_FILE = "Mybatis-config.xml";

    protected SqlSession getSQLSession() throws IOException
    {	
        String resource =SQL_MAPPING_FILE;
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlMapper.openSession();
    }
}