package com.barshop.app.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Country extends DataAccessObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("countryCode")
    private short countryCode;

    @JsonProperty("twoDigitIso")
    private String twoDigitIso;

    @JsonProperty("threeDigitIso")
    private String threeDigitIso;

    @JsonProperty("countryCallingCode")
    private String countryCallingCode;
}
