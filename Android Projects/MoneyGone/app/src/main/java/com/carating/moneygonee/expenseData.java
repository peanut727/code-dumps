package com.carating.moneygonee;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class expenseData {

        public int amount;
        public String name;
        public String category;
        public String date;
        public String desc;
        public String user;

        public expenseData() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public expenseData(int amount, String name, String category, String date, String desc, String user) {
            this.amount = amount;
            this.name = name;
            this.category = category;
            this.date = date;
            this.desc = desc;
            this.user = user;
        }
}
