package com.idea.fuel1;

public class Four {
    String sid,ppname,dbname,dcontact,dlocation,email4;

    public String getSid() {
        return sid;
    }

    public String getPpname() {
        return ppname;
    }

    public String getDbname() {
        return dbname;
    }

    public String getDcontact() {
        return dcontact;
    }

    public String getDlocation() {
        return dlocation;
    }



    public String getEmail4() {
        return email4;
    }

    public Four(String sid, String ppname, String dbname, String dcontact, String dlocation,String email4) {
        this.sid = sid;
        this.ppname = ppname;
        this.dbname = dbname;
        this.dcontact = dcontact;
        this.dlocation = dlocation;

        this.email4=email4;
    }
}
