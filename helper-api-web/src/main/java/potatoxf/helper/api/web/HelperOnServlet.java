package potatoxf.helper.api.web;

import javax.servlet.http.HttpServletRequest;

/**
 * @author potatoxf
 * @date 2022/7/23
 */
public final class HelperOnServlet {
    /**
     * 获取请求来源的IP,可以适应前置部署有Nginx等反向代理软件等的情况. HTTP_CLIENT_IP 无法伪造，所以放在第一个
     * http://blog.csdn.net/songylwq/article/details/7701718
     *
     * @param request
     * @return
     * @author Stone
     */
    public static String getRequestSourceIp(HttpServletRequest request) {
        String ip = request.getHeader("HTTP_CLIENT_IP");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-FORWARDED-FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
