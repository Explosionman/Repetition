package ru.rybinskov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientApp {
    private static final String PLAIN_TYPE = "text/plain";
    private static final String JSON_TYPE = "application/json";
    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";

    private static class Response {
        private String httpVersion;
        private int statusCode;
        private int contentLength;

        public Response(InputStream inputStream, boolean debug) throws IOException {
            String line = null;
            StringBuilder sb = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                line = reader.readLine();
                if (debug) System.out.println(line);
                parseStatus(line);

                do {
                    line = reader.readLine();
                    parseHeader(line);
                    if (line.isEmpty()) break;
                    if (debug) System.out.println(line);
                } while (line != null);

                if (debug) System.out.println("\n---- Received data ---- \n");

                while (line != null) {
                    line = reader.readLine();
                    if (line == null) break;
                    if (debug) System.out.println(line);
                }
                if (debug) System.out.println("------------------------------------------------ \n");
            }

        }

        private void parseStatus(String line) {
            String[] strings = line.split("\\s+");
            httpVersion = strings[0];
            statusCode = Integer.parseInt(strings[1]);
        }

        private void parseHeader(String line) {
            if (line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split("\\s++")[1]);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        String newFilm = "{\"description\":\"new film\"}";
        sendRequest("localhost", 8080, POST_METHOD, "/film",JSON_TYPE, newFilm);
        sendRequest("localhost", 8080, GET_METHOD, "/film", PLAIN_TYPE, "");

        sendRequest("localhost", 8080, GET_METHOD, "/movie", PLAIN_TYPE, "");
        sendRequest("localhost", 8080, POST_METHOD, "/movie", PLAIN_TYPE, "");
    }

    public static void sendRequest(String host, int port, String method, String path, String contentType, String data) throws IOException {
        try (Socket socket = new Socket(host, port)) {
            StringBuilder output = new StringBuilder();
            output.append(method).append(" ").append(path).append(" ").append("HTTP/1.1").append("\r\n");
            output.append("Host: ").append(host).append(":").append(port).append("\r\n");
            output.append("Accept: ").append("text/plain,application/json;charset=UTF-8").append("\r\n");
            output.append("Connection: ").append("close").append("\r\n");
            output.append("Content-Type: ").append(contentType).append("\r\n");
            if (data.length() > 0) {
                output.append("Content-Length: ").append(data.length()).append("\r\n");
                output.append("\r\n").append(data);
            }
            output.append("\r\n");
            socket.getOutputStream().write(output.toString().getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            Response response = new Response(socket.getInputStream(), true);
        }
    }

}
