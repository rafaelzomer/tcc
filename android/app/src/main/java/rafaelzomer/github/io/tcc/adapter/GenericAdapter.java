package rafaelzomer.github.io.tcc.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rafaelzomer.github.io.tcc.R;
import rafaelzomer.github.io.tcc.news.News;
import rafaelzomer.github.io.tcc.news.NewsAdapter;

public class GenericAdapter<T> extends RecyclerView.Adapter<GenericAdapter.ViewHolder> {
    private List<T> mDataset;
    public GenericAdapter(List<T> mDataset) {
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenericAdapter.ViewHolder holder, int position) {
        holder.set(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface Holder<T> {
        void configure(View view);
        void set(T news);
    }

    static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        private Holder<T> holder;

        private ViewHolder(Holder<T> holder, View v) {
            super(v);
            this.holder = holder;
        }

        public abstract void configure(View view);

        void set(T news) {
            holder.set(news);
        };
    }
}
