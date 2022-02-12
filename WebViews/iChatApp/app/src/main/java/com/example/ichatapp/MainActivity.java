package com.example.ichatapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputType;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("https://ichatappapp.herokuapp.com/");
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);

//		Prompt to get the name of user
		webView.setWebChromeClient(new WebChromeClient(){
			@Override
			public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
				final EditText input = new EditText(MainActivity.this);
				input.setInputType(InputType.TYPE_CLASS_TEXT);
				input.setText(defaultValue);
				float dpi = MainActivity.this.getResources().getDisplayMetrics().density;
				AlertDialog alertDialog = (new AlertDialog.Builder(MainActivity.this))
						.setMessage(message)
						.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								result.confirm(input.getText().toString());
							}
						})
						.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								result.cancel();
							}
						})
						.create();
				alertDialog.setView(input, (int)(22*dpi), (int)(5*dpi), (int)(22*dpi), (int)(5*dpi));
				alertDialog.show();
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