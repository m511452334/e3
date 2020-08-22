import static org.junit.Assert.*;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	
	@Test
	public void testJedis() throws Exception {
		//创建一个连接Jedis对象,参数host,post
		Jedis jedis = new Jedis("192.168.25.128", 6379);
		//直接使用Jedis操作redis,所有jedis的命令都对应一个方法
		jedis.set("test1", "my first jedis test");
		String string = jedis.get("test1");
		System.out.println(string);
		//关闭连接
		jedis.close();
	}
	
	@Test
	public void testJedisPool() throws Exception {
		JedisPool jedisPool = new JedisPool("192.168.25.128", 6379);
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get("test1");
		System.out.println(string);
		jedis.close();
		jedisPool.close();
	}
	
	
}
