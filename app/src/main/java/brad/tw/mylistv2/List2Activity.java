package brad.tw.mylistv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class List2Activity extends AppCompatActivity {
    private RecyclerView recycler;
    private String[] dataset = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6"};
    private LinkedList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        data = new LinkedList<>();
        for (String s : dataset){
            data.add(s);
        }

        recycler = (RecyclerView)findViewById(R.id.recyclerView);

    }
}
