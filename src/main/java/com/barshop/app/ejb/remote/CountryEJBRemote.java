package com.barshop.app.ejb.remote;

import java.util.List;

import javax.ejb.Remote;

import com.barshop.app.models.dto.Country;

@Remote
public interface CountryEJBRemote {

    public List<Country> findAll();

    public boolean deleteById(long id);

    public Country createOrUpdate( Country country );

}
