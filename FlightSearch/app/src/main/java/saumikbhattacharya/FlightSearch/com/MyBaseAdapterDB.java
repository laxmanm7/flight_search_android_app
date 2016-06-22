package saumikbhattacharya.FlightSearch.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapterDB extends BaseAdapter {

    public Context ba_context;
    public ArrayList<ListRowItem> listItems = new ArrayList<>();
    public LayoutInflater inflater;
    ListRowItem currentlistitem;

    public MyBaseAdapterDB(Context ma_context, ArrayList<ListRowItem> ma_listItems) {
        super();
        this.ba_context = ma_context;
        this.listItems = ma_listItems;

        inflater = (LayoutInflater) ba_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null)
            vi = inflater.inflate(R.layout.saved_item_layout, parent, false);

        TextView origin = (TextView) vi.findViewById(R.id.layout_textview4);
        TextView destination = (TextView) vi.findViewById(R.id.layout_textview5);
        TextView travel_date = (TextView) vi.findViewById(R.id.layout_textview6);
        TextView adult = (TextView) vi.findViewById(R.id.layout_textview10);
        TextView infant = (TextView) vi.findViewById(R.id.layout_textview11);
        TextView searched_date = (TextView) vi.findViewById(R.id.layout_textview12);

        currentlistitem = listItems.get(position);

        String str_origin = currentlistitem.getOrigin();
        String str_destination = currentlistitem.getDestination();
        String str_travel_date = currentlistitem.getDepartureDate();
        String str_adult = currentlistitem.getAdult();
        String str_infant = currentlistitem.getInfant();
        String str_searched_date = currentlistitem.getCurrentdate();

        origin.setText(str_origin);
        destination.setText(str_destination);
        travel_date.setText(str_travel_date);
        adult.setText(str_adult);
        infant.setText(str_infant);
        searched_date.setText(str_searched_date);

        return vi;
    }
}

