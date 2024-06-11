package io.github.hyperpay.service.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import reactor.util.function.Tuple3;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LettuceRedisClient {


    /**
     * 缓存有效时间1小时
     */
    long EXPIRE_TIME_HOUR = 60 * 60L;


    /**
     * 缓存有效时间1天 EXPIRE_TIME
     */
    long EXPIRE_TIME_DAY = 60 * 60 * 24L;

    RedisTemplate<String, Object> redisTemplate;

    public LettuceRedisClient(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object val, long expireTime, TimeUnit timeUnit) {
        redisTemplate.boundValueOps(key).set(val, getSecondsExpireTime(expireTime, timeUnit), TimeUnit.SECONDS);
    }

    public void set(String key, Object val, Date expireDate) {
        redisTemplate.boundValueOps(key).set(val);
        redisTemplate.expireAt(key, expireDate);
    }

    public void set(String key, Object val) {
        redisTemplate.boundValueOps(key).set(val);
    }

    public <T> T get(String key, Class<T> classT) {
        Object obj = redisTemplate.boundValueOps(key).get();
        return Objects.nonNull(obj) ? (T) obj : null;
    }

    public void hset(String key, Map<String, Object> map, long expireTime, TimeUnit timeUnit) {
        redisTemplate.boundHashOps(key).putAll(map);
        long secondsExpireTime = getSecondsExpireTime(expireTime, timeUnit);
        redisTemplate.expire(key, secondsExpireTime, TimeUnit.SECONDS);
    }

    public void hset(String key, Map<String, Object> map, Date expireDate) {
        redisTemplate.boundHashOps(key).putAll(map);
        redisTemplate.expireAt(key, expireDate);
    }

    public void hset(String key, Map<String, Object> map) {
        redisTemplate.boundHashOps(key).putAll(map);
    }

    public <T> T hgetOne(String outKey, String insideKey, Class<T> classT) {
        Object obj = redisTemplate.boundHashOps(outKey).get(insideKey);
        return Objects.nonNull(obj) ? (T) obj : null;
    }

    /**
     * 默认hash  val 储存相同的数据类型
     *
     * @param key key
     * @param classT 泛型类
     * @return
     */
    public <T> List<T> hgetList(String key, Class<T> classT) {
        List<Object> values = redisTemplate.boundHashOps(key).values();
        return CollectionUtils.isEmpty(values) ? Lists.newArrayList() :
                values.stream().filter(Objects::nonNull).map(i -> (T) i).collect(Collectors.toList());
    }

    /**
     * 默认hash  val 储存相同的数据类型
     *
     * @param key
     * @param classT
     * @param <T>
     * @return
     */
    public <T> Map<String, T> hgetMap(String key, Class<T> classT) {
        Map<Object, Object> map = redisTemplate.boundHashOps(key).entries();
        return MapUtils.isEmpty(map) ? Maps.newHashMap() : map.entrySet().stream()
                .filter(i -> Objects.nonNull(i.getKey()) && Objects.nonNull(i.getValue()))
                .collect(Collectors.toMap(i -> (String) (i.getKey()), i -> (T) i.getValue(), (k1, k2) -> k2));
    }

    public Map<String, Object> hgetMap(String key) {
        final Map<Object, Object> map = redisTemplate.boundHashOps(key).entries();
        return MapUtils.isEmpty(map) ? Maps.newHashMap() : map.entrySet().stream()
                .filter(i -> Objects.nonNull(i.getKey()) && Objects.nonNull(i.getValue()))
                .collect(Collectors.toMap(i -> (String) (i.getKey()), i -> i.getValue(), (k1, k2) -> k2));
    }

    public void batchSet(Map<String, String> map) {
        redisTemplate.executePipelined((RedisCallback<String>) connection -> {
            map.forEach((key, value) -> connection.set(key.getBytes(), value.getBytes()));
            return null;
        }, redisTemplate.getValueSerializer());
    }

    public void batchSet(Map<String, String> map, long expireTime, TimeUnit timeUnit) {
        long t = getSecondsExpireTime(expireTime, timeUnit);
        redisTemplate.executePipelined((RedisCallback<String>) connection -> {
            map.forEach((key, value) -> connection.set(key.getBytes(), value.getBytes(), Expiration.seconds(t), RedisStringCommands.SetOption.UPSERT));
            return null;
        }, redisTemplate.getValueSerializer());
    }

    public Map<String, Object> batchGet(List<String> keys) {
        List<Object> list = redisTemplate.executePipelined((RedisCallback<String>) connection -> {
            for (String key : keys) {
                connection.get(key.getBytes());
            }
            return null;
        }, redisTemplate.getValueSerializer());

        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            if (Objects.nonNull(list.get(i))) {
                map.put(keys.get(i), list.get(i));
            }
        }
        return map;
    }

    @Deprecated
    public Map<String, Map<String, Object>> batchHashGet(List<String> hashKeyList) {
        List<Object> list = redisTemplate.executePipelined((RedisCallback<String>) connection -> {
            for (String key : hashKeyList) {
                connection.hGetAll(key.getBytes());
            }
            return null;
        }, redisTemplate.getValueSerializer());
        Map<String, Map<String, Object>> map = new HashMap<>(hashKeyList.size());
        for (int i = 0; i < hashKeyList.size(); i++) {
            String hashKey = hashKeyList.get(i);
            Object values = list.get(i);
            if (Objects.nonNull(values)) {
                Map<String, Object> mm = (Map<String, Object>) values;
                map.put(hashKey, mm);
            }
        }
        return map;
    }

    @Deprecated
    public void batchHashSet(List<Tuple3<String, Map<String, String>, Long>> hashList) {
        redisTemplate.executePipelined((RedisCallback<String>) connection -> {
            for (Tuple3 tuple : hashList) {
                String hashKey = (String) tuple.getT1();
                Map<String, String> values = (Map<String, String>) tuple.getT2();
                long expireTime = (long) tuple.get(3);
                expireTime = expireTime <= 0 ? EXPIRE_TIME_HOUR : expireTime;
                Map<byte[], byte[]> bytes = new HashMap<>(values.size());
                values.forEach((key, value) -> {
                    if (Objects.nonNull(key) && Objects.nonNull(value)) {
                        bytes.put(key.getBytes(), value.getBytes());
                    }
                });
                connection.hMSet(hashKey.getBytes(), bytes);
                connection.expire(hashKey.getBytes(), expireTime);
            }
            return null;
        }, redisTemplate.getValueSerializer());
    }

    public Boolean del(String delKey) {
        return redisTemplate.delete(delKey);
    }

    public long batchDel(Set<String> keyList) {
        return Optional.ofNullable(redisTemplate.delete(keyList)).orElse(0L);
    }

    public long batchHDel(String key, Set<String> delKeys) {
        return Optional.ofNullable(redisTemplate.boundHashOps(key).delete(delKeys.toArray())).orElse(0L);
    }

    public Boolean lockKey(String key, String val, long expireTime, TimeUnit timeUnit) {
        long secondsExpireTime = getSecondsExpireTime(expireTime, timeUnit);
        return redisTemplate.opsForValue().setIfAbsent(key, val, secondsExpireTime, TimeUnit.SECONDS);
    }

    public Boolean lockKey(String key, String val) {
        return redisTemplate.opsForValue().setIfAbsent(key, val);
    }

    public Boolean releaseKey(String key, String val) {
        String lockVal = this.get(key, String.class);
        if (Objects.nonNull(lockVal) && lockVal.equals(val)) {
            return this.del(key);
        }
        return Boolean.FALSE;
    }

    public Boolean releaseKey(String key) {
        return this.del(key);
    }

    public boolean expire(String key, long expireTime, TimeUnit timeUnit) {
        return redisTemplate.expire(key, getSecondsExpireTime(expireTime, timeUnit), TimeUnit.SECONDS);
    }

    public boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 默认缓存1天
     *
     * @param expireTime
     * @param timeUnit
     * @return
     */
    private long getSecondsExpireTime(long expireTime, TimeUnit timeUnit) {
        long resultTime = EXPIRE_TIME_DAY;
        if (expireTime > 0) {
            if (Objects.isNull(timeUnit)) {
                resultTime = expireTime;
            } else {
                switch (timeUnit) {
                    case DAYS:
                        resultTime = expireTime * 24 * 60 * 60;
                        break;
                    case HOURS:
                        resultTime = expireTime * 60 * 60;
                        break;
                    case MINUTES:
                        resultTime = expireTime * 60;
                        break;
                    case SECONDS:
                        resultTime = expireTime;
                        break;
                    case MILLISECONDS:
                        resultTime = expireTime / 1000;
                        break;
                    case MICROSECONDS:
                        resultTime = expireTime / 1000 / 1000;
                        break;
                    case NANOSECONDS:
                        resultTime = expireTime / 1000 / 1000 / 1000;
                        break;
                    default:
                        resultTime = expireTime;
                }
            }
        }
        return resultTime;
    }


    public Long incr(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public Long incrExpire(String key, Integer seconds) {
        if (Objects.isNull(seconds)) {
            return incr(key);
        }
        Long increment = redisTemplate.opsForValue().increment(key);
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        return increment;
    }
}
