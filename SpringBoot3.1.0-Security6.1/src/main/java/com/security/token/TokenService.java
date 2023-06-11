package com.security.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.security.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 伍六七
 * @date 2023/6/11 11:16
 */
@RequiredArgsConstructor
@Service
public class TokenService {
    private final RedisTemplate<String, String> redisTemplate;

    private final String TOKEN_KEY = "token:admin:";
    private final int EXPIRED_Time_DAY = 1;
    private final TimeUnit EXPIRED_Time_TYPE = TimeUnit.DAYS;

    public List<Token> getAllTokenByUser(Integer userId) {
        Set<String> keys = redisTemplate.keys(TOKEN_KEY);
        List<Token> tokens = new ArrayList<>();
        Objects.requireNonNull(keys).forEach(l -> {
            try {
                Token token = JsonUtil.jsonStrToObj(l, Token.class);
                if (userId.equals(token.userId)) {
                    tokens.add(token);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return tokens;
    }

    public void saveAll(List<Token> validUserTokens) {
        validUserTokens.forEach(l -> {
            String accessToken = l.getAccessToken();
            String tokenJson = null;
            try {
                tokenJson = JsonUtil.objToJsonStr(l);
                redisTemplate.opsForValue().set(TOKEN_KEY + accessToken, tokenJson, EXPIRED_Time_DAY, EXPIRED_Time_TYPE);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void save(Token token) {
        try {
            String json = JsonUtil.objToJsonStr(token);
            redisTemplate.opsForValue().set(TOKEN_KEY + token.getAccessToken(), json, EXPIRED_Time_DAY, EXPIRED_Time_TYPE);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Token findByToken(String jwt) {
        String str = redisTemplate.opsForValue().get(TOKEN_KEY + jwt);
        try {
            return JsonUtil.jsonStrToObj(str, Token.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delByToken(String jwt) {
        redisTemplate.delete(TOKEN_KEY + jwt);
    }
}

