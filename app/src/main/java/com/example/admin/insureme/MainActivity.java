package com.example.admin.insureme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandablelistview_home_menu_);
        final ArrayList<Home_menu> home_menu = getData();
        HomeMenuAdapter adapter = new HomeMenuAdapter(this, home_menu);
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), home_menu.get(groupPosition).child_items.get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Intent renewpolicy, getQuote, myAccount;
                switch (groupPosition){
                    case 1:
                        renewpolicy = new Intent(MainActivity.this, RenewP.class);
                        MainActivity.this.startActivity(renewpolicy);
                        break;
                    case 2:
                        getQuote = new Intent(MainActivity.this, GetQuote.class);
                        MainActivity.this.startActivity(getQuote);
                        break;
                    case 3:
                        myAccount = new Intent(MainActivity.this, MyAccount.class);
                        MainActivity.this.startActivity(myAccount);
                        break;
                }

                return false;
            }
        });

        }
    private ArrayList<Home_menu> getData() {
       Home_menu buy_policy=new Home_menu("B1");
       Home_menu renew_policy=new Home_menu("B2");
       Home_menu get_quote=new Home_menu("B3");
       Home_menu my_account=new Home_menu("b4");

       buy_policy.child_items.add("M1");
       buy_policy.child_items.add("m2");
       buy_policy.child_items.add("m3");
       buy_policy.child_items.add("m4");


       ArrayList<Home_menu> whole_menu=new ArrayList<Home_menu>();
       whole_menu.add(buy_policy);
       whole_menu.add(renew_policy);
       whole_menu.add(get_quote);
       whole_menu.add(my_account);

        return whole_menu;
    }
}
