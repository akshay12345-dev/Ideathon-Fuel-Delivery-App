package com.idea.fuel1;

public class Fifth {
    String idorder1,customermail79,quantityorder,orderamount,pumpidentity,vehiclid,edumail;

    public String getEdumail() {
        return edumail;
    }

    public String getIdorder1() {
        return idorder1;
    }

    public String getCustomermail79() {
        return customermail79;
    }

    public String getQuantityorder() {
        return quantityorder;
    }

    public String getOrderamount() {
        return orderamount;
    }

    public String getPumpidentity() {
        return pumpidentity;
    }

    public String getVehiclid() {
        return vehiclid;
    }

    public Fifth(String idorder1,String customermail79, String quantityorder, String orderamount, String pumpidentity, String vehiclid,String edumail) {
        this.idorder1=idorder1;
        this.customermail79 = customermail79;
        this.quantityorder = quantityorder;
        this.orderamount = orderamount;
        this.pumpidentity = pumpidentity;
        this.vehiclid = vehiclid;
        this.edumail=edumail;
    }
}
