(ns gobbgobb.core
    (:require 
      [compojure.core :refer [routes]]
      [ring.adapter.jetty :as server]
      [gobbgobb.handler.main :refer [main-routes]]))

(defonce server (atom nil))

(def app
  (routes
    main-routes))

(defn start-server []
  (when-not @server
            (reset! server (server/run-jetty #'app {:port 3000 :join? false}))))

(defn stop-server []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart-server []
  (when @server
    (stop-server)
    (start-server)))
