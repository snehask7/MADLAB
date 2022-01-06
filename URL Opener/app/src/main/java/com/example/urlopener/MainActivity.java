package com.example.urlopener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
public class MainActivity extends AppCompatActivity  {
    WebView simpleWebView;
    Button loadWebPage, loadFromStaticHtml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFromStaticHtml = (Button) findViewById(R.id.loadFromStaticHtml);
        loadWebPage = (Button) findViewById(R.id.loadWebPage);
        simpleWebView = (WebView) findViewById(R.id.simpleWebView);
    }
    public void LoadPage(View v){
        String url = "https://snehasriram.com/";
        simpleWebView.getSettings().setJavaScriptEnabled(true);
                simpleWebView.getSettings().setAllowContentAccess(true);
                simpleWebView.getSettings().setAllowFileAccess(true);
                simpleWebView.loadUrl(url); // load a web page in a web view
    }
    public void LoadStatic(View v){
        String customHtml = "<html><body><h1>Hello</h1>" +
                        "<h3>Welcome to the <em>restaurant</em></h3>" +
                        "<p><mark>Buy 1 get 1 free</mark></p>" +
                        "<p>List of beverages</p>" +
                        "<p><ol><li><b>Tea</b></li><li><u>Coffee</u></li><li>Milk</li></ol></p>" +
                        "<p><i>Have a good day</i></p>" + "<p><sup>Come</sup> back <sub>again</sub></p>" + "</body></html>";
                simpleWebView.loadData(customHtml, "text/html", "UTF-8");
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}