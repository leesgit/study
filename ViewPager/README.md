# ViewPager

## ����üũ


public class MyViewPagerAdapter extends FragmentPagerAdapter {

    int images[] = {R.drawable.ic_audiotrack_black_24dp,R.drawable.ic_insert_emoticon_black_24dp,R.drawable.ic_android_black_24dp};

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { //�������� ȭ�� ���⼭�� �̹���
        return ItemFragment.newInstance(images[position]);
    }

    @Override
    public int getCount() { //viewpager�� ����
        return 3;
    }
}
����

public class ItemFragment extends Fragment {

    public static ItemFragment newInstance(int position) {
        
        Bundle args = new Bundle();
        args.putInt("position",position); // MyViewPagerAdapter�� Fragment getItem(int position)�� set�Ѵ�.
        
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item,container,false);
        ImageView imageView =(ImageView)view.findViewById(R.id.list_item);

        imageView.setImageResource(getArguments().getInt("position")); //position�� set�� ��Ʈ��(�̹���)�� �����´�
        return view;
    }
}