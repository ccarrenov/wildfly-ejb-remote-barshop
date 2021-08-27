package com.barshop.app.ejb.remote.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.barshop.app.ejb.remote.CountryEJBRemote;
import com.barshop.app.models.dto.Country;

@Stateless(name = "CountryEJBBean")
public class CountryEJBBean implements CountryEJBRemote {

    private List<Country> countries;

    public CountryEJBBean() {
        this.countries = new ArrayList<>();
    }

    @Override
    public List<Country> findAll() {
        return countries;
    }

    @Override
    public void deleteById( long id ) {
        int position = -1;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId() == id) {
                position = i;
            }
        }

        if (position != -1) {
            countries.remove(position);
        }
    }

    @Override
    public void save( Country country ) {
        countries.add(country);
    }

    @Override
    public void update( Country country ) {
        int position = -1;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId() == country.getId()) {
                position = i;
            }
        }

        if (position != -1) {
            Country updateC = countries.get(position);
            updateC.setName(country.getName());
            updateC.setThreeDigitIso(country.getThreeDigitIso());
            updateC.setTwoDigitIso(country.getTwoDigitIso());
            updateC.setCountryCallingCode(country.getCountryCallingCode());
            updateC.setCountryCode(country.getCountryCode());
        }
    }

}
