package com.springboot.chapter7;

import com.springboot.chapter7.config.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter7")
@MapperScan(basePackages = "com.springboot.chapter7", annotationClass = Repository.class)
@EnableCaching
public class Chapter7Application {

    // 注入 RedisTemplate
    @Autowired
    private RedisTemplate redisTemplate = null;

    // Redis 连接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory = null;

    // Redis 消息监听器
    @Autowired
    private MessageListener redisMdgListener = null;

    // 任务池
    private ThreadPoolTaskScheduler taskScheduler = null;

    /**
     * 创建任务池，运行线程等待处理 Redis 的消息
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (taskScheduler != null) {
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        // Redis 连接工厂
        container.setConnectionFactory(connectionFactory);
        // 设置运行任务池
        container.setTaskExecutor(initTaskScheduler());
        // 定义监听渠道，名称为 topic1
        Topic topic = new ChannelTopic("topic1");
        // 使用监听器监听 Redis 的消息
        container.addMessageListener(redisMdgListener, topic);
        return container;
    }

    // 定义自定义后初始化方法
    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    public static void main(String[] args) {
         SpringApplication.run(Chapter7Application.class, args);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
//        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
//        redisTemplate.opsForValue().set("key1", "value1");
//        redisTemplate.opsForHash().put("hash", "field", "hvalue");
//        useRedisCallback(redisTemplate);
//        useSessionCallback(redisTemplate);
    }

    // 需要处理底层的转换规则，如果不考虑改写底层，尽量不使用它
    public static void useRedisCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set("key1".getBytes(), "value1".getBytes());
                redisConnection.hSet("hash".getBytes(), "field".getBytes(), "hvalue".getBytes());
                return null;
            }
        });
    }

    // 高级接口，比较友好，一般情况下，优先使用它
    public static void useSessionCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForValue().set("key1", "value1");
                redisOperations.opsForHash().put("hash", "field", "hvalue");
                return null;
            }
        });
    }

    // 设置 RedisTemplate
    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }
}
