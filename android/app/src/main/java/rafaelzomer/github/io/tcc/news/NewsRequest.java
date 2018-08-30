package rafaelzomer.github.io.tcc.news;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import rafaelzomer.github.io.tcc.request.AbstractRequest;

public class NewsRequest extends AbstractRequest<News> {
    public NewsRequest(Context context) {
        super(context);
    }

    @Override
    protected String getUrl() {
        return "news";
    }

    protected Type getListClazz() {
        return new TypeToken<List<News>>(){}.getType();
    }

    @Override
    protected Class<News> getClazz() {
        return News.class;
    }
}
