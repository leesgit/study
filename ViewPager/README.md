# ViewPager

## 권한체크


public class MyViewPagerAdapter extends FragmentPagerAdapter {

    int images[] = {R.drawable.ic_audiotrack_black_24dp,R.drawable.ic_insert_emoticon_black_24dp,R.drawable.ic_android_black_24dp};

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { //뷰페이저 화면 여기서는 이미지
        return ItemFragment.newInstance(images[position]);
    }

    @Override
    public int getCount() { //viewpager의 갯수
        return 3;
    }
}
설정

public class ItemFragment extends Fragment {

    public static ItemFragment newInstance(int position) {
        
        Bundle args = new Bundle();
        args.putInt("position",position); // MyViewPagerAdapter의 Fragment getItem(int position)을 set한다.
        
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item,container,false);
        ImageView imageView =(ImageView)view.findViewById(R.id.list_item);

        imageView.setImageResource(getArguments().getInt("position")); //position에 set된 인트값(이미지)을 가져온다
        return view;
    }
}