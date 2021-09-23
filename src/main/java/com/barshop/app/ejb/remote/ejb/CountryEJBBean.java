package com.barshop.app.ejb.remote.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.models.dao.GenericDAO;
import com.barshop.app.models.dto.Country;
import com.barshop.app.models.entity.Entity;
import com.barshop.app.models.mapper.util.EntityReflexionUtil;

@Stateless(name = "CountryEJBBean")
public class CountryEJBBean implements CountryEJBRemote {

    private static final Logger LOGGER = Logger.getLogger(CountryEJBBean.class);

    private List<Country> countries;

    private GenericDAO<Country, Entity, Long> dao;

    public CountryEJBBean() {
        this.countries = new ArrayList<>();
        dao = new GenericDAO<>();
    }

    @Override
    public List<Country> findAll() {
        LOGGER.info("findAll");
        Entity country = EntityReflexionUtil.newInstance("Country");
        return dao.findAll(Country.class, country);
    }

    @Override
    public void deleteById( long id ) {
        LOGGER.info("deleteById");
        int position = -1;
        for (int i = 0; i < this.countries.size(); i++) {
            if (this.countries.get(i).getId() == id) {
                position = i;
            }
        }

        if (position != -1) {
            this.countries.remove(position);
        }
        LOGGER.info(this.countries.size());
    }

    @Override
    public void save( Country country ) {
        LOGGER.info("save");
        LOGGER.info(this.countries.size());
        this.countries.add(country);
    }

    @Override
    public void update( Country country ) {
        LOGGER.info("update");
        int position = -1;
        for (int i = 0; i < this.countries.size(); i++) {
            if (this.countries.get(i).getId() == country.getId()) {
                position = i;
            }
        }

        if (position != -1) {
            Country updateC = this.countries.get(position);
            updateC.setName(country.getName());
            updateC.setThreeDigitIso(country.getThreeDigitIso());
            updateC.setTwoDigitIso(country.getTwoDigitIso());
            updateC.setCountryCallingCode(country.getCountryCallingCode());
            updateC.setCountryCode(country.getCountryCode());
        }

        LOGGER.info(this.countries.size());
    }

}
