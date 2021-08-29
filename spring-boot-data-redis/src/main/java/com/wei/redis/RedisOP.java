package com.wei.redis;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public interface RedisOP {
    /**
     * @Description 设置到期时间
     * @param key
     * @param second
     * @return
     */
    boolean expire(String key, int second);

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    long getExpire(String key);

    /**
     * 是否存在该键值对
     * @param key
     * @return
     */
    boolean hasKey(String key);

    /**
     * 批量删除
     * @param key
     */
    void del(String... key);


    /**
     * 获取值
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * @Description 设置值
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value);
}
