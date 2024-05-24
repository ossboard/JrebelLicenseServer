package com.delpast.handler;

import org.eclipse.jetty.server.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class IndexHandler {
    public static void indexHandler(Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        // 병합 서버 주소
        String licenseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        StringBuffer html = new StringBuffer("<h3>사용 지침（Instructions for use）</h3>");

        html.append("<hr/>");

        html.append("<h1>Hello,This is a Jrebel & JetBrains License Server!</h1>");
        html.append("<p>License Server started at ").append(licenseUrl);
        html.append("<p>JetBrains(before 2018.1+) Activation address was: <span style='color:red'>").append(licenseUrl).append("/");
        html.append("<p>JRebel 7.1 and earlier version Activation address was: <span style='color:red'>")
                .append(licenseUrl).append("/{tokenname}")
                .append("</span>, with any email.");
        html.append("<p>JRebel 2018.1 and later version Activation address was: ")
                .append(licenseUrl).append("/{guid}")
                .append("(eg:<span style='color:red'>")
                .append(licenseUrl).append("/").append(UUID.randomUUID().toString())
                .append("</span>), with any email.");

        html.append("<hr/>");

        html.append("<h1>Hello，이 주소는 Jrebel & JetBrains License Server!</h1>");
        html.append("<p>JetBrains(2018.1+이전버전)라이센스 서버 활성화 주소 ").append(licenseUrl);
        html.append("<p>JetBrains 활성화 주소는 다음과 같습니다 : <span style='color:red'>").append(licenseUrl).append("/");
        html.append("<p>JRebel 7.1 및 이전 버전 활성화 주소 : <span style='color:red'>")
                .append(licenseUrl).append("/{tokenname}")
                .append("</span>, 그리고 이메일 주소");
        html.append("<p>JRebel 2018.1+ 버전 활성화 주소: ")
                .append(licenseUrl).append("/{guid}")
                .append("(例如：<span style='color:red'>")
                .append(licenseUrl).append("/").append(UUID.randomUUID().toString())
                .append("</span>), 그리고 이메일 주소");

        response.getWriter().println(html);
    }
}
