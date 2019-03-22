package io.parcelx.util.data;

import java.io.Serializable;

/**
 * 登录用户数据
 * @author XieZhibing
 *
 */
public class TokenInfo implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;

	/** Token */
	private String token;
	/** 到期时间 */
	private long expire;

	
	public TokenInfo() {
		super();
	}

	public TokenInfo(String token, long expire) {
		super();
		this.token = token;
		this.expire = expire;
	}

	/** Token */
	public String getToken() {
		return token;
	}

	/** Token */
	public void setToken(String token) {
		this.token = token;
	}
	
	/** 到期时间 */
	public long getExpire() {
		return expire;
	}

	/** 到期时间 */
	public void setExpire(long expire) {
		this.expire = expire;
	}

}
