package com.example.m.cavaliuerslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;



import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView playerListView;
    ArrayList<Player> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerListView = (ListView)findViewById(R.id.listView);
        players = makePlayers();
        PlayerAdapter adapter = new PlayerAdapter(this, players);
        playerListView.setAdapter(adapter);
        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), players.get(position).mName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class PlayerAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<Player> mPlayers;
        LayoutInflater mInflater;

        public PlayerAdapter(Context c, ArrayList<Player> players) {
            mContext = c;
            mPlayers = players;
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        public int getCount() {
            return mPlayers.size();

        }

        public Object getItem(int position) {
            return mPlayers.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.players_view_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
                viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
                viewHolder.textViewNumber = (TextView) convertView.findViewById(R.id.textViewNumber);
                viewHolder.textViewSalary =(TextView) convertView.findViewById(R.id.textViewSalary);
                convertView.setTag(viewHolder);
            } else
            {
                viewHolder=(ViewHolder)convertView.getTag();
            }
            Player currentPlayer = mPlayers.get(position);
            viewHolder.textViewName.setText(currentPlayer.mName);
            viewHolder.textViewDescription.setText(currentPlayer.mDescription);
            NumberFormat formatter1 = NumberFormat.getCurrencyInstance();
            String price = formatter1.format(currentPlayer.mSallary);
            viewHolder.textViewSalary.setText(price);
            NumberFormat formatter = NumberFormat.getIntegerInstance();
            String number=formatter.format(currentPlayer.mNumber);
            viewHolder.textViewNumber.setText(number);
            return convertView;
        }
    }

    private static class ViewHolder {
        public TextView textViewName;
        public TextView textViewDescription;
        public TextView textViewNumber;
        public TextView textViewSalary;

    }

    private ArrayList<Player> makePlayers() {
        ArrayList<Player> player = new ArrayList<Player>();
        player.add(new Player("LeBron James ", "HEIGHT 6 ft8 in" ,23,31000000));
        player.add(new Player("Kyrie Irving", "HEIGHT 6 ft3 in" , 2,17640000));
        player.add(new Player("Kevin Love ", "HEIGHT 6 ft10 in" , 0,21170000));
        player.add(new Player("Chris Anderson", "HEIGHT 6 ft10 in" , 00,5000000));
        player.add(new Player("Mo Williams ", "HEIGHT 6 ft 1 in", 52,3750000));
        return player;
    }

    private class Player {
        String mName;
        String mDescription;
        int mNumber;
        int mSallary;

        public Player(String name, String description, int number, int sallary) {
            this.mName = name;
            this.mDescription = description;
            this.mNumber = number;
            this.mSallary=sallary;
        }

    }
}
