package com.example.m.lab08_listviewandadaptershomework;

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
                viewHolder.textViewNumber = (TextView) convertView.findViewById(R.id.textViewPrice);
                convertView.setTag(viewHolder);
            } else
            {
                viewHolder=(ViewHolder)convertView.getTag();
            }
            Player currentPlayer = mPlayers.get(position);
            viewHolder.textViewName.setText(currentPlayer.mName);
            viewHolder.textViewDescription.setText(currentPlayer.mDescription);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String price = formatter.format(currentPlayer.mNumber);
            viewHolder.textViewNumber.setText(price);
            return convertView;
        }
    }

    private static class ViewHolder {
        public TextView textViewName;
        public TextView textViewDescription;
        public TextView textViewNumber;

    }

    private ArrayList<Player> makePlayers() {
        ArrayList<Player> player = new ArrayList<Player>();
        player.add(new Player("LeBron James ", "HEIGHT\n" +
                "6 ft8 in\n" +
                "/ 2.03m\n" +
                "WEIGHT\n" +
                "250 lbs\n" +
                "/ 113.4kg\n" +
                "BORN\n" +
                "12/30/1984\n" +
                "AGE\n" +
                "31 years\n" +
                "FROM\n" +
                "St. Vincent-St. Mary HS (OH)\n" +
                "NBA DEBUT\n" +
                "2003\n" +
                "YEARS IN NBA\n" +
                "13\n" +
                "PREVIOUSLY\n" +
                "CLE 2014 - 2016\n" +
                "MIA 2010 - 2013\n" +
                "CLE 2003 - 2009 ",23));
        player.add(new Player("Kyrie Irving", "HEIGHT\n" +
                "6 ft3 in\n" +
                "/ 1.9m\n" +
                "WEIGHT\n" +
                "193 lbs\n" +
                "/ 87.5kg\n" +
                "BORN\n" +
                "03/23/1992\n" +
                "AGE\n" +
                "24 years\n" +
                "FROM\n" +
                "Duke\n" +
                "NBA DEBUT\n" +
                "2011\n" +
                "YEARS IN NBA\n" +
                "5\n" +
                "PREVIOUSLY\n" +
                "CLE 2011 - 2016", 2));
        player.add(new Player("Kevin Love ", "HEIGHT\n" +
                "6 ft10 in\n" +
                "/ 2.08m\n" +
                "WEIGHT\n" +
                "251 lbs\n" +
                "/ 113.9kg\n" +
                "BORN\n" +
                "09/07/1988\n" +
                "AGE\n" +
                "28 years\n" +
                "FROM\n" +
                "UCLA\n" +
                "NBA DEBUT\n" +
                "2008\n" +
                "YEARS IN NBA\n" +
                "8\n" +
                "PREVIOUSLY\n" +
                "CLE 2014 - 2016\n" +
                "MIN 2008 - 2013 ", 0));
        player.add(new Player("Chris Anderson", "HEIGHT\n" +
                "6 ft10 in\n" +
                "/ 2.08m\n" +
                "WEIGHT\n" +
                "245 lbs\n" +
                "/ 111.1kg\n" +
                "BORN\n" +
                "07/07/1978\n" +
                "AGE\n" +
                "38 years\n" +
                "FROM\n" +
                "Blinn\n" +
                "NBA DEBUT\n" +
                "2001\n" +
                "YEARS IN NBA\n" +
                "14\n" +
                "PREVIOUSLY\n" +
                "CLE 2016 - 2016\n" +
                "MEM 2015 - 2015\n" +
                "MIA 2012 - 2015\n" +
                "DEN 2008 - 2011  ", 00));
        player.add(new Player("Mo Williams ", "HEIGHT\n" +
                "6 ft1 in\n" +
                "/ 1.85m\n" +
                "WEIGHT\n" +
                "198 lbs\n" +
                "/ 89.8kg\n" +
                "BORN\n" +
                "12/19/1982\n" +
                "AGE\n" +
                "33 years\n" +
                "FROM\n" +
                "Alabama\n" +
                "NBA DEBUT\n" +
                "2003\n" +
                "YEARS IN NBA\n" +
                "13\n" +
                "PREVIOUSLY\n" +
                "CLE 2015 - 2015\n" +
                "CHA 2014 - 2014\n" +
                "MIN 2014 - 2014\n" +
                "POR 2013 - 2013 ", 52));
        return player;
    }

    private class Player {
        String mName;
        String mDescription;
        double mNumber;

        public Player(String name, String description, double number) {
            this.mName = name;
            this.mDescription = description;
            this.mNumber = number;
        }

    }
}


