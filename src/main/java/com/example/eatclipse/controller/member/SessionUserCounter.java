package com.example.eatclipse.controller.member;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionUserCounter implements HttpSessionListener {
  private static Logger logger = LoggerFactory.getLogger(SessionUserCounter.class);
  
  //  총 접속자 수
  public static int count;
  
  public static int getCount() {
    return count;
  }

  @Override
  public void sessionCreated(HttpSessionEvent event) {
    //  세션이 생성될 때 세션객체를 꺼내옴.
    HttpSession session = event.getSession();
    count ++;
    logger.error("\n\t세션이 생성되었습니다. : {}, 총 접속자수 : {}", session.getId(), count);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    // 세션이 소멸될 때
    count--;
    if( count < 0 ) count = 0;
    
    HttpSession session = event.getSession();
    logger.error("\n\t세션이 종료되었습니다. : {}, 총 접속자수 : {}", session.getId(), count);
  }
  
}