package com.example.admin.insureme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 23/03/2017.
 */

public class HomeMenuAdapter extends BaseExpandableListAdapter {
    private ArrayList<Home_menu> home_menu;
    LayoutInflater inflater;

    public HomeMenuAdapter(Context context, ArrayList<Home_menu> home_menu){
        this.home_menu = home_menu;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return home_menu.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return home_menu.get(groupPosition).child_items.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return home_menu.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return home_menu.get(groupPosition).child_items.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = inflater.inflate(R.layout.home_menu_view, null);
        }
        Home_menu homeMenu = (Home_menu)getGroup(groupPosition);
        TextView mainMenuTextView = (TextView)convertView.findViewById(R.id.home_menu_item);
        ImageView menuIcon = (ImageView)convertView.findViewById(R.id.home_menu_icon);

        String item_title = homeMenu.title;
        mainMenuTextView.setText(item_title);

        switch(groupPosition){
            case 0:
                menuIcon.setImageResource(R.drawable.cart);
                convertView.setBackgroundResource(R.drawable.lightblue_bg);
                break;

            case 1:
                menuIcon.setImageResource(R.drawable.arrows);
                convertView.setBackgroundResource(R.drawable.darkblue_bg);
                break;
            case 2:
                menuIcon.setImageResource(R.drawable.quote);
                convertView.setBackgroundResource(R.drawable.lightpurple_bg);
                break;
            case 3:
                menuIcon.setImageResource(R.drawable.profile);
                convertView.setBackgroundResource(R.drawable.darkpurple_bg);
                break;
            default:
                menuIcon.setImageResource(R.drawable.quote);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.home_child_menu, null);
        }
        String child = (String) getChild(groupPosition, childPosition);
        TextView childTextView = (TextView) convertView.findViewById(R.id.child_textView);

        childTextView.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

}
