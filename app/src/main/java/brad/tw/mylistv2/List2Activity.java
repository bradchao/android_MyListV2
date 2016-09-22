package brad.tw.mylistv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class List2Activity extends AppCompatActivity {
    private RecyclerView recycler;
    private String[] dataset = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6"};
    private LinkedList<String> data;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        data = new LinkedList<>();
        for (String s : dataset){
            data.add(s);
        }

        recycler = (RecyclerView)findViewById(R.id.recyclerView);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new MyAdapter();
        recycler.setAdapter(adapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public MyViewHolder(View v) {
                super(v);
                mTextView = (TextView) v;
            }
        }

//        public MyAdapter() {
//        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // brad
            View view = View.inflate(List2Activity.this,
                    R.layout.layout_itemv2,null);

            // google
//            View view = LayoutInflater.from(List2Activity.this)
//                    .inflate(R.layout.layout_itemv2, parent, false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


}
