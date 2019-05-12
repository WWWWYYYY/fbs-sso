package com.enjoy.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieBasedSession{

    public static final String COOKIE_NAME_SESSION = "psession";
    public static final String DOMAIN = "dev.com";

    public static String getRequestedSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie == null) {
                continue;
            }

            if (!COOKIE_NAME_SESSION.equalsIgnoreCase(cookie.getName())) {
                continue;
            }

            return cookie.getValue();
        }
        return null;
    }

    /**
     * 创建session，同时种cookie。需要注意的就是域名要写成当前域名的父域名
     * @param request
     * @param response
     */
    public static void onNewSession(HttpServletRequest request,
                             HttpServletResponse response) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        Cookie cookie = new Cookie(COOKIE_NAME_SESSION, sessionId);
        //如果在Cookie中设置了"HttpOnly"属性，那么通过JavaScript脚本将无法读取到Cookie信息，这样能有效的防止XSS攻击，让网站应用更加安全。
        //XSS攻击全称跨站脚本攻击
        cookie.setHttpOnly(true);
        cookie.setPath(request.getContextPath() + "/");//可设置应用根路径
        cookie.setDomain(DOMAIN);
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }

}
