package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.EnvironmentDTO;
import com.tren.huantai.model.dto.StatisticDTO;
import com.tren.huantai.model.params.LoginParam;
import com.tren.huantai.security.token.AuthToken;
import com.tren.huantai.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public AuthToken authenticate(LoginParam loginParam) {
        return null;
    }

    @Override
    public void clearToken() {

    }

    @Override
    public StatisticDTO getCount() {
        return null;
    }

    @Override
    public EnvironmentDTO getEnvironments() {
        return null;
    }

    @Override
    public AuthToken refreshToken(String refreshToken) {
        return null;
    }
}
