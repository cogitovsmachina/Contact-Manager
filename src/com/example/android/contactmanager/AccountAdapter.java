package com.example.android.contactmanager;

import java.util.ArrayList;

import com.example.android.contactmanager.ContactAdder.AccountData;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Custom adapter used to display account icons and descriptions in the account spinner.
 */
 public class AccountAdapter extends ArrayAdapter<AccountData> {
    public AccountAdapter(Context context, ArrayList<AccountData> accountData) {
        super(context, android.R.layout.simple_spinner_item, accountData);
        setDropDownViewResource(R.layout.account_entry);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // Inflate a view template
        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) getContext()).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.account_entry, parent, false);
        }
        TextView firstAccountLine = (TextView) convertView.findViewById(R.id.firstAccountLine);
        TextView secondAccountLine = (TextView) convertView.findViewById(R.id.secondAccountLine);
        ImageView accountIcon = (ImageView) convertView.findViewById(R.id.accountIcon);

        // Populate template
        AccountData data = getItem(position);
        firstAccountLine.setText(data.getName());
        secondAccountLine.setText(data.getTypeLabel());
        Drawable icon = data.getIcon();
        if (icon == null) {
            icon = getContext().getResources().getDrawable(android.R.drawable.ic_menu_search);
        }
        accountIcon.setImageDrawable(icon);
        return convertView;
    }
}
