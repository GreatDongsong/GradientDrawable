package dawson.com.gradientdrawable;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gradientBackground(this,getWindow().getDecorView());


    }

    public static void gradientBackground(final Activity activity, final View bgView) {
        final int colorDark;
        final int colorLight;
        colorLight = 0xff676f76;
        colorDark = 0xff333f48;
        bgView.post(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                ColorGradientDrawable colorGradientDrawable = new ColorGradientDrawable(bgView.getWidth(), bgView.getHeight(), new int[]{colorLight, colorDark});
                bgView.setBackground(colorGradientDrawable);
            }
        });
    }
}
