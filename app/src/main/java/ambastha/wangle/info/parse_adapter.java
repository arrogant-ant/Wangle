package ambastha.wangle.info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ambastha.wangle.R;

/**
 * Created by shubham on 3/11/2017.
 */

public class parse_adapter extends ArrayAdapter
{
    List list=new ArrayList();
    public parse_adapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Information object) {
        super.add(object);
        list.add(object);
    }


    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        contactHolder ch;
        if(row==null) {
            LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = li.inflate(R.layout.individual_layout, parent, false);
            ch = new contactHolder();
            ch.tx_empid = (TextView) row.findViewById(R.id.empid);
            ch.tx_password = (TextView) row.findViewById(R.id.password);
            ch.tx_emailid = (TextView) row.findViewById(R.id.emailid);
            ch.tx_phone_no = (TextView) row.findViewById(R.id.phone_no);
            row.setTag(ch);

        }
        else
        {
           ch=(contactHolder)row.getTag();

        }
        Information info=(Information)this.getItem(position);
        ch.tx_emailid.setText(info.getEmailid());
        ch.tx_password.setText(info.getPassword());
        ch.tx_phone_no.setText(info.getPhone_no());
        ch.tx_phone_no.setText(info.getPhone_no());


        return row;
    }
     static class contactHolder
    {
   TextView tx_empid,tx_password,tx_emailid,tx_phone_no;
    }
}
