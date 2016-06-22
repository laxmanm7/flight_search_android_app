package saumikbhattacharya.FlightSearch.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    public Context ba_context;
    public ArrayList<ListRowItem> listitem = new ArrayList<>();
    public LayoutInflater inflater;
    ListRowItem currentlistitem;

    public MyBaseAdapter(Context ma_context, ArrayList<ListRowItem> ma_listitem) {
        super();
        this.ba_context = ma_context;
        this.listitem = ma_listitem;

        inflater = (LayoutInflater) ba_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.listitem.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null)
            vi = inflater.inflate(R.layout.listview_item_layout, parent, false);

        TextView carrier = (TextView) vi.findViewById(R.id.layout_textview1);
        TextView number = (TextView) vi.findViewById(R.id.layout_textview2);
        TextView arrivaltime_label = (TextView) vi.findViewById(R.id.layout_textview3);
        TextView departuretime_label = (TextView) vi.findViewById(R.id.layout_textview4);
        TextView saletotal_label = (TextView) vi.findViewById(R.id.layout_textview5);
        TextView arrivaltime = (TextView) vi.findViewById(R.id.layout_textview7);
        TextView departuretime = (TextView) vi.findViewById(R.id.layout_textview6);
        TextView saletotal = (TextView) vi.findViewById(R.id.layout_textview8);

        currentlistitem = listitem.get(position);

        String str_carrier = currentlistitem.getCarrier();
        String str_number = currentlistitem.getNumber();
        String str_arrivaltime = currentlistitem.getArrival();
        String str_departuretime = currentlistitem.getDeparture();
        String str_saletotal = currentlistitem.getSaletotal();
        String origin = currentlistitem.getOrigin();
        String destination = currentlistitem.getDestination();

        carrier.setText(str_carrier);
        number.setText(str_number);
        arrivaltime_label.setText(origin);
        departuretime_label.setText(destination);
        saletotal_label.setText("Total Fare");
        arrivaltime.setText(str_arrivaltime+" HRS");
        departuretime.setText(str_departuretime+" HRS");
        saletotal.setText(str_saletotal);

        return vi;
    }
}

