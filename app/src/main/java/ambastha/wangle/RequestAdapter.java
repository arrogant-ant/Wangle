package ambastha.wangle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabita_Sant on 11/03/17.
 */

public class RequestAdapter extends ArrayAdapter<Request> {
    List<Request> list = new ArrayList<Request>();
    public RequestAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Request object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Request getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ReqHolder reqHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            reqHolder = new ReqHolder();
            reqHolder.siteManager = (TextView) row.findViewById(R.id.name);
            reqHolder.rType = (TextView) row.findViewById(R.id.type);
            reqHolder.rNo = (TextView) row.findViewById(R.id.no);
            row.setTag(reqHolder);
        } else {
            reqHolder = (ReqHolder) row.getTag();
        }
        Request request = this.getItem(position);
        reqHolder.siteManager.setText(request.getSiteManager());
        reqHolder.rType.setText(request.getResType());
        reqHolder.rNo.setText(request.getResNo());

        return row;
    }

    static class ReqHolder {
        TextView siteManager, rType, rNo;
    }
}
