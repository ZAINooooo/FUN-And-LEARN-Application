package minhasoftapp.funandlearn;

/**
 * Created by hc on 1/21/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.example.hc.toogl21stjan.com.example.htc.toogl21jan_Inside_UI.Utils.models.WelcomeActivity;

import com.example.hc.game1.R;

//import xdroid.toaster.Toaster;
////import java.security.Signature;


@SuppressWarnings("ALL")
public class Splashscreen extends Activity

{


    TextView Loading;

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    /** Called when the activity is first created. */
    Thread splashTread;
    //SessionManagement sessionManagement;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

               //logTokens(this);


            //hiding the title bar while showing the splash screen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

                //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen);

              //call the method
           StartAnimations();

        //sessionManagement =new SessionManagement(this);




    }


    //modify the UI component on a non UI thread so that app won't crash

    private void setText(final CharSequence text)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.loading_text)).setText(text);
            }
        });
    }




//    public static void logTokens(Activity context)
//    {
//
//        // Add code to print out the key hash
//        try {
//            PackageInfo info = context.getPackageManager().getPackageInfo(
//                    context.getApplicationContext().getPackageName(),
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA-1");
//                md.update(signature.toByteArray());
////                Log.e("SHA1-KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
////                Log.e("SHA1-KeyHash:::",md.toString());
//
//                md = MessageDigest.getInstance("MD5");
//                md.update(signature.toByteArray());
////                Log.e("MD5-KeyHash:::",
////                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
//
//                md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.e("SHA-Hex-From-KeyHash:::", bytesToHex(md.digest()));
//                md.update(signature.toByteArray());
//                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//        } catch (NoSuchAlgorithmException e) {
//        }
//    }



    final protected static char[] hexArray = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }





    private void StartAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);



        //creating the new thread and runing the timer on it
        splashTread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 5500)
                    {
                        sleep(100);

                        waited= waited + 100;

                        setText("Loading...");

//                        if(waited < 5000)
//                        {
////                            setText("Loading...");
//                        }
//                        else if(waited >= 5000 && waited < 6000 )
//                        {
//                            setText("Loading..");
//                        }
//
//                        else if (waited >= 6000)
//                        {
//                            setText("Loading...");
//                        }
//                          waited= waited + 100;
                    }
                    Intent intent = new Intent(Splashscreen.this, CategoriesActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splashscreen.this.finish();

                }

                catch (InterruptedException e)
                {
                    // do nothing
                }
                finally
                {
                    Splashscreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}
