package com.carating.moneygonee;

public class users {
    public int uid;
    public String uname;
    public String umail;
    public String upassword;

    public users() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public users(int uid, String uname, String umail, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.umail = umail;
        this.upassword = upassword;
    }
}

