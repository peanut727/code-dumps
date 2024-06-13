package com.carating.moneygonee.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.carating.moneygonee.R;
import com.carating.moneygonee.model.Data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.api.Distribution;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class dashboardFragment extends Fragment {

    // Dashboard
    public dashboardFragment() {
        // Required empty public constructor
    }

    //Floating buttons
    private FloatingActionButton fab_main,fab_income_btn, fab_expense_btn;
    // Floating text
    private TextView fab_income_txt, fab_expense_txt, totInctxt, totExptxt;
    //boolean
    private boolean isOpen = false;

    //Animation
    private Animation FadOpen, FadClose;
    // Firebase Auth
    private FirebaseAuth mAuth;
    private DatabaseReference mIncomeDatabase;
    private DatabaseReference mExpenseDatabase;

    //Recycler Views
    private RecyclerView mRecyclerIncome, mRecyclerExpense, recyclerIncomeView, recyclerExpenseView;
    private FirebaseRecyclerAdapter<Data, dashboardFragment.IncomeViewHolder> incomeAdapter;
    private FirebaseRecyclerAdapter<Data, dashboardFragment.ExpenseViewHolder> expenseAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // authentication
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uid = mUser.getUid();

        mIncomeDatabase = FirebaseDatabase.getInstance().getReference().child("IncomeData").child(uid);
        mExpenseDatabase = FirebaseDatabase.getInstance().getReference().child("ExpenseDatabase").child(uid);

        // Views declaration
        fab_main = myView.findViewById(R.id.fb_main_plus_btn);
        fab_income_btn = myView.findViewById(R.id.income_ft_btn);
        fab_expense_btn = myView.findViewById(R.id.expense_ft_btn);

        //connect
        fab_income_txt = myView.findViewById(R.id.income_ft_text);
        fab_expense_txt = myView.findViewById(R.id.expense_ft_text);

        // Animation
        FadClose = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_close);
        FadOpen  = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_open);

        // Total income and expenses view
        totExptxt = myView.findViewById(R.id.expense_set_result);
        totInctxt = myView.findViewById(R.id.income_set_result);

        //Recycler
        mRecyclerIncome = myView.findViewById(R.id.recycler_income);
        mRecyclerExpense = myView.findViewById(R.id.recycler_expense);

        // Click listeners
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOpen) {

                    fab_income_btn.startAnimation(FadClose);
                    fab_expense_btn.startAnimation(FadClose);
                    fab_income_btn.setClickable(false);
                    fab_expense_btn.setClickable(false);

                    fab_income_txt.startAnimation(FadClose);
                    fab_expense_txt.startAnimation(FadClose);
                    fab_income_txt.setClickable(false);
                    fab_expense_txt.setClickable(false);
                    isOpen = false;

                }
                else
                {
                    fab_income_btn.startAnimation(FadOpen);
                    fab_expense_btn.startAnimation(FadOpen);
                    fab_income_btn.setClickable(true);
                    fab_expense_btn.setClickable(true);

                    fab_income_txt.startAnimation(FadOpen);
                    fab_expense_txt.startAnimation(FadOpen);
                    fab_income_txt.setClickable(true);
                    fab_expense_txt.setClickable(true);
                    isOpen = true;
                }

            }
        });
        fab_expense_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseDataInsert();
            }
        });

        fab_income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeDataInsert();
            }
        });

        // Total Income Amount Show
        mIncomeDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                double totalIncomeValue = 0;

                for (DataSnapshot incomeSnap:snapshot.getChildren()) {

                    Data data = incomeSnap.getValue(Data.class);
                    totalIncomeValue += data.getAmount();
                    String stTotal = String.valueOf(totalIncomeValue);
                    totInctxt.setText("₱ " + stTotal);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Total Expense Amount Show
        mExpenseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                double totalIncomeValue = 0;

                for (DataSnapshot incomeSnap:snapshot.getChildren()) {

                    Data data = incomeSnap.getValue(Data.class);
                    totalIncomeValue += data.getAmount();
                    String stTotal = String.valueOf(totalIncomeValue);
                    totExptxt.setText("₱ " + stTotal);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Recycler Code
        // Income recycler
        LinearLayoutManager lManagerIncome = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        lManagerIncome.setStackFromEnd(true);
        lManagerIncome.setReverseLayout(true);
        mRecyclerIncome.setHasFixedSize(true);
        mRecyclerIncome.setLayoutManager(lManagerIncome);
        // Income
        recyclerIncomeView = myView.findViewById(R.id.recycler_income);
        recyclerExpenseView = myView.findViewById(R.id.recycler_expense);

        // Expenses recycler
        LinearLayoutManager lManagerExpense = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        lManagerExpense.setReverseLayout(true);
        lManagerIncome.setStackFromEnd(true);
        mRecyclerExpense.setHasFixedSize(true);
        mRecyclerExpense.setLayoutManager(lManagerExpense);

        return myView;
    }

    public void incomeDataInsert() {

        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myView = inflater.inflate(R.layout.custom_layout_insertdata,null);
        myDialog.setView(myView);
        AlertDialog dialog = myDialog.create();

        final EditText edtAmount = myView.findViewById(R.id.amount_edt);
        final EditText edtType   = myView.findViewById(R.id.type_edt);
        final EditText edtDesc   = myView.findViewById(R.id.desc_edt);

        Button btnSave = myView.findViewById(R.id.save_btn);
        Button btnCancel = myView.findViewById(R.id.cancel_btn);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc   = edtDesc.getText().toString().trim();
                String amount = edtAmount.getText().toString().trim();
                String type   = edtType.getText().toString().trim();

                if (TextUtils.isEmpty(type)) {
                    edtType.setError("Required field.");
                    return;
                }

                if (TextUtils.isEmpty(amount)) {
                    edtAmount.setError("Required field.");
                    return;
                }
                int amountInt = Integer.parseInt(amount);

                if (TextUtils.isEmpty(desc)) {
                    edtDesc.setError("Required field.");
                    return;
                }

                String id = mIncomeDatabase.push().getKey();
                String mDate = DateFormat.getDateInstance().format(new Date());

                Data data = new Data(amountInt,type,desc,id,mDate);

                mIncomeDatabase.child(id).setValue(data);

                Toast.makeText(getActivity(),"Income Added!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //Cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void expenseDataInsert() {


        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myView = inflater.inflate(R.layout.custom_layout_insertdata, null);
        myDialog.setView(myView);
        AlertDialog dialog = myDialog.create();

        final EditText edtAmount = myView.findViewById(R.id.amount_edt);
        final EditText edtType = myView.findViewById(R.id.type_edt);
        final EditText edtDesc = myView.findViewById(R.id.desc_edt);

        Button btnSave = myView.findViewById(R.id.save_btn);
        Button btnCancel = myView.findViewById(R.id.cancel_btn);
        //Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = edtDesc.getText().toString().trim();
                String amount = edtAmount.getText().toString().trim();
                String type = edtType.getText().toString().trim();

                if (TextUtils.isEmpty(type)) {
                    edtType.setError("Required field.");
                    return;
                }

                if (TextUtils.isEmpty(amount)) {
                    edtAmount.setError("Required field.");
                    return;
                }
                int amountInt = Integer.parseInt(amount);

                if (TextUtils.isEmpty(desc)) {
                    edtDesc.setError("Required field.");
                    return;
                }

                String id = mExpenseDatabase.push().getKey();
                String mDate = DateFormat.getDateInstance().format(new Date());

                Data data = new Data(amountInt, type, desc, id, mDate);

                mExpenseDatabase.child(id).setValue(data);

                Toast.makeText(getActivity(), "Expense Added!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //Cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    // income data
    @Override
    public void onStart() {
        super.onStart();

        // Configure FirebaseRecyclerOptions
        FirebaseRecyclerOptions<Data> options =
                new FirebaseRecyclerOptions.Builder<Data>()
                        .setQuery(mIncomeDatabase, Data.class)
                        .build();

        // Initialize FirebaseRecyclerAdapter
        FirebaseRecyclerAdapter<Data, IncomeViewHolder> incomeAdapter = new FirebaseRecyclerAdapter<Data, IncomeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull IncomeViewHolder holder, int position, @NonNull Data model) {
                holder.setIncomeType(model.getType());
                holder.setIncomeDate(model.getDate());
                holder.setIncomeAmount(model.getAmount());
            }

            @NonNull
            @Override
            public IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dashboard_income, parent, false);
                return new IncomeViewHolder(view);
            }
        };

        // Set the adapter to the RecyclerView
        recyclerIncomeView.setAdapter(incomeAdapter);

        // Start listening for database changes
        incomeAdapter.startListening();

        //Expense
        FirebaseRecyclerOptions<Data> optionsExpense =
                new FirebaseRecyclerOptions.Builder<Data>()
                        .setQuery(mExpenseDatabase, Data.class)
                        .build();
        // Initialize FirebaseRecyclerAdapter Expense
        FirebaseRecyclerAdapter<Data, ExpenseViewHolder> expenseAdapter = new FirebaseRecyclerAdapter<Data, ExpenseViewHolder>(optionsExpense) {
            @Override
            protected void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position, @NonNull Data model) {
                holder.setExpenseType(model.getType());
                holder.setExpenseDate(model.getDate());
                holder.setExpenseAmount(model.getAmount());
            }
            @NonNull
            @Override
            public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dashboard_expense, parent, false);
                return new ExpenseViewHolder(view);
            }
        };

        recyclerExpenseView.setAdapter(expenseAdapter);
        expenseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        // Stop listening for database changes
        if (incomeAdapter != null) {
            incomeAdapter.stopListening();
        }
        if (expenseAdapter != null) {
            expenseAdapter.stopListening();
        }
    }

    public static class IncomeViewHolder extends RecyclerView.ViewHolder {

        View mIncomeView;

        public IncomeViewHolder(View itemView) {
            super(itemView);
            mIncomeView = itemView;
        }

        public void setIncomeType(String type) {
            TextView mType = mIncomeView.findViewById(R.id.type_Income_ds);
            mType.setText(type);
        }

        public void setIncomeAmount(int amount) {
            TextView mAmount = mIncomeView.findViewById(R.id.amount_Income_ds);
            String strAmount = String.valueOf(amount);
            mAmount.setText("₱ " + strAmount);
        }

        public void setIncomeDate(String date) {
            TextView mDate = mIncomeView.findViewById(R.id.date_Income_ds);
            mDate.setText(date);
        }
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {

        View mExpenseView;

        public ExpenseViewHolder(View itemView) {
            super(itemView);
            mExpenseView = itemView;
        }

        public void setExpenseType(String type) {
            TextView mType = mExpenseView.findViewById(R.id.type_Expense_ds);
            mType.setText(type);
        }

        public void setExpenseAmount(int amount) {
            TextView mAmount = mExpenseView.findViewById(R.id.amount_Expense_ds);
            String strAmount = String.valueOf(amount);
            mAmount.setText("₱ " + strAmount);
        }

        public void setExpenseDate(String date) {
            TextView mDate = mExpenseView.findViewById(R.id.date_Expense_ds);
            mDate.setText(date);
        }
    }
}
