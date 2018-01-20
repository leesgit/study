# CardView

## 코드리뷰

MainActivity

Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar); //
        setSupportActionBar(toolbar);                  //툴바 세팅
        getSupportActionBar().setDisplayShowTitleEnabled(false); //타이틀 가림


toolbar.findViewById(R.id.toolbar_email).setOnClickListener(new View.OnClickListener() { //툴바의 아이템 온클릭
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"도착한 메시지가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        });




drawerLayout = (DrawerLayout)findViewById(R.id.main_layout);  //layout을 DrawerLayout으로
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {  //navigation 아이템 온클릭
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.first) {
                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new FirstFragment() ).commit();
                }
                else if (item.getItemId()==R.id.second) {

                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new SecondFragment() ).commit();
                }
                else if (item.getItemId()==R.id.third) {

                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new ThirdFragment() ).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);//왼쪽
                return false;
            }
        });

activity_main.xml

<android.support.design.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
    <include layout="@layout/tool_bar"/>       //툴바 로드
        </android.support.design.widget.AppBarLayout>

        <FrameLayout                                       //navigation 온클릭으로 fragment를 바꿔주기위해
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            android:id="@+id/main_frame"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"> </FrameLayout>

    </android.support.design.widget.CoordinatorLayout>

    <android.support.design.widget.NavigationView
        android:id="@+id/navigationView"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"                 //네비게이션 위치
        app:headerLayout="@layout/side_bar"            //네비게이션으로 구현할 xml
        app:menu="@menu/nav_item">
