package com.barshop.app.ejb.remote;

import java.util.List;

import javax.ejb.Remote;

import com.barshop.app.models.dto.Country;

@Remote
public interface CountryEJBRemote {

    public List<Country> findAll();

    public void deleteById(long id);

    public void save( Country country );

    public void update( Country country );

}
