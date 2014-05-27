package org.javalusir.design_model.singleon;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * singleon demo use for redis depends on jedis 
 * @author javalusir
 *
 */
public class JRedisSiglonPool {

	private static final String IP = "127.0.0.1";
	private static final int PORT = 6379;
	private static final int MaxActive = 1024;
	private static final int MaxIdle = 10;
	private static final long MaxWait = 60;
	private static final boolean TestOnBorrow = true;
	private static final boolean TestOnReturn = true;
	private static final JedisPoolConfig POOLCONFIG = new MyJedisPoolConfig();
	private static final JedisPool POOl = new JedisPool(POOLCONFIG, IP, PORT);

	private JRedisSiglonPool() {

	}

	public static JedisPool getJedisPoolInstance() {
		return POOl;
	}

	private static boolean validateJedisObject(Jedis jedis) {
		return jedis.isConnected();
	}

	public static Jedis getJedisConnection() {
		Jedis jedis = getJedisPoolInstance().getResource();
		return validateJedisObject(jedis) ? jedis : getJedisConnection();// j;//getJedisPoolInstance().getResource();
	}

	public static void close(Jedis jedis) {
		if (jedis != null)
			if (validateJedisObject(jedis))
				POOl.returnBrokenResource(jedis);
			else
				POOl.returnBrokenResource(jedis);
	}

	private static class MyJedisPoolConfig extends JedisPoolConfig {
		private MyJedisPoolConfig() {
			super.setMaxActive(MaxActive);
			super.setMaxIdle(MaxIdle);
			super.setMaxWait(MaxWait);
			super.setTestOnBorrow(TestOnBorrow);
			super.setTestOnReturn(TestOnReturn);
		}
	}

}
