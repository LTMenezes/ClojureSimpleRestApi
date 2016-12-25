(ns clojure-simple-rest-api.core
  (:gen-class)
  (:use compojure.core)
  (:use [clojure.string :only [join capitalize]])
  (:require [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
            [compojure.route :as route]
            [ring.util.response :as r]))

(defn say-hi
  "Function that says hi to your users!"
  [name]
  (-> (r/response (-> (apply str (join "," ["Hello" (capitalize name)]))))
      (r/header "Content-Type" "text/html; charset=utf-8")))

(defn log
  "Middleware for logging requests to the server"
  [app]
  (fn [req]
    (println "Server has been contacted.")
    (app req)))

(defroutes app-routes
           (GET "/:name" [name] (say-hi name))
           (route/not-found "Page not found"))

(def app
  "Our server handler"
  (-> app-routes log))

(defn start-server
  "Start a Jetty webserver for us. Really cool"
  [] (jetty/run-jetty (var app) {:port 8081 :max-threads 100}))