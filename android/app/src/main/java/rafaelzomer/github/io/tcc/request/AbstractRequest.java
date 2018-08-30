package rafaelzomer.github.io.tcc.request;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractRequest<T> {
    private final String SERVER_URL = "http://10.0.2.2:8080/";
    private final Gson gson = new Gson();
    private RequestQueue queue;

    public AbstractRequest(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }

    protected abstract String getUrl();

    protected abstract Class<T> getClazz();

    protected abstract Type getListClazz();

    public void getList(final Consumer<List<T>> success, final Consumer<VolleyError> error) {
        this.query("", response -> {
            success.accept(gson.fromJson(response, getListClazz()));
        }, error);
    }

    public void getOne(Long id, final Consumer<T> success) {
        this.getOne(id, success, null);
    }

    public void getOne(Long id, final Consumer<T> success, final Consumer<VolleyError> error) {
        this.query(id.toString(), response -> {
            success.accept(gson.fromJson(response, getClazz()));
        }, error);
    }

    protected <R> void query(String url, final Consumer<String> success, final Consumer<VolleyError> error) {
        GsonRequest request = new GsonRequest(SERVER_URL + getUrl() + "/" + url,
                success::accept,
                response -> {
                    if (error != null) {
                        error.accept(response);
                    }
                });
        this.queue.add(request);
    }
}
