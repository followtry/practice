/***********-- ��Ļת�� --*************/
ֻ�������ʾ
 android:screenOrientation="landscape"

 ֻ��������ʾ
  android:screenOrientation="portrait"

 ����Ļ���������仯ʱ���ص������
  android:configChanges="orientation|keyboardHidden"

  �������л�ʱ����֤activity�������٣����´�����������Ƶ���ŵ�
  4.0֮���ϵͳ
  android:configChanges="orientation|keyboardHidden|screenSize
  4.0֮ǰ��ϵͳ
  android:configChanges="orientation|keyboardHidden"

  /*******-- �������ж���Ļת�� --**********/
  Point outSize=new Point();;
getWindowManager().getDefaultDisplay().getSize(outSize);
int x=outSize.x;
int y=outSize.y;

�ж�x��y�Ĵ�С�Ϳ����ж��Ǻ�����������

