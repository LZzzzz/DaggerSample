package com.demo.longzongjia.daggerdemo.mvp.view.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.demo.longzongjia.App;
import com.demo.longzongjia.daggerdemo.R;
import com.demo.longzongjia.daggerdemo.di.component.AppComponent;
import com.demo.longzongjia.daggerdemo.di.component.DaggerActivityComponent;
import com.demo.longzongjia.daggerdemo.di.moudle.ActivityMoudle;
import com.demo.longzongjia.daggerdemo.mvp.impl.MainContract;
import com.demo.longzongjia.daggerdemo.mvp.presenter.Mainpresenter;
import com.demo.longzongjia.daggerdemo.utils.ThemeHelper;
import com.demo.longzongjia.daggerdemo.widget.CardPickerDialog;
import com.demo.longzongjia.daggerdemo.widget.KeyEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.IView, CardPickerDialog.ClickListener {

    @Inject
    Mainpresenter mainpresenter;
    @Inject
    ThemeHelper themeHelper;

    @BindView(R.id.tv_nick_name)
    TextView tvNickName;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_blog)
    TextView tvBlog;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.tv_name)
    KeyEditText tvName;
    @BindView(R.id.bt_search)
    Button btSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        ButterKnife.bind(this);
        initView();
        setupActivityComponent(App.getApplication(this).getAppComponent());
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ThemeUtils.getColorById(this, R.color.theme_color_primary_dark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    ThemeUtils.getThemeAttrColor(this, android.R.attr.colorPrimary));
            setTaskDescription(description);
        }
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityMoudle(new ActivityMoudle(this))
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
        tvNickName.setText("昵称:");
        tvCompany.setText("公司:");
        tvBlog.setText("博客:");
        tvFollow.setText("粉丝:");
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateView(String nickname, String company, String blog) {
        tvNickName.setText(getString(R.string.nick_name, nickname));
        tvCompany.setText(getString(R.string.company, company));
        tvBlog.setText(getString(R.string.blog, blog));
    }

    @Override
    public void showFollows(String msg) {
        tvFollow.setText(msg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme) {
            CardPickerDialog dialog = new CardPickerDialog();
            dialog.setClickListener(this);
            dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfirm(int currentTheme) {
        if (themeHelper.getTheme(MainActivity.this) != currentTheme) {
            themeHelper.setTheme(MainActivity.this, currentTheme);
            ThemeUtils.refreshUI(MainActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final MainActivity context = MainActivity.this;
                                ActivityManager.TaskDescription taskDescription =
                                        new ActivityManager.TaskDescription(null, null,
                                                ThemeUtils.getThemeAttrColor(context, android.R.attr.colorPrimary));
                                setTaskDescription(taskDescription);
                                getWindow().setStatusBarColor(
                                        ThemeUtils.getColorById(context, R.color.theme_color_primary_dark));
                            }
                        }

                        @Override
                        public void refreshSpecificView(View view) {
                            //TODO: will do this for each traversal
                        }
                    }
            );
        }
    }


    @OnClick(R.id.bt_search)
    public void onViewClicked() {
        mainpresenter.searchUser(tvName.getText().toString());
    }
}
