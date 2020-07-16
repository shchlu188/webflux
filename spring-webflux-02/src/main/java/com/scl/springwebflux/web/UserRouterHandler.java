package com.scl.springwebflux.web;

import com.scl.springwebflux.handler.UserHandler;
import com.scl.springwebflux.service.UserService;
import com.scl.springwebflux.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/12
 * @Description
 **********************************/
public class UserRouterHandler {
    public static void main(String[] args) throws InterruptedException {
        UserRouterHandler handler = new UserRouterHandler();
        handler.createReactorServer();
        System.out.println("服务器启动...");
        Thread.sleep(Integer.MAX_VALUE);
    }
    private final UserHandler userHandler = new UserHandler(new UserServiceImpl());

    // 1 创建Router
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(GET("/users/{id}").and(accept(APPLICATION_JSON)),userHandler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),userHandler::getUserAll)
                .andRoute(PUT("/users").and(accept(APPLICATION_JSON)),userHandler::addUser);
    }
/*    public RouterFunction<ServerResponse> rootFunction01() {
        return RouterFunctions
                .route(GET("/users/{id}").and(accept(APPLICATION_JSON)),userHandler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),
                        request -> {
                          return userHandler.getUserAll(request);
                        });
    }
*/

    // 2 创建 服务器完成适配

    public void createReactorServer()  {
        RouterFunction<ServerResponse> route = routerFunction();

        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer server = HttpServer.create();
        server.port(8080);
        server.handle(adapter).bindNow();
    }
}