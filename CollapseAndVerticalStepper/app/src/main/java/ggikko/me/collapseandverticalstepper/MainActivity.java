package ggikko.me.collapseandverticalstepper;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.text1) TextView text1;
    @Bind(R.id.text2) TextView text2;
    @Bind(R.id.appbar) AppBarLayout appbar;

    int flag = 3;
    @OnClick(R.id.text1)
    void setAlpha(){
    }

    //TODO : 0은 안보이는거 1은 보이는거

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("ggikko", "scr6oll Y " + verticalOffset);
                appBarLayout.getY();

                final float scale = getResources().getDisplayMetrics().density;
                int height = (int)((int)(verticalOffset - 0.5f)/scale);
                Log.e("ggikko", "height Y " + height);
                Log.e("ggikko", "getY Y " + height);
                Log.e("ggikko", "value " + (1 - ((-height) / 160f) * 2));

                text2.setAlpha(1-(((-height)/160f)*2f));
                text1.setAlpha(1-(((-height)/160f)*2f));

            }
        });

    }

    public void scrolling(int height) {
        Log.e("ggikko", "scroll Y " + height);
    }
}
