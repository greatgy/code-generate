package ${pkg_name};

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import cc.linkedme.json.JsonConverter;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@Slf4j
@Component
public class ${AaBb}Cache {

    <bean id="${aaBb}CacheRedisClient" class="cc.linkedme.cache.redis.RedisClientUtil" init-method="init">
        <property name="host" value="#{verificationCodeProps['${aaBb}HostName']}"></property>
        <property name="port" value="#{verificationCodeProps['${aaBb}Port']}"></property>
        <property name="password" value="#{verificationCodeProps['password']}"></property>
    </bean>

    @Resource
    private RedisClientUtil ${aaBb}CacheRedisClient;

    private static final int FUNNEL_INFO_CACHE_EXPIRE = (int) TimeUnit.DAYS.toSeconds(1);


    public ${AaBb} get${AaBb}FromCache(String ${aaBb}Key) {
        log.info("get${AaBb}FromCache, ${aaBb}Key:{}", ${aaBb}Key);

        String ${aaBb} = ${aaBb}CacheRedisClient.get(${aaBb}Key);
        if (${aaBb} != null) {
            ${aaBb}CacheRedisClient.expire(${aaBb}Key, FUNNEL_INFO_CACHE_EXPIRE);
        }

        log.info("get${AaBb}FromCache, ${aaBb}Key:{}, ${aaBb}:{}", ${aaBb}Key, ${aaBb});
        return ${aaBb} != null ? JsonConverter.parse(${aaBb}, ${AaBb}.class) : null;
    }

    public void set${AaBb}ToCache(String ${aaBb}Key, String ${aaBb}) {
        log.info("set${AaBb}ToCache, ${aaBb}Key:{}, ${aaBb}:{}", ${aaBb}Key, ${aaBb});
        if (${aaBb}Key == null || ${aaBb} == null) {
            return;
        }
        ${aaBb}CacheRedisClient.setex(${aaBb}Key, ${aaBb}, FUNNEL_INFO_CACHE_EXPIRE);
    }

    public void delKey(String... keys) {
        log.info("delKey, keys:{}", keys);

        long del = ${aaBb}CacheRedisClient.del(keys);

        log.info("delKey, keys:{}, del:{}", keys, del);
    }
}
