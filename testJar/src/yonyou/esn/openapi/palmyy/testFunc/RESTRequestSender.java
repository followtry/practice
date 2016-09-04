package yonyou.esn.openapi.palmyy.testFunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class RESTRequestSender {

	
	private RESTRequestSender() {
	}

	/**
	 * 向指定URL发送POST请求
	 * 
	 * @param url
	 *            指定的 URL
	 * @param param
	 *            参数格式name1=value1&name2=value2
	 * @return 请求的结果
	 */
	public static String sendPost(String url, String param) {
		System.out.println("url:\n" + url);
		System.out.println("params:\n" + param);
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			initConnection(conn, "application/json","POST");

			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();

			BufferedReader br = null;

			InputStream inputStream = null;
			try {
				inputStream = conn.getInputStream();
			} catch (IOException e) {
				inputStream = conn.getErrorStream();
				System.out.println("catch exception:" + e.getMessage());
			}
			br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			String response = "";
			String nachricht;
			while ((nachricht = br.readLine()) != null) {
				response += nachricht;
			}
			System.out.println("response:" + response);
			result = response;
		} catch (Exception e) {
			System.out.println("发送 POST请求错误:" + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return result;
	}
	
	
	public static InputStream sendPost(String url, byte[] param) {
		System.out.println("url:\n" + url);
		OutputStream out = null;
		InputStream inputStream = null;
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
//			initConnection(conn, "application/json");
			initConnection(conn, "","POST");

			out = conn.getOutputStream();
			out.write(param);
			out.flush();


			try {
				inputStream = conn.getInputStream();
			} catch (IOException e) {
				inputStream = conn.getErrorStream();
				System.out.println("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("发送 POST请求错误:" + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return inputStream;
	}
	
	public static InputStream sendGet(String url) {
		System.out.println("url:\n" + url);
		OutputStream out = null;
		InputStream inputStream = null;
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			initConnection(conn, "","GET");
			try {
				inputStream = conn.getInputStream();
			} catch (IOException e) {
				inputStream = conn.getErrorStream();
				System.out.println("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("发送 GET请求错误:" + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return inputStream;
	}
	
	public static String sendGetForStr(String url) {
		System.out.println("url:\n" + url);
		OutputStream out = null;
		InputStream inputStream = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			initConnection(conn, "","GET");
			try {
				inputStream = conn.getInputStream();
				in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				result = getResponse(in);
			} catch (IOException e) {
				System.out.println("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("发送 GET请求错误:" + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			if(inputStream!= null){
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	}
	
	

	private static void initConnection(HttpURLConnection conn,
			String contentType,String httpMethod) {
		conn.setRequestProperty("accept", "*/*");
		if (contentType != null && contentType.trim().length() > 0) {
			conn.setRequestProperty("Content-Type", contentType);
		}
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		try {
			conn.setRequestMethod(httpMethod);
		} catch (ProtocolException e) {
			System.out.println("set http method fail:");
		}
		conn.setDoOutput(true);
		conn.setDoInput(true);
	}

	/**
	 * 向指定URL上传文件
	 * 
	 * @param url
	 *            指定的 URL
	 * @param param
	 *            参数格式name1=value1&name2=value2
	 * @return 请求的结果
	 */
	public static String sendPostByInputStream(String url, InputStream is) {
		System.out.println("url:\n" + url);
		OutputStream out = null;
		BufferedReader in = null;
		String result = "";

		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
			initConnection(conn, "","POST");

			out = conn.getOutputStream();
			send(is, out);

			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			result = getResponse(in);
			System.out.println("result:" + result);
		} catch (Exception e) {
			System.out.println("发送 POST请求错误:" + e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	}

	private static String getResponse(BufferedReader in) throws IOException {
		String result;
		StringBuilder lineSb = new StringBuilder();
		String line = "";
		while ((line = in.readLine()) != null) {
			lineSb.append(line);
		}
		result = lineSb.toString();
		return result;
	}

	private static void send(InputStream is, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[128];
		int n = is.read(buffer);
		while (n > 0) {
			out.write(buffer, 0, n);
			n = is.read(buffer);
		}
		out.flush();
	}

}
