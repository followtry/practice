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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RESTRequestSender {

	private static final  Logger LOG = LoggerFactory.getLogger(RESTRequestSender.class);
	
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
		LOG.debug("url:\n" + url);
		LOG.debug("params:\n" + param);
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
				LOG.error("catch exception:" + e.getMessage());
			}
			br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			String response = "";
			String nachricht;
			while ((nachricht = br.readLine()) != null) {
				response += nachricht;
			}
			LOG.debug("response:" + response);
			result = response;
		} catch (Exception e) {
			LOG.error("发送 POST请求错误:" + e.getMessage(),e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				LOG.error(ex.getMessage(),ex);
			}
		}
		return result;
	}
	
	
	public static InputStream sendPost(String url, byte[] param) {
		LOG.info("url:\n" + url);
		LOG.info("params:\n" + param);
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
				LOG.error("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			LOG.error("发送 POST请求错误:" + e.getMessage(),e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				LOG.error(ex.getMessage(),ex);
			}
		}
		return inputStream;
	}
	
	public static InputStream sendGet(String url) {
		LOG.info("url:\n" + url);
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
				LOG.error("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			LOG.error("发送 GET请求错误:" + e.getMessage(),e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				LOG.error(ex.getMessage(),ex);
			}
		}
		return inputStream;
	}
	
	public static String sendGetForStr(String url) {
		LOG.info("url:\n" + url);
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
				LOG.error("catch exception:" + e.getMessage());
			}
		} catch (Exception e) {
			LOG.error("发送 GET请求错误:" + e.getMessage(),e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				LOG.error(ex.getMessage(),ex);
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(),e);
				}
			}
			if(inputStream!= null){
				try {
					inputStream.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(),e);
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
			LOG.error("set http method fail:",e);
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
		LOG.info("url:\n" + url);
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
			LOG.debug("result:" + result);
		} catch (Exception e) {
			LOG.error("发送 POST请求错误:" + e.getMessage(),e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(),e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(),e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(),e);
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
