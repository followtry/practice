/***********---�ڲ����ļ��ж���ռ��λ�ú�����---**************/
<TextView
        android:id="@+id/tv_hello"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />
    
    <Button 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/tv_hello"
        android:text="��ť" />
/**********************************/
 android:textColor="#4432dece" ���е�"44"���������͸���ȣ�����������ɫ

/*********---px��dp������----*****************/
dp == dip ��λ�����ܶ�
dp��ָ�������ܶȵı�ֵ���ܱ�֤�ڲ�ͬ�ֱ��ʵ��ֻ���UIͬһ
px����ָ���أ��ڲ�ͬ��Ļ�ϴ�С���䣬�����UI����
"sp":������sp�����ݷֱ��ʴ�С���ţ����������ݡ�Ҳ������dp

/************---���Բ���---****************/
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >
	Ĭ��Ϊ��ֱ��������

���Բ����п���Ƕ����Բ��ֺͿռ�ͬʱ���ڵ�
/**********---��񲼾�---******************/
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
    
    <TableRow 
		android:layout_width="wrap_content"
		android:layout_height="wrap_content" >
        <TextView 
			android:layout_weight="1"
			android:layout_height="wrap_content"
			android:text="����"            
            />
        <TextView 
			android:layout_weight="2"
			android:layout_height="wrap_content"
			android:text="����"            
            />
    </TableRow>
	<TableRow 
		android:layout_width="wrap_content"
		android:layout_height="wrap_content" >
        <TextView 
			android:layout_weight="2"
			android:layout_height="wrap_content"
			android:text="����"            
            />
        <TextView 
			android:layout_weight="1"
			android:layout_height="wrap_content"
			android:text="����"            
            />
    </TableRow>
    <TableRow 
		android:layout_width="wrap_content"
		android:layout_height="wrap_content" >
        <TextView 
			android:layout_weight="1"
			android:layout_height="wrap_content"
			android:text="����"            
            />
        <TextView 
			android:layout_weight="1"
			android:layout_height="wrap_content"
			android:text="����"            
            />
        
         <TextView 
			android:layout_weight="1"
			android:layout_height="wrap_content"
			android:text="����"            
            />
    </TableRow>
</TableLayout>
�ʺ����칫������Ժ�ֵ��ʾ
android:layout_weight="1" �����൱�ڶ���ؼ���ÿ���ϵĿ�ȱ�


/**************---���Բ���---**************/
����Ϸ���õ���Զ�һЩ�������ط����Ƽ�ʹ��
/**********---֡����---****************/
����������֡����

/**********************************/

