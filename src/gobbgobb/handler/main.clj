(ns gobbgobb.handler.main
    (:require
      [compojure.core :refer [defroutes GET POST]]
      [compojure.route :as route]
      [gobbgobb.util.response :as res]))

(defn home-view [req]
  "<h1>Home</h1>")

(defn home [req]
  (-> (home-view req)
      res/response
      res/html))

(defroutes main-routes
  (GET "/" _ home)
  (POST "/" _ home)
  (route/not-found "NOT FOUND"))
