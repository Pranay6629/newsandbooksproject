package com.monu.newsapp.parameter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("finskyOfferType")
    @Expose
    private Integer finskyOfferType;
    @SerializedName("listPrice")
    @Expose
    private ListPrice_ listPrice;
    @SerializedName("retailPrice")
    @Expose
    private RetailPrice_ retailPrice;

    /**
     * No args constructor for use in serialization
     *
     */
    public Offer() {
    }

    /**
     *
     * @param retailPrice
     * @param listPrice
     * @param finskyOfferType
     */
    public Offer(Integer finskyOfferType, ListPrice_ listPrice, RetailPrice_ retailPrice) {
        super();
        this.finskyOfferType = finskyOfferType;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
    }

    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice_ getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
    }

}
