package com.example.myapplication;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Global {

    public void open(Fragment fragment, FragmentManager fm, Boolean animateLayout, Boolean addToBackStack, Boolean clearBackStack) {
        //initialize fragment transaction
        FragmentTransaction transaction = fm.beginTransaction();
        //clear stack based if sent clearBackStack=true
        clearStack(fm, clearBackStack);
        //show enter & exit animation if sent animateLayout=true
        showAnimateion(transaction, animateLayout);
        //making a transaction
        transaction.replace(R.id.frame_layout, fragment);
        //if send addToBackStack=true add transaction into stack
        addToStack(fragment, transaction, addToBackStack);
        //commit the transaction
        transaction.commit();
    }

    //if container id of framLayout is passd then this methos executes
    public void open(Fragment fragment, FragmentManager fm, int containerId) {
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }

    private void clearStack(FragmentManager fm, Boolean clearBackStack) {
        if (clearBackStack) {
            //clear the BackStack
            for (int i=0; i<fm.getBackStackEntryCount(); i++) fm.popBackStack();
        }
    }

    private void showAnimateion(FragmentTransaction transaction, Boolean animateLayout) {

        if (animateLayout) {
            //show animation while fragment enters & exits
            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        }
    }

    private void addToStack(Fragment fragment, FragmentTransaction transaction, Boolean addToBackStack) {
        if (addToBackStack) {
            //add the fragment to backStack
            String name = fragment.getClass().getName().toUpperCase();
            transaction.addToBackStack(name);
        }
    }

    public void hideKeypad(Context context, EditText editText){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void callIntent(){
        /*Intent intent = new Intent(CurrentActivity.this, NextActivity.class);
        intent.putExtra("key", value);
        intent.putExtra("key", value);
        CurrentActivity.this.startActivity(intent);*/

        /*
        Intent intent = getIntent();
        String id = intent.getStringExtra(key)
        String
        * */

        /*
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString(key);
            pass = extras.getString(key);
        }
        * */
    }
}
