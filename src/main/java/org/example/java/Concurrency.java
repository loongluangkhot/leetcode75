package org.example.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

// https://blogs.oracle.com/javamagazine/post/virtual-threads-futures
public class Concurrency {
    public class Request {
        public Request(Socket socket) {

        }
    }

    public class Page {
        public Page(Request request) {

        }

        public Page setWeather(String weather) {
            return this;
        }

        public Page setRestaurants(String restaurant) {
            return this;
        }

        public Page setTheaters(String theaters) {
            return this;
        }

        public void send() {}
    }

    public class Weather {
        public static String fetch(Request req) {
            return "";
        }
    }

    public class Restaurants {
        public static String fetch(Request req) {
            return "";
        }
    }

    public class Theaters {
        public static String fetch(Request req) {
            return "";
        }
    }

    public class SequentialServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);

        public SequentialServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                handleRequest(socket);
            }
        }

        void handleRequest(Socket socket) {
            var request = new Request(socket);              // parse a request
            var page = new Page(request);                   // create a base page
            page.setWeather(Weather.fetch(request))         // add weather info to the page
                    .setRestaurants(Restaurants.fetch(request)) // add restaurant info to the page
                    .setTheaters(Theaters.fetch(request))      // add theater info to the page
                    .send();                                    // send the page back as a response
        }
    }

    public class ListeningThreadServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);

        public ListeningThreadServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                new Thread((() -> handleRequest(socket))).start();
            }
        }

        void handleRequest(Socket socket) {
            var request = new Request(socket);              // parse a request
            var page = new Page(request);                   // create a base page
            page.setWeather(Weather.fetch(request))         // add weather info to the page
                    .setRestaurants(Restaurants.fetch(request)) // add restaurant info to the page
                    .setTheaters(Theaters.fetch(request))      // add theater info to the page
                    .send();                                    // send the page back as a response
        }
    }

    public class ListeningThreadWithForkJoinServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);

        public ListeningThreadWithForkJoinServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                new Thread((() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })).start();
            }
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);              // parse a request
            var page = new Page(request);                   // create a base page
            Thread t1 = new Thread(() -> page.setWeather(Weather.fetch(request)));
            Thread t2 = new Thread(() -> page.setRestaurants(Restaurants.fetch(request)));
            Thread t3 = new Thread(() -> page.setTheaters(Theaters.fetch(request)));
            t1.start(); t2.start(); t3.start();

            t1.join(); t2.join(); t3.join();
            page.send();                                  // send the page back as a response
        }
    }

    public class ThreadPoolDeadLockProneServer { // DON'T DO THIS!
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec = Executors.newFixedThreadPool(16);

        public ThreadPoolDeadLockProneServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                exec.execute(() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            exec.close();
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);
            var page = new Page(request);
            var done = new CountDownLatch(3);

            exec.execute(() -> {
                page.setWeather(Weather.fetch(request));
                done.countDown();
            });

            exec.execute(() -> {
                page.setRestaurants(Restaurants.fetch(request));
                done.countDown();
            });

            exec.execute(() -> {
                page.setTheaters(Theaters.fetch(request));
                done.countDown();
            });

            done.await();
            page.send();
        }
    }

    public class ThreadPoolServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec1 = Executors.newFixedThreadPool(4);
        private final ExecutorService exec2 = Executors.newFixedThreadPool(12);

        public ThreadPoolServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                exec1.execute(() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            exec1.close();
            exec2.close();
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);
            var page = new Page(request);
            var done = new CountDownLatch(3);

            exec2.execute(() -> {
                page.setWeather(Weather.fetch(request));
                done.countDown();
            });

            exec2.execute(() -> {
                page.setRestaurants(Restaurants.fetch(request));
                done.countDown();
            });

            exec2.execute(() -> {
                page.setTheaters(Theaters.fetch(request));
                done.countDown();
            });

            done.await();
            page.send();
        }
    }

    public class CompletableFutureDeadLockServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec1 = Executors.newFixedThreadPool(4);
        private final ExecutorService exec2 = Executors.newFixedThreadPool(12);

        public CompletableFutureDeadLockServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                exec1.execute(() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            exec1.close();
            exec2.close();
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);
            var futureWeather = CompletableFuture.supplyAsync(() -> Weather.fetch(request), exec2);
            var futureRestaurants = CompletableFuture.supplyAsync(() -> Restaurants.fetch(request), exec2);
            var futureTheaters = CompletableFuture.supplyAsync(() -> Theaters.fetch(request), exec2);

            new Page(request)
                    .setWeather(futureWeather.join())
                    .setRestaurants(futureRestaurants.join())
                    .setTheaters(futureTheaters.join())
                    .send();
        }
    }

    public class CallbackServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec = Executors.newFixedThreadPool(16);

        public CallbackServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                exec.execute(() -> handleRequest(socket));
            }
            exec.close();
        }

        void handleRequest(Socket socket) {
            var request = new Request(socket);

            var futureWeather = CompletableFuture.supplyAsync(() -> Weather.fetch(request), exec);
            var futureRestaurants = CompletableFuture.supplyAsync(() -> Restaurants.fetch(request), exec);
            var futureTheaters = CompletableFuture.supplyAsync(() -> Theaters.fetch(request), exec);

            var page = new Page(request);

            futureWeather.thenAccept(weather ->
                    futureRestaurants.thenAccept(restaurants ->
                            futureTheaters.thenAccept(theaters ->
                                    page.setWeather(weather)
                                            .setRestaurants(restaurants)
                                            .setTheaters(theaters)
                                            .send())));
        }
    }

    public class FuturesCombineServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec1 = Executors.newSingleThreadExecutor();
        private final ExecutorService exec2 = Executors.newFixedThreadPool(16);

        public FuturesCombineServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                exec1.execute(() -> handleRequest(socket));
            }
            exec1.close();
            exec2.close();
        }

        void handleRequest(Socket socket) {
            var futureRequest = CompletableFuture.supplyAsync(() -> new Request(socket), exec2);

            var futureWeather = futureRequest.thenApplyAsync(Weather::fetch, exec2);
            var futureRestaurants = futureRequest.thenApplyAsync(Restaurants::fetch, exec2);
            var futureTheaters = futureRequest.thenApplyAsync(Theaters::fetch, exec2);

            futureRequest
                    .thenApplyAsync(Page::new, exec2)
                    .thenCombine(futureWeather, Page::setWeather)
                    .thenCombine(futureRestaurants, Page::setRestaurants)
                    .thenCombine(futureTheaters, Page::setTheaters)
                    .thenAccept(Page::send);
        }
    }

    public class VirtualThreadServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);

        public VirtualThreadServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                Thread.startVirtualThread(() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);
            var page = new Page(request);
            var t1 = Thread.startVirtualThread(() -> page.setWeather(Weather.fetch(request)));
            var t2 = Thread.startVirtualThread(() -> page.setRestaurants(Restaurants.fetch(request)));
            var t3 = Thread.startVirtualThread(() -> page.setTheaters(Theaters.fetch(request)));

            t1.join(); t2.join(); t3.join();

            page.send();
        }
    }

    public class VirtualThreadWithFuturesServer {
        int port = 8080;
        private final ServerSocket server = new ServerSocket(port);
        private final ExecutorService exec0 = Executors.newSingleThreadExecutor();
        private final ExecutorService exec = Executors.newFixedThreadPool(16);

        public VirtualThreadWithFuturesServer() throws IOException {
        }

        public void run() throws IOException {
            while (!server.isClosed()) {
                var socket = server.accept();
                Thread.startVirtualThread(() -> {
                    try {
                        handleRequest(socket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            exec.close();
        }

        void handleRequest(Socket socket) throws InterruptedException {
            var request = new Request(socket);

            var futureWeather = new CompletableFuture<String>();
            var futureRestaurants = new CompletableFuture<String>();
            var futureTheaters = new CompletableFuture<String>();

            Thread.startVirtualThread(() -> futureWeather.complete(Weather.fetch(request)));
            Thread.startVirtualThread(() -> futureRestaurants.complete(Restaurants.fetch(request)));
            Thread.startVirtualThread(() -> futureTheaters.complete(Theaters.fetch(request)));

            new Page(request)
                    .setWeather(futureWeather.join())
                    .setRestaurants(futureRestaurants.join())
                    .setTheaters(futureTheaters.join())
                    .send();
        }
    }


}
