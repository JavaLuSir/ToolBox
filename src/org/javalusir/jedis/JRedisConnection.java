package org.javalusir.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * singlen pool
 * @author javalusir
 *
 */
public class JRedisConnection{
	
	private static final String IP="127.0.0.1";
	private static final int PORT=6379;
	private static final int MaxActive=53;
	private static final int MaxIdle=35;
	private static final long MaxWait=10;
	private static final boolean TestOnBorrow=true;
	private static final boolean TestOnReturn=true;
	private static final JedisPoolConfig POOLCONFIG =new MyJedisPoolConfig();	
	private static final JedisPool POOl = new JedisPool(POOLCONFIG,IP,PORT);
	/**
	 * private method
	 */
	private JRedisConnection(){
		
	}
	
	/**
	 * get a instance of jedisPool
	 * @return
	 */
	private static JedisPool getJedisPoolInstance(){
		return POOl;
	}

	/**
	 * get a jedis object
	 * @return get a jedis object
	 */
	public static Jedis getJedisConnection() {
		return getJedisPoolInstance().getResource();
	}
	
	/**
	 * close resource
	 * @param jedis
	 */
	public static void close(Jedis jedis) {
		jedis.quit();
		jedis.disconnect();
	}

	/**
	 * this class is use to construct a config for pool
	 * @author javalusir
	 *
	 */
	private static class MyJedisPoolConfig extends JedisPoolConfig{
		private MyJedisPoolConfig(){
			super.setMaxActive(MaxActive);
			super.setMaxIdle(MaxIdle);
			super.setMaxWait(MaxWait);
			super.setTestOnBorrow(TestOnBorrow);
			super.setTestOnReturn(TestOnReturn);
		}
	}


}
