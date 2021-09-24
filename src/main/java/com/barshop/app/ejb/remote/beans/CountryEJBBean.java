package com.barshop.app.ejb.remote.beans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.models.dao.GenericDAO;
import com.barshop.app.models.dto.Country;
import com.barshop.app.models.entity.Entity;
import com.barshop.app.models.mapper.util.EntityReflexionUtil;

@Stateless(name = "CountryEJBBean")
public class CountryEJBBean implements CountryEJBRemote {

    private static final Logger LOGGER = Logger.getLogger(CountryEJBBean.class);
    
    private final static String COUNTRY = "Country";

    private GenericDAO<Country, Entity, Long> dao;

    protected EntityManager em;

    public CountryEJBBean() throws NamingException {
        dao = new GenericDAO<>();
    }

    @Override
    public List<Country> findAll() {
        LOGGER.info("findAll");
        Entity country = EntityReflexionUtil.newInstance(COUNTRY);
        return dao.findAll(Country.class, country);
    }

    @Override
    public boolean deleteById( long id ) {
        LOGGER.info("deleteById");
        Entity country = EntityReflexionUtil.newInstance(COUNTRY);
        try {
            dao.deleteById(country, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
            return false;
        }
    }

    @Override
    public Country createOrUpdate( final Country countryD ) {
        LOGGER.info("deleteById");
        Entity country = EntityReflexionUtil.newInstance(COUNTRY);
        try {
            return dao.createOrUpdate(Country.class, country, Long.class, countryD);
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }

}
