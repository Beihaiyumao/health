package com.neusoft.service;


import com.neusoft.DataDictionary.LikedStatusEnum;
import com.neusoft.entity.LikeArticle;
import com.neusoft.tool.RedisKeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;


    public void saveLiked2Redis(String likedUserId, String articleId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, articleId);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.LIKE.getCode());
    }


    public void unlikeFromRedis(String likedUserId, String articleId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, articleId);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.UNLIKE.getCode());
    }


    public void deleteLikedFromRedis(String likedUserId, String articleId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, articleId);
        redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
    }


    public void incrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, 1);
    }


    public void decrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, -1);
    }


    public List<LikeArticle> getLikedDataFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED, ScanOptions.NONE);
        List<LikeArticle> list = new ArrayList<>();
        while (cursor.hasNext()){
            Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();
            //分离出 likedUserId，likedPostId
            String[] split = key.split("::");
            String likedUserId = split[0];
            String articleId = split[1];
            Integer value = (Integer) entry.getValue();

            //组装成 UserLike 对象
            LikeArticle userLike = new LikeArticle(likedUserId, articleId, value);
            list.add(userLike);

            //存到 list 后从 Redis 中删除
            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
        }

        return list;
    }

//    @Override
//    public List<LikeArticle> getLikedCountFromRedis() {
//        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, ScanOptions.NONE);
//        List<LikeArticle> list = new ArrayList<>();
//        while (cursor.hasNext()){
//            Map.Entry<Object, Object> map = cursor.next();
//            //将点赞数量存储在 LikedCountDT
//            String key = (String)map.getKey();
//            LikeArticle dto = new LikeArticle(key, (Integer) map.getValue());
//            list.add(dto);
//            //从Redis中删除这条记录
//            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, key);
//        }
//        return list;
//    }
}
