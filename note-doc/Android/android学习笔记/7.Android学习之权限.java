/******--- �ļ����ʵ�Ȩ�� ---*********/
˽�С��ɶ�����д���ɶ���д
switch (flag) {
	case R.id.rb_private:
		Log.i(TAG, "flag="+flag);
		mode=Context.MODE_PRIVATE;
		break;
	case R.id.rb_readable:
		Log.i(TAG, "flag="+flag);
		mode=Context.MODE_WORLD_READABLE;
		break;
	case R.id.rb_writeable:
		Log.i(TAG, "flag="+flag);
		mode=Context.MODE_WORLD_WRITEABLE;
		break;
	case R.id.rb_public:
		Log.i(TAG, "flag="+flag);
		mode=Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE;
		break;

	default:
		break;
}	