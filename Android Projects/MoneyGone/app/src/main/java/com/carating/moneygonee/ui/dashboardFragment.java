package com.carating.moneygonee.ui;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private TextView fab_income_txt, fab_expense_txt;
    //boolean
    private boolean isOpen = false;

    //Animation
    private Animation FadOpen, FadClose;
    // Firebase Auth
    private FirebaseAuth mAuth;
    private DatabaseReference mIncomeDatabase;
    private DatabaseReference mExpenseDatabase;

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
        //Save
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
}