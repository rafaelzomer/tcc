package rafaelzomer.github.io.tcc.news;

import android.arch.core.util.Function;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

import rafaelzomer.github.io.tcc.R;
import rafaelzomer.github.io.tcc.request.GsonRequest;

public class NewsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);

//        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView = view.findViewById(R.id.news_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        new ClientResource("http://restlet.com").get().write(System.out);
//        NewsAsyncTask newsAsyncTask = new NewsAsyncTask();
//        newsAsyncTask.execute();
        NewsRequest newsRequest = new NewsRequest(this.getContext());
        newsRequest.getList(news -> {
            Log.d("zomer=NOT", "=="+news);
            for (News newse : news) {
                Log.d("zomer=2", "-->"+newse);
            }
        }, null);
//        RequestQueue queue = Volley.newRequestQueue(this.getContext());
//        String url = "http://10.0.2.2:8080/news/1";
//
//// Request a string response from the provided URL.
//        GsonRequest<News> stringRequest = new GsonRequest(url, News.class,
//                new Response.Listener<News>() {
//                    @Override
//                    public void onResponse(News response) {
//                        // Display the first 500 characters of the response string.
//                        Log.d("zomer=", "=" + response.getTitle());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
////                mTextView.setText("That didn't work!");
//                    }
//                });

// Add the request to the RequestQueue.
//        queue.add(stringRequest);

        // specify an adapter (see also next example)
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            newsList.add(new News("teste" + i, "lorem10dadsdoasdksad ,d asd,a sd, d,a d,asd, sa,d ,a," + i));
        }
        mAdapter = new NewsAdapter(newsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void load() {
    }

}
