package com.tren.huantai.service;

import com.tren.huantai.model.dto.EnvironmentDTO;
import com.tren.huantai.model.dto.StatisticDTO;
import com.tren.huantai.model.params.LoginParam;
import com.tren.huantai.security.token.AuthToken;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    /**
     * Expired seconds.
     */
    int ACCESS_TOKEN_EXPIRED_SECONDS = 24 * 3600;

    int REFRESH_TOKEN_EXPIRED_DAYS = 30;

    String ACCESS_TOKEN_CACHE_PREFIX = "halo.admin.access_token.";

    String REFRESH_TOKEN_CACHE_PREFIX = "halo.admin.refresh_token.";

    @NonNull
    AuthToken authenticate(@NonNull LoginParam loginParam);
    /**
     * Clears authentication.
     */
    void clearToken();

    /**
     * Get system counts.
     *
     * @return count dto
     */
    @NonNull
    StatisticDTO getCount();

    /**
     * Get system environments
     *
     * @return environments
     */
    @NonNull
    EnvironmentDTO getEnvironments();

    /**
     * Refreshes token.
     *
     * @param refreshToken refresh token must not be blank
     * @return authentication token
     */
    @NonNull
    AuthToken refreshToken(@NonNull String refreshToken);
}
