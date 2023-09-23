package com.example.virtualcashdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*******************************************
 * *Created by Hanzel B. Metrio 2023-09/01 *
 ******************************************/
public class drawerAdapter extends BaseAdapter{
    private Context context;
    private List<Drawer> drawer;

    public drawerAdapter(Context context, List<Drawer> drawer){
        this.context =context;
        this.drawer =drawer;
    }

    @Override
    public int getCount() {
        return drawer != null ? drawer.size():0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.drawerlist, viewGroup, false);

        TextView txtDrawer=rootView.findViewById(R.id.drawer);

        txtDrawer.setText(drawer.get(i).getDrawer());

        return rootView;
    }
}
