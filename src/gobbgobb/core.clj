(ns gobbgobb.core
    (:require [ring.adapter.jetty :as server]))

(defonce server (atom nil))

(defn tmp-handler [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello, world!"})

(defn start-server []
  (when-not @server
            (reset! server (server/run-jetty #'tmp-handler {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (when @server
    (stop-server)
    (start-server)))
