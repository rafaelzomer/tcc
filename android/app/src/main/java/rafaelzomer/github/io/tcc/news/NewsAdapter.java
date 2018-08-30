package rafaelzomer.github.io.tcc.news;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import rafaelzomer.github.io.tcc.R;
import rafaelzomer.github.io.tcc.adapter.GenericAdapter;

public class NewsAdapter extends GenericAdapter<News> {
    public NewsAdapter(List<News> dataset) {
        super(dataset);
    }

//    @NonNull
//    @Override
//    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.news_list_adapter, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
//        holder.set(mDataset.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
    static class ViewHolder extends GenericAdapter.ViewHolder {
        private TextView mTitle;
        private TextView mContent;

        @Override
        public void configure(View view) {
            mTitle = view.findViewById(R.id.title);
            mContent = view.findViewById(R.id.content);
        }

        @Override
        public void set(News news) {
            mTitle.setText(news.getTitle());
            mContent.setText(news.getContent());
        }

//        @Override
//        void set(News news) {
//        }
    }
}
