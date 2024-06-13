package com.carating.moneygonee.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carating.moneygonee.R;
import com.carating.moneygonee.model.Data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class expenseFragment extends Fragment {

    // Firebase database
    private FirebaseAuth mAuth;
    private DatabaseReference mExpenseDatabase;
    // Recycler View
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<Data, expenseFragment.MyViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_expense, container, false);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uid = mUser.getUid();

        mExpenseDatabase = FirebaseDatabase.getInstance().getReference().child("ExpenseDatabase").child(uid);

        recyclerView = myView.findViewById(R.id.recycle_id_expense);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();

        // Configure FirebaseRecyclerOptions
        FirebaseRecyclerOptions<Data> options =
                new FirebaseRecyclerOptions.Builder<Data>()
                        .setQuery(mExpenseDatabase, Data.class)
                        .build();

        // Initialize FirebaseRecyclerAdapter
        adapter = new FirebaseRecyclerAdapter<Data, expenseFragment.MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull expenseFragment.MyViewHolder holder, int position, @NonNull Data model) {
                holder.setType(model.getType());
                holder.setDesc(model.getDesc());
                holder.setDate(model.getDate());
                holder.setAmount(model.getAmount());
            }

            @NonNull
            @Override
            public expenseFragment.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.expense_recycler_data, parent, false);
                return new expenseFragment.MyViewHolder(view);
            }
        };

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);

        // Start listening for database changes
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        // Stop listening for database changes
        if (adapter != null) {
            adapter.stopListening();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        private void setType(String type) {
            TextView mType = mView.findViewById(R.id.type_txt_expense);
            mType.setText(type);
        }

        private void setDesc(String note) {
            TextView mDesc = mView.findViewById(R.id.desc_txt_expense);
            mDesc.setText(note);
        }

        private void setDate(String date) {
            TextView mDate = mView.findViewById(R.id.date_txt_expense);
            mDate.setText(date);
        }

        private void setAmount(int amount) {
            TextView mAmount = mView.findViewById(R.id.amount_txt_expense);
            String stAmount = String.valueOf(amount);
            mAmount.setText(stAmount);
        }
    }
}
