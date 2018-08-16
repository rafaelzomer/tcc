package rafaelzomer.github.io.tcc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);
        load();
        return view;
    }

    private void load() {
        TextView text = view.findViewById(R.id.info_text);
        text.getText();
    }

}
