package com.wjf.mywjf.home.entity;

import com.wjf.mywjf.JsonResponseParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2015/8/4 0004.
 */
@HttpResponse(parser = JsonResponseParser.class)
public class AppMenus {
    public List<HeadNav> appMenus;
}
