# CardView

## �ڵ帮��

MainActivity

Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar); //
        setSupportActionBar(toolbar);                  //���� ����
        getSupportActionBar().setDisplayShowTitleEnabled(false); //Ÿ��Ʋ ����


toolbar.findViewById(R.id.toolbar_email).setOnClickListener(new View.OnClickListener() { //������ ������ ��Ŭ��
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"������ �޽����� �����ϴ�.",Toast.LENGTH_SHORT).show();
            }
        });




drawerLayout = (DrawerLayout)findViewById(R.id.main_layout);  //layout�� DrawerLayout����
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {  //navigation ������ ��Ŭ��
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
                drawerLayout.closeDrawer(GravityCompat.START);//����
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
    <include layout="@layout/tool_bar"/>       //���� �ε�
        </android.support.design.widget.AppBarLayout>

        <FrameLayout                                       //navigation ��Ŭ������ fragment�� �ٲ��ֱ�����
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            android:id="@+id/main_frame"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"> </FrameLayout>

    </android.support.design.widget.CoordinatorLayout>

    <android.support.design.widget.NavigationView
        android:id="@+id/navigationView"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"                 //�׺���̼� ��ġ
        app:headerLayout="@layout/side_bar"            //�׺���̼����� ������ xml
        app:menu="@menu/nav_item">
