/**********---  �ֻ����(SD��) ---*************/
д��SD����ʱ��ҪȨ��
android.permission.WRITE_EXTERNAL_STORAGE #д���ⲿ�洢�ϵ�Ȩ��
ֻ��Ҫ��д��λ�ø�Ϊ/sdcard/����

�ж��Ƿ����SD�������ж�SD���Ƿ��Ѿ�����
if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) 
