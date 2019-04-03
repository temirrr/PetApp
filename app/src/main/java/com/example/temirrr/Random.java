package com.example.temirrr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Random extends AppCompatActivity {
    TextView dogUrlTextView;
    ImageView randomDogImageVIew;
    String dogUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        dogUrlTextView = (TextView) findViewById(R.id.dog_url_text_view);
        randomDogImageVIew = (ImageView) findViewById(R.id.random_dog_image_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://random.dog/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceDog interfaceDog = retrofit.create(InterfaceDog.class);

        Call<Post> call = interfaceDog.getPost("mp4,webm,gif");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    dogUrlTextView.setText("Code:" + response.code());
                    return;
                }

                Post post = response.body();
                dogUrl = post.getUrl();
                Picasso.get().load(dogUrl).into(randomDogImageVIew);
                dogUrlTextView.setText("Retrieved from: " + "\n" + dogUrl);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                dogUrlTextView.setText(t.getMessage());

            }
        });
    }
}
