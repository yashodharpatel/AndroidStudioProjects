package com.example.uicolorpicker;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("https://clicktocopy.netlify.app/");
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);

//		Toast to get color code of copied color
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
				result.confirm();
				return true;
			}
		});

//		Showing Error if user internet connection is interrupted
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				webView.loadUrl("about:blank");
				AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
				alertDialog.setTitle("Error");
				alertDialog.setMessage("Please check your internet connection and try again.");
				alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
						startActivity(getIntent());
					}
				});
				alertDialog.show();
			}
		});
	}

	public class myWebClient extends WebViewClient{
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon){
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view,String url){
			view.loadUrl(url);
			return true;
		}
	}

	@Override
	public void onBackPressed(){
		if(webView.canGoBack()) {
			webView.goBack();
		}
		else{
			super.onBackPressed();
		}
	}
}