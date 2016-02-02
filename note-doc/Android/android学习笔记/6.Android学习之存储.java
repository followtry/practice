/*********---�����ļ����ֻ�---**********/
context.getCacheDir() /data/data/����/cache
context.getFilesDir()  /data/data/����/files

//���ݴ洢�Ĵ���
@Override
public boolean saveUserNameAndPwd(Context context,String username, String pwd) {
	
	Log.i(TAG, context.getFilesDir().toString());
	
	File file=new File(context.getFilesDir(),fileName);
	FileOutputStream out=null;
	try {
	   out=new FileOutputStream(file);
	   out.write((username+"#"+pwd).getBytes());
	   out.flush();
	   return true;
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if (out!=null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return false;
}

//���ݻ�ȡ�Ĵ���
@Override
public Map<String, String> getUserInfo(Context context) {
	
	File file=new File(context.getFilesDir(), fileName);
	FileInputStream in=null;
	try {
		in = new FileInputStream(file);
		BufferedReader bReader=new BufferedReader(new InputStreamReader(in));
		String str=bReader.readLine();
		String[] param=str.split("#");
		Map<String, String> map=new HashMap<String, String>();	
		if (param.length<2) {
			return null;
		}
		map.put("username", param[0]);
		map.put("password", param[1]);
		return map;
		
	} catch (Exception e) {
		return null;
	}finally{
		if (in!=null) {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

